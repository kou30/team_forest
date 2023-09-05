package model;

import java.sql.Date;

public class ShinamonoDTO {
	private int shinamono_id;
	private int user_id;
	private String aite_name;
	private Date re_time;
	private int bunrui;
	private int category;
	private int item;
	private String shinamono_name;
	private int shinamono_kingaku;
	private String memo;
	
	public ShinamonoDTO() {}
	
	public ShinamonoDTO(int shinamono_id,int user_id,String aite_name,Date re_time,int bunrui,int category,int item,String shinamono_name,int shinamono_kingaku,String memo) {
	this.shinamono_id=shinamono_id;
	this.user_id=user_id;
	this.aite_name=aite_name;
	this.re_time=re_time;
	this.bunrui=bunrui;
	this.category=category;
	this.item=item;
	this.shinamono_name=shinamono_name;
	this.shinamono_kingaku=shinamono_kingaku;
	this.memo=memo;
	}
	
	public int getShinamono_id() {
		return shinamono_id;
	}
	public void setShinamono_id(int shinamono_id) {
		this.shinamono_id = shinamono_id;
	}
	public Date getRe_time() {
		return re_time;
	}
	public void setRe_time(Date re_time) {
		this.re_time = re_time;
	}
	public int getBunrui() {
		return bunrui;
	}
	public void setBunrui(int bunrui) {
		this.bunrui = bunrui;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public String getShinamono_name() {
		return shinamono_name;
	}
	public void setShinamono_name(String shinamono_name) {
		this.shinamono_name = shinamono_name;
	}
	public int getShinamono_kingaku() {
		return shinamono_kingaku;
	}
	public void setShinamono_kingaku(int shinamono_kingaku) {
		this.shinamono_kingaku = shinamono_kingaku;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getAite_name() {
		return aite_name;
	}

	public void setAite_name(String aite_name) {
		this.aite_name = aite_name;
	}
	
}

