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

@WebServlet("/main.do")
public class b_mainController extends HttpServlet {
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
		String departO = request.getParameter("departO");
	  String arrivalO = request.getParameter("arrivalO");
	  String dateO = request.getParameter("datepicker1");
	  String levelO = request.getParameter("levelO");
	  System.out.println("편도="+departO+" "+arrivalO+" "+dateO+" "+levelO);
	  
	  int data=0;
  	int routeNo1 = rdao.dbtimeO(departO, arrivalO);
	  ArrayList<reserveDTO> timelistO = rdao.dbtimeO(dateO, levelO, routeNo1);
	  request.setAttribute("timelistO", timelistO);
	  request.setAttribute("dateO", dateO);
	  request.setAttribute("departO", departO);
	  request.setAttribute("arrivalO", arrivalO);
	  request.setAttribute("levelO", levelO);
	  for (reserveDTO reserveDTO : timelistO) {
			data = reserveDTO.getData();
		}
	  request.setAttribute("data", data);	
	  RequestDispatcher dis = request.getRequestDispatcher("b_time.jsp");
	  dis.forward(request, response);	  	
	}
}
