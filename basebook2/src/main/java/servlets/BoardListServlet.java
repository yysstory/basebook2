package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import servlets.dao.BoardDao;
import servlets.domain.Board;

@WebServlet("/list")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("boardListServlet 호출");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		ApplicationContext appCtx = WebApplicationContextUtils
				.getWebApplicationContext(this.getServletContext());

		BoardDao boardDao = (BoardDao) appCtx.getBean("boardDao");

		List<Board> boardList = boardDao.selectList();
		
		request.setAttribute("boardList", boardList);

		
		
		
		response.setContentType("text/html;charset=UTF-8");

		RequestDispatcher rd = request.getRequestDispatcher("/jsp/BoardList.jsp");
		rd.include(request, response);

	}

}
