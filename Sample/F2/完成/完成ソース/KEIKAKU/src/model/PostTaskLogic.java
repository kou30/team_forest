package model;

import dao.TaskDAO;

public class PostTaskLogic {

	public void execute(Taskitiran roomtask) {
		TaskDAO dao = new TaskDAO();
		dao.create(roomtask);
	}

}
