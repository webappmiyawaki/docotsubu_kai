<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.User" %>
<%
User registerUser = (User) session.getAttribute("registerUser");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<p>下記のユーザーを登録します</p>
<p>
ユーザー名:<%= registerUser.getName() %><br>
パスワード:<%= registerUser.getPass() %><br>
</p>
<a href="/docotsubu_kai/RegisterUser">戻る</a>
<a href="/docotsubu_kai/RegisterUser?action=done">登録</a>
</body>
</html>