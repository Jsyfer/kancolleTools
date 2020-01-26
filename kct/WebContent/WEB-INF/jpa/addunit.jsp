<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="jpa.UnitDetails"%>
<%@ page import="jpa.Type"%>
<%@ page import="jpa.Unit"%>
<%@ page import="jpa.Status"%>
<%@ page import="javax.servlet.http.HttpSession"%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
//对预选列表进行多条件筛选
	//每次对复选框进行点击操作则重新进行筛选
	$("#filters").find("input:checkbox").on("change",function(){
		//将两组复选框的筛选条件分别存放进两个列表内
		var checkTypeArray = [];
		var checkStatusArray = [];
		$("#typeFilters input:checked").each(function(){
			checkTypeArray.push($(this).attr("value"))
		});
		$("#statusFilters input:checked").each(function(){
			checkStatusArray.push($(this).attr("value"))
		});
		//将 table内的每一行数据 与 上述列表内容进行比对，若不存在列表内，则隐藏该行
		$("#shipSelectionTable tr").each(function(){
			var classes = $(this).attr('class').split(' ');
			//分别判断两个class属性是否均存在于对应的列表内
			var hasTypeIn = jQuery.inArray(classes[0], checkTypeArray) !== -1;
			var hasStatusIn = jQuery.inArray(classes[1], checkStatusArray) !== -1;
			//若两者均存在则显示该行，否则隐藏
			if(hasTypeIn && hasStatusIn){
				$(this).show();
			}else{
				$(this).hide();
			}
		});
	});
//复选框全选功能
	//对类型进行全选
	$("#typeCheckAll").click(function(){
		$('.typeCheck').prop('checked', $(this).prop('checked'));
	});
	//对状态进行全选
	$("#statusCheckAll").click(function(){
		$('.statusCheck').prop('checked', $(this).prop('checked'));
	});
	//对舰船进行全选
	$("#shipCheckAll").click(function(){
		$('.shipCheck:visible').prop('checked', $(this).prop('checked'));
	});
});
</script>
<html>
<head>
<title>add unit</title>
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
</style>
</head>
<body>
	<table id="filters">
		<tr>
			<td>
				<input type="checkbox" name="type" id="typeCheckAll" checked>全选
			</td>
			<td id="typeFilters">
				<%
					for(Type type : (List<Type>)session.getAttribute("typeList")){
				%>
				<input type="checkbox" name="type" class="typeCheck" value="<%=type.getName()%>" checked><%=type.getName()%>
				<%
					}
				%>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox" name="status" id="statusCheckAll" checked>全选
			</td>
			<td id="statusFilters">
				<%
					for(Status status : (List<Status>)session.getAttribute("statusList")){
				%>
				<input type="checkbox" name="status" class="statusCheck" value="kai<%=status.getId()%>" checked><%=status.getName()%>
				<%
					}
				%>
			</td>
		</tr>
	</table>
	<form action="addunit" method="post">
		<button>添加</button>
		<br>
	<table>
		<thead>
			<tr>
				<th><input type="checkbox" id="shipCheckAll"></th>
				<th>图鉴编号</th>
				<th>舰船名</th>
			</tr>
		</thead>
		<tbody id="shipSelectionTable">
		<%
			for (UnitDetails unit : (List<UnitDetails>) request.getAttribute("unitList")) {
		%>
		<tr class="<%=unit.getTypeName()%> kai<%=unit.getuStatus()%>">
			<td><input type="checkbox" name="unitCheck" class="shipCheck" value="<%=unit.getuId()%>"></td>
			<td><%=unit.getuId()%></td>
			<td><%=unit.getuName()%></td>
		</tr>
		<%
			}
		%>
		</tbody>
	</table>
	</form>
<a href="login">主页</a><br>
<a href="fleetplan">战力分配规划</a><br>
</body>
</html>