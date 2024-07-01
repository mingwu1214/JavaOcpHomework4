package controller.hermitcrabhouseorder;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import dao.impl.HermitCrabHouseOrderDaoImpl;
import model.HermitCrabHouseOrder;
import model.Member;
import util.Date;
import util.cal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;

public class HermitCrabHouseL3UI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HermitCrabHouseL3UI frame = new HermitCrabHouseL3UI();
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
	public HermitCrabHouseL3UI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HermitCrabHouseL3UI.class.getResource("/images/hermit-crab_64.png")));
		setTitle("自然舒居級: 提供自然的舒適殼型，讓寄居蟹享受自然的庇護。");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 820, 793);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("歡迎使用訂殼系統");
		lblNewLabel_2.setBounds(114, 62, 397, 30);
		lblNewLabel_2.setForeground(new Color(95, 158, 160));
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		lblNewLabel_2.setBackground(Color.WHITE);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("自然舒居級: 提供自然的舒適殼型，讓寄居蟹享受自然的庇護。");
		lblNewLabel.setBounds(114, 103, 515, 50);
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel.setBackground(Color.WHITE);
		contentPane.add(lblNewLabel);
		
		JRadioButton dd_2 = new JRadioButton("   貓眼螺");
		dd_2.setBounds(502, 419, 168, 23);
		buttonGroup.add(dd_2);
		dd_2.setForeground(new Color(95, 158, 160));
		dd_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		dd_2.setBackground(Color.WHITE);
		contentPane.add(dd_2);
		
		JRadioButton dd_1 = new JRadioButton("   綠螺天然殼");
		dd_1.setBounds(124, 419, 168, 23);
		buttonGroup.add(dd_1);
		dd_1.setForeground(new Color(95, 158, 160));
		dd_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        dd_1.setSelected(true); // Set dd_1 as selected by default
		dd_1.setBackground(Color.WHITE);
		contentPane.add(dd_1);
		
		JButton btnNewButton_1_1 = new JButton("確認");
		btnNewButton_1_1.setBounds(491, 664, 138, 40);
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object o = cal.readFile("member.txt");
				Member m = (Member) o;
				String name = m.getName();
				HermitCrabHouseOrder p=new HermitCrabHouseOrder();
				if (dd_1.isSelected()) {
					p.setName(name);
					p.setL1N1(0);
					p.setL1N2(0);
					p.setL2N1(0);
					p.setL2N2(0);			
					p.setL3N1(1);
					p.setL3N2(0);
					p.setDate(date.getText());
					p.setTime("12:00");
					p.setDate2(date.getText());
					p.setTime2("12:00");
					//new HermitCrabHouseOrderDaoImpl().add(p);
					cal.saveFile("HermitCrabHouseOrder.txt", p);
		        } else if (dd_2.isSelected()) {
					p.setName(name);
					p.setL1N1(0);
					p.setL1N2(0);
					p.setL2N1(0);
					p.setL2N2(0);			
					p.setL3N1(0);
					p.setL3N2(1);
					p.setDate(date.getText());
					p.setTime("12:00");
					p.setDate2(date.getText());
					p.setTime2("12:00");
					//new HermitCrabHouseOrderDaoImpl().add(p);
					cal.saveFile("HermitCrabHouseOrder.txt", p);
		        }
				HermitCrabHouseConfirmUI l= new HermitCrabHouseConfirmUI();
				l.setVisible(true);
	            dispose();
			
		}
	});
		btnNewButton_1_1.setForeground(UIManager.getColor("Button.select"));
		btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton_1_1.setBackground(Color.WHITE);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("返回寄居蟹度假豪華住宿選擇");
		btnNewButton_1_1_1.setBounds(114, 664, 278, 40);
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				HermitCrabHouseUI l= new HermitCrabHouseUI();
				l.setVisible(true);
				dispose();	
			}
		});
		btnNewButton_1_1_1.setForeground(UIManager.getColor("Button.select"));
		btnNewButton_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		contentPane.add(btnNewButton_1_1_1);
		
		JLabel pic01 = new JLabel("");
		pic01.setBounds(63, 191, 350, 200);
        pic01.setIcon(new ImageIcon(HermitCrabHouseL3UI.class.getResource("/images/L3N1.png")));
        pic01.setBackground(Color.WHITE);
        contentPane.add(pic01);
        
        JLabel pic01_1 = new JLabel("");
        pic01_1.setBounds(436, 191, 350, 200);
        pic01_1.setBackground(Color.WHITE);
        pic01_1.setIcon(new ImageIcon(HermitCrabHouseL3UI.class.getResource("/images/L3N2.png")));
        contentPane.add(pic01_1);
        
        JTextArea txtrBc = new JTextArea();
        txtrBc.setBounds(124, 484, 222, 122);
        txtrBc.setRows(1);
        txtrBc.setForeground(Color.GRAY);
        txtrBc.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        txtrBc.setLineWrap(true); 
        txtrBc.setWrapStyleWord(true); 
        txtrBc.setText("歡迎入住綠螺天然殼，寄居蟹的豪華度假勝地！寬敞舒適，通風透氣，自然涼爽，貼合您的需求。享受無與倫比的殼內生活，絕佳的度假之選！");
        contentPane.add(txtrBc);
        
        JTextArea txtrBc_1 = new JTextArea();
        txtrBc_1.setBounds(502, 484, 222, 136);
        txtrBc_1.setWrapStyleWord(true);
        txtrBc_1.setText("探秘貓眼螺的奇幻世界，寄居蟹的理想居所！溫暖舒適，獨特設計讓您享受愜意的殼內時光。度假休閒，非凡體驗，盡在貓眼螺！");
        txtrBc_1.setRows(1);
        txtrBc_1.setLineWrap(true);
        txtrBc_1.setForeground(Color.GRAY);
        txtrBc_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        contentPane.add(txtrBc_1);
        
        date = new JTextField();
        date.setFont(new Font("Tahoma", Font.PLAIN, 28));
		date.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Date date1=new Date(date);
				date1.showDialog();
			}
		});
        date.setBounds(301, 617, 154, 30);
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1; // months are 0-based
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String formattedmonth = String.format("%02d", month);
        String formattedday = String.format("%02d", day);

        date.setText( "" + year + "-" + formattedmonth + "-" + formattedday);
        contentPane.add(date);
        date.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("選擇入殼日期");
        lblNewLabel_1.setFont(new Font("微軟正黑體", Font.PLAIN, 28));
        lblNewLabel_1.setBounds(114, 617, 178, 30);
        contentPane.add(lblNewLabel_1);
		
		
	}
}


