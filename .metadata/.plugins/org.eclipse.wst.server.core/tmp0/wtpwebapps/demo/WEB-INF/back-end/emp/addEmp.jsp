<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>







<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>員工資料新增 - addEmp.jsp</title>

<%@ include file="included-fragment.file" %>
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

<nav class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		 <div align="center"> <h2>員工資料新增 - addEmp.jsp</h2>
		 <h3><a class="navbar-brand" href="<%=request.getContextPath()%>/back-end/emp/select_page.jsp"><img src="<%=request.getContextPath()%>/resources/images/back1.gif">回查詢頁</a></h3></div>
</nav>

	<div align="center">
		<h3><b>所有欄位皆為必填欄位</b></h3>
		<form action="<%=request.getContextPath()%>/emp/emp.do" method="post" enctype="multipart/form-data">
			

			
			
			
			
			<div>
			<label for="ename">員工姓名:</label>
			<input id ="ename" name="ename" type="text" value="${param.ename}" onclick="hideContent('ename.errors');" />
			<span  id ="ename.errors" class="error">${errorMsgs.ename}<br/></span>
			</div>
			
			<div>
			<label for="job">職位:</label>
			<input id ="job" name="job" type="text" value="${param.job}" onclick="hideContent('job.errors');" />
			<span  id ="job.errors" class="error">${errorMsgs.job}</span>
			</div>

			<div>
			<label for="hiredate">雇用日期:</label>
			<input id ="hiredate" name="hiredate" type="date" value="${param.hiredate}" onclick="hideContent('hiredate.errors');" />
			<span  id ="hiredate.errors" class="error">${errorMsgs.hiredate}</span>
			</div>
			
			<div>
			<label for="sal">薪水:</label>
			<input id ="sal" name="sal" type="text" value="${param.sal}" onclick="hideContent('sal.errors');" />
			<span  id ="sal.errors" class="error">${errorMsgs.sal}</span>
			</div>
			
            <div>
			<label for="comm">獎金:</label>
			<input id ="comm" name="comm" type="text" value="${param.comm}" onclick="hideContent('comm.errors');" />
			<span  id ="comm.errors" class="error">${errorMsgs.comm}</span>
			</div>
			
			<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" />
			<div>
			<label for="deptno">部門:</label>	
			<select id="deptno" name="deptno">
			  	<c:forEach var="deptVO" items="${deptSvc.all}">
				  <option value="${deptVO.deptno}" ${(param.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname}
			    </c:forEach>
			</select>		
			</div>

            <div>
			<label for="upFiles">照片:</label>
			<input id ="upFiles" name="upFiles" type="file" onclick="previewImage()" multiple="multiple" onchange="hideContent('upFiles.errors');" />
			<span  id ="upFiles.errors" class="error">${errorMsgs.upFiles}</span>
			<div id="blob_holder"></div>
			</div>
			
			<div>
				<div></div>
				<input  type="hidden" name="action" value="insert">
				<button type="submit" id="submit"> 送出新增 </button>
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
	if (filereader_support === true && acceptedTypes[file.type] === true) {
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
		blob_holder.innerHTML = "<div  style='text-align: left;'>" + "● filename: " + file.name
				+ "<br>" + "● ContentTyp: " + file.type
				+ "<br>" + "● size: " + file.size + "bytes"
				+ "<br>" + "● 上傳ContentType限制: <b> <font color=red>image/png、image/jpeg、image/gif </font></b></div>";
		document.getElementById('submit').disabled = true;
	}
}
</script>

</body>
</html>