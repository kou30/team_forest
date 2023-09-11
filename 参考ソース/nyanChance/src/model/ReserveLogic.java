package model;

import java.util.List;

import dao.ReserveDAO;

public class ReserveLogic {
	// 予約全リスト取得
	public List<Reserve> findFromCat(int catid) {
		ReserveDAO dao = new ReserveDAO();
		List<Reserve> reserveList = dao.findFromCat(catid);
		return reserveList;
	}
	// 特定個人の予約リストを取得
	public List<Reserve> findFromUser(String name) {
		ReserveDAO dao = new ReserveDAO();
		List<Reserve> reserveList = dao.findFromUser(name);
		return reserveList;
	}
	// 予約（１個）を新規保存
	public void create(Reserve reserve) {
		ReserveDAO dao = new ReserveDAO();
		dao.create(reserve);
	}
	// 予約（１個）を削除
	public void delete(int reservedId) {
		ReserveDAO dao = new ReserveDAO();
		dao.delete(reservedId);
	}
}
