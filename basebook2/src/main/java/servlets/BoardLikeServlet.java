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
import servlets.domain.Board;


@WebServlet("/like")
public class BoardLikeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Board board = new Board();
		request.setCharacterEncoding("UTF-8");
		board.setContentNo(Integer.parseInt(request.getParameter("no")));
		board.setContentLike(Integer.parseInt(request.getParameter("like")));
		
		ApplicationContext appCtx =
		        WebApplicationContextUtils.getWebApplicationContext(
		            this.getServletContext());
		    
		BoardDao boardDao = (BoardDao)appCtx.getBean("boardDao");
		boardDao.like(board);
		

	}

}
