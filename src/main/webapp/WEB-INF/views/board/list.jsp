<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!-- 반복문, if문에 들어있는 태그를 사용할 수 있도록  -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 콤마, 날짜 ,시간 등을 넣을 수 있는 태그 -->
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<!-- jquery 와 bootstrap 라이브러리 등록: CDN방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1"> <!-- 장치에 맞게 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.dataRow:hover{
	background: #ccc;
	cursor: pointer;
}

</style>
<script type="text/javascript">
$(function(){
	$(".dataRow").click(function(){ //클래스는 여러개
		//타이틀누르기
		var no=$(this).find(".no").text();
		location = "view.do?no="+no+"&inc=1"; //클릭하면 해당 주소로 이동
	});
});

</script>
</head>
<body>
<div class="container">
	<h1>게시판 리스트</h1>
	<table class="table">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>

		<c:if test="${empty list}">
			<!-- 만약 데이터가 없으면 없음을 표시 -->
			<tr>
				<td colspan="5"> 데이터가 존재하지 않습니다.</td> <!-- 이 한줄이 다섯칸의 역할을 함 -->
			</tr>
		</c:if>

		<c:if test="${!empty list}">
			<!-- 데이터가 존재하면 -->
			<!-- 데이터의 갯수만큼 반복되어 지는 부분 -->
			<c:forEach items="${list}" var="vo"> <!-- ${list}에서 하나씩꺼내 vo라는 이름으로 받는다 -->
				<tr class="dataRow" >
					<td class="no">${vo.no}</td>
					<td>${vo.title}</td>
					<td>${vo.writer}</td>
					<td>
						<fmt:formatDate value="${vo.writeDate}"
						pattern="yyyy.MM.dd"/>
					</td>
					<td>${vo.hit}</td>
				</tr>
			</c:forEach>
		</c:if>


		<tr>
			<td>
				<a href="write.do" class="btn btn-default">글쓰기 </a>
			</td>
		</tr>
	</table>
</div>
</body>
</html>