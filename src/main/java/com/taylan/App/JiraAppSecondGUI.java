package com.taylan.App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jettison.json.JSONException;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class JiraAppSecondGUI {

	public static JFrame frame2;
	public static JTextField issuekeytextf;
	public static String issueKey;

	/**
	 * Launch the application.
	 */
	public static void SecondGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JiraAppSecondGUI window = new JiraAppSecondGUI();
					window.frame2.setVisible(true);
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
	public JiraAppSecondGUI() throws ClientProtocolException, IOException, JSONException {
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
		frame2 = new JFrame();
		frame2.setTitle("Jira Application");
		frame2.setType(Type.POPUP);
		frame2.setResizable(false);
		frame2.setBounds(100, 100, 500, 350);
		frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.getContentPane().setLayout(null);

		JLabel userlabel = new JLabel("User          : ");
		userlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		userlabel.setBounds(53, 85, 134, 20);
		frame2.getContentPane().add(userlabel);

		JLabel issuekeylabel = new JLabel("Issue Key :");
		issuekeylabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		issuekeylabel.setBounds(53, 149, 134, 20);
		frame2.getContentPane().add(issuekeylabel);

		JLabel displaynamelabel = new JLabel(App.getUserDisplayName());
		displaynamelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		displaynamelabel.setBounds(204, 87, 290, 20);
		frame2.getContentPane().add(displaynamelabel);

		issuekeytextf = new JTextField();
		issuekeytextf.setFont(new Font("Tahoma", Font.BOLD, 14));
		issuekeytextf.setColumns(10);
		issuekeytextf.setBounds(204, 151, 192, 20);
		frame2.getContentPane().add(issuekeytextf);

		JButton nextbutton = new JButton("Next");
		nextbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					issueKey = issuekeytextf.getText();
					App.getIssueType();

					if (issuekeytextf.getText().isEmpty() == true) {
						String message = "Please enter your informations correctly";
						JOptionPane.showMessageDialog(frame2, message, "Error", JOptionPane.ERROR_MESSAGE);
						frame2.setVisible(true);
					} else {
						issueKey = issuekeytextf.getText();
						JiraAppThirdGUI.ThirdGUI();
						frame2.setVisible(false);
					}
				} catch (JSONException ex) {

					String message = "Wrong Issue Key";
					JOptionPane.showMessageDialog(frame2, message, "Error", JOptionPane.ERROR_MESSAGE);
					frame2.setVisible(true);

				} catch (ClientProtocolException e1) {

					e1.printStackTrace();
				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});
		nextbutton.setFont(new Font("Tahoma", Font.BOLD, 14));
		nextbutton.setBounds(312, 223, 125, 36);
		frame2.getContentPane().add(nextbutton);

		JLabel iconlabel = new JLabel();
		iconlabel.setIcon(new ImageIcon(JiraAppSecondGUI.class.getResource("/com/taylan/App/newimage.jpg")));
		iconlabel.setBounds(0, 0, 494, 321);
		frame2.getContentPane().add(iconlabel);
	}

}
