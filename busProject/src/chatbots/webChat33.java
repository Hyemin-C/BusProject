package chatbots;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;


import javax.servlet.http.HttpSession;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
import javax.websocket.EndpointConfig;
import javax.websocket.server.ServerEndpoint;

import Member.MemberDAO;
import Member.MemberDTO;




@ServerEndpoint(value = "/webChat33", configurator = HttpCfg.class)
public class webChat33 {

	// clientId와 wsSess정보를 저장
	private static Map<MemberDTO, EndpointConfig> cfgs = Collections.synchronizedMap(new HashMap<>());
	private Session wsSess;
	private HttpSession httpSess;
	private EndpointConfig cfg;
	private MemberDTO memDTO;
//	private static List<User> sUsers = Collections.synchronizedList(new ArrayList<>());// 데이타 동기화

	@OnOpen
	public void oC(Session wsSess, EndpointConfig cfg) {
		this.httpSess = (HttpSession) wsSess.getUserProperties().get(HttpCfg.Session);
		this.memDTO = (MemberDTO) httpSess.getAttribute("m_id");
		if (this.memDTO!=null) {
			if (!cfgs.containsKey(this.memDTO)) {
				this.wsSess = wsSess;
				cfgs.put(this.memDTO, cfg);
				this.cfg = cfgs.get(this.memDTO);
				System.out.println("webChat3.java handleOpen()");
				System.out.println("wsSess (" + this.wsSess + ") 클라이언트");
				System.out.println("member (" + this.memDTO.getM_id() + ")가 접속되었습니다.");
				try {
					wsSess.getBasicRemote().sendText(this.memDTO.getM_id() +"님 안녕하세요.");
				} catch (IOException e) {
					e.printStackTrace();
				}
				// Admin.visit(store.conName)
			} else {
				try {
					cfgs.remove(this.memDTO);		// 새로고침 대비
					this.wsSess = wsSess;
					cfgs.put(this.memDTO, cfg);		// 새로고침 대비
					wsSess.getBasicRemote().sendText(this.memDTO.getM_id() +"님 안녕하세요.");
					wsSess.getBasicRemote().sendText("새로운 채팅창입니다.");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}// if
		} else {
			try {
				wsSess.getBasicRemote().sendText("회원정보입니다. 로그인후 사용해주시기 바랍니다.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}// if
	}

	@OnMessage
	public void mC(String msgs, Session wsSess) throws IOException { //throws IOException {
		
		// 전체메세지
		// 귓속말
		System.out.println("wsSess1 (" + this.wsSess + ") 메시지 (" + msgs + ")");
		cfgs.entrySet().forEach((entry)->{
			RemoteEndpoint.Basic remote = wsSess.getBasicRemote();
			if(entry.getKey()!=wsSess) {
				System.out.println("wsSess2 (" + this.wsSess + ") 메시지 (" + msgs + ")");
				System.out.println(memDTO.getM_id());
				System.out.println(memDTO.getM_img());
				System.out.println("key:" + entry.getKey() + ", value:" + entry.getValue())	;
				try {
					remote.sendText(memDTO.getM_id());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				String tmpMsg = "{";
//				tmpMsg += "\"" + "id" + "\"" + ":" + "\"" + memDTO.getM_id();
//				tmpMsg += ","; 
//				tmpMsg += "\"" + "img" + "\"" + ":" + "\"" + memDTO.getM_img(); 
//				tmpMsg += ","; 
//				tmpMsg += "\"" + "msg" + "\"" + ":" + "\"" + msgs; 
//				tmpMsg += "}";
			}else {
				try {
					remote.sendText(memDTO.getM_img());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
//		if (cfgs.containsKey(wsSess)) {
//			RemoteEndpoint.Basic remote = wsSess.getBasicRemote();
//			String tmpMsg = "{";
//			tmpMsg += "\"" + "id" + "\"" + ":" + "\"" + memDTO.getM_id();
//			tmpMsg += ","; 
//			tmpMsg += "\"" + "img" + "\"" + ":" + "\"" + memDTO.getM_img(); 
//			tmpMsg += ","; 
//			tmpMsg += "\"" + "msg" + "\"" + ":" + "\"" + msgs; 
//			tmpMsg += "}";
//			System.out.println(memDTO.getM_id());
//			System.out.println(memDTO.getM_img());
//			//remote.sendText(tmpMsg);
//			Admin.sendMessage(tmpMsg,memDTO);
//			System.out.println(tmpMsg);
////			e.printStackTrace();
////			System.out.println("webChat3.java handleMessage()");
////			System.out.println("wsSess = " + wsSess);
////			System.out.println("msgs = "  + msgs);
//			//if(member != null) return "Session("+wsSess+") - " + member.getM_id();//getM_img()
//			//else return "\n회원서비스입니다. 로그인하시기 바랍니다.";
//			//return "error";
//		} else {
//			System.out.println("wsSess (" + wsSess + ") 클라이언트 세션이 없습니다.");
//		}
//		
	}

	@OnClose
	public void cC(Session wsSess) {
		if(cfgs.containsKey(wsSess)) {
			System.out.println("wsSess (" + wsSess + ") 클라이언트 접속종료합니다.");
			if (this.memDTO!=null) {
				try {
					wsSess.getBasicRemote().sendText(this.memDTO.getM_id() +"님 안녕히 가세요.");
				} catch (IOException e) {
					e.printStackTrace();
				}
				// Admin.bye(store.conName)
			}
			//Admin.bye(wsSess);//Admin.by("String"); 
			cfgs.remove(wsSess);
		}
	}
	
	@OnError
	public void eC(Throwable e, Session wsSess) {
		if(cfgs.containsKey(wsSess)) {
			System.out.println("wsSess (" + wsSess + ") 클라이언트가 에러종료 되었습니다.");
			//Admin.bye(wsSess);//Admin.by("String"); 
			//e.printStackTrace();
		}
	}

//	// 사용자가 관리자에게 보내는 메세지 용도
//	private static void allMsg(String msgs, Session wsSess) {	
//	    try {
//	    	//RemoteEndpoint.Basic remote = wsSess.getBasicRemote();
//	    	//remote.sendText(tmpMsg);
//	    	cfgs.get(wsSess).getBasicRemote().sendText(msgs);	
//	    } catch (IOException e) {	
//	      e.printStackTrace();	
//	    }
//	}
//	
//	private static void whisperMsg(String msgs) {	
//		  if (admin != null) {
//		    try {	
//		      admin.getBasicRemote().sendText(msgs);	
//		    } catch (IOException e) {	
//		      e.printStackTrace();	
//		    }	
//		  }	
//		}

//	public static void sendMessage(MemberDTO memDTO, String msgs) {		
//	  send("{\"status\":\"message\", \"user\":\"" + memDTO.getM_id() + "\", \"message\":\"" + msgs + "\"}");	
//	}
//	public static void visit(MemberDTO memDTO) {
//	  send("{\"status\":\"visit\", \"user\":\"" + memDTO.getM_id() + "\"}");	
//	}
//	public static void bye(MemberDTO memDTO) {	
//	  send("{\"status\":\"bye\", \"user\":\"" + memDTO.getM_id() + "\"}");	
//	}
	
//	//관리자가 사용자에게 보내는 메세지 용도
//	public static void sendMessage(String sUser, String msgs) {
//		User user = getUser(sUser);														// getClientId
//		System.out.println("webChat3.java sendMessage()");
//		System.out.println("sUser=" + sUser);
//		System.out.println("msgs=" + msgs);
//		if (user != null) {																		// is getClientId
//			try {
//				user.sSess.getBasicRemote().sendText(msgs);				// client SessionValue정보로 getBasicRemote()로 msg전송
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	// 관리자 접속시 getClientIdList 정보제공 용도
//	public static String[] getClientIds() {
//		String[] clentIds = new String[sUsers.size()];	// sUsers 크기만큼 clientIds[] 크기설정
//		for (int i = 0; i < clentIds.length; i++) {			// clentIds[] for문 루프
//			clentIds[i] = sUsers.get(i).sUser;						// clentIds[]에 sUsers의 clentIds[]로 clientId 저장
//		}
//		return clentIds;// clientIds[] 반환(clientId의 id값)
//	}
	
}// webChat3

