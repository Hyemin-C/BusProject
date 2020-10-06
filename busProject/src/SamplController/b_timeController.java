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

import SampleDAO.timeDAO;

@WebServlet("/time.do")
public class b_timeController extends HttpServlet {
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
		timeDAO tdao = new timeDAO();
		
		int data = Integer.parseInt(request.getParameter("data"));
		String depart = request.getParameter("depart");
	  String arrival = request.getParameter("arrival");
	  String company = request.getParameter("company");
	  String platform = request.getParameter("platform");
		
		String departR = request.getParameter("departR");
	  String arrivalR = request.getParameter("arrivalR");
	  String dateR1 = request.getParameter("dateR1");
	  String dateR2 = request.getParameter("dateR2");
	  String levelR = request.getParameter("levelR");
	  
	  String departO = request.getParameter("departO");
	  String arrivalO = request.getParameter("arrivalO");
	  String dateO = request.getParameter("dateO");
	  String levelO = request.getParameter("levelO");
	  	  
	  String routeno = request.getParameter("routeno");
	  String timeno = request.getParameter("timeno");	  
	  
	  String preuserid = request.getParameter("preuserid");
	  String preseatcount = request.getParameter("preseatcount");
	  String preseatSel = request.getParameter("preseatSel");
	  String prerouteno = request.getParameter("prerouteno");
	  String pretimeno = request.getParameter("pretimeno");
	  String preadult = request.getParameter("preadult");
	  String prestudent = request.getParameter("prestudent");
	  String prefare = request.getParameter("prefare");
		
	  request.setAttribute("depart", depart);
	  request.setAttribute("arrival", arrival);
	  request.setAttribute("company", company);
	  request.setAttribute("platform", platform);  	 
	  
	  request.setAttribute("dateR1", dateR1);
	  request.setAttribute("dateR2", dateR2);
	  request.setAttribute("departR", departR);
	  request.setAttribute("arrivalR", arrivalR);
	  request.setAttribute("levelR", levelR);	
	  
	  request.setAttribute("dateO", dateO);
	  request.setAttribute("departO", departO);
	  request.setAttribute("arrivalO", arrivalO);
	  request.setAttribute("levelO", levelO);
	  
	  
		request.setAttribute("data", data);
		request.setAttribute("routeno", routeno);
		request.setAttribute("timeno", timeno);		
		
		request.setAttribute("preuserid", preuserid);
	  request.setAttribute("preseatcount", preseatcount);
	  request.setAttribute("preseatSel", preseatSel);
	  request.setAttribute("prerouteno", prerouteno);
	  request.setAttribute("pretimeno", pretimeno);
	  request.setAttribute("preadult", preadult);
	  request.setAttribute("prestudent", prestudent);
	  request.setAttribute("prefare", prefare);
	  
	  ArrayList<Integer> s_code = tdao.dbcode(routeno,timeno);
	  
	  HttpSession session = request.getSession();
	  String id = (String) session.getAttribute("id");
	  
	  request.setAttribute("s_code", s_code);
	  request.setAttribute("id", id);
	  
	  //response.sendRedirect("b_time.jsp");
	  RequestDispatcher dis = request.getRequestDispatcher("b_seat.jsp");
	  dis.forward(request, response);
	}
}
