<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
	
		<!-- header -->
		<c:import url="/WEB-INF/views/include/header.jsp"/>
		
		<div id="content">
			<div id="board">
				<form id="search_form" action="" method="post">
					<input type="text" id="kwd" name="kwd" value="">
					<input type="submit" value="찾기">
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
				<c:forEach items="${list }" var = "vo">
						<tr>
							<td>3</td>
							<td><a href="">${vo.title }</a></td>
							<td>${vo.userVo.name }</td>
							<td>${vo.view_cnt }</td>
							<td>${vo.reg_date}</td>
							<td><a href="" class="del">삭제</a></td>
						</tr>
				</c:forEach>						
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
							<a href="board?a=writeform" id="new-book">글쓰기</a>
						</div>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
								
			</div>
		</div>
		
		<!-- navigation -->
		<c:import url="/WEB-INF/views/include/navi.jsp"/>
		
		<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"/>
	</div>
</body>
</html>