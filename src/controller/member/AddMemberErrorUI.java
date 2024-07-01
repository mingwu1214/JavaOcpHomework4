package controller.member;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.LoginUI;
import controller.hermitcrabhouseorder.HermitCrabHouseUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Toolkit;
import javax.swing.JLabel;

public class AddMemberErrorUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddMemberErrorUI frame = new AddMemberErrorUI();
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
	public AddMemberErrorUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddMemberErrorUI.class.getResource("/images/0-1420_red-cross-mark-clipart-green-checkmark-red-x.png")));
		setTitle("註冊新帳號失敗");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 416, 265);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("重新再註冊一次");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddMemberUI l= new AddMemberUI();
				l.setVisible(true);
				dispose();				
			}
		});
		btnNewButton.setPreferredSize(new Dimension(400, 250));

        // Load the image icon
        ImageIcon iconL3 = new ImageIcon(HermitCrabHouseUI.class.getResource("/images/error01.png"));
        
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
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 28));
		btnNewButton.setBounds(20, 39, 372, 215);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("註冊新帳號失敗");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		lblNewLabel.setBounds(20, 0, 372, 38);
		panel.add(lblNewLabel);
	}

}
