<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.GenerateString" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<div class="logo">
	<img src="img/index_welcome_balloon.png" width="400">
	<h1>どこつぶへようこそ</h1>
</div>
<%
GenerateString generateString = new GenerateString();
String gname = generateString.generate();
%>

<form action="/docotsubu_kai/Login" method="post">
ユーザー名：<input type="text" name="name" value="<%= gname %>"><br>
パスワード：<input type="password" name="pass" value="1234"><br>
<input type="submit" value="ログイン">
</form>


</body>
</html>