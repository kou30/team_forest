package model;
import java.io.Serializable;

public class RoomPass implements Serializable{
	private String roomid;	//部屋ID
	private String pass;	//PASSWORD

	public RoomPass() {}

	public RoomPass(String roomid) {
		this.roomid = roomid;
	}
	public RoomPass(String roomid,String pass) {
		this.roomid = roomid;
		this.pass = pass;
	}

	public String getRoomPass() {return pass;}
	public void setRoomPass(String pass) { this.pass = pass;}

	public String getRoomId() {return roomid;}
	public void setRoomId(String roomid) { this.roomid = roomid;}
}

