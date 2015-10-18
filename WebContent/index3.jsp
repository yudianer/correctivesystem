<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.cmli.correctivesystem.domain.Customer"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
			List<Customer> customers = (List<Customer>) request.getAttribute("customers");
			if (customers != null && customers.size() > 0) {
		%>
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<th>
					ID
				</th>
				<th>
					Minwen
				</th>
				<th>
					Hanwen
				</th>
				<th>
					UPDATE/DELETE
				</th>
			</tr>
			<%
				for (Customer customer : customers) {
			%>
			<tr>
				<td><%=customer.getId()%></td>
				<td><%=customer.getMinwen()%></td>
				<td><%=customer.getHanwen()%></td>
				<td>
					<a href="update.do?id=<%=customer.getId()%>" class="update"> <font size="4">修改</font> </a>
					<a href="delete.do?id=<%=customer.getId()%>" class="delete"><font size="4">删除</font> </a>
				</td>
			</tr>
			<%
				}
			%>

		</table>
		<%
			}
		%>
		
</body>
</html>