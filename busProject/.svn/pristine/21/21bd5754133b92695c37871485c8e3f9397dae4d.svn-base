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

@WebServlet("/FaQHit.do")
public class FaQHitController extends HttpServlet {
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
		
		int rn = Integer.parseInt(request.getParameter("rn"));
		int no = Integer.parseInt(request.getParameter("no"));
		
		FaQDAO dao = new FaQDAO();
		dao.FaQHit(no);
		
		request.setAttribute("rn", rn);
		
		RequestDispatcher dis = request.getRequestDispatcher("FaQDetail.do");
		dis.forward(request, response);
		
	}//doUser END
	
}//FaQController class END
