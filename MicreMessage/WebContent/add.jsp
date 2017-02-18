<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>添加界面</title>
</head>
<body>
<a href="<%=basePath %>List.action"><b>内容列表</b></a><br>
<form action="<%=basePath %>AddServlet.action" method="post">
指令：<input type="text" name="command"><br>
描述：<input type="text" name="description"><br>
内容：<input type="text" size="40" name="content"><br>
<input type="submit" value="提交">
</form>

</body>
</html>