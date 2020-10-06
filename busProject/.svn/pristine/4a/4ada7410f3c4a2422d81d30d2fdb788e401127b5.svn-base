package chatbots;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SessUnreg")
public class SessUnreg extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public SessUnreg() {
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
		
		
			// parsing to the session
			String madeUseridSessionName = "m_id";// key
			String madeUserpwSessionName = "m_pw";

			
			// parsing to a userid, userpw
			String getUseridValue = (String) getHttpSess.getAttribute(madeUseridSessionName);// ="userid"
			String getUserpwValue = (String) getHttpSess.getAttribute(madeUserpwSessionName);// ="userpw"

			
			// check to a userid, userpw
			if(getUseridValue != null || !getUseridValue.isEmpty()) getHttpSess.setAttribute(madeUseridSessionName, null);
			if(getUserpwValue != null || !getUserpwValue.isEmpty()) getHttpSess.setAttribute(madeUserpwSessionName, null);

			
			// sysPrint
			System.out.println("======================= session UnRegister ==========================\n");
			System.out.println("check the sessionObject = " + getHttpSess);
			System.out.println("check the getUseridValue = " + getUseridValue);
			//System.out.println("check the getUserpwValue = " + getUserpwValue);
			System.out.println("======================= session UnRegister ==========================\n");
			
			// webPrint
			res.getWriter().append("Session Unregister\n");
			res.getWriter().append("Session = " + getUseridValue);
			
			getHttpSess.invalidate(); // delete SessionObjectKey
			// movePage : res.sendRedirect("main.do");
		
		}// if
		
	}// doUser()
} // seeUnreg{}