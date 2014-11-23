package servlets;


import java.io.IOException;

import javafx.collections.SetChangeListener;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import servlets.dao.BoardDao;
import servlets.domain.Board;


@WebServlet("/add")
public class boardAddServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;


	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("boardAddServlet서블릿 호출");
		
		Board board = new Board();
		request.setCharacterEncoding("UTF-8");
		board.setContentId(request.getParameter("id"));
		board.setContentPassword(request.getParameter("password"));
		board.setContentContent(request.getParameter("content"));
		board.setContentAvi(request.getParameter("url"));
		
		BoardDao boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
		
		boardDao.insert(board);
		
		HttpServletResponse orginResponse = (HttpServletResponse)response;
	    orginResponse.sendRedirect("/basebook/list");
		

		
		
		
	}

}
