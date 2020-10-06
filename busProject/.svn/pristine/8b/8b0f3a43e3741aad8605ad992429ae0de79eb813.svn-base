package notice;

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

@WebServlet("/noticeUpdate.do")
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
		int rn = Integer.parseInt(request.getParameter("rn"));
		
		if(connect.equals("update")) {
			noticeDAO dao = new noticeDAO();
			noticeDTO dto = new noticeDTO();
			
			dto = dao.noticeDetail(rn);
			int no = dto.getNo();
			String title = dto.getTitle();
			String content = dto.getContent();
			
			request.setAttribute("rn", rn);	
			request.setAttribute("no", no);	
			request.setAttribute("title", title);	
			request.setAttribute("content", content);	
			
			RequestDispatcher dis = request.getRequestDispatcher("notice/noticeUpdate.jsp");
			dis.forward(request, response);
		}else {
			int no = Integer.parseInt(request.getParameter("no"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			noticeDAO dao = new noticeDAO();
			dao.noticeUpdate(no,title,content);
			
			response.sendRedirect("noticeDetail.do?rn="+rn);
		}//if END
		
	}//doUser END
	
}//noticeController class END
