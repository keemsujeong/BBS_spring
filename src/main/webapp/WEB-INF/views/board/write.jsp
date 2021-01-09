<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<!-- jquery 와 bootstrap 라이브러리 등록: CDN방식 -->
<meta name="viewport" content="width=device-width, initial-scale=1"> <!-- 장치에 맞게 설정 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<h1>게시판 글쓰기</h1>
  <form method="post"> <!-- action을 지정하지 않으면 동일한 url이 받음 -->
    <div class="form-group">
      <label for="title">제목:</label>
      <input type="text" class="form-control" id="title"
      	name="title" required="required" pattern=".{4,100}" 
     	maxlength ="100"> <!-- required 데이터가 반드시 요구됨, title:4자부터 100자까지 -->
    </div>
    <div class="form-group">
  		<label for="comment">내용:</label>
  		<textarea class="form-control" rows="5" id="content"
  		name="content"></textarea>
	</div>
    <div class="form-group">
      <label for="writer">작성자:</label>
      <input type="text" class="form-control" id="writer"
      	name="writer" required="required" pattern="[가-힣a-zA-Z]{2,10}" 
     	maxlength ="10"> 
    </div>
    <div class="form-group">
      <label for="pw">비밀번호:</label>
      <input type="text" class="form-control" id="pw"
      	name="pw" required="required" pattern=".{3,30}" 
     	maxlength ="50"> 
    </div>
    <button>등록</button>
  </form>
</div>
</body>
</html>