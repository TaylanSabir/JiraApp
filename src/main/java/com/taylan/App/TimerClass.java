package com.taylan.App;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jettison.json.JSONException;

public class TimerClass {

	static Date date = new Date();

	public static void Timer() {

		final Timer timer = new Timer();
		final Timer timer1 = new Timer();
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		final String formatstartdate = sdf.format(JiraAppFourthGUI.startdatechooser.getDate());
		final String formatfinishdate = sdf.format(JiraAppFourthGUI.finishdatechooser.getDate());

		TimerTask timertask = new TimerTask() {
			@Override
			public void run() {
				String formatdate = sdf.format(date);
				if (formatdate.equals(formatstartdate)) {
					timer.cancel();
					TimerTask timertask1 = new TimerTask() {

						public void run() {
							String formatdate = sdf.format(date);

							if (date.getDay() != 6 && date.getDay() != 0) {
								try {
									AddWorklog.addWorklog();
								} catch (ClientProtocolException e) {
									e.printStackTrace();
								} catch (IOException e) {
									e.printStackTrace();
								} catch (JSONException e) {
									e.printStackTrace();
								} catch (ParseException e) {
									e.printStackTrace();
								}
							}

							if (formatdate.equals(formatfinishdate)) {
								timer1.cancel();
								String message = "Worklog Saving Finished";
								JOptionPane.showMessageDialog(null, message, "Finished", JOptionPane.ERROR_MESSAGE);
								System.exit(0);
							}
						}
					};
					FileSaving.FileSave();
					timer1.schedule(timertask1, 0, 24 * 60 * 60 * 1000);
				}
			}
		};
		timer.schedule(timertask, 0, 1000);

	}

}
