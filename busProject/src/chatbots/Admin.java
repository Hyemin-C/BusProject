package chatbots;


import java.io.IOException;
import java.util.regex.Pattern;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;	
import javax.websocket.OnOpen;	
import javax.websocket.Session;	
import javax.websocket.server.ServerEndpoint;	




@ServerEndpoint("/admin")
public class Admin {
	
	private static Session admin = null;	
	private static Pattern pat = Pattern.compile("^\\{\\{.*?\\}\\}");

	@OnOpen	
	public void handleOpen(Session wsSess) {
	  if (admin != null) {													//static admin �� ������������ �ֳ�Ȯ��	
	    try {	
	      admin.close();														// ������ session �ݱ�
	    } catch (IOException e) {}	
	  }	
	  admin = wsSess;	 															// ���� ���Ӱ����ڿ��� �����ڼ����� ����
	  for(String sUser : webChat3.getClientIds()) {	// structureClass ȸ������ ����Ʈ(�̸�) for�� �ݺ�
	    visit(sUser);																// �����ڿ��� �����ڸ���Ʈ ����
	  }	
	}	
	
	
	@OnMessage	
	public void handleMessage(String msgs, Session wsSess) throws IOException {
		System.out.println("admin.jsp sendmessage");
		System.out.println("WSSession = " + wsSess + ",msgs = " + msgs);
	  String[] split = msgs.split("#####", 2);				// �����ڵ�/�����/�޼��� 
	  String user = split[0];	
	  String msg = split[1];	
		System.out.println("user = " + user + ",msg = " + msg);
//		final String msg = msgs.replaceAll(pat.pattern(), "");
//		final String uname = name.replaceFirst("^\\{\\{", "").replaceFirst("\\}\\}$", "");
	  webChat3.sendMessage(user, msg);// send Msg to a ClientId
	}	
	
	@OnClose	
	public void handleClose(Session wsSess) {	
	  admin = null;	
	}
	
	@OnError	
	public void handleError(Throwable e, Session wsSess) {	
	  System.out.println("wsSess = " + wsSess +", 클라이언트가 오류가 났습니다.");
	  //e.printStackTrace();	
	}		
	
	// 사용자가 관리자에게 보내는 메시지 용도
	private static void send(String msgs) {	
	  if (admin != null) {
	    try {	
	      admin.getBasicRemote().sendText(msgs);	
	    } catch (IOException e) {	
	      e.printStackTrace();	
	    }	
	  }	
	}

	public static void sendMessage(String sUser, String msgs) {	
	  send("{\"status\":\"message\", \"user\":\"" + sUser + "\", \"message\":\"" + msgs + "\"}");	
	}
	public static void visit(String sUser) {	
	  send("{\"status\":\"visit\", \"user\":\"" + sUser + "\"}");	
	}
	public static void bye(String sUser) {	
	  send("{\"status\":\"bye\", \"user\":\"" + sUser + "\"}");	
	}	
}