<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="jpa.UnitDetails"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fleet Plan</title>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
}

td, th {
	border: 1px solid;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #FFFFFF;
}

#container {
	display: -webkit-box;
	display: -moz-box;
	display: box;
	-webkit-box-orient: horizontal; /*属性值：[horizontal]横向/[vertical]纵向*/
	-moz-box-orient: horizontal;
	box-orient: horizontal;
}

#left {
	-webkit-box-flex: 1;
	-moz-box-flex: 1;
	box-flex: 1;
}

#right {
	-webkit-box-flex: 1;
	-moz-box-flex: 1;
	box-flex: 1;
}
</style>
</head>
<body>

<div id="container">
    <div id="left">  
        <form action="fleetplan" method="post">
            <button>》》》》</button>
       		<table>
				<thead>
					<tr>
						<th><input type="checkbox" id="LshipCheckAll"></th>
						<th>图鉴编号</th>
						<th>舰船名</th>
						<th>舰船類型</th>
						<th>tagName</th>
					</tr>
				</thead>
				<tbody id="LshipSelectionTable">
					<%
						for (UnitDetails unit : (List<UnitDetails>) request.getAttribute("unitListUsed")) {
					%>
					<tr class="<%=unit.getTypeName()%> <%=unit.getuStatus()%> Tag<%=unit.getTagId()%>">
						<td><input type="checkbox" name="unitCheck" class="shipCheck" value="<%=unit.getuId()%>"></td>
						<td><%=unit.getuId()%></td>
						<td><%=unit.getuName()%></td>
						<td><%=unit.getTypeName()%></td>
						<td><%=unit.getTagName()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
    	</form>
    </div>
    <div id="right">
        <form action="fleetplan" method="post">
            <button>《《《《</button>
       		<table>
				<thead>
					<tr>
						<th><input type="checkbox" id="RshipCheckAll"></th>
						<th>图鉴编号</th>
						<th>舰船名</th>
						<th>舰船類型</th>
						<th>tagName</th>
					</tr>
				</thead>
				<tbody id="RshipSelectionTable">
					<%
						for (UnitDetails unit : (List<UnitDetails>) request.getAttribute("unitList")) {
					%>
					<tr class="<%=unit.getTypeName()%> <%=unit.getuStatus()%> Tag<%=unit.getTagId()%>">
						<td><input type="checkbox" name="unitCheck" class="shipCheck" value="<%=unit.getuId()%>"></td>
						<td><%=unit.getuId()%></td>
						<td><%=unit.getuName()%></td>
						<td><%=unit.getTypeName()%></td>
						<td><%=unit.getTagName()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
        </form>
    </div>
</div>
</body>
</html>

