package model;

import java.io.Serializable;

public class Product implements Serializable {
	private Integer id;
	private Integer productid;
	private String name;
	private String description;
	private Integer price;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(Integer productid, String name, String description, Integer price) {
		super();
		this.productid = productid;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getProductid() {
		return productid;
	}
	public void setProductid(Integer productid) {
		this.productid = productid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}
