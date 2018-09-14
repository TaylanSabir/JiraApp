package com.taylan.App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import org.apache.http.client.ClientProtocolException;
import org.codehaus.jettison.json.JSONException;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class JiraAppFirstGUI {

	public static JFrame frame1;
	public static JTextField usernametextf;
	public static JPasswordField passwordtextf;
	public static String username;
	public static String password;

	/**
	 * Launch the application.
	 */
	public static void FirstGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JiraAppFirstGUI window = new JiraAppFirstGUI();
					window.frame1.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JiraAppFirstGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.setResizable(false);
		frame1.setTitle("Jira Application");
		frame1.setType(Type.POPUP);
		frame1.setBounds(100, 100, 500, 350);
		frame1.setLocationRelativeTo(null);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);

		JLabel usernamelabel = new JLabel("Username : ");
		usernamelabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernamelabel.setBounds(53, 85, 134, 20);
		frame1.getContentPane().add(usernamelabel);

		JLabel passwordlabel = new JLabel("Password  :");
		passwordlabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordlabel.setBounds(53, 149, 134, 20);
		frame1.getContentPane().add(passwordlabel);

		usernametextf = new JTextField();
		usernametextf.setFont(new Font("Tahoma", Font.BOLD, 14));
		usernametextf.setBounds(245, 84, 192, 20);
		frame1.getContentPane().add(usernametextf);
		usernametextf.setColumns(10);

		passwordtextf = new JPasswordField();
		passwordtextf.setEchoChar('*');
		passwordtextf.setFont(new Font("Tahoma", Font.BOLD, 14));
		passwordtextf.setBounds(245, 148, 192, 20);
		frame1.getContentPane().add(passwordtextf);

		JButton loginbutton = new JButton("Login");
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					username = usernametextf.getText();
					password = passwordtextf.getText();
					App.getUserDisplayName();

					if (usernametextf.getText().isEmpty() == true || passwordtextf.getPassword().length == 0) {

						String message = "Please enter your informations correctly";
						JOptionPane.showMessageDialog(frame1, message, "Error", JOptionPane.ERROR_MESSAGE);
						frame1.setVisible(true);
					} else {
						username = usernametextf.getText();
						password = passwordtextf.getText();
						JiraAppSecondGUI.SecondGUI();
						frame1.setVisible(false);

					}

				} catch (JSONException ex) {

					String message = "Wrong ID-Password";
					JOptionPane.showMessageDialog(frame1, message, "Error", JOptionPane.ERROR_MESSAGE);
					frame1.setVisible(true);

				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		loginbutton.setFont(new Font("Tahoma", Font.BOLD, 14));
		loginbutton.setBounds(172, 223, 125, 36);
		frame1.getContentPane().add(loginbutton);

		JLabel iconlabel = new JLabel();
		iconlabel.setIcon(new ImageIcon(JiraAppFirstGUI.class.getResource("/com/taylan/App/newimage.jpg")));
		iconlabel.setBounds(0, 0, 494, 321);
		frame1.getContentPane().add(iconlabel);

	}

	public static String getKey() {

		String usernamepassword = username + ":" + password;
		byte[] encoded = java.util.Base64.getEncoder().encode(usernamepassword.getBytes());
		String key = new String(encoded);

		return key;
	}

}
