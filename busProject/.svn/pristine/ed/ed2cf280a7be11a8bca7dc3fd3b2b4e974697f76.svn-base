package chatbots;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class HttpCfg extends Configurator {
	public static final String Session = "Session";
	public static final String Context = "Context";
	
	@Override
	public void modifyHandshake(ServerEndpointConfig config, HandshakeRequest req, HandshakeResponse res) {

		HttpSession session = (HttpSession) req.getHttpSession();
		ServletContext context = session.getServletContext();
		
		config.getUserProperties().put(HttpCfg.Session, session);
		config.getUserProperties().put(HttpCfg.Context, context);
	}
}