package FaQ;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.PortableInterceptor.DISCARDING;

import FaQ.FaQDTO;
import FaQ.FaQDAO;

@WebServlet("/FaQInsert.do")
public class FaQInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response);
	}//doGet END

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request,response);
	}//doPost END
	
	protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String connect = request.getParameter("cnct");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		if(connect.equals("write")) {
			RequestDispatcher dis = request.getRequestDispatcher("FaQ/FaQWrite.jsp");
			dis.forward(request, response);
		}else{
			FaQDAO dao = new FaQDAO();
			dao.FaQInsert(title, content);
		
			response.sendRedirect("FaQList.do");
		}//if END
		
	}//doUser END
	
}//FaQController class END
