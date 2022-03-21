<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%
User loginUser = (User) session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>どこつぶ</title>
</head>
<body>
<h1>どこつぶログイン</h1>
<% if(loginUser != null) {
	out.println("<p>ログインに成功しました</p>");
	out.println("<p>"+loginUser.getName() +"さん</p>");
	out.println("<a href=\"Main\">つぶやき投稿・閲覧へ</a><br>");
}else{
	out.println("ログインに失敗しました");
	out.println("<a href=\"/docotsubu_kai/\">TOPへ</a>");
}
%>
<a href="index.jsp">index.jsp</a>
</body>
</html>