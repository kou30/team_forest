package model;

import java.io.Serializable;

public class Taskitiran implements Serializable{
	private String roomId;	//部屋ID
	private String task;	//タスク

	public Taskitiran() {}
	public Taskitiran(String task) {
		this.task = task;
	}

	public Taskitiran(String sessionId,String tasks) {
		this.roomId = sessionId;
		this.task = tasks;
	}

	public String getTask() {return task;}
	public void setTask(String task) {
		this.task = task;
	}
	public String getRoomId() {return roomId;}
	public void setRoomId(String roomId) {
		this.roomId = roomId;}

}