package model;

import dao.UserDAO;

public class LoginLogic {

	public User execute(User user) {
		UserDAO dao = new UserDAO();
		user = dao.login(user);
		if (user != null) { return user; }
		return null;
	}
}
