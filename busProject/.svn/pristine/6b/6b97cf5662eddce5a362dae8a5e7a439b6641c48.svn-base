package SamplController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SampleDAO.reserveDeleteDAO;

@WebServlet("/reserveDelete.do")
public class b_reserveDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();		
		reserveDeleteDAO rddao = new reserveDeleteDAO();
		
		String code = request.getParameter("code");
		int timeno = Integer.parseInt(request.getParameter("timeno"));
		int routeno = Integer.parseInt(request.getParameter("routeno"));
		String id = request.getParameter("id");
		String[] code2= code.split(",");
		for(int i=0; i<code2.length; i++) {
			System.out.println("code3="+code2[i]);
			rddao.dbdelete(code2[i],timeno,routeno, id);
		}		

  	request.setAttribute("id", id);
	  RequestDispatcher dis = request.getRequestDispatcher("reserveCheck.do");
	  dis.forward(request, response);
	}
}
