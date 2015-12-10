<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!-- 미구현파트 구현해야됨 -->

<div id="navigation">
	<ul>

		<li class="selected"><a href="main">김민영</a></li>
		
		<c:choose>
		<c:when test="${!empty authUser }">
			<li><a href="gb?a=list">방명록</a></li>		
		</c:when>
		<c:otherwise>
			<li><a href="user?a=loginform">방명록</a></li>
		</c:otherwise>
		</c:choose>
		<li><a href="board?a=list">게시판</a></li>
		
		<%-- 		
		<c:choose>
			<c:when test="">
				<li class="selected"><a href="main">김민영</a></li>
				<li><a href="gb?a=list">방명록</a></li>
				<li><a href="">게시판</a></li>
			</c:when>
			<c:when test="">
				<li><a href="main">김민영</a></li>
				<li class="selected"><a href="gb?a=list">방명록</a></li>
				<li><a href="">게시판</a></li>
			</c:when>
			<c:when test="">
				<li><a href="main">김민영</a></li>
				<li><a href="gb?a=list">방명록</a></li>
				<li class="selected"><a href="">게시판</a></li>
			</c:when>
		</c:choose> 
		--%>
	</ul>
</div>