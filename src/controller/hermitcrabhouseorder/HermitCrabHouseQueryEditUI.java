package controller.hermitcrabhouseorder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.member.LoginSuccessUI;
import dao.impl.HermitCrabHouseOrderDaoImpl;
import dao.impl.PorderDaoImpl;
import dao.impl.ProductDaoImpl;
import model.HermitCrabHouseOrder;
import model.Member;
import model.Porder;
import model.Product;
import util.cal;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PrinterException;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class HermitCrabHouseQueryEditUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HermitCrabHouseQueryEditUI frame = new HermitCrabHouseQueryEditUI();
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
	public HermitCrabHouseQueryEditUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(HermitCrabHouseQueryEditUI.class.getResource("/images/hermit-crab_64.png")));
		setTitle("列印訂殼清單");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 690, 419);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JTextArea output = new JTextArea();
		output.setBounds(25, 21, 642, 376);
		panel.add(output);
			
		Member m=(Member)(cal.readFile("member.txt"));

		List<HermitCrabHouseOrder> l = new HermitCrabHouseOrderDaoImpl().selectAll();
		HermitCrabHouseOrder[] p=l.toArray(new HermitCrabHouseOrder[l.size()]);
		int n=p.length -1;
	
		List<Product> ll = new ProductDaoImpl().selectAll();
		Product[] product=ll.toArray(new Product[l.size()]);

		String houseType="";
		String entryDate=p[n].getDate();
		String entryTime=p[n].getTime();
		if(p[n].getL1N1()>0) {
			houseType = "L1N1 穀倉木屋";
		} else if(p[n].getL1N1()>0) {
			houseType = "L1N2 木弧吊窩";
		} else if(p[n].getL2N1()>0) {
			houseType = "L2N1 智能光芒黃";
		} else if(p[n].getL2N1()>0) {
			houseType = "L2N2 未來探索粉";
		} else if(p[n].getL3N1()>0) {
			houseType = "L3N1 綠螺天然殼";
		} else if(p[n].getL3N1()>0) {
			houseType = "L3N2 貓眼螺";
		} 
		String outputDetail = "入住資訊:\n" +
		"\n" + "名子:\t" + p[n].getName() + 
		"\n" + "入住殼形:\t" + houseType + 
		"\n" + "入殼日期:\t" + entryDate +
		"\n" + "入殼時間:\t" + entryTime;

		output.setText(outputDetail);		
		
		JButton btnNewButton = new JButton("列印訂殼收據");
		btnNewButton.setIcon(new ImageIcon(HermitCrabHouseQueryEditUI.class.getResource("/images/hermit-crab_64.png")));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					output.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		btnNewButton.setBounds(34, 440, 295, 78);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("殼的世界入口");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginSuccessUI l=new LoginSuccessUI();
				l.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(HermitCrabHouseQueryEditUI.class.getResource("/images/hermit-crab_64.png")));
		btnNewButton_1.setFont(new Font("微軟正黑體", Font.BOLD, 28));
		btnNewButton_1.setBounds(350, 440, 330, 78);
		contentPane.add(btnNewButton_1);
	}
}
