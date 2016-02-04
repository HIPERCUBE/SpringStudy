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
			<h3>폼 관련 커스텀 태그</h3>
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
				<div class="sector_title"><h4><span class="no">Sec01. </span>&lt;form:form&gt;</h4></div>
				<div class="sector_content">
					<a class="button" href="javascript:join1()">폼 요청</a>
					<script>
						function join1() {
							$.ajax({
								url: "join1",
								success: function(data) {
									$("#sec01_result").html(data);
								}
							});
						}
					</script>
				</div>
				<div id="sec01_result" class="sector_result"></div>
			</div>
			
			<div class="sector">
				<div class="sector_title"><h4><span class="no">Sec02. </span>&lt;form:input&gt; &lt;form:password&gt; &lt;form:hidden&gt;</h4></div>
				<div class="sector_content">
					<a class="button" href="javascript:join2()">폼 요청</a>
					<script>
						function join2() {
							$.ajax({
								url: "join2",
								success: function(data) {
									$("#sec02_result").html(data);
								}
							});
						}
					</script>
				</div>
				<div id="sec02_result" class="sector_result"></div>
			</div>
			
			<div class="sector">
				<div class="sector_title"><h4><span class="no">Sec03. </span>&lt;form:select&gt; &lt;form:options&gt;</h4></div>
				<div class="sector_content">
					<a class="button" href="javascript:join3()">폼 요청</a>
					<script>
						function join3() {
							$.ajax({
								url: "join3",
								success: function(data) {
									$("#sec03_result").html(data);
								}
							});
						}
					</script>
				</div>
				<div id="sec03_result" class="sector_result"></div>
			</div>			
			
			<div class="sector">
				<div class="sector_title"><h4><span class="no">Sec04. </span>&lt;form:checkboxes&gt;</h4></div>
				<div class="sector_content">
					<a class="button" href="javascript:join4()">폼 요청</a>
					<script>
						function join4() {
							$.ajax({
								url: "join4",
								success: function(data) {
									$("#sec04_result").html(data);
								}
							});
						}
					</script>
				</div>
				<div id="sec04_result" class="sector_result"></div>
			</div>
			
			<div class="sector">
				<div class="sector_title"><h4><span class="no">Sec05. </span>&lt;form:radiobuttons&gt;</h4></div>
				<div class="sector_content">
					<a class="button" href="javascript:join5()">폼 요청</a>
					<script>
						function join5() {
							$.ajax({
								url: "join5",
								success: function(data) {
									$("#sec05_result").html(data);
								}
							});
						}
					</script>
				</div>
				<div id="sec05_result" class="sector_result"></div>
			</div>			
		</div>
	</body>
</html>