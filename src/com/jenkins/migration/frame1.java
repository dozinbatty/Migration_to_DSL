package com.jenkins.migration;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;


import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.awt.event.ActionEvent;

//import com.jenkins.migration.*;

public class frame1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame1 window = new frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				URLConnectionReader objURLConnection = new URLConnectionReader();
						
				try {
					Properties prop = new Properties();
					String fileName = "./resources/config.properties";
					InputStream inputstream = new FileInputStream(fileName);
					prop.load(inputstream);
					//System.out.println("URL" + prop.getProperty("app.URL"));
			        String userpass = prop.getProperty("app.userpass");
			        String geturl = prop.getProperty("app.URL");
					JOptionPane.showMessageDialog(null, objURLConnection.getConfig(geturl,userpass));
					// Adding a testing line to the file for rebase
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnShow.setBounds(53, 106, 89, 23);
		frame.getContentPane().add(btnShow);
	}
}
