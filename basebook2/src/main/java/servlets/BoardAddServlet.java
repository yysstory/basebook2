package servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import servlets.dao.BoardDao;
import servlets.domain.Board;

@WebServlet("/add")
public class BoardAddServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("boardAddServlet서블릿 호출");
		request.setCharacterEncoding("UTF-8");

		Board board = new Board();
		board.setContentId(request.getParameter("id"));
		board.setContentPassword(request.getParameter("password"));
		board.setContentContent(request.getParameter("content"));
		board.setContentAvi(request.getParameter("url"));
		board.setContentLike(0);
		board.setContentUnlike(0);

		ApplicationContext appCtx = WebApplicationContextUtils
				.getWebApplicationContext(this.getServletContext());

		BoardDao boardDao = (BoardDao) appCtx.getBean("boardDao");
		boardDao.insert(board);

		HttpServletResponse orginResponse = (HttpServletResponse) response;
		orginResponse.sendRedirect("/basebook2/list");

	}

}
