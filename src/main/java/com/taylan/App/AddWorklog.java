package com.taylan.App;

import java.io.IOException;
import java.net.URI;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class AddWorklog {
	static String started;
	static String authorname;
	static long spentseconds;
	static int count;
	static int count1;
	static long totalspent = 0;

	public static void addWorklog() throws ClientProtocolException, IOException, JSONException, ParseException {

		URI uri = URI.create(App.url + "issue/" + JiraAppSecondGUI.issuekeytextf.getText());
		org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(uri);
		request.setHeader("Authorization", " Basic " + JiraAppFirstGUI.getKey());
		request.setHeader("Content-type", "application/json");
		HttpResponse response = client.execute(request);
		String issueresponse;
		issueresponse = EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject responsejson = new JSONObject(issueresponse);

		JSONObject obje1 = responsejson.getJSONObject("fields");
		JSONObject obje2 = obje1.getJSONObject("worklog");
		JSONArray array1 = obje2.getJSONArray("worklogs");

		if (array1.length() == 0) {
			WorklogRequest.worklogRequest();

		} else {

			for (int i = 0; i < array1.length(); i++) {

				JSONObject obje3 = array1.getJSONObject(i);
				JSONObject obje4 = obje3.getJSONObject("author");
				authorname = obje4.getString("name");

				String date = obje3.getString("started");
				DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date1 = sdf.parse(date);
				started = sdf.format(date1);

				spentseconds = obje3.getLong("timeSpentSeconds");

				Date date2 = new Date();
				SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
				String formatdate = sdf1.format(date2);
				long spenttime = 21600;

				if (App.getUserName().equals(authorname) && (formatdate.equals(started))) {
					count1++;

					totalspent = totalspent + spentseconds;

					if (totalspent >= spenttime) {
						break;

					} else {

						timeSpentSecondsRequest();
						break;

					}

				} else {
					count++;

				}

			}

			if (count != 0 && count1 == 0) {
				WorklogRequest.worklogRequest();

			}

		}

	}

	public static void timeSpentSecondsRequest() throws JSONException, ClientProtocolException, IOException {

		char c = JiraAppFourthGUI.workhourtextf.getText().charAt(0);
		long newspentseconds = ((Integer.parseInt(String.valueOf(c))) * 3600 - spentseconds);

		String comment = JiraAppFourthGUI.commentarea.getText();
		URI uri = URI.create(App.url + "issue/" + JiraAppSecondGUI.issuekeytextf.getText() + "/worklog");
		org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(uri);

		JSONObject main = new JSONObject();
		main.put("comment", comment);
		main.put("timeSpentSeconds", newspentseconds);
		String json = main.toString();

		StringEntity entity = new StringEntity(json);
		request.setEntity(entity);
		request.setHeader("Authorization", " Basic " + JiraAppFirstGUI.getKey());
		request.setHeader("Content-type", "application/json");
		client.execute(request);

	}

}
