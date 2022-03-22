<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.generator.GenerateString" %>
<%@ page import="model.generator.GeneratePassword" %>
<%@page import="model.RegistorUserList"%>
<%@page import="java.util.*" %>
<%@page import="model.User"%>
<%
RegistorUserList rul = (RegistorUserList) application.getAttribute("rul");
%>

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

初回起動時は新規登録しか表示されない。
<form action="RegisterUser" method="get">
	<button type='submit' name='action'>新規登録</button>
</form>
<br>
<% if(rul!=null){ %>
<form action="Login" method="post">
ユーザー名：<input type="text" name="name"><br>
パスワード：<input type="password" name="pass"><br>
<input type="submit" value="ログイン">
</form>
<br>
<br>
登録ユーザー一覧<br>
<%
if(rul!=null){
	List<User> rList = rul.getRegistorUserList();
	for(User rUser:rList){
%>
user:<%= rUser.getName() %> pass:<%= rUser.getPass() %><br>
<%
	}
}
} %>

</body>
</html>