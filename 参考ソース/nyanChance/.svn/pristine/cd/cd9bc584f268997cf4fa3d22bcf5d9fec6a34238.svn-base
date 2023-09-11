package model;

import java.util.List;
import dao.UserDAO;

public class UserLogic {
	public List<User> findAll() {
		UserDAO dao = new UserDAO();
		List<User> userList = dao.findAll();
		return userList;
	}
	public boolean create(User user) {
		UserDAO dao = new UserDAO();
		return dao.create(user);

	}
	public void delete() {
		UserDAO dao = new UserDAO();
		dao.delete();
	}
}
