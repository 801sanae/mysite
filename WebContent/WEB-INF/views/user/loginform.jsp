<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%-- <%
	String result = request.getParameter("result");
%> --%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/user.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		
		<!-- header -->
		<%-- <jsp:include page="/WEB-INF/views/include/header.jsp" /> --%>
		<c:import url="/WEB-INF/views/include/header.jsp"/>
		
		<!-- content -->
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="get" action="/mysite/user">
					<input type="hidden" name="a" value="login"> 
					<label class="block-label" for="email">이메일</label> 
					
					<input id="email" name="email" type="text" value=""> 
					<label class="block-label">패스워드</label> <input name="password"	type="password" value=""> 
					
					<input type="submit" value="로그인">
					
					<c:if test="${param.result ne fail  }">
						<p>로그인이 실패 했습니다.</p>
					</c:if>
					
					
					
					<%-- 
					<%
						if ("fail".equals(result)) {
					%>

					<p>로그인이 실패 했습니다.</p>

					<%
						}
					%> 
					--%>
				</form>
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