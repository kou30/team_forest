package model;

import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
	private String name;
	private String pass;
	private String tell;
	private Date createDate;
	private boolean superUser;

	public User() { }
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	public User(String name, String pass, String tell,Date createDate, boolean superUser) {
		this.name = name;
		this.pass = pass;
		this.tell = tell;
		this.createDate = createDate;
		this.superUser = superUser;
	}

	public String getName() { return name; }
	public String getPass() { return pass; }
	public String getTell() { return tell; }
	public Date getCreateDate() { return createDate; }
	public boolean getSuperUser() {return superUser; }
}


