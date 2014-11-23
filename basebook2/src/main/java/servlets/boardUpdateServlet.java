package servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;

import servlets.dao.BoardDao;
import servlets.domain.Board;


@WebServlet("/update")
public class boardUpdateServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		
		System.out.println("boardUpdateServlet 호출");
		
		Board board = new Board();
		request.setCharacterEncoding("UTF-8");
		
		//No.22 id:앱등이
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("id").split(" ")[0]);
		System.out.println(request.getParameter("id").split(" ")[0].substring(3));
	//	<center><iframe width="450" height="300" src="//www.youtube.com/embed/s1AwGAZltNU" frameborder="0" allowfullscreen=""></iframe></center>
		
		
		
		board.setContentNo(Integer.parseInt(request.getParameter("id").split(" ")[0].substring(3)));
		board.setContentId(request.getParameter("id").split(":")[request.getParameter("id").split(":").length-1]);
		
		board.setContentPassword(request.getParameter("password"));
		board.setContentContent(request.getParameter("content"));
		board.setContentAvi(request.getParameter("url"));/*
		board.setContentLike(Integer.parseInt(request.getParameter("like")));
		board.setContentUnlike(Integer.parseInt(request.getParameter("unlike")));*/
		
		BoardDao boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
		boardDao.update(board);
		
		HttpServletResponse orginResponse = (HttpServletResponse)response;
	    orginResponse.sendRedirect("/basebook/list");

	
	}

}
