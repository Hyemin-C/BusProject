package access;

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

import notice.noticeDTO;
import notice.noticeDAO;

@WebServlet("/access.do")
public class noticeUpdateController extends HttpServlet {
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
		
		String connect = request.getParameter("cnct");
		
		if(connect.equals("resGid")){
			RequestDispatcher dis = request.getRequestDispatcher("info/info_list_01.jsp");
			dis.forward(request, response);
		}else if(connect.equals("payGid")){
			RequestDispatcher dis = request.getRequestDispatcher("info/PayInfo.jsp");
			dis.forward(request, response);
		}else if(connect.equals("mChat")) {
			RequestDispatcher dis = request.getRequestDispatcher("chatbox/mChat.jsp");
			dis.forward(request, response);
		}else if(connect.equals("aChat")){
			RequestDispatcher dis = request.getRequestDispatcher("chatbox/aChat.jsp?sid=admin");
			dis.forward(request, response);
		}else {
			RequestDispatcher dis = request.getRequestDispatcher("b_main.jsp");
			dis.forward(request, response);
		}
	}//doUser END
	
}//noticeController class END
