package model;

import java.util.List;

import dao.TaskDAO;

public class GetTaskListLogic {
 public List<Task> execute(String room){
	 TaskDAO dao=new TaskDAO();
	 List<Task>taskList=dao.findAll(room);
	 return taskList;
 }
}
