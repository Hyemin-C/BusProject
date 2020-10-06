package SamplController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SampleDAO.infoDAO;
import SampleDTO.infoDTO;


@WebServlet("/info2.do")
public class b_infoController2 extends HttpServlet {
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
		infoDAO infodao = new infoDAO();
		infoDTO infodto = new infoDTO();

    String userid = request.getParameter("userid");
    int busRoute = Integer.parseInt(request.getParameter("busRoute"));
    int busList = Integer.parseInt(request.getParameter("busList"));
    int busAdult = Integer.parseInt(request.getParameter("busAdult"));
    int busStudent = Integer.parseInt(request.getParameter("busStudent"));
    int busFare = Integer.parseInt(request.getParameter("busFare"));
    int seatCount = Integer.parseInt(request.getParameter("seatCount"));    
    String []seatList = request.getParameterValues("seatlist");
    if (seatList != null){  
      for(int i = 0;i < seatList.length;i++) {
      	infodto.setUserid(userid);
        infodto.setBusRoute(busRoute);
        infodto.setBusList(busList);
        infodto.setBusAdult(busAdult);
        infodto.setBusStudent(busStudent);
        infodto.setBusFare(busFare);
        infodto.setSeatCount(seatCount);
      	infodto.setSeatList(seatList[i]);
      	infodao.dbseatO(infodto);
      	infodao.dbtimeO(infodto);
        //out.println(seatList[i]+"번 ");
      }//for end
    }//if end
        
    String preuserid = request.getParameter("preuserid");
	  int prebusRoute = Integer.parseInt(request.getParameter("prebusRoute"));
	  int prebusList = Integer.parseInt(request.getParameter("prebusList"));
	  int prebusAdult = Integer.parseInt(request.getParameter("prebusAdult"));
	  int prebusStudent = Integer.parseInt(request.getParameter("prebusStudent"));
	  int prefare = Integer.parseInt(request.getParameter("prefare"));
	  int preseatCount = Integer.parseInt(request.getParameter("preseatCount"));
	  String []preseatSel = request.getParameterValues("preseatSel");
	  if (preseatSel != null){
	    for(int i = 0;i < preseatSel.length;i++) {
	    	infodto.setPreuserid(preuserid);
	      infodto.setPrebusRoute(prebusRoute);
	      infodto.setPrebusList(prebusList);
	      infodto.setPrebusAdult(prebusAdult);
	      infodto.setPrebusStudent(prebusStudent);
	      infodto.setPrefare(prefare);
	      infodto.setPreseatCount(preseatCount);  
	      infodto.setPreseatSel(preseatSel[i]); 
	      infodao.dbseatR(infodto);
	      infodao.dbtimeR(infodto);
	      //System.out.println("pre="+preseatSel[i]+" id"+preuserid);
	      //out.println(preseatSel[i]+"번 ");
	    }//for end
	  }//if end
	    
    response.sendRedirect("b_pay.jsp");
//	  RequestDispatcher dis = request.getRequestDispatcher("b_info.jsp");
//	  dis.forward(request, response);
	}
}
