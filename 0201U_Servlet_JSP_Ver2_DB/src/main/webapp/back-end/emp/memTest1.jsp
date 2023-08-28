<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="en">
<head>


<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>測試複選搜查預約</title>
<%@ include file="included-fragment.file"%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

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
</style>
</head>
<body>
	<c:if test="${not empty errorMsgs}">
		<div class="error-message">${errorMsgs}</div>
	</c:if>

	<div align="center">
		<h3>
			<b>所有欄位皆為必填欄位想辦法改成不用必填要從servlet下手判斷在那邊執行這邊顯示</b>
		</h3>





		<style>
.custom-horizontal-spacing {
	margin-left: 70px; /* 左側間距 */
	margin-right: 20px; /* 右側間距 */
}
</style>


		<jsp:useBean id="tableSvc" scope="page"
			class="Testgametable.GametableService" />
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
		
		
	
		<table border="1">
			<tr>
				<th>日期</th>
				<th>上午(9-12)</th>
				<th>下午(13-16)</th>
				<th>晚上(17-20)</th>
			</tr>
			<c:forEach var="VO" items="${tableSvc.all}">
				<tr>
					<td>${tb.TABLE_DATE}</td>
					<td>${tb.TABLE_MOR == 0 ? "Available" : (tb.TABLE_MOR == 1 ? "Booked" : "Closed")}</td>
					<td>${tb.TABLE_EVE == 0 ? "Available" : (tb.TABLE_EVE == 1 ? "Booked" : "Closed")}</td>
					<td>${tb.TABLE_NIGHT == 0 ? "Available" : (tb.TABLE_NIGHT == 1 ? "Booked" : "Closed")}</td>
				</tr>
			</c:forEach>
</body>
</html>