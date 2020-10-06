package SamplController;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SampleDAO.seatDAO;


@WebServlet("/seat.do")
public class b_seatController extends HttpServlet {
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
		seatDAO sdao = new seatDAO();
		
		String depart = request.getParameter("depart");
		String arrival = request.getParameter("arrival");
		String company = request.getParameter("company");		
		String platform = request.getParameter("platform");
		
		String dateO = request.getParameter("dateO");
		String dateR1 = request.getParameter("dateR1");
		String dateR2 = request.getParameter("dateR2");
		String departO = request.getParameter("departO");
		String departR = request.getParameter("departR");
		String arrivalO = request.getParameter("arrivalO");
		String arrivalR = request.getParameter("arrivalR");
		String levelO = request.getParameter("levelO");
		String levelR = request.getParameter("levelR");
		System.out.println(URLDecoder.decode(arrivalO,"UTF-8")); 
		System.out.println("dateO="+dateO+"dateR1="+dateR1+"departO="+departO+"departR="+departR+"arrivalO="+arrivalO+"arrivalR="+arrivalR);
		System.out.println("편도등급="+levelO+", 왕복등급="+levelR);
    String userid = request.getParameter("userid");
    String busRoute = request.getParameter("busRoute");
    String busList = request.getParameter("busList");
    String busAdult = request.getParameter("busAdult");
    String busStudent = request.getParameter("busStudent");
    String busFare = request.getParameter("busFare");
    String seatCount = request.getParameter("seatcount");       
    String seatList = request.getParameter("seatlist");
    
    request.setAttribute("userid", userid);
    request.setAttribute("busRoute", busRoute);
    request.setAttribute("busList", busList);
    request.setAttribute("busAdult", busAdult);
    request.setAttribute("busStudent", busStudent);
    request.setAttribute("busFare", busFare);
    request.setAttribute("seatCount", seatCount);
    request.setAttribute("seatList", seatList);
    
    String preuserid = request.getParameter("preuserid");
    String prebusRoute = request.getParameter("prerouteno");
    String prebusList = request.getParameter("pretimeno");
    String prebusAdult = request.getParameter("preadult");
    String prebusStudent = request.getParameter("prestudent");
    String prefare = request.getParameter("prefare");
    String preseatCount = request.getParameter("preseatcount");
    String preseatSel = request.getParameter("preseatSel");
    
    request.setAttribute("preuserid", preuserid);
    request.setAttribute("prebusRoute", prebusRoute);
    request.setAttribute("prebusList", prebusList);
    request.setAttribute("prebusAdult", prebusAdult);
    request.setAttribute("prebusStudent", prebusStudent);
    request.setAttribute("prefare", prefare);
    request.setAttribute("preseatCount", preseatCount);
    request.setAttribute("preseatSel", preseatSel); 

    request.setAttribute("depart", depart);
    request.setAttribute("arrival", arrival);
    request.setAttribute("company", company);    
    request.setAttribute("platform", platform);
    
    request.setAttribute("dateO", dateO);
    request.setAttribute("dateR1", dateR1);
    request.setAttribute("dateR2", dateR2);
    request.setAttribute("departO", departO);
    request.setAttribute("departR", departR);
    request.setAttribute("arrivalO", arrivalO);
    request.setAttribute("arrivalR", arrivalR);
    request.setAttribute("levelO", levelO);
    request.setAttribute("levelR", levelR);		
	  
	  RequestDispatcher dis = request.getRequestDispatcher("b_info.jsp");
	  dis.forward(request, response);
	}
}
