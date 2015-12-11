<%@ page contentType="text/html;charset=UTF-8" %>
<%-- <%
	String no = request.getParameter("no");
%> --%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
	
		<!-- header -->
		<%-- <jsp:include page="/WEB-INF/views/include/header.jsp" /> --%>
		<c:import url="/WEB-INF/views/include/header.jsp"/>
	
		<!-- content -->
		<div id="content">
			<div id="guestbook" class="delete-form">
				<form method="post" action="/mysite/gb">
					<input type="hidden" name="a" value="delete">
					<input type='hidden' name="no" value="${param.no}">
					<label>비밀번호</label>
					<input type="password" name="password">
					<input type="submit" value="확인">
				</form>
				<a href="/mysite/gb?a=list">방명록 리스트</a>
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