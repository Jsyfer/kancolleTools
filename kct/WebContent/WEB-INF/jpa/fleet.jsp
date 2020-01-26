<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jpa.Unit"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fleet</title>
</head>
<body>

	<table>
		<tr>
			<td>图鉴编号</td>
			<td>舰船名</td>
		</tr>
		<%
			for (Unit unit : (List<Unit>) request.getAttribute("unitList")) {
		%>
		<tr>
			<td><%=unit.getId()%></td>
			<td><%=unit.getName()%></td>
		</tr>
		<%
			}
		%>
	</table>

</body>
</html>