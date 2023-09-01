package controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.NameDAO;
import model.NameDTO;

/**
 * Servlet implementation class MainPage
 */
@WebServlet("/MainPage")
@MultipartConfig
public class MainPage extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NameDAO dao=new NameDAO();
		List<NameDTO> list=dao.findAll();
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/main.jsp");!!
		rd.forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name=request.getParameter("name");
		String yomi=request.getParameter("yomi");
		String relationship=request.getParameter("relationship");
		String address=request.getParameter("address");
		String sex=request.getParameter("sex");
		Date birthday=request.aaaa("birthday");
		String note=request.getParameter("note");
		Part part=request.getPart("photo");
		
		String photo=part.getSubmittedFileName();
		String path=getServletContext().getRealPath("/upload");
		part.write(path+File.separator+photo);
		NameDAO dao=new NameDAO();
		dao.insertOne(new NameDTO(name,yomi,relationship,address,sex,birthday,note,photo));
		doGet(request, response);
	}

}
