<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<%@page import="com.cmli.correctivesystem.domain.Customer"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		<%
			Customer customers = (Customer) request.getAttribute("customersup");
		%>
		<form action="add.do" method="post" name="addcustomer">
			<table>
				<tr>
					<td>
						Minwen
					</td>
					<td>
						<input type="text" name="minwen"  value="<%=customers.getMinwen() %>" />
					</td>
					<td>
						Hanwen
					</td>
					<td>
						<input type="text" name="hanwen" value="<%=customers.getHanwen() %>" />
					</td>
				</tr>
				<tr>
					<td>
						Shuxone
					</td>
					<td>
						<input type="text" name="shuxone" value="<%=customers.getShuxone() %>" />
					</td>
					<td>
						Shuxtwo
					</td>
					<td>
						<input type="text" name="shuxtwo"  value="<%=customers.getShuxtwo() %>" />
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Update" />
					</td>
				</tr>

			</table>
		</form>

	</body>
</html>
