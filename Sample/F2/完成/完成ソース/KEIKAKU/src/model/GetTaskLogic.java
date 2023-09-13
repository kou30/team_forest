package model;


import java.util.List;

import dao.TaskDAO;

public class GetTaskLogic {
  public List<Taskitiran>execute(Taskitiran roomtask){
		  TaskDAO dao = new TaskDAO();
		  List<Taskitiran>taskList = dao.find(roomtask);
		  return taskList;

  }
}
