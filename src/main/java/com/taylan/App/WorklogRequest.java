package com.taylan.App;

import java.io.IOException;
import java.net.URI;

import org.apache.http.client.ClientProtocolException;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class WorklogRequest {

	public static void worklogRequest() throws ClientProtocolException, IOException, JSONException {

		String comment = JiraAppFourthGUI.commentarea.getText();
		String timespent = JiraAppFourthGUI.workhourtextf.getText();

		URI uri = URI.create(App.url + "issue/" + JiraAppSecondGUI.issuekeytextf.getText() + "/worklog");
		org.apache.http.client.HttpClient client = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(uri);

		JSONObject main = new JSONObject();
		main.put("comment", comment);
		main.put("timeSpent", timespent);
		String json = main.toString();

		StringEntity entity = new StringEntity(json);
		request.setEntity(entity);
		request.setHeader("Authorization", " Basic " + JiraAppFirstGUI.getKey());
		request.setHeader("Content-type", "application/json");
		client.execute(request);

	}

}
