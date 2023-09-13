// メッセージに関する情報を持つ JavaBeans
//  MESSAGEテーブルのレコードを表すクラス


package model;

import java.io.Serializable;

public class MessageInfo implements Serializable {
	private int id;			 // id
	private String name;	 // ユーザーの名前
	private String text;	 // メッセージ内容
	private String message_time;  // 投稿日時
	private int animal_key;  // 動物の主キー

	public MessageInfo() {}
	public MessageInfo(String name, String text, String message_time) {
		this.name = name;
		this.text = text;
		this.message_time = message_time;
	}
	public MessageInfo(int id, String name, String text, String message_time, int animal_key) {
		this.id = id;
		this.name = name;
		this.text = text;
		this.message_time = message_time;
		this.animal_key = animal_key;
	}
	public int getId() { return id; }
	public String getName() {return name; }
	public String getText() { return text; }
	public String getMessage_time() { return message_time; }
	public int getAnimal_key() { return animal_key; }
}

