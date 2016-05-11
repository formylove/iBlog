package main.src.websocket;

import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.HandshakeRequest;
import javax.websocket.server.ServerEndpointConfig;
import javax.websocket.server.ServerEndpointConfig.Configurator;

public class GetHttpSessionConfigurator extends Configurator {

    @Override
    public void modifyHandshake(ServerEndpointConfig sec,
            HandshakeRequest request, HandshakeResponse response) {
        HttpSession httpSession=(HttpSession) request.getHttpSession();
        if(request.getHeaders().get("cookie") != null){
        	sec.getUserProperties().put("cookie",request.getHeaders().get("cookie").get(0));
        }
        sec.getUserProperties().put(HttpSession.class.getName(),httpSession);
    }
    
}