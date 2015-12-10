<%@page import="java.util.List"%>
<%@page import="com.hanains.mysite.vo.GuestBookVo"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>


<%-- <%
	List<GuestBookVo> list = (List<GuestBookVo>) request.getAttribute("list");
%> --%>

<%
	pageContext.setAttribute("newLine", "\n");
%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/guestbook.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
	
		<!-- header -->
		<%-- <jsp:include page="/WEB-INF/views/include/header.jsp" /> --%>
		<c:import url="/WEB-INF/views/include/header.jsp"/>
		
		
<%-- 		
	<!-- content -->
		<div id="content">
			<div id="guestbook">
				<form action="/mysite/gb" method="post">
					<input type="hidden" name="a" value="insert">
					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
							<td>비밀번호</td>
							<td><input type="password" name="pass"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
					<li>
						<%
							int totalNum = list.size();
							int index = 0;
							for (GuestBookVo vo : list) {
						%>
						<table>
							<tr>
								<td><%=totalNum - index++%></td>
								<td>${vo.name }</td>
								<td><%=vo.getReg_date()%></td>
								<td><a href="/mysite/gb?a=form&no=<%=vo.getNo()%>">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4><%=vo.getMessage().replaceAll("\n", "<br>")%>
								</td>
							</tr>
						</table> 
						<%
 						}
 						%> 
 						<br>
					</li>
				</ul>
			</div>
		</div> 
--%>

		<!-- 
		%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		%%%%%%%%%%EL JSTL 적용%%%%%%%%%%
		%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
		 -->
		 
		<!-- content -->
		<div id="content">
			<div id="guestbook">
				<form action="/mysite/gb" method="post">
					<input type="hidden" name="a" value="insert">
					<table>
						<tr>
							<td>이름</td>
							<td>
								<input type="text" name="name" value="${authUser.name }" >
							</td>
							<td>비밀번호</td>
							<td>
								<input type="password" name="pass" value="${authUser.password }" >
							</td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
				<ul>
					<li>
						<c:set var="cnt" value="${fn:length(list)}" />
						<c:set var="newLine" value="\n"/>
						<c:forEach items="${list }" var="vo" varStatus="status">
						
						<table>
							<tr>
								<td>${cnt-status.index }</td>
								<td>${vo.name }</td>
								<td>${vo.reg_date }</td>
								<td><a href="/mysite/gb?a=form&no=${vo.no }">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4>
								<%-- <%=vo.getMessage().replaceAll("\n", "<br>")%> --%>
								${fn:replace(vo.message,'<br>', 'newLine')}
								<!-- ??????? -->
								</td>
							</tr>
						</table> 
						
						</c:forEach>
 						<br>
					</li>
				</ul>
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