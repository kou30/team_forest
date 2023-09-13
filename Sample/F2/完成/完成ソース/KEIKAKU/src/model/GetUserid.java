package model;
import dao.UserDAO;
public class GetUserid {
	public String execute(String roomid) {
		UserDAO dao=new UserDAO();
			String userid=dao.find(roomid);
		return userid;

	}
}

