<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
	  <%
		request.setCharacterEncoding("UTF-8");
	%>

    	<form action="add.do" method="post" name="addcustomer">
			<table>
				<tr>
					<td>
						Minwen
					</td>
					<td>
						<input type="text" name="minwen" />
					</td>
					<td>
						Hanwen
					</td>
					<td>
						<input type="text" name="hanwen" />
					</td>
				</tr>
				
				<tr>
					<td>
						Shuxone
					</td>
					<td>
						<input type="text" name="shuxone" />
					</td>
					<td>
						Shuxtwo
					</td>
					<td>
						<input type="text" name="shuxtwo" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Add data" class="add"/>
					</td>
				</tr>
				
			</table>
		</form>
  </body>
</html>
