package chatbots;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/webChat4444444")
public class webChat4444444 {
	
	@OnOpen
	public void open()
	{
		System.out.println("client connect");
	}
	
	@OnClose
	public void close()
	{
		System.out.println("client disconnect");
	}
	
	@OnMessage
	public String cMsg(String msg)
	{
		System.out.println("client Message");
		String reply = "echo " + msg;
		return reply;
	}
	
	@OnError
	public void error(Throwable e)
	{
		e.printStackTrace();
	}
	
}
