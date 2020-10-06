package notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.omg.PortableInterceptor.DISCARDING;

import Member.MemberDAO;
import Member.MemberDTO;
import notice.noticeDTO;
import notice.noticeDAO;

@WebServlet("/noticeList.do")
public class noticeListController extends HttpServlet {
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
		noticeDTO dto = new noticeDTO();
		noticeDAO dao = new noticeDAO();
		
		
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
		
		
		//-----------검색--------------
		String kef = request.getParameter("kef");
		String kew = request.getParameter("kew");
		if(kef==null||kef.equals("")||kew==null||kew.equals("")) {
			kef="n_title";
			kew="";
		}
		
		request.setAttribute("kef", kef);
		request.setAttribute("kew", kew);
		//----------------------------!
				
		
		//-----------페이징--------------
		int page, start=1, end=10, startPage, endPage, temp=0, totalPage;
		String pageNum = request.getParameter("page");
		if(pageNum==null||pageNum.equals("")) {pageNum = "1";}
		page = Integer.parseInt(pageNum);
		int totalList = dao.noticeTotal(kef, kew);
		
		start = page*10-9;
		end = page*10;
		
		temp = (page-1)%10;
		startPage = page-temp;
		endPage = startPage+9;
		totalPage = (totalList-1)/10+1;
		if(endPage>totalPage) {endPage = totalPage;}
		
		request.setAttribute("page", page);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);
		request.setAttribute("totalPage", totalPage);
		//----------------------------!
		
		
		//-----------리스트-------------
		ArrayList<noticeDTO> List = dao.noticeList(start, end, kef, kew);
		
		request.setAttribute("List", List);
		//----------------------------!
		
		
		RequestDispatcher dis = request.getRequestDispatcher("notice/noticeList.jsp");
		dis.forward(request, response);
		
	}//doUser END
	
}//noticeController class END
