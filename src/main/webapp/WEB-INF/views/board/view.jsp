<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글보기</title>

<!-- jquery 와 bootstrap 라이브러리 등록: CDN방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1"> <!-- 장치에 맞게 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
$(function (){
	$("#deleteBtn").click(function(){
		var pw = prompt("비밀번호 입력:");
		$("#deletePw").val(pw);
		$("#deleteForm").submit();
		//화면이동을 막는다
		return false;
	});
})

</script>
</head>
<body>
<div class="container">
<h1>게시판 글보기</h1>
<table class="table">
<tr> <!-- controller에서 "vo"란 이름으로 전달받았음 -->
	<th>글번호</th>
	<td>${vo.no}</td>
</tr>
<tr>
	<th>제목</th>
	<td>${vo.title}</td>
</tr>
<tr>
	<th>내용</th>
	<td><pre>${vo.content}</pre></td>
</tr>
<tr>
	<th>작성자</th>
	<td>${vo.writer}</td>
</tr>
<tr>
	<th>작성일</th>
	<td>
		<fmt:formatDate value="${vo.writeDate}" pattern="yyyy.MM.dd"/>
	</td>
</tr>
<tr>
	<th>조회수</th>
	<td>${vo.hit}</td>
</tr>

<tr>
	<td colspan="2">
		<a href="update.do?no=${vo.no}" class="btn btn-default">수정</a>
		<a href="#" class="btn btn-default" id="deleteBtn">삭제</a>
		<a href="list.do" class="btn btn-default">목록</a>
	</td>
</tr>

</table>
</div>
<!-- 삭제를 위한 form tag:보이지 않는다 -->
<form action="delete.do" method="post" id="deleteForm">
	<input type="hidden" name="no" value="${vo.no}">
	<input type="hidden" name="pw" id="deletePw" >
</form>
</body>
</html>