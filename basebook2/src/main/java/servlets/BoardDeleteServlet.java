package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import servlets.dao.BoardDao;

@WebServlet("/delete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("boardDeleteServlet 호출");
		
		request.setCharacterEncoding("UTF-8");

		ApplicationContext appCtx = WebApplicationContextUtils
				.getWebApplicationContext(this.getServletContext());

		BoardDao boardDao = (BoardDao) appCtx.getBean("boardDao");

		System.out.println(request.getParameter("id"));
		String noid = request.getParameter("id").split(" ")[0].substring(3);


		boardDao.delete(Integer.parseInt(noid));
		response.sendRedirect("/basebook2/list");

	}

}
