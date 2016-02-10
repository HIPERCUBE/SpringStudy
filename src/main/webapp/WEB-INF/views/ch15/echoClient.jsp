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
            ws = new WebSocket("ws://" + window.location.host + "/websocket/echo");

            ws.onopen = function () {
                log("접속이 되었습니다.");
                setConnected(true);
            };

            ws.onclose = function () {
                log("접속이 끊어 졌습니다.");
                setConnected(false);
            };

            ws.onmessage = function (event) {
                log(event.data);
            }
        }

        function disconnect() {
            if (ws != null) {
                ws.close();
                ws = null;
            }
        }

        function echo() {
            var message = $("#message").val();
            ws.send(message);
        }

        function setConnected(connected) {
            if (connected) {
                $("#connect").attr("disabled", "disabled");
                $("#disconnect").removeAttr("disabled");
                $("#echo").removeAttr("disabled");
            } else {
                $("#connect").removeAttr("disabled");
                $("#disconnect").attr("disabled", "disabled");
                $("#echo").attr("disabled", "disabled");
            }
        }

        function log(message) {
            $("#console").append("<span style='display:block'>" + message + "</span>");
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
        <div class="sector_title"><h4><span class="no">Sec01. </span>에코 클라이언트</h4></div>
        <div class="sector_content">
            <div id="connect-container">
                <div>
                    <button id="connect" class="button" onclick="connect();" class="button">Connect</button>
                    <button id="disconnect" class="button" disabled="disabled" onclick="disconnect();" class="button">
                        Disconnect
                    </button>
                </div>
                <div>
                    <textarea id="message" style="width: 350px">Here is a message!</textarea>
                </div>
                <div>
                    <button id="echo" class="button" onclick="echo();" disabled="disabled" class="button">Echo message
                    </button>
                </div>
            </div>
            <div id="console-container">
                <div id="console"/>
            </div>
        </div>
        <div id="sec01_result" class="sector_result"></div>
    </div>
</body>
</html>