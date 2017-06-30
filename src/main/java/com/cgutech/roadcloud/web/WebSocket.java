package com.cgutech.roadcloud.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * Created by Becan on 2017/6/8.
 */
@ServerEndpoint("/websocket")
@Component
public class WebSocket extends BaseWebSocket{
    private Logger logger = Logger.getLogger(WebSocket.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocket对象。
    private static Set<Session> clients = new CopyOnWriteArraySet<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        clients.add(session);
        addOnlineCount();
        logger.info("有新连接加入！当前在线客户端数量为：" + getOnlineCount());
    }

    @OnClose
    public void onClose(){
        clients.remove(session);
        subOnlineCount();
       logger.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message,Session session){
        logger.info("来自客户端的消息："+message);
    }

    @OnError
    public void onError(Session session,Throwable e){
        logger.error("websocket 发生错误："+e);
        e.printStackTrace();
    }

    public void sendMessage(String message){
        sendMessage(message,clients);
    }
    public void sendInfo(String message){
        synchronized (session){
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            logger.error("websocket 给客户端["+session+"]发送消息失败："+e);
            e.printStackTrace();
        }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocket.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocket.onlineCount--;
    }
}
