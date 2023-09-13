// メッセージの投稿と取得に関する処理を行うモデル

package model;

import java.util.List;

import dao.MessageDAO;

public class MessageLogic {

	// メッセージの投稿
	public void execute(MessageInfo messageInfo) {
		MessageDAO dao = new MessageDAO();
		dao.create(messageInfo);
	}

	// 動物の主キーを指定したメッセージの取得
	public List<MessageInfo> execute(int animal_key) {
		MessageDAO dao = new MessageDAO();
		List<MessageInfo> messageInfoList = dao.findAll(animal_key);
		return messageInfoList;
	}
}
