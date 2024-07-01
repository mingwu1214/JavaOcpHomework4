package controller;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.hermitcrabhouseorder.HermitCrabHouseUI;
import controller.member.AddMemberUI;
import controller.member.LoginErrorUI;
import controller.member.LoginSuccessUI;
import dao.impl.MemberDaoImpl;
import model.Member;
import util.cal;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.*;


public class LoginUI extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	JLabel timeLabel;

	/**
	 * Launch the application.;
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
				
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

	/**
	 * Create the frame.
	 */
	public LoginUI() {
		setTitle("寄居蟹度假豪華住宿");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginUI.class.getResource("/images/hermit-crab_64.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				new Thread(new clock()).start();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 587, 546);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 553, 488);
		contentPane.add(panel);
		panel.setLayout(null);
        panel.setOpaque(false);  // Make the panel transparent

		
		JLabel lblNewLabel = new JLabel("帳號");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblNewLabel.setBounds(60, 47, 96, 35);
		panel.add(lblNewLabel);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		username.setBounds(166, 53, 96, 21);
		panel.add(username);
		username.setColumns(10);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		password.setColumns(10);
		password.setBounds(166, 98, 96, 21);
		panel.add(password);
		
		JLabel lblPassword = new JLabel("密碼");
		lblPassword.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		lblPassword.setBounds(60, 92, 96, 35);
		panel.add(lblPassword);
		

		
		JButton btnSignup = new JButton("註冊");
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMemberUI l=new AddMemberUI();
				l.setVisible(true);
				dispose();				
			}
		});
		btnSignup.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnSignup.setBounds(44, 199, 96, 35);
		panel.add(btnSignup);
		

		JButton btnNewButton = new JButton("登入");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * 1.擷取-->username,password->getText
				 * 2.判斷-->queryMember(帳號,密碼);
				 * 3.!=null-->LoginSuccessUI
				 * 4.LoginErrorUI
				 */
				
				String Username=username.getText();
				String Password=password.getText();		
				Member m=new MemberDaoImpl().queryMember(Username, Password);
				
				if(m!=null) {
					/*
					try {
						FileOutputStream fos = new FileOutputStream("member.txt");
						ObjectOutputStream oos =new ObjectOutputStream(fos);
						oos.writeObject(m);
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();						
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					*/
					cal.saveFile("member.txt", m);
					
					LoginSuccessUI l=new LoginSuccessUI();
					l.setVisible(true);
					dispose();
				}else {
						LoginErrorUI l= new LoginErrorUI();
						l.setVisible(true);
						dispose();
				}
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.PLAIN, 20));
		btnNewButton.setBounds(166, 199, 96, 35);
		panel.add(btnNewButton);
		
		//JLabel timeLabel = new JLabel("00:00:00");
		timeLabel = new JLabel("00:00:00");
		timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		timeLabel.setBounds(377, 234, 127, 25);
		panel.add(timeLabel);

		 // Load the background image
        ImageIcon backgroundIcon = new ImageIcon(LoginUI.class.getResource("/images/home.png"));
        
		JLabel backgroundLabel = new JLabel(new ImageIcon(LoginUI.class.getResource("/images/home.png")));
		backgroundLabel.setBounds(10, 11, 533, 466);
		panel.add(backgroundLabel);
	
	}
	//
	private static String format(int n)
	{
		return n<10? "0"+n:""+n;
	}
	private static String getTime()

	{
		Calendar calendar=new GregorianCalendar();
		int H=calendar.get(Calendar.HOUR_OF_DAY);
		int M=calendar.get(calendar.MINUTE);
		int S=calendar.get(calendar.SECOND);
		
		return format(H)+":"+format(M)+":"+format(S);
	}
	private class clock implements Runnable
	{
		public void run()
		{
			while(true)
			{
				timeLabel.setText(getTime());
				
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				
			}
		}
	}
}
