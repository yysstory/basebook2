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


@WebServlet("/update")
public class BoardUpdateServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
       

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {

		
		System.out.println("boardUpdateServlet 호출");
		
		Board board = new Board();
		request.setCharacterEncoding("UTF-8");
		
		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("id").split(" ")[0]);
		System.out.println(request.getParameter("id").split(" ")[0].substring(3));
		
		ApplicationContext appCtx =
		        WebApplicationContextUtils.getWebApplicationContext(
		            this.getServletContext());
		    
	 BoardDao boardDao = (BoardDao)appCtx.getBean("boardDao");
		
		
		
		board.setContentNo(Integer.parseInt(request.getParameter("id").split(" ")[0].substring(3)));
		board.setContentId(request.getParameter("id").split(":")[request.getParameter("id").split(":").length-1]);
		
		board.setContentPassword(request.getParameter("password"));
		board.setContentContent(request.getParameter("content"));
		board.setContentAvi(request.getParameter("url"));
		
		
		board.setContentLike(Integer.parseInt(request.getParameter("like")));
		board.setContentUnlike(Integer.parseInt(request.getParameter("unlike")));
		
		
		
		
		boardDao.update(board);
		
		HttpServletResponse orginResponse = (HttpServletResponse)response;
	    orginResponse.sendRedirect("/basebook2/list");

	
	}

}
