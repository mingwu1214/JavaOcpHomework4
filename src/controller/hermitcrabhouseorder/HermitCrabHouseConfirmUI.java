package controller.hermitcrabhouseorder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.LoginErrorUI;
import controller.member.LoginSuccessUI;
import dao.impl.HermitCrabHouseOrderDaoImpl;
import dao.impl.ProductDaoImpl;
import model.HermitCrabHouseOrder;
import model.Product;
import util.cal;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class HermitCrabHouseConfirmUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HermitCrabHouseConfirmUI frame = new HermitCrabHouseConfirmUI();
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
	public HermitCrabHouseConfirmUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HermitCrabHouseConfirmUI.class.getResource("/images/hermit-crab_64.png")));
		setTitle("請確認您的訂殼清單");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 359);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 416, 302);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel custom = new JLabel("?");
		custom.setFont(new Font("微軟正黑體", Font.BOLD, 20));
		custom.setBackground(new Color(128, 255, 255));
		custom.setBounds(10, 20, 102, 29);
		panel.add(custom);
		
		JLabel show = new JLabel("您的訂殼清單");
		show.setVerticalAlignment(SwingConstants.TOP);
		show.setFont(new Font("新細明體", Font.BOLD, 28));
		show.setBounds(122, 12, 269, 48);
		panel.add(show);
		

		
		JTextArea output = new JTextArea();
		output.setBounds(20, 67, 368, 156);
		panel.add(output);

		/**/
		List<Product> l = new ProductDaoImpl().selectAll();
		Product[] product=l.toArray(new Product[l.size()]);

		HermitCrabHouseOrder p=(HermitCrabHouseOrder)(cal.readFile("HermitCrabHouseOrder.txt"));
		
		custom.setText(p.getName());

		String houseType="";
		String entryDate=p.getDate();
		String entryTime=p.getTime();
		if(p.getL1N1()>0) {
			houseType = "L1N1 穀倉木屋";
		} else if(p.getL1N1()>0) {
			houseType = "L1N2 木弧吊窩";
		} else if(p.getL2N1()>0) {
			houseType = "L2N1 智能光芒黃";
		} else if(p.getL2N1()>0) {
			houseType = "L2N2 未來探索粉";
		} else if(p.getL3N1()>0) {
			houseType = "L3N1 綠螺天然殼";
		} else if(p.getL3N1()>0) {
			houseType = "L3N2 貓眼螺";
		} 
		String outputDetail = "入住資訊:\n" +
		"\n" + "名子:\t" + p.getName() + 
		"\n" + "入住殼形:\t" + houseType + 
		"\n" + "入殼日期:\t" + entryDate +
		"\n" + "入殼時間:\t" + entryTime;

		output.setText(outputDetail);
		
		JButton btnNewButton = new JButton("確認訂殼");
		btnNewButton.setIcon(new ImageIcon(HermitCrabHouseConfirmUI.class.getResource("/images/hermit-crab_64.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new HermitCrabHouseOrderDaoImpl().add(p);
				HermitCrabHouseFinishUI l= new HermitCrabHouseFinishUI();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		btnNewButton.setBounds(150, 234, 241, 57);
		panel.add(btnNewButton);		
	}
}
