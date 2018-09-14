package com.taylan.App;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileSaving {

	public static void FileSave() {
		Date date = new Date();
		File file = new File("D:/worklog.txt");
		if (!file.exists())
			try {
				file.createNewFile();
			} catch (Exception e2) {
				e2.printStackTrace();
			}

		try {

			FileWriter fwriter = new FileWriter(file);
			BufferedWriter writer = new BufferedWriter(fwriter);
			writer.write("Worklog saved on issue :" + JiraAppSecondGUI.issuekeytextf.getText() + " "
					+ JiraAppFourthGUI.workhourtextf.getText() + " with comment "
					+ JiraAppFourthGUI.commentarea.getText());
			writer.newLine();
			writer.write(date.toString());
			writer.newLine();
			writer.write("------------------------------------");
			writer.newLine();
			writer.close();
		} catch (IOException e1) {

			e1.printStackTrace();
		}
	}

}
