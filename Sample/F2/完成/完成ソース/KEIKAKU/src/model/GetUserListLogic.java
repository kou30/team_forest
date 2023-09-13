package model;

import java.util.List;

import dao.UserDAO;

public class GetUserListLogic {
 public List<User> execute(String room){
	 UserDAO dao=new UserDAO();
	 List<User>userList=dao.findAll(room);
	 return userList;
 }
}
