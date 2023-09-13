package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AnimalDAO;
import model.AnimalInfo;

@WebServlet("/Search")
public class Search extends HttpServlet{
	private static final long serialVersonUID = 1L;

	String error = "";


	public void doGet(HttpServletRequest request ,HttpServletResponse response)
		 	throws ServletException ,IOException{

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/search.jsp");
		dispatcher.forward(request, response);

	}

 	public void doPost(HttpServletRequest request ,HttpServletResponse response)
 	throws ServletException ,IOException{

 		request.setCharacterEncoding("UTF-8");
 		String sexcase = request.getParameter("sex");
 		String agecase = request.getParameter("age");
 		String placecase = request.getParameter("place");
 	 	int ifkey = 0;

 	 	try {
 	 		//AnimalDAOのsearch()メソッド呼び出し
					AnimalDAO dao = new AnimalDAO();
					ArrayList<AnimalInfo>animalList = dao.search(sexcase, agecase, placecase);
					request.setAttribute("animalList", animalList);

			 		HttpSession session = request.getSession();
					session.setAttribute("AnimalInfo", ifkey);

			 	 	RequestDispatcher dispatcher = request.getRequestDispatcher(
			 	 			"/WEB-INF/jsp/main.jsp");
					dispatcher.forward(request, response);

			 	 	//main.jspにフォワード

	 		}catch(Exception e){

 	 			error ="予期せぬエラーが発生しました。<br>"+e;

 	 	}
 	}
 }
 	/*	try{
 			//配列宣言
 			List<AnimalInfo>search = new ArrayList<AnimalInfo>();

 			//オブジェクト宣言
 			AnimalDAO objDao = new AnimalDAO();

 			//検索メソッドの呼び出し
 			search = objDao.search(sexcase, agecase, placecase);
 			System.out.println(search);
 			if(search.size() == 0) {
 				System.out.println("要素がありません");
 			}
 				//検索結果を持ってmain.jspにフォワード

 			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
 			dispatcher.forward(request, response);

 		}catch(Exception e){
 			error ="予期せぬエラーが発生しました。<br>"+e;

 		}
 	}
 }*/