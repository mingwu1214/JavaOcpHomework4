package dao;

import java.util.List;

import model.Product;

// CRUD
public interface ProductDao {
// create
	void add(Product p);
// read
	List<Product> selectAll();
	Product selectById(int id);
// update
	
// delete
}
