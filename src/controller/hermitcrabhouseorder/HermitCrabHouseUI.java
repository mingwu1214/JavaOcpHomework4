package controller.hermitcrabhouseorder;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.Toolkit;

public class HermitCrabHouseUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HermitCrabHouseUI frame = new HermitCrabHouseUI();
			        // Get the screen size
			        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

			        // Calculate the new location of the window
			        int x = (screenSize.width - frame.getWidth()) / 2;
			        int y = 0; // Align to the top

			        // Set the new location of the window
			        frame.setLocation(x, y);
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
	public HermitCrabHouseUI() {
		setTitle("寄居蟹度假豪華住宿選擇\n");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HermitCrabHouseUI.class.getResource("/images/hermit-crab_64.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 820, 793);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

        // Create a JButton
		JButton btnNewButtonL3 = new JButton("自然舒居級");
		btnNewButtonL3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HermitCrabHouseL3UI l= new HermitCrabHouseL3UI();
				l.setVisible(true);
				dispose();	
			}
		});
		btnNewButtonL3.setVerticalTextPosition(SwingConstants.CENTER);
		btnNewButtonL3.setForeground(new Color(255, 255, 255));
		btnNewButtonL3.setFont(new Font("微軟正黑體 Light", Font.BOLD, 48));
		btnNewButtonL3.setBounds(40, 129, 720, 150);
		btnNewButtonL3.setPreferredSize(new Dimension(720, 720));

        // Load the image icon
        ImageIcon iconL3 = new ImageIcon(HermitCrabHouseUI.class.getResource("/images/L3.png"));
        
        // Check if the image icon is loaded correctly
        if (iconL3.getImageLoadStatus() == MediaTracker.COMPLETE) {
            // Scale the image icon to fit the button size
            Image img = iconL3.getImage();
            Image scaledImg = img.getScaledInstance(btnNewButtonL3.getPreferredSize().width, btnNewButtonL3.getPreferredSize().height, Image.SCALE_SMOOTH);
            btnNewButtonL3.setIcon(new ImageIcon(scaledImg));
        } else {
            System.out.println("Image not found or failed to load.");
        }
        btnNewButtonL3.setHorizontalTextPosition(SwingConstants.CENTER);
        
		contentPane.add(btnNewButtonL3);
		
        // Create a JButton
		JButton btnNewButtonL2 = new JButton("科技智享級");
		btnNewButtonL2.setForeground(new Color(255, 255, 255));
		btnNewButtonL2.setFont(new Font("微軟正黑體 Light", Font.BOLD, 48));
		btnNewButtonL2.setBounds(40, 329, 720, 150);
		btnNewButtonL2.setPreferredSize(new Dimension(720, 720));

        // Load the image icon
        ImageIcon iconL2 = new ImageIcon(HermitCrabHouseUI.class.getResource("/images/L2.png"));
        
        // Check if the image icon is loaded correctly
        if (iconL2.getImageLoadStatus() == MediaTracker.COMPLETE) {
            // Scale the image icon to fit the button size
            Image img = iconL2.getImage();
            Image scaledImg = img.getScaledInstance(btnNewButtonL2.getPreferredSize().width, btnNewButtonL2.getPreferredSize().height, Image.SCALE_SMOOTH);
            btnNewButtonL2.setIcon(new ImageIcon(scaledImg));
        } else {
            System.out.println("Image not found or failed to load.");
        }
        btnNewButtonL2.setHorizontalTextPosition(SwingConstants.CENTER);
        
		contentPane.add(btnNewButtonL2);		

        // Create a JButton
		JButton btnNewButtonL1 = new JButton("奢華尊貴級");
		btnNewButtonL1.setForeground(new Color(255, 255, 255));
		btnNewButtonL1.setFont(new Font("微軟正黑體 Light", Font.BOLD, 48));
		btnNewButtonL1.setBounds(40, 529, 720, 150);
		btnNewButtonL1.setPreferredSize(new Dimension(1000, 264));

        // Load the image icon
        ImageIcon iconL1 = new ImageIcon(HermitCrabHouseUI.class.getResource("/images/L1.png"));
        
        // Check if the image icon is loaded correctly
        if (iconL1.getImageLoadStatus() == MediaTracker.COMPLETE) {
            // Scale the image icon to fit the button size
            Image img = iconL1.getImage();
            Image scaledImg = img.getScaledInstance(btnNewButtonL1.getPreferredSize().width, btnNewButtonL1.getPreferredSize().height, Image.SCALE_SMOOTH);
            btnNewButtonL1.setIcon(new ImageIcon(scaledImg));
        } else {
            System.out.println("Image not found or failed to load.");
        }
        btnNewButtonL1.setHorizontalTextPosition(SwingConstants.CENTER);
        
		contentPane.add(btnNewButtonL1);	
		
		JLabel lblNewLabel = new JLabel("寄居蟹度假豪華住宿選擇\n");
		lblNewLabel.setFont(new Font("標楷體", Font.PLAIN, 48));
		lblNewLabel.setBounds(40, 39, 546, 65);
		contentPane.add(lblNewLabel);
		

	}
}
