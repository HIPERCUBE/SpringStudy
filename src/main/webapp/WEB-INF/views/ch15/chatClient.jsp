<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>main</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/content.css">
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.min.js"></script>
    <style type="text/css">
        body {
            font-size: small;
            color: white;
        }

        #connect-container {
            float: left;
            width: 400px
        }

        #connect-container div {
            padding: 5px;
        }

        #console-container {
            float: left;
            margin-left: 15px;
            width: 400px;
        }

        #console {
            border: 1px solid #CCCCCC;
            border-right-color: #999999;
            border-bottom-color: #999999;
            height: 170px;
            overflow-y: scroll;
            padding: 5px;
            width: 100%;
        }

        #console p {
            padding: 0;
            margin: 0;
        }
    </style>
    <script type="text/javascript">
        var ws = null;

        function connect() {
            ws = new WebSocket("ws://" + window.location.host + "/websocket/chat");

            ws.onopen = function () {
                log("접속이 되었습니다.");
                setConnected(true);
            };

            ws.onclose = function () {
                log("접속이 끊어 졌습니다.");
                setConnected(false);
            };

            ws.onmessage = function (event) {
                var strJson = event.data;
                var json = JSON.parse(strJson);
                var command = json.command;
                var data = json.data;
                if (command == "display") {
                    display(data);
                }
            }
        }

        function disconnect() {
            if (ws != null) {
                ws.close();
                ws = null;
            }
        }

        function display(data) {
            var fontColor = data.fontColor;
            var message = data.message;
            log(message, fontColor);
        }

        function send() {
            var chatName = $("#chatName").val();
            if (chatName == "") {
                alert("채팅명을 입력해 주세요.");
                return;
            }

            var fontColor = $("#fontColor").val();

            var message = $("#message").val();
            if (message == "") {
                alert("메시지를 입력해 주세요.");
                return;
            }

            var json = {
                "command": "broadcast",
                "data": {
                    "chatName": chatName,
                    "fontColor": fontColor,
                    "message": message
                }
            };

            var strJson = JSON.stringify(json);

            ws.send(strJson);
        }

        function setConnected(connected) {
            if (connected) {
                $("#connect").attr("disabled", "disabled");
                $("#disconnect").removeAttr("disabled");
                $("#btnSend").removeAttr("disabled");
            } else {
                $("#connect").removeAttr("disabled");
                $("#disconnect").attr("disabled", "disabled");
                $("#btnSend").attr("disabled", "disabled");
            }
        }

        function log(message, color) {
            $("#console").append("<span style='display:block;color:" + color + ";'>" + message + "</span>");
            if ($("#console span").length > 20) {
                $("#console span").first().remove();
            }
            $("#console").scrollTop($("#console").height());
        }
    </script>
</head>
<body>
<div id="header">
    <h3>웹소켓</h3>
</div>

<div id="content">
    <div class="sector">
        <div class="sector_title"><h4><span class="no">Sec01. </span>채팅 클라이언트</h4></div>
        <div class="sector_content">
            <div id="connect-container">
                <div>
                    <button id="connect" onclick="connect();" class="button">Connect</button>
                    <button id="disconnect" disabled="disabled" onclick="disconnect();" class="button">Disconnect
                    </button>
                </div>

                <div>
                    채팅명: <input id="chatName" type="text"/> <br/>
                    글색상: <input id="fontColor" type="color"/> <br/>
                </div>

                <div>
                    <textarea id="message" style="width: 350px">Here is a message!</textarea>
                </div>
                <div>
                    <button id="btnSend" onclick="send();" disabled="disabled" class="button">Send message</button>
                </div>
            </div>
            <div id="console-container">
                <div id="console"/>
            </div>
        </div>
    </div>
</div>
</body>
</html>