package model;

import dao.TaskDAO;

public class PostUserid {
	public void execute(String room,String userid) {
		TaskDAO dao =new TaskDAO();
		dao.updateuserid(room,userid);
		}
}
