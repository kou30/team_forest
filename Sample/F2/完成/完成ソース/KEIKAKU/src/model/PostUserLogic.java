package model;

import dao.UserDAO;

//ユーザーを新規登録するモデル
public class PostUserLogic {
public void execute(User user) {
	//登録処理
	UserDAO dao=new UserDAO();
	dao.create(user);
}
}
