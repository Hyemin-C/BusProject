package FaQ;

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
import javax.servlet.http.HttpSession;

import org.omg.PortableInterceptor.DISCARDING;

import FaQ.FaQDTO;
import Member.MemberDTO;
import FaQ.FaQDAO;

@WebServlet("/FaQDetail.do")
public class FaQDetailController extends HttpServlet {
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
		
		
		//-----------로그인-------------
		HttpSession session = request.getSession();
		MemberDTO Mdto = (MemberDTO) session.getAttribute("m_id");
		int level;
		if(Mdto==null) {
			level = 1;
		}else {
			level = Mdto.getM_admin();
		}
		
		request.setAttribute("level", level);
		//----------------------------!
		
		
		int rn = Integer.parseInt(request.getParameter("rn"));
		
		FaQDAO dao = new FaQDAO();
		FaQDTO dto = dao.FaQDetail(rn);
		int no = dto.getNo();
		String title = dto.getTitle();
		Date date = dto.getDate();
		Date editDate = dto.getEditDate();
		String content = dto.getContent();
		int hit = dto.getHit();
		
		request.setAttribute("rn", rn);
		request.setAttribute("no", no);
		request.setAttribute("title", title);
		request.setAttribute("date", date);
		request.setAttribute("editDate", editDate);
		request.setAttribute("content", content);
		request.setAttribute("hit", hit);
		
		//-----------------다음글-------------------
		FaQDTO dtoP = dao.FaQDetail(rn+1);
		String titleP = dtoP.getTitle();
		int noP = dtoP.getNo();
		request.setAttribute("titleP", titleP);
		request.setAttribute("noP", noP);
		//----------------------------------------!
		
		//-----------------이전글-------------------
		FaQDTO dtoN = dao.FaQDetail(rn-1);
		String titleN = dtoN.getTitle();
		int noN = dtoN.getNo();
		request.setAttribute("titleN", titleN);
		request.setAttribute("noN", noN);
		//----------------------------------------!
		
		RequestDispatcher dis = request.getRequestDispatcher("FaQ/FaQDetail.jsp");
		dis.forward(request, response);
		
	}//doUser END
	
}//FaQController class END
