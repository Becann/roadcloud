package com.cgutech.roadcloud.web;

import org.apache.log4j.Logger;

import javax.websocket.Session;
import java.io.IOException;
import java.util.Set;

/**
 * Created by Becan on 2017/6/8.
 */
public class BaseWebSocket {
    private Logger logger = Logger.getLogger(BaseWebSocket.class);

    public void sendMessage(String message, Set<Session> clients) {
        for (Session session:clients){
            synchronized (session) {
                try {
                    session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    logger.error("websocket 发送数据失败："+e);
                    e.printStackTrace();
                }
            }
        }

    }
}
