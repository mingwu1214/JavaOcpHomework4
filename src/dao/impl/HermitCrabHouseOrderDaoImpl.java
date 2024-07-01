package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.HermitCrabHouseOrderDao;
import model.HermitCrabHouseOrder;

public class HermitCrabHouseOrderDaoImpl implements HermitCrabHouseOrderDao {

	public static void main(String[] args) {
		//Porder p = new Porder("test01",1,2,3);
		//new PorderDaoImpl().add(p);
		List<HermitCrabHouseOrder> l=new HermitCrabHouseOrderDaoImpl().selectAll();
		for(HermitCrabHouseOrder p2:l) 
		{
			System.out.println(p2.getId() + "\t" + p2.getName() +"\t"+p2.getL1N1() +"\t"+p2.getL1N2() +"\t"+p2.getL2N1() +"\t"+p2.getL2N2() +"\t"+p2.getL3N1() +"\t"+p2.getL3N2());
		}
		System.out.println("================================");
		HermitCrabHouseOrder p3=new HermitCrabHouseOrderDaoImpl().selectById(1);
		System.out.println(p3.getId() + "\t" + p3.getName() +"\t"+p3.getL1N1() +"\t"+p3.getL1N2() +"\t"+p3.getL2N1() +"\t"+p3.getL2N2() +"\t"+p3.getL3N1() +"\t"+p3.getL3N2());
	}

	@Override
	public void add(HermitCrabHouseOrder p) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getDb();
		String SQL="insert into hermitcrabhouseorder(name,l1n1,l1n2,l2n1,l2n2,l3n1,l3n2,date,time,date2,time2) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getL1N1());
			ps.setInt(3, p.getL1N2());
			ps.setInt(4, p.getL2N1());
			ps.setInt(5, p.getL2N2());
			ps.setInt(6, p.getL3N1());
			ps.setInt(7, p.getL3N2());
			ps.setString(8, p.getDate());
			ps.setString(9, p.getTime());
			ps.setString(10, p.getDate2());
			ps.setString(11, p.getTime2());						
			ps.executeUpdate();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public List<HermitCrabHouseOrder> selectAll() {
		/*
		 * 1.先連線-->Connection
		 * 2.sQL
		 * 3.new ArrayList
		 * 4.執行-->preparedstatement-->executeQuery
		 * 5.ResultSet-->顯示-->List
		 * 
		 */
		Connection conn=DbConnection.getDb();
		String SQL="select * from hermitcrabhouseorder";
		List<HermitCrabHouseOrder> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				HermitCrabHouseOrder p = new HermitCrabHouseOrder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setL1N1(rs.getInt("L1N1"));
				p.setL1N2(rs.getInt("L1N2"));
				p.setL2N1(rs.getInt("L2N1"));
				p.setL2N2(rs.getInt("L2N2"));
				p.setL3N1(rs.getInt("L3N1"));
				p.setL3N2(rs.getInt("L3N2"));	
				p.setDate(rs.getString("date"));
				p.setTime(rs.getString("time"));
				p.setDate2(rs.getString("date2"));
				p.setTime2(rs.getString("time2"));				
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public HermitCrabHouseOrder selectById(int id) {
		Connection conn=DbConnection.getDb();
		System.out.println(conn);
		String SQL="select * from hermitcrabhouseorder where id=?";
		HermitCrabHouseOrder p=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				p=new HermitCrabHouseOrder();
				p.setId(rs.getInt("id"));
				p.setName(rs.getString("name"));
				p.setL1N1(rs.getInt("L1N1"));
				p.setL1N2(rs.getInt("L1N2"));
				p.setL2N1(rs.getInt("L2N1"));
				p.setL2N2(rs.getInt("L2N2"));
				p.setL3N1(rs.getInt("L3N1"));
				p.setL3N2(rs.getInt("L3N2"));	
				p.setDate(rs.getString("date"));
				p.setTime(rs.getString("time"));
				p.setDate2(rs.getString("date2"));
				p.setTime2(rs.getString("time2"));			
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

}
