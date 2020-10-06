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

@WebServlet("/timeCheck.do")
public class b_timeCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		reserveDAO rdao = new reserveDAO();
		reserveDTO rdto = new reserveDTO();
		PrintWriter out = response.getWriter();
		String departT = request.getParameter("departT");
		String arrivalT = request.getParameter("arrivalT");
		String dateT = request.getParameter("datepicker4");
		String levelO = request.getParameter("levelO");
		System.out.println("검색=" + departT +" " + arrivalT + " " + dateT +" " + levelO );
		
		int routeNo3 = rdao.dbtimeO(departT,arrivalT);
		ArrayList<reserveDTO> timelistT = rdao.dbtimeCheckT(dateT,levelO,routeNo3);  
		request.setAttribute("timelistT", timelistT);
		request.setAttribute("departT", departT);
		request.setAttribute("arrivalT", arrivalT);
		request.setAttribute("dateT", dateT);
		request.setAttribute("levelO", levelO);
		RequestDispatcher dis = request.getRequestDispatcher("b_timeCheck.jsp");
		dis.forward(request,response);
	}
}
