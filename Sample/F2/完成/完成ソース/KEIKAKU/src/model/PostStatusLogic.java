package model;

import dao.TaskDAO;

public class PostStatusLogic {
	public void execute(Task task) {
		TaskDAO dao =new TaskDAO();
		dao.update(task);
		}
}
