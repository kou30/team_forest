package model;
import java.io.Serializable;

public class Task implements Serializable{
	private String roomid;//ルームID
	private String taskname;//タスク
	private String status;//状態
	private String userid;//ユーザーID
	private String color;//色

public Task(){}
public Task(String roomid,String taskname,String status,String userid,String color) {
	this.roomid=roomid;
	this.taskname=taskname;
	this.status=status;
	this.userid=userid;
	this.color=color;
}
public String getRoomid() {return roomid;}
public void setRoomid(String roomid) {
	this.roomid=roomid;
}

public String getTaskname() {return taskname;}
public void setTask(String taskname) {
	this.taskname=taskname;
}

public String getStatus() {return status;}
public void setStatus(String status) {
	this.status=status;
}
public String getUserid() {return userid;}
public void setUserid(String userid) {
	this.userid=userid;
}
public String getColor() {return color;}
public void setColor(String color) {
	this.color=color;
}
}
