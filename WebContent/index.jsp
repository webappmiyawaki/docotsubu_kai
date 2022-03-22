<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.GenerateString" %>
<%@ page import="model.GeneratePassword" %>
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
GeneratePassword generatePassword = new GeneratePassword();
String gpass = generatePassword.generate();
%>

<form action="RegisterUser" method="get">
	<button type='submit' name='action'>新規登録</button>
</form>

<form action="Login" method="post">
ユーザー名：<input type="text" name="name" value="<%= gname %>"><br>
パスワード：<input type="password" name="pass" value="<%= gpass %>"><br>
<input type="submit" value="ログイン">
</form>

</body>
</html>