package controller.member;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.hermitcrabhouseorder.HermitCrabHouseUI;
import model.Member;
import util.cal;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class LoginSuccessUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginSuccessUI frame = new LoginSuccessUI();
			        // Get the screen size
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

			        // Calculate the new location of the window
			        int x = (screenSize.width - frame.getWidth()) / 2;
			        int y = 0; // Align to the top

			        // Set the new location of the window
			        frame.setLocation(x, y);
					frame.setVisible(true);					
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
	public LoginSuccessUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginSuccessUI.class.getResource("/images/hermit-crab_64.png")));
		setTitle("歡迎進入殼的世界");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 0, 467, 638);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 11, 443, 579);
		contentPane.add(panel);
		panel.setLayout(null);
		
		// 進入訂殼
		JButton btnNewButton = new JButton("進入訂殼");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setIcon(null);
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 48));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//PorderUI l=new PorderUI();
				HermitCrabHouseUI l= new HermitCrabHouseUI();
				l.setVisible(true);
				dispose();				
			}
		});
		btnNewButton.setPreferredSize(new Dimension(300, 300));

        // Load the image icon
        ImageIcon iconL3 = new ImageIcon(HermitCrabHouseUI.class.getResource("/images/enter01.png"));
        
        // Check if the image icon is loaded correctly
        if (iconL3.getImageLoadStatus() == MediaTracker.COMPLETE) {
            // Scale the image icon to fit the button size
            Image img = iconL3.getImage();
            Image scaledImg = img.getScaledInstance(btnNewButton.getPreferredSize().width, btnNewButton.getPreferredSize().height, Image.SCALE_SMOOTH);
            btnNewButton.setIcon(new ImageIcon(scaledImg));
        } else {
            System.out.println("Image not found or failed to load.");
        }
        btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);		
		btnNewButton.setBounds(20, 60, 401, 229);
		panel.add(btnNewButton);
		
		// +++ 查詢編修
		JButton btnNewButton2 = new JButton("查詢編修殼單");
		btnNewButton2.setForeground(new Color(255, 255, 255));
		btnNewButton2.setIcon(null);
		btnNewButton2.setFont(new Font("新細明體", Font.PLAIN, 48));
		btnNewButton2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//PorderUI l=new PorderUI();
				HermitCrabHouseUI l= new HermitCrabHouseUI();
				l.setVisible(true);
				dispose();				
			}
		});
		btnNewButton2.setPreferredSize(new Dimension(300, 300));

        // Load the image icon
        ImageIcon iconL3_2 = new ImageIcon(HermitCrabHouseUI.class.getResource("/images/enter01.png"));
        
        // Check if the image icon is loaded correctly
        if (iconL3_2.getImageLoadStatus() == MediaTracker.COMPLETE) {
            // Scale the image icon to fit the button size
            Image img = iconL3_2.getImage();
            Image scaledImg = img.getScaledInstance(btnNewButton2.getPreferredSize().width, btnNewButton2.getPreferredSize().height, Image.SCALE_SMOOTH);
            btnNewButton2.setIcon(new ImageIcon(scaledImg));
        } else {
            System.out.println("Image not found or failed to load.");
        }
        btnNewButton2.setHorizontalTextPosition(SwingConstants.CENTER);		
        btnNewButton2.setBounds(20, 330, 401, 229);
		panel.add(btnNewButton2);		
		// --- 查詢編修
		
		JLabel memberShow = new JLabel("");
		memberShow.setFont(new Font("新細明體", Font.BOLD, 28));
		memberShow.setBounds(258, 23, 134, 26);
		panel.add(memberShow);
		
		JLabel lblNewLabel = new JLabel("歡迎進入殼的世界");
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		lblNewLabel.setBounds(10, 11, 245, 39);
		panel.add(lblNewLabel);
		
		Object o = cal.readFile("member.txt");
		Member m = (Member) o;
		memberShow.setText(m.getName());
		/*
		try {
			FileInputStream fis = new FileInputStream("member.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Member m= (Member)(ois.readObject());
			memberShow.setText(m.getName());
			

		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	}
}
