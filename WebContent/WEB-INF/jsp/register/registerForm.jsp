<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.GenerateString" %>
<%@ page import="model.GeneratePassword" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>

<%
GenerateString generateString = new GenerateString();
String gname = generateString.generate();
GeneratePassword generatePassword = new GeneratePassword();
String gpass = generatePassword.generate();
%>

<form action="/docotsubu_kai/RegisterUser" method="post">
ユーザー名：<input type="text" name="name" value="<%= gname %>"><br>
パスワード：<input type="password" name="pass" value="<%= gpass %>"><br>
<input type="submit" value="新規登録">
</form>

</body>
</html>
