package model;

import dao.RoomDAO;

public class GetRoomLogic {
	public RoomPass execute(RoomPass room){
		RoomDAO dao = new RoomDAO();
		RoomPass rooms = dao.select(room);
		return rooms;
	}
}