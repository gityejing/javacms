<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery.1.5.1.js"></script>		
	<script type="text/javascript" src="js/main.js"></script>
	
  </head>
  
  <body>
  	<div>${error}</div>
    <table width="350">

    	<form action="servlet/LoginServlet" method="POST">
    	<tr>
    		<td width="100px;">User Name :</td>
    		<td width="200px;"><input type="text" name="username"/></td>
    	</tr>
    	<tr>
    		<td>Password :</td>
    		<td><input type="password" name="password"></td>
    	</tr>
    	<tr>
    		<td>Safe Code :</td>
    		<td><input type="text" name="safecode">
    		<div id="safeCodeDiv" style="float:right;padding-left:0;width:50px;border:solid 1px red;"></div>
    		</td>
    	</tr>
    	<tr>
    		<td><input type="submit" value="Login"></td>
    	</tr>   
    	</form> 	    	    	
    </table>

  </body>
</html>
