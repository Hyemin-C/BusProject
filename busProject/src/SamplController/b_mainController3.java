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

import SampleDAO.reserveDAO;
import SampleDTO.reserveDTO;

@WebServlet("/main3.do")
public class b_mainController3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
		reserveDAO rdao = new reserveDAO();
		reserveDTO rdto = new reserveDTO();
		PrintWriter out = response.getWriter();
	  
	  String departR = request.getParameter("departR");
	  String arrivalR = request.getParameter("arrivalR");
	  String dateR2 = request.getParameter("datepicker3");
	  String dateR1 = request.getParameter("datepicker2");
	  String levelR2 = request.getParameter("levelR2");
	  System.out.println("왕복2="+" "+arrivalR+" "+departR+" "+dateR2+" "+levelR2);
	  
	  String userid = request.getParameter("userid");
	  String seatcount = request.getParameter("seatcount");
	  String seatSel = request.getParameter("seatSel");
	  String routeno = request.getParameter("routeno");
	  String timeno = request.getParameter("timeno");
	  String adult = request.getParameter("adult");
	  String student = request.getParameter("student");
	  String fare = request.getParameter("fare");
	  
	  int data=0;
  	int routeNo2 = rdao.dbtimeO(arrivalR, departR);		 
	  ArrayList<reserveDTO> timelistR2 = rdao.dbtimeR2(dateR2, levelR2, routeNo2);		  
	  request.setAttribute("timelistR2", timelistR2);
	  request.setAttribute("dateR2", dateR2);
	  request.setAttribute("dateR1", dateR1);
	  request.setAttribute("departR", departR);
	  request.setAttribute("arrivalR", arrivalR);
	  request.setAttribute("levelR2", levelR2);
	  
	  request.setAttribute("userid", userid);
	  request.setAttribute("seatcount", seatcount);
	  request.setAttribute("seatSel", seatSel);
	  request.setAttribute("routeno", routeno);
	  request.setAttribute("timeno", timeno);
	  request.setAttribute("adult", adult);
	  request.setAttribute("student", student);
	  request.setAttribute("fare", fare);
	  
	  for (reserveDTO reserveDTO : timelistR2) {
			data = reserveDTO.getData();
		}
	  request.setAttribute("data", data);	
	  RequestDispatcher dis = request.getRequestDispatcher("b_timeR.jsp");
	  dis.forward(request, response);
	  //response.sendRedirect("b_time.jsp");		
	}
}
