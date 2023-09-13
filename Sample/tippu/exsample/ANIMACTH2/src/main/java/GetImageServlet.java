
	import java.awt.image.BufferedImage;
	import java.io.IOException;
	import java.io.OutputStream;

	import javax.imageio.ImageIO;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import DAO.ItemDao;

	/**
	 * Servlet implementation class GetImageServlet
	 */
	@WebServlet("/getImage")
	public class GetImageServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// 画像のIDを取得する
			String id = request.getParameter("id");

			// 取得したIDに紐づく画像データをDBから取得する
			ItemDao dao = new ItemDao();
			BufferedImage img = dao.selectImageById(Integer.parseInt(id));

			// 画像をクライアントに返却する
			response.setContentType("image/jpeg");
			OutputStream os = response.getOutputStream();
			ImageIO.write(img, "jpg", os);
			os.flush();
		}

	}