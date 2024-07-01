package dao;

import java.util.List;

import model.HermitCrabHouseOrder;

// CRUD
public interface HermitCrabHouseOrderDao {
// create
	void add(HermitCrabHouseOrder p);
// read
	List<HermitCrabHouseOrder> selectAll();
	HermitCrabHouseOrder selectById(int id);
	List<HermitCrabHouseOrder> selectByName(String name);

// update
	
// delete
}
