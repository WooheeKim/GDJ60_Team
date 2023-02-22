<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 보기</title>

</head>
<body>
	
	<h1>Detail Page</h1>
	<c:if test="${not empty dto}">
		<h3>번호 : ${dto.num}</h3>
		<h3>제목 : ${dto.title}</h3>
		<h3>작성자 : ${dto.writer}</h3>
		<h3>작성날짜 : ${dto.regDate}</h3>
		<h3>조회수 : ${dto.hit}</h3>
		<h3>내용 : ${dto.contents}</h3>
		<div>
			<c:if test="${not empty dto.bankBookImgDTO}">
				<img src="../resources/upload/board/${dto.boardImgDTO.fileName}">
			</c:if>
		</div>
		<a href="./delete?num=${dto.num}">상품삭제</a>
	</c:if>
	
	<c:if test="${empty dto}">
		<h3>존재하지 않는 상품입니다</h3>
	</c:if>
	<a href="./update?num=${dto.num}">상품수정</a>
	<a href="./list">목록으로</a>
	

</body>
</html>