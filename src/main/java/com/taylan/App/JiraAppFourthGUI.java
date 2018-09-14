package com.taylan.App;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JiraAppFourthGUI {

	public static JFrame frame4;

	public static JTextField workhourtextf;
	public static JDateChooser startdatechooser;
	public static JDateChooser finishdatechooser;
	public static JTextArea commentarea;

	/**
	 * Launch the application.
	 */
	public static void FourthGUI() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JiraAppFourthGUI window = new JiraAppFourthGUI();
					window.frame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JiraAppFourthGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame4 = new JFrame();
		frame4.setTitle("Jira Application");
		frame4.setResizable(false);
		frame4.setType(Type.POPUP);
		frame4.setBounds(100, 100, 500, 350);
		frame4.setLocationRelativeTo(null);
		frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame4.getContentPane().setLayout(null);

		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStartDate.setBounds(21, 30, 180, 20);
		frame4.getContentPane().add(lblStartDate);

		JLabel lblFinishDate = new JLabel("Finish Date");
		lblFinishDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFinishDate.setBounds(21, 70, 180, 20);
		frame4.getContentPane().add(lblFinishDate);

		JLabel lblWorkHour = new JLabel("Work Hour");
		lblWorkHour.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWorkHour.setBounds(21, 110, 180, 20);
		frame4.getContentPane().add(lblWorkHour);

		JLabel lblComment = new JLabel("Comment");
		lblComment.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblComment.setBounds(21, 150, 180, 20);
		frame4.getContentPane().add(lblComment);

		startdatechooser = new JDateChooser();
		startdatechooser.setDateFormatString("yyyy.MM.dd");
		startdatechooser.getCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 14));
		startdatechooser.setBounds(252, 30, 180, 20);

		frame4.getContentPane().add(startdatechooser);

		finishdatechooser = new JDateChooser();
		finishdatechooser.setBounds(252, 70, 180, 20);
		frame4.getContentPane().add(finishdatechooser);
		finishdatechooser.getCalendarButton().setFont(new Font("Tahoma", Font.BOLD, 14));

		finishdatechooser.setDateFormatString("yyyy.MM.dd");

		workhourtextf = new JTextField();
		workhourtextf.setText("(Ex:3h)");
		workhourtextf.setBounds(252, 110, 180, 20);
		frame4.getContentPane().add(workhourtextf);
		workhourtextf.setColumns(10);
		workhourtextf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				workhourtextf.setText("");
			}

		});

		commentarea = new JTextArea();
		commentarea.setBounds(252, 150, 180, 22);
		commentarea.setText("Working on issue " + JiraAppSecondGUI.issuekeytextf.getText());
		commentarea.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				commentarea.setText("");
			}

		});
		frame4.getContentPane().add(commentarea);

		JButton btnSave = new JButton("Save ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (finishdatechooser.getDate().before(startdatechooser.getDate())
						|| finishdatechooser.getDate().getTime() == 0 || startdatechooser.getDate().getTime() == 0) {

					String message = "Please select correct dates !";
					JOptionPane.showMessageDialog(frame4, message, "Error", JOptionPane.ERROR_MESSAGE);

					frame4.setVisible(true);

				} else if (workhourtextf.getText().isEmpty() == true) {

					String message = "Please enter Work Hour !";
					JOptionPane.showMessageDialog(frame4, message, "Error", JOptionPane.ERROR_MESSAGE);

					frame4.setVisible(true);

				} else if (commentarea.getText().isEmpty()) {

					String message = "Please enter your comment !";
					JOptionPane.showMessageDialog(frame4, message, "Error", JOptionPane.ERROR_MESSAGE);

					frame4.setVisible(true);

				} else {

					startdatechooser.setEnabled(false);
					finishdatechooser.setEnabled(false);
					frame4.setVisible(false);
					TimerClass.Timer();

				}

			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(336, 252, 125, 36);
		frame4.getContentPane().add(btnSave);

		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame4.setVisible(false);
				JiraAppThirdGUI.frame3.setVisible(true);

			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		button_1.setBounds(21, 252, 125, 36);
		frame4.getContentPane().add(button_1);

		JLabel iconlabel = new JLabel();
		iconlabel.setIcon(new ImageIcon(JiraAppFourthGUI.class.getResource("/com/taylan/App/newimage.jpg")));
		iconlabel.setBounds(0, 0, 494, 321);
		frame4.getContentPane().add(iconlabel);
	}
}
