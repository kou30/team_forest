package model;

import dao.RoomDAO;

public class PostRoomListLogic {
	public String execute(RoomPass room) {
		RoomDAO dao = new RoomDAO();
		dao.create(room);
		String RoomId = dao.find();
		return RoomId;
	}
}
