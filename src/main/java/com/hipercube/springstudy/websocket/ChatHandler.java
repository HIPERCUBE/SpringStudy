package com.hipercube.springstudy.websocket;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Copyright (c) 2/7/16 Joowon Ryoo
 * <p/>
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 * <p/>
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 * <p/>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 */

@Component
public class ChatHandler extends TextWebSocketHandler {
    private static final Logger logger = LoggerFactory.getLogger(ChatHandler.class);
    private List<WebSocketSession> list = new ArrayList<WebSocketSession>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        logger.info("afterConnectionEstablished");
        list.add(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("handleTextMessage");
        String strJson = message.getPayload();
        JSONObject jsonObject = new JSONObject(strJson);
        String command = jsonObject.getString("command");
        JSONObject data = jsonObject.getJSONObject("data");
        if (command.equals("broadcast")) {
            broadcast(data);
        }
    }

    private void broadcast(JSONObject data) throws IOException {
//        {
//            "command": "display",
//            "data": {
//              "fontColor": "#ff0000",
//              "message": [홍길동] 안녕하세요"
//            }
//        }
        String chatName = data.getString("chatName");
        String fontColor = data.getString("fontColor");
        String message = data.getString("message");

        JSONObject root = new JSONObject();
        root.put("command", "display");
        JSONObject d = new JSONObject();
        d.put("fontColor", fontColor);
        d.put("message", "[" + chatName + "] " + message);
        root.put("data", d);

        String strJson = root.toString();

        TextMessage textMessage = new TextMessage(strJson);
        for (WebSocketSession wss : list) {
            synchronized (wss) {
                wss.sendMessage(textMessage);
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        logger.info("afterConnectionClosed");
        list.remove(session);
    }
}
