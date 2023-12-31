package model;
import java.io.Serializable;
import java.sql.Date;

public class Reserve implements Serializable{

	private int id;
	private int catId;
	private String userName;
	private String catName;
	private Date date;
	private Date birthday;
	private String sex;
	private String catKind;
	private String comment;

	public Reserve() {}
	public Reserve(int id, String userName, int catId, Date date, String comment) {
		this.id = id;
		this.userName = userName;
		this.catId = catId;
		this.date = date;
		this.comment = comment;
	}
	public Reserve(String userName, int catId, Date date, String comment) {
		this.userName = userName;
		this.catId = catId;
		this.date = date;
		this.comment = comment;
	}

	public Reserve(int id, int catId,String catName, Date birthday, Date date,String sex,String catKind, String comment) {
		this.id = id;
		this.catId = catId;
		this.catName = catName;
		this.birthday = birthday;
		this.date = date;
		this.sex = sex;
		this.catKind  =catKind;
		this.comment = comment;
	}

	public int getId() {return id;}
	public int getCatId() {return catId;}
	public String getUserName() {return userName;}
	public String getCatName() {return catName;}
	public Date getDate() {return date;}
	public Date getBirthday() {return birthday;}
	public String getSex() {return sex;}
	public String getCatKind() {return catKind;}
	public String getComment() {return comment;}




}
