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
</style>
</head>

<body>
	<nav
		class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		<div align="center">
			<h2>工業風輸入式預約 - membertest.jsp</h2>
			<h3>
				<a class="navbar-brand"
					href="<%=request.getContextPath()%>/back-end/emp/select_page.jsp"><img
					src="<%=request.getContextPath()%>/resources/images/back1.gif">不要亂按
					會跳回去</a>
			</h3>
		</div>
	</nav>

	<div align="center">
		<h3>
			<b>所有欄位皆為必填欄位想辦法改成不用必填要從servlet下手判斷在那邊執行這邊顯示</b>
		</h3>
		<form action="<%=request.getContextPath()%>/GameServlet" method="post"
			enctype="multipart/form-data">


			<div>
				<label for="TABLE_DATE">預約日期:</label> <input id="TABLE_DATE"
					name="TABLE_DATE" type="date" value="${param.hiredate}"
					onclick="hideContent('TABLE_DATE.errors');" /> <span
					id="TABLE_DATE.errors" class="error">${errorMsgs.hiredate}</span>
			</div>



			<jsp:useBean id="tableSvc" scope="page"
				class="Testgametable.GametableService" />

			<label>遊戲桌型:<input type="radio" id="table-${GametableVO.TABLE_NO}" name="TABLE_NO" value="${GametableVO.TABLE_NO}"></label>
			<div class="row">
				<!-- Bootstrap row to contain the columns -->
				
					<c:forEach var="GametableVO" items="${tableSvc.all}">
						<div class="col-md-1 col-sm-1">
							<!-- Your Bootstrap column class -->
							<input type="radio" id="${GametableVO.TABLE_NO}"
								name="TABLE_NO" value="${GametableVO.TABLE_NO}"> <label
								for="${GametableVO.TABLE_NO}">${GametableVO.TABLE_MANE}</label>
						</div>
					</c:forEach>
				
			</div>



			<div>
				<div></div>
				<input type="hidden" name="action" value="insert">
				<button type="submit" id="submit">送出新增</button>
				<div></div>
			</div>
		</form>
	</div>


	<!-- JavaScript part -->
	<script type="text/javascript">
		//清除提示信息
		function hideContent(d) {
			document.getElementById(d).style.display = "none";
		}

		//照片上傳-預覽用
		var filereader_support = typeof FileReader != 'undefined';
		if (!filereader_support) {
			alert("No FileReader support");
		}
		acceptedTypes = {
			'image/png' : true,
			'image/jpeg' : true,
			'image/gif' : true
		};
		function previewImage() {
			var upfile1 = document.getElementById("upFiles");
			upfile1.addEventListener("change", function(event) {
				var files = event.target.files || event.dataTransfer.files;
				for (var i = 0; i < files.length; i++) {
					previewfile(files[i])
				}
			}, false);
		}
		function previewfile(file) {
			if (filereader_support === true
					&& acceptedTypes[file.type] === true) {
				var reader = new FileReader();
				reader.onload = function(event) {
					var image = new Image();
					image.src = event.target.result;
					image.width = 100;
					image.height = 75;
					image.border = 2;
					if (blob_holder.hasChildNodes()) {
						blob_holder.removeChild(blob_holder.childNodes[0]);
					}
					blob_holder.appendChild(image);
				};
				reader.readAsDataURL(file);
				document.getElementById('submit').disabled = false;
			} else {
				blob_holder.innerHTML = "<div  style='text-align: left;'>"
						+ "● filename: "
						+ file.name
						+ "<br>"
						+ "● ContentTyp: "
						+ file.type
						+ "<br>"
						+ "● size: "
						+ file.size
						+ "bytes"
						+ "<br>"
						+ "● 上傳ContentType限制: <b> <font color=red>image/png、image/jpeg、image/gif </font></b></div>";
				document.getElementById('submit').disabled = true;
			}
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
