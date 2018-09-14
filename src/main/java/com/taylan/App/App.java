package com.taylan.App;

import java.io.IOException;
import java.net.URI;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class App {

	public static String url = "";
	public static JSONObject responsejson;
	public static String displayname;

	public static void main(String[] args) throws ClientProtocolException, IOException, JSONException {

		JiraAppFirstGUI.FirstGUI();

	}

	public static String getIssueStatus() throws ClientProtocolException, IOException, JSONException {

		issueClient();
		JSONObject object1 = responsejson.getJSONObject("fields");
		JSONObject object2 = object1.getJSONObject("status");
		String status = object2.getString("name");

		return status;

	}

	public static String getIssueType() throws ClientProtocolException, IOException, JSONException {

		issueClient();
		JSONObject object1 = responsejson.getJSONObject("fields");
		JSONObject object2 = object1.getJSONObject("issuetype");
		String type = object2.getString("name");

		return type;

	}

	public static String getIssueDueDate() throws ClientProtocolException, IOException, JSONException {

		issueClient();
		JSONObject object1 = responsejson.getJSONObject("fields");

		String duedate = object1.getString("duedate");

		return duedate;

	}

	public static String getIssueOriginalEstimateMinutes() throws ClientProtocolException, IOException, JSONException {

		issueClient();
		JSONObject object1 = responsejson.getJSONObject("fields");
		JSONObject object2 = object1.getJSONObject("timetracking");
		String originalestimate = object2.getString("originalEstimate");

		return originalestimate;

	}

	public static String getIssueRemiaingEstimateMinutes() throws ClientProtocolException, IOException, JSONException {

		issueClient();
		JSONObject object1 = responsejson.getJSONObject("fields");
		JSONObject object2 = object1.getJSONObject("timetracking");
		String remainingestimate = object2.getString("remainingEstimate");

		return remainingestimate;

	}

	public static String getIssueTimeSpent() throws ClientProtocolException, IOException, JSONException {

		issueClient();
		JSONObject object1 = responsejson.getJSONObject("fields");
		JSONObject object2 = object1.getJSONObject("timetracking");
		String timeSpent = object2.getString("timeSpent");

		return timeSpent;

	}

	public static String getUserDisplayName() throws ClientProtocolException, IOException, JSONException {

		URI uri = URI.create(url + "myself");
		org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(uri);
		request.setHeader("Authorization", " Basic " + JiraAppFirstGUI.getKey());
		request.setHeader("Content-type", "application/json");
		HttpResponse response = client.execute(request);
		String userresponse;
		userresponse = EntityUtils.toString(response.getEntity(), "UTF-8");

		responsejson = new JSONObject(userresponse);
		displayname = responsejson.getString("displayName");

		return displayname;

	}

	public static String getUserName() throws ClientProtocolException, IOException, JSONException {

		URI uri = URI.create(url + "myself");
		org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(uri);
		request.setHeader("Authorization", " Basic " + JiraAppFirstGUI.getKey());
		request.setHeader("Content-type", "application/json");
		HttpResponse response = client.execute(request);
		String userresponse;
		userresponse = EntityUtils.toString(response.getEntity(), "UTF-8");
		JSONObject responsejson = new JSONObject(userresponse);
		String name = responsejson.getString("name");

		return name;

	}

	public static void issueClient() throws ClientProtocolException, IOException, JSONException {

		URI uri = URI.create(url + "issue/" + JiraAppSecondGUI.issueKey);
		org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(uri);
		request.setHeader("Authorization", " Basic " + JiraAppFirstGUI.getKey());
		request.setHeader("Content-type", "application/json");
		HttpResponse response = client.execute(request);
		String issueresponse;
		issueresponse = EntityUtils.toString(response.getEntity(), "UTF-8");
		responsejson = new JSONObject(issueresponse);

	}

}
