package Member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DBConnect.DBConnect;

@WebServlet("/Join.do")
public class JoinController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public JoinController() {
		super();
	}
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doJoin(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doJoin(req, resp);
	}

	public void doJoin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "Member/Join.jsp";  
			
			String connect = request.getParameter("con");
		
			
			MemberDTO dto = new MemberDTO();
			if(connect.equals("insert")) {
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}else {
				MemberDAO dao = new MemberDAO();
				dto.setM_id(request.getParameter("m_id"));
				dto.setM_pw(request.getParameter("m_pw"));
				dto.setM_email(request.getParameter("m_email"));
				dto.setM_phone(request.getParameter("m_phone"));
				dao.insertMember(dto);
			
				
				response.sendRedirect("Login.do");
			}
			
		}
}
