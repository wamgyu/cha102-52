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
	<nav
		class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		<div align="center">
			<h2>工業風輸入式預約 - membertest.jsp</h2>
			<h3>
				<a class="navbar-brand"
					href="<%=request.getContextPath()%>/back-end/emp/backbooking.jsp"><img
					src="<%=request.getContextPath()%>/resources/images/back1.gif">不要亂按
					會跳過去後台預約頁面</a>
			</h3>
		</div>
	</nav>

	<div align="center">
		<h3>
			<b>所有欄位皆為必填欄位想辦法改成不用必填要從servlet下手判斷在那邊執行這邊顯示</b>
		</h3>
		<form action="<%=request.getContextPath()%>/GameServlet" method="post">
            <!-- 這邊是使用曾刪改查的觸發KEY 傳回GameServlet後if ("insert".equals(action)) { 條件判斷
             -->

			<jsp:useBean id="tableSvc" scope="page"
				class="Testgametable.GametableService" />
			<div>
				<label for="TABLE_DATE">預約日期:</label> <input id="TABLE_DATE"
					name="TABLE_DATE" type="date" value="${param.TABLE_DATE}"
					onclick="hideContent('TABLE_DATE.errors');" /> <span
					id="TABLE_DATE.errors" class="error">要選日期喔!</span>
			</div>
      </div>

    



		<style>
		     .custom-horizontal-spacing {
        margin-left: 70px;   /* 左側間距 */
        margin-right: 20px;  /* 右側間距 */
    }
		</style>
		
		<label align="custom-horizontal-spacing">遊戲桌型:</label>
		<div class="row">
		    <c:forEach var="GametableVO" items="${tableSvc.all}">
		        <div class="col-md-2 center custom-horizontal-spacing"> <!-- Use col-md-3 for 4 items per row -->
		            <input type="radio" id="${GametableVO.TABLE_NO}" name="TABLE_NO"
		                value="${GametableVO.TABLE_NO}">
		            <label for="${GametableVO.TABLE_NO}">${GametableVO.TABLE_MANE}</label>
		        </div>
		    </c:forEach>
		</div>



	<div align="center">
		<input type="radio" class="d-inline-block" id="TABLE_MOR" name="PERIOD_TIME" value="0">
		<label class="d-inline-block" for="TABLE_MOR">上午(9-12)</label> 
		
		<input type="radio" class="d-inline-block" id="TABLE_EVE" name="PERIOD_TIME" value="1"> 
		<label class="d-inline-block" for="TABLE_EVE">下午(13-16)</label>

		<input type="radio" class="d-inline-block" id="TABLE_NIGHT" name="PERIOD_TIME" value="2">
		<label class="d-inline-block" for="TABLE_NIGHT">晚上(17-20)</label>
	</div>


	<div  align="center">	<!--hidden 允许 Web 开发者包含用户不可见、不可改的数据，在用户提交表单时，这些数据会一并发送出 -->
		<div></div>			<!--type="hidden"  name="action" -->
		<input type="hidden" name="action" value="insert"><!-- 就是它嗎的他實現insere功能傳輸!!!!表單可能會有一個隱藏字段<input type="hidden" name="action" value="insert">，當提交表單時，這個值會被傳送到Servlet，從而知道該進行"insert"操作。 -->
		<button type="submit" id="submit">送出新增</button> <!-- submit才是使資料送回的按鈕型態 -->
		<div></div>
	</div>
	</form>
	</div>














	<!-- JavaScript part -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	
	
<script>
	
	
		//清除提示信息
		function hideContent(d) {
			document.getElementById(d).style.display = "none";
		}

		//設定日期範圍
		let dateInput = document.getElementById('TABLE_DATE');
		// 設定今天作為最小日期
		let today = new Date();
		let dd = String(today.getDate()).padStart(2, '0');
		let mm = String(today.getMonth() + 1).padStart(2, '0'); //January is 0!
		let yyyy = today.getFullYear();
		today = yyyy + '-' + mm + '-' + dd;
		dateInput.min = today;

		// 設定10天後作為最大日期
		let tenDaysLater = new Date();
		tenDaysLater.setDate(tenDaysLater.getDate() + 10);
		dd = String(tenDaysLater.getDate()).padStart(2, '0');
		mm = String(tenDaysLater.getMonth() + 1).padStart(2, '0');
		yyyy = tenDaysLater.getFullYear();
		let maxDate = yyyy + '-' + mm + '-' + dd;
		dateInput.max = maxDate;
	</script>
</body>
</html>
