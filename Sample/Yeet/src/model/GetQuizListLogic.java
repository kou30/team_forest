package model;

import java.util.List;

import dao.QuizDAO;

public class GetQuizListLogic {
	public  List<Quiz> execute() {
		QuizDAO dao = new QuizDAO();
		List<Quiz> quizList = dao.findAll();
		return quizList;
	}
}
