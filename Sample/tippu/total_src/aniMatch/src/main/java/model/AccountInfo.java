// ユーザーに関する情報を持つ JavaBeans
// ACCOUNTテーブルのレコードを表すクラスpackage model;

package model;

import java.io.Serializable;


/**----------------------------------------------------------------------*
 *■■■AccountInfoクラス■■■
 *概要：（「ACCOUNT」テーブル）
 *----------------------------------------------------------------------**/
public class AccountInfo implements Serializable{

	//----------------------------------------------------------------
	//フィールド
	//----------------------------------------------------------------
	private String userId;         //ユーザーID
	private String pass;       //ユーザーパスワード
	private String userName;       //ユーザー名


	public AccountInfo() {}

	public AccountInfo(String userId, String pass, String userName) {
		this.userId = userId;
		this.pass = pass;
		this.userName = userName;
	}
	//----------------------------------------------------------------
	//getter/setter

	//private に設定されたフィールドは外部からアクセスが出来ないので、
	//メソッドを介してアクセスする必要があり、それが getterである

	// setter は単純に「フィールドに値を代入するためのメソッド」
	//----------------------------------------------------------------

	//getter/setter（対象フィールド：userId）
	public String getUserId() { return userId; }
	public void setUserId(String userId) { this.userId = userId; }

	//getter/setter（対象フィールド：passWord）
	public String getPass() { return pass; }
	public void setPass(String pass) { this.pass = pass; }

	//getter/setter（対象フィールド：userName）
	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }
}