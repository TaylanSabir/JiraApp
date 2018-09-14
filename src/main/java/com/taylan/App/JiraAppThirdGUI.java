package com.taylan.App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jettison.json.JSONException;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class JiraAppThirdGUI {

	public static JFrame frame3;

	/**
	 * Launch the application.
	 */
	public static void ThirdGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JiraAppThirdGUI window = new JiraAppThirdGUI();
					window.frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws JSONException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public JiraAppThirdGUI() throws ClientProtocolException, IOException, JSONException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws JSONException
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	private void initialize() throws ClientProtocolException, IOException, JSONException {
		frame3 = new JFrame();
		frame3.setType(Type.POPUP);
		frame3.setTitle("Jira Application");
		frame3.setResizable(false);
		frame3.setBounds(100, 100, 500, 350);
		frame3.setLocationRelativeTo(null);
		frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame3.getContentPane().setLayout(null);

		JLabel label0 = new JLabel("Issue Type ");
		label0.setFont(new Font("Tahoma", Font.BOLD, 14));
		label0.setBounds(21, 30, 180, 20);
		frame3.getContentPane().add(label0);

		JLabel label1 = new JLabel("Issue Status ");
		label1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label1.setBounds(21, 70, 180, 20);
		frame3.getContentPane().add(label1);

		JLabel label2 = new JLabel("Issue Due Date         ");
		label2.setFont(new Font("Tahoma", Font.BOLD, 14));
		label2.setBounds(21, 110, 180, 20);
		frame3.getContentPane().add(label2);

		JLabel label3 = new JLabel("Original Estimate Min.  ");
		label3.setFont(new Font("Tahoma", Font.BOLD, 14));
		label3.setBounds(21, 150, 180, 20);
		frame3.getContentPane().add(label3);

		JLabel label4 = new JLabel("Remaining Estimate Min. ");
		label4.setFont(new Font("Tahoma", Font.BOLD, 14));
		label4.setBounds(21, 190, 180, 20);
		frame3.getContentPane().add(label4);

		JLabel typelabel = new JLabel(App.getIssueType());
		typelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		typelabel.setBounds(246, 30, 238, 20);
		frame3.getContentPane().add(typelabel);

		JLabel statuslabel = new JLabel(App.getIssueStatus());
		statuslabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		statuslabel.setBounds(246, 70, 238, 20);
		frame3.getContentPane().add(statuslabel);

		JLabel duedatelabel = new JLabel(App.getIssueDueDate());
		duedatelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		duedatelabel.setBounds(246, 110, 238, 20);
		frame3.getContentPane().add(duedatelabel);

		JLabel orgminlabel = new JLabel(App.getIssueOriginalEstimateMinutes());
		orgminlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		orgminlabel.setBounds(246, 150, 238, 20);
		frame3.getContentPane().add(orgminlabel);

		JLabel remminlabel = new JLabel(App.getIssueRemiaingEstimateMinutes());
		remminlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		remminlabel.setBounds(246, 190, 238, 20);
		frame3.getContentPane().add(remminlabel);

		JButton nextbutton = new JButton("Next");
		nextbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JiraAppFourthGUI.FourthGUI();
				frame3.setVisible(false);

			}
		});
		nextbutton.setFont(new Font("Tahoma", Font.BOLD, 14));
		nextbutton.setBounds(336, 252, 125, 36);
		frame3.getContentPane().add(nextbutton);

		JButton backbutton = new JButton("Back");
		backbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame3.setVisible(false);
				JiraAppSecondGUI.frame2.setVisible(true);
				
			}
		});
		backbutton.setFont(new Font("Tahoma", Font.BOLD, 14));
		backbutton.setBounds(21, 252, 125, 36);
		frame3.getContentPane().add(backbutton);

		JLabel iconlabel = new JLabel();
		iconlabel.setIcon(new ImageIcon(JiraAppThirdGUI.class.getResource("/com/taylan/App/newimage.jpg")));
		iconlabel.setBounds(0, 0, 494, 321);
		frame3.getContentPane().add(iconlabel);
	}

}
