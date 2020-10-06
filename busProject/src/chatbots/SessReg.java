package chatbots;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessReg")
public class SessReg extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	
	public SessReg() {
		super();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doUser(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doUser(req, res);
	}
	
	protected void doUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// parsing to the session
		HttpSession getHttpSess = (HttpSession) req.getSession();

		
		// check to a SessionObject
		if (getHttpSess == null) {
			
			// session Write || url Move
			// movePage : res.sendRedirect("main.do");
			
		} else {
			
			// init to a userid, userpw of the Session key
			String madeUseridSessionName = "m_id";// session key
			String madeUserpwSessionName = "m_pw";// session key
//			String madeUseridSessionValue = "red";	// session value
//			String madeUserpwSessionValue = "1234";	// session value
			String madeUseridFormName = "m_id";	// form key
			String madeUserpwFormName = "m_pw";	// form key	

			// parsing to a userid, userpw
			String getUseridValue = (String) getHttpSess.getAttribute(madeUseridSessionName);// =session "userid"value
			String getUserpwValue = (String) getHttpSess.getAttribute(madeUserpwSessionName);// =session "userpw"value
			
			
			
			// check to a userid, userpw
			//if(getUserpwValue == null || getUserpwValue.isEmpty());
			if ( getUseridValue == null || getUseridValue.isEmpty() || getUserpwValue == null || getUserpwValue.isEmpty() ) {
				
				// login			
				String getUseridFormValue = req.getParameter(madeUseridFormName);	// form value
				String getUserpwFormValue = req.getParameter(madeUserpwFormName);	// form value
				
				
				// 로그인 페이지에 온 데이타, 전송값 없는 경우
				if (getUseridFormValue == null || getUseridFormValue.isEmpty() || getUserpwFormValue == null || getUserpwFormValue.isEmpty()) {
					// 로그인 페이지 이동
					// movePage : res.sendRedirect("login.do");
					
				} else {// 전송값 있는 경우

					// 회원 idcheck() - 회원인경우
					getHttpSess.setAttribute(madeUseridSessionName, getUseridFormValue);// 아이디 저장
					getHttpSess.setAttribute(madeUserpwSessionName, getUserpwFormValue);// 비밀번호 저장
					// movePage : res.sendRedirect("main.do");
					
					
					// 회원이 아닌경우
					// movePage : res.sendRedirect("login.do");
				}// if
				
				
			} else {

				// logon 회원 idcheck() - 
				String queryUseridSessionValue = "";
				String queryUserpwSessionValue = "";
				getHttpSess.setAttribute(madeUseridSessionName, queryUseridSessionValue);
				getHttpSess.setAttribute(madeUserpwSessionName, queryUserpwSessionValue);
				
				
				// sysPrint
				System.out.println("======================= session Register ==========================\n");
				System.out.println("check the sessionObject = " + getHttpSess);
				System.out.println("check the getUseridValue = " + getUseridValue);
				//System.out.println("check the getUserpwValue = " + getUserpwValue);
				System.out.println("======================= session Register ==========================\n");
				
				// webPrint
				res.getWriter().append("Session Register \n");
				res.getWriter().append("Session = " + (String) req.getSession().getAttribute(getUseridValue));
				
				// movePage : res.sendRedirect("goPage.do");
			}

			
			
			
		}// if
		
		
	}// doUser()
	
}// SessReg{}