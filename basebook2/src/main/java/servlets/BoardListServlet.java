package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import servlets.dao.BoardDao;
import servlets.domain.Board;

@WebServlet("/list")
public class BoardListServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {

		System.out.println("boardListServlet 호출");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		ApplicationContext appCtx =
		        WebApplicationContextUtils.getWebApplicationContext(
		            this.getServletContext());
		    
	 BoardDao boardDao = (BoardDao)appCtx.getBean("boardDao");
		
		
		
		
		List<Board> boardList = boardDao.selectList();

		

	    request.setAttribute("boardList", boardList);
	    
	    response.setContentType("text/html;charset=UTF-8");
	    

	    RequestDispatcher rd = request.getRequestDispatcher(
	        "/jsp/BoardList.jsp");
	    rd.include(request, response);
		
		

	}

}
