package model;
import java.io.Serializable;

public class User implements Serializable{
	private String roomid;//ルームID
	private String userid;//ユーザーID
	private String name;//ユーザー名
	private String color;//ユーザーカラー

public User(){}
public User(String roomid,String name,String color) {
	this.roomid=roomid;
	this.name=name;
	this.color=color;
}
public User(String roomid,String userid, String name,String color) {
	this.roomid=roomid;
	this.userid=userid;
	this.name=name;
	this.color=color;
}
public User(String userid) {
this.userid=userid;
}

public User(String roomid,String userid) {
		this.roomid=roomid;
		this.userid=userid;
}
public String getRoomid() {return roomid;}
public void setRoomid(String roomid) {
	this.roomid=roomid;
}

public String getUserid() {return userid;}
public void setUserid(String userid) {
	this.userid=userid;
}

public String getName() {return name;}
public void setName(String name) {
	this.name=name;
}
public String getColor() {return color;}
public void setColor(String color) {
	this.color=color;
}
}
