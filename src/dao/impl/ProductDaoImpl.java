package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DbConnection;
import dao.ProductDao;
import model.Product;

public class ProductDaoImpl implements ProductDao {

	public static void main(String[] args) {
		//Product p = new Product("test01",1,2,3);
		//new ProductDaoImpl().add(p);
		List<Product> l=new ProductDaoImpl().selectAll();
		for(Product p2:l) 
		{
			System.out.println(p2.getId() + "\t" + p2.getName() +"\t"+p2.getDescription() +"\t"+p2.getPrice());
		}
		System.out.println("================================");
		Product p3=new ProductDaoImpl().selectById(1);
		System.out.println(p3.getId() + "\t" + p3.getName() +"\t"+p3.getDescription() +"\t"+p3.getPrice());

	}

	@Override
	public void add(Product p) {
		// TODO Auto-generated method stub
		Connection conn=DbConnection.getDb();
		String SQL="insert into Product(productid,name,description,price) values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, p.getProductid());
			ps.setString(2, p.getName());
			ps.setString(3, p.getDescription());
			ps.setInt(4, p.getPrice());
			ps.executeUpdate();
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public List<Product> selectAll() {
		/*
		 * 1.先連線-->Connection
		 * 2.sQL
		 * 3.new ArrayList
		 * 4.執行-->preparedstatement-->executeQuery
		 * 5.ResultSet-->顯示-->List
		 * 
		 */
		Connection conn=DbConnection.getDb();
		String SQL="select * from Product";
		List<Product> l=new ArrayList();
		
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) 
			{
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setProductid(rs.getInt("productid"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getInt("price"));		
				l.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Product selectById(int id) {
		Connection conn=DbConnection.getDb();
		System.out.println(conn);
		String SQL="select * from Product where id=?";
		Product p=null;
		try {
			PreparedStatement ps=conn.prepareStatement(SQL);
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				p=new Product();
				p.setId(rs.getInt("id"));
				p.setProductid(rs.getInt("productid"));
				p.setName(rs.getString("name"));
				p.setDescription(rs.getString("description"));
				p.setPrice(rs.getInt("price"));			
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return p;
	}

}