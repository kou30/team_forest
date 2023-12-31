package model;
import java.io.Serializable;
import java.util.Date;


public class Cat implements Serializable{
	private int id;
	private String name;
	private Date birthday;
	private String age;
	private String sex;
	private String catKind;
	private boolean isFosterParents;
	private String comment;


	public Cat() {}
	public Cat(int id,String name,Date birthday,String age,String sex,String catKind,boolean isFosterParents,String comment) {
		this.id=id;
		this.name=name;
		this.birthday=birthday;
		this.age=age;
		this.sex=sex;
		this.catKind=catKind;
		this.isFosterParents=isFosterParents;
		this.comment=comment;
	}

	public int getId() {return id;}
	public String getName() {return name;}
	public Date getBirthday() {return birthday;}
	public String getAge() {return age;}
	public String getSex() {return sex;}
	public String getCatKind() {return catKind;}
	public boolean getIsFosterParents() {return isFosterParents;}
	public String getComment() {return comment;}
}
