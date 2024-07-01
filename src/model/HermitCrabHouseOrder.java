package model;

import java.io.Serializable;

public class HermitCrabHouseOrder implements Serializable {
	private Integer id;
	private String name;
	private Integer L1N1;
	private Integer L1N2;
	private Integer L2N1;
	private Integer L2N2;
	private Integer L3N1;
	private Integer L3N2;	
	private String date;
	private String time;
	private String date2;
	private String time2;
	

	public HermitCrabHouseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HermitCrabHouseOrder(Integer id, String name, Integer l1n1, Integer l1n2, Integer l2n1, Integer l2n2,
			Integer l3n1, Integer l3n2, String date, String time, String date2, String time2) {
		super();
		this.id = id;
		this.name = name;
		L1N1 = l1n1;
		L1N2 = l1n2;
		L2N1 = l2n1;
		L2N2 = l2n2;
		L3N1 = l3n1;
		L3N2 = l3n2;
		this.date = date;
		this.time = time;
		this.date2 = date2;
		this.time2 = time2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getL1N1() {
		return L1N1;
	}

	public void setL1N1(Integer l1n1) {
		L1N1 = l1n1;
	}

	public Integer getL1N2() {
		return L1N2;
	}

	public void setL1N2(Integer l1n2) {
		L1N2 = l1n2;
	}

	public Integer getL2N1() {
		return L2N1;
	}

	public void setL2N1(Integer l2n1) {
		L2N1 = l2n1;
	}

	public Integer getL2N2() {
		return L2N2;
	}

	public void setL2N2(Integer l2n2) {
		L2N2 = l2n2;
	}

	public Integer getL3N1() {
		return L3N1;
	}

	public void setL3N1(Integer l3n1) {
		L3N1 = l3n1;
	}

	public Integer getL3N2() {
		return L3N2;
	}

	public void setL3N2(Integer l3n2) {
		L3N2 = l3n2;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	public String getTime2() {
		return time2;
	}

	public void setTime2(String time2) {
		this.time2 = time2;
	}

}
