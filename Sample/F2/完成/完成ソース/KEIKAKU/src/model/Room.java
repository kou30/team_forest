package model;

import java.io.Serializable;

public class Room implements Serializable{
		private String pass;//パスワード
public Room() {}
	public Room(String pass) {
		this.pass=pass;
	}
	public String getPass() {return pass;}

}
