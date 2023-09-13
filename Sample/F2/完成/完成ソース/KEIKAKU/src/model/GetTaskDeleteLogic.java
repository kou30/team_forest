package model;

import dao.TaskDAO;

public class GetTaskDeleteLogic {
	public void execute(RoomPass room) {
		TaskDAO dao = new TaskDAO();
		dao.delete(room);
	}
}
