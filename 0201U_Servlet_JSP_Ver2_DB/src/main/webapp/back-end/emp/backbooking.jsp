<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>工業版輸入式預約</title>
<%@ include file="included-fragment.file"%>



<style type="text/css">
button {
	padding: 5px;
}

form {
	display: table;
}

form div {
	display: table-row;
}

label, input, span, select {
	display: table-cell;
	margin: 5px;
	text-align: left;
}

input[type=text], input[type=password], select, textarea {
	width: 200px;
	margin: 5px;
}

form div div {
	display: table-cell;
}

.center {
	margin-left: auto;
	margin-right: auto;
}

table, td {
	border: 1px solid #333;
	width: 200px;
	margin: 5px;
	height: 20px;
}

thead, tfoot {
	background-color: #333;
	color: #fff;
	width: 200px;
	height: 20px;
}
</style>

<title>Insert title here</title>
</head>
<body>
	<nav
		class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		<div align="center">
			<h2>工業風後台改變預約狀態 - backbooking.jsp</h2>
			<h3>
				<a class="navbar-brand"
					href="<%=request.getContextPath()%>/back-end/emp/membertest.jsp"><img
					src="<%=request.getContextPath()%>/resources/images/back1.gif">不要亂按
					會跳回去選擇預約</a>
			</h3>
		</div>
	</nav>


	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<div align="center">
		<h3>
			<b>所有欄位皆為必填欄位想辦法改成不用必填要從servlet下手判斷在那邊執行這邊顯示</b>
		</h3>
		<form action="<%=request.getContextPath()%>/GameServlet" method="post">

			<jsp:useBean id="tableSvc" scope="page"
				class="Testgametable.GametableService" />

			<jsp:useBean id="daySvc" scope="page"
				class="Testtablebooking.TablebookingService" />
				
				
			<label align="custom-horizontal-spacing">遊戲桌型:</label>
			<div align="center">
				<select  name="selectedDate">
					<c:forEach var="booking" items="${daySvc.ten}">
						<option value="${booking.TABLE_DATE}">${booking.TABLE_DATE}</option>
					</c:forEach>
				</select>
			</div>

			<label align="custom-horizontal-spacing">遊戲桌型:</label>
			<div class="row">
				<c:forEach var="GametableVO" items="${tableSvc.all}">
					<div class="col-md-2 center custom-horizontal-spacing">
						<!-- Use col-md-3 for 4 items per row -->
						<input type="radio" id="${GametableVO.TABLE_NO}" name="TABLE_NO"
							value="${GametableVO.TABLE_NO}"> <label
							for="${GametableVO.TABLE_NO}">${GametableVO.TABLE_MANE}</label>
					</div>
				</c:forEach>
			</div>
			<input type="submit" value="預約">
		</form>




		<table>
			<thead>
				<tr>
					<th>日期</th>
					<th>上午時段</th>
					<th>下午時段</th>
					<th>晚上時段</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="selectedDateValue" items="${tableSvc.all}">
					<tr>
						<td>${booking.TABLE_DATE}</td>
						<td>${booking.TABLE_MOR}</td>
						<td>${booking.TABLE_EVE}</td>
						<td>${booking.TABLE_NIGHT}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="submit" value="選擇">
		</form>
	</div>

</body>
</html>