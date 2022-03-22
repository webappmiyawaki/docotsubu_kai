<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.generator.GenerateString" %>
<%@ page import="model.generator.GeneratePassword" %>
<%@page import="model.RegistorUserList"%>
<%@page import="java.util.*" %>
<%
RegistorUserList rul = (RegistorUserList) application.getAttribute("rul");
%>
<%@page import="model.User"%>

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

<p>入力が面倒くさいので自動で初期値出力</p>
<p>name:<%= gname %><br>
pass:<%= gpass %></p>
<br>
<form action="/docotsubu_kai/VerifyUser" method="get">
ユーザー名：<input type="text" name="name" value="<%= gname %>"><br>
パスワード：<input type="password" name="pass" value="<%= gpass %>"><br>
<br>
<input type="submit" value="新規登録">
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
%>

</body>
</html>
