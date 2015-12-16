<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">

		<!-- header -->
		<c:import url="/WEB-INF/views/include/header.jsp" />

		<div id="content">
			<div id="board">
				<form id="search_form" action="/mysite/board" method="post">
					<input type="hidden" name="a" value="search"> <input
						type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>

				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					
					
					<c:choose>
						<c:when test="${empty slist }">
							<c:set var="cnt" value="${fn:length(list)}" />
							
							<c:forEach items="${list }" var="board" varStatus="status">
								<tr>
									<td>${cnt-status.index}</td>
									
<%--  									<td><a href="board?a=view&no=${board.no}">${board.title }</a></td>
 --%>
								
									<td class="title" style="padding-left:${( board.depth )*10 }px">
										<c:if test="${board.depth > 0 }">
											<img src="${pageContext.request.contextPath}/assets/images/ico-reply.gif">
										</c:if> 
										
										<a href="board?a=view&no=${board.no}">${board.title }</a>
									</td> 

									<td>${board.member_name }</td>
									<td>${board.view_cnt }</td>
									<td>${board.reg_date}</td>
									<c:choose>
										<c:when test="${!empty authUser }">
											<td><a href="main?a=index" class="del"> <img
													src="/mysite/assets/images/recycle.png">
											</a></td>
										</c:when>
										<c:otherwise>
											<td></td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<c:set var="cnt" value="${fn:length(slist)}" />
						
							<c:forEach items="${slist }" var="board" varStatus="status">
								<tr>
									<td>${cnt-status.index}</td>
									<td><a href="board?a=view&no=${board.no}">${board.title }</a></td>
									<td>${board.member_name }</td>
									<td>${board.view_cnt }</td>
									<td>${board.reg_date}</td>
									<c:choose>
										<c:when test="${!empty authUser }">
											<td><a href="main?a=index" class="del"> <img
													src="/mysite/assets/images/recycle.png">
											</a></td>
										</c:when>
										<c:otherwise>
											<td></td>
										</c:otherwise>
									</c:choose>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</table>

				<div class="pager">
					<ul>
						<li class="pg-prev"><a href="#">◀ 이전</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li class="disable">4</li>
						<li class="disable">5</li>
						<li class="pg-next"><a href="#">다음 ▶</a></li>
					</ul>
				</div>

				<c:choose>
					<c:when test="${!empty authUser }">
						<div class="bottom">
							<a href="board?a=writeform&group_no=0&order_no=0&depth=0" id="new-book">글쓰기</a>
						</div>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>

			</div>
		</div>

		<!-- navigation -->
		<c:import url="/WEB-INF/views/include/navi.jsp" />

		<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp" />
	</div>
</body>
</html>