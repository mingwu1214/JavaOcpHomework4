package controller.member;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import dao.impl.MemberDaoImpl;
import model.Member;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMemberUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberUI frame = new AddMemberUI();
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
	public AddMemberUI() {
		setTitle("註冊新帳號");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(10, 10, 416, 256);
		contentPane.add(panel);
        panel.setOpaque(false);  // Make the panel transparent
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("姓名");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 10, 114, 39);
		panel.add(lblNewLabel);
		
		name = new JTextField();
		name.setFont(new Font("微軟正黑體", Font.PLAIN, 28));
		name.setBounds(135, 18, 96, 21);
		panel.add(name);
		name.setColumns(10);
		
		JLabel lblUsername = new JLabel("帳號");
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		lblUsername.setBounds(10, 49, 114, 39);
		panel.add(lblUsername);
		
		username = new JTextField();
		username.setFont(new Font("微軟正黑體", Font.PLAIN, 28));
		username.setColumns(10);
		username.setBounds(135, 57, 96, 21);
		panel.add(username);
		
		JLabel lblPassword = new JLabel("密碼");
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		lblPassword.setBounds(10, 88, 114, 39);
		panel.add(lblPassword);
		
		password = new JTextField();
		password.setFont(new Font("微軟正黑體", Font.PLAIN, 28));
		password.setColumns(10);
		password.setBounds(135, 96, 96, 21);
		panel.add(password);
		
		JLabel lblAddress = new JLabel("地址");
		lblAddress.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		lblAddress.setForeground(new Color(255, 255, 255));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		lblAddress.setBounds(10, 127, 114, 39);
		panel.add(lblAddress);
		
		address = new JTextField();
		address.setFont(new Font("微軟正黑體", Font.PLAIN, 28));
		address.setColumns(10);
		address.setBounds(135, 135, 230, 21);
		panel.add(address);
		
		JLabel lblPhone = new JLabel("手機");
		lblPhone.setForeground(new Color(255, 255, 255));
		lblPhone.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		lblUsername.setForeground(new Color(255, 255, 255));
		lblUsername.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		lblPhone.setBounds(10, 159, 114, 39);
		panel.add(lblPhone);
		
		phone = new JTextField();
		phone.setFont(new Font("微軟正黑體", Font.PLAIN, 28));
		phone.setColumns(10);
		phone.setBounds(135, 167, 96, 21);
		panel.add(phone);
		
		JButton btnNewButton = new JButton("註冊新帳號");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Username=username.getText();
				
				Member m=new MemberDaoImpl().queryUsername(Username);
				
				if(m!=null)
				{
					AddMemberErrorUI a=new AddMemberErrorUI();
					a.setVisible(true);
					dispose();
				}
				else
				{
					String Name=name.getText();
					String Password=password.getText();
					String Address=address.getText();
					String Phone=phone.getText();
					
					Member m2=new Member(Name,Username,Password,Address,Phone);
					new MemberDaoImpl().addMember(m2);
					
					AddMemberSuccessUI a=new AddMemberSuccessUI();
					a.setVisible(true);
					dispose();
					
					
				}				
			}
		});
		btnNewButton.setBounds(289, 222, 96, 23);
		panel.add(btnNewButton);
		
		JLabel backgroundLabel = new JLabel(new ImageIcon(LoginUI.class.getResource("/images/signup.png")));
		backgroundLabel.setBounds(0, 0, 406, 256);
		panel.add(backgroundLabel);
	}
}
