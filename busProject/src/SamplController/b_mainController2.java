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

@WebServlet("/main2.do")
public class b_mainController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}
	
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		reserveDAO rdao = new reserveDAO();
		reserveDTO rdto = new reserveDTO();
		PrintWriter out = response.getWriter();
	  
	  String departR = request.getParameter("departR");
	  String arrivalR = request.getParameter("arrivalR");
	  String dateR1 = request.getParameter("datepicker2");
	  String dateR2 = request.getParameter("datepicker3");
	  String levelR = request.getParameter("levelR");
	  System.out.println("왕복="+departR+" "+arrivalR+" "+dateR1+" "+dateR2+" "+levelR);
	  
	  int data=0;
  
  	int routeNo1 = rdao.dbtimeO(departR, arrivalR);
  	ArrayList<reserveDTO> timelistR1 = rdao.dbtimeR1(dateR1, levelR, routeNo1);
  	request.setAttribute("timelistR1", timelistR1);
  	request.setAttribute("dateR1", dateR1);
	  request.setAttribute("dateR2", dateR2);
	  request.setAttribute("departR", departR);
	  request.setAttribute("arrivalR", arrivalR);
	  request.setAttribute("levelR", levelR);
	  for (reserveDTO reserveDTO : timelistR1) {
			data = reserveDTO.getData();
		}
	  request.setAttribute("data", data);	
	  RequestDispatcher dis = request.getRequestDispatcher("b_time.jsp");
	  dis.forward(request, response);	
	}
}
