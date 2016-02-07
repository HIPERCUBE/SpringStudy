<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>main</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/content.css">
		<script type="text/javascript" src="${pageContext.request.contextPath}/resources/javascript/jquery-1.11.3.min.js"></script>
	</head>
	<body>
		<div id="header">
			<h3>파일 업로드, 다운로드</h3>
		</div>
		
		<div id="content">
			<div class="sector">
				<div class="sector_title"><h4><span class="no">Sec00. </span>이론</h4></div>
				<div class="sector_content">
					<a class="button" href="ppt">PPT 보기</a>
				</div>
				<div id="sec00_result" class="sector_result"></div>
			</div>		
			<div class="sector">
				<div class="sector_title"><h4><span class="no">Sec01. </span>파일 업로드</h4></div>
				<div class="sector_content">
					<!-- 동일한 파일을 지정하면 onchange 이벤트가 발행하지 않음 -->
					<input class="button" id="attach" type="file" name="attach" onchange="send()"/>
					
<xmp>
//대화상자에서 취소 버튼을 클릭했을 경우
if(document.querySelector("#attach").files.length == 0) return;

var file = document.querySelector("#attach").files[0];

var data = new FormData();
data.append("attach", file);
 
$.ajax({
      url: "upload",
      type: "POST",
      data: data,
      cache: false,
      processData: false, 
      contentType: false,
      success: function(data) {
          $("#sec01_result").append("<img width='200px' src='download?fileName=" + data.fileName + "'/>");
      }
});
</xmp>
					<script>
						function send() {
							//대화상자에서 취소 버튼을 클릭했을 경우
							if(document.querySelector("#attach").files.length == 0) return;
							
							//var file = $("#attach")[0].files[0];
							var file = document.querySelector("#attach").files[0];
							
							var data = new FormData();
							data.append("attach", file);
						  
							$.ajax({
							      url: "upload",
							      type: "POST",
							      data: data,
							      cache: false,
							      processData: false, 
							      contentType: false,
							      success: function(data) {
							          $("#sec01_result").append("<img width='200px' src='download?fileName=" + data.fileName + "'/>");
							      }
							});
						}
					</script>
				</div>
				<div id="sec01_result" class="sector_result"></div>
			</div>
		</div>
	</body>
</html>