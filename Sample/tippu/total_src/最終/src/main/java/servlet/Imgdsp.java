package servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Fileselect;
/**
 * Servlet implementation class Imgdsp
 */
@WebServlet("/Imgdsp")
public class Imgdsp extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Imgdsp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //IDの取得
        String ID = request.getParameter("ID");

        System.out.println(ID);

        //取得したIDに紐づく画像データをDBから取得
        Fileselect dao = new Fileselect();
        BufferedImage BIMG = dao.selectImageById(Integer.parseInt(ID));

        //画像を返す
        response.setContentType("image/jpeg");
        OutputStream OS = response.getOutputStream();
        ImageIO.write(BIMG, "jpg", OS);
        OS.flush();
	}



}
