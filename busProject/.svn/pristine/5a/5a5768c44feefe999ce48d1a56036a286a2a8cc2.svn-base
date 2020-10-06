package SamplController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import SampleDAO.reserveCheckDAO;
import SampleDTO.reserveCheckDTO;

@WebServlet("/reserveCheck.do")
public class b_reserveCheckController extends HttpServlet {
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
		reserveCheckDAO rcdao = new reserveCheckDAO();
	  
	  HttpSession session = request.getSession();
	  String id = (String) session.getAttribute("id");
	  
	  if(id==""||id==null) {
	  	response.sendRedirect("Login.do");
	  }else {	  
		  //response.sendRedirect("b_reserveCheck.jsp");
	  	ArrayList<reserveCheckDTO> reservelist = rcdao.dbcheck(id);
	  	request.setAttribute("reservelist", reservelist);
	  	request.setAttribute("id", id);
		  RequestDispatcher dis = request.getRequestDispatcher("b_reserveCheck.jsp");
		  dis.forward(request, response);
	  }
	}
}
