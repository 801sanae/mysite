<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/main.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
	
		<!-- header -->
		<%-- <jsp:include page="/WEB-INF/views/include/header.jsp" /> --%>
		<c:import url="/WEB-INF/views/include/header.jsp"/>
		
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile" src="/mysite/assets/images/dean.jpg">
					<h2>안녕하세요. dean의 mysite에 오신 것을 환영합니다.</h2>
					<p>
						이 사이트는 웹 프로그램밍 실습과제 예제 사이트입니다.<br> 메뉴는 사이트 소개, 방명록, 게시판이 있구요.
						JAVA 수업 + 데이터베이스 수업 + 웹프로그래밍 수업 배운 거 있는거 없는 거 다 합쳐서 만들어 놓은 사이트
						입니다.<br> <br> 
						<c:choose>
							<c:when test="${!empty authUser }">
							<a href="gb?a=list">방명록</a>에 글 남기기<br>
							</c:when>
							<c:otherwise>
							</c:otherwise>
						</c:choose>	
					</p>
				</div>
			</div>
		</div>
		<!-- navigation -->
		<%-- <jsp:include page="/WEB-INF/views/include/navi.jsp" /> --%>
		<c:import url="/WEB-INF/views/include/navi.jsp">
<%-- 			<c:param name="menu" value="main"></c:param> --%>
		</c:import>
		<!-- footer -->
		<%-- <jsp:include page="/WEB-INF/views/include/footer.jsp" /> --%>
		<c:import url="/WEB-INF/views/include/footer.jsp"/>
	</div>
</body>
</html>