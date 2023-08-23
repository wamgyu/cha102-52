<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>







<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>員工資料管理 - select_page.jsp</title>

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
		margin: 2px;
		text-align: left;		
	}
	input[type=text], input[type=password], select, textarea {
		width: 200px;
		margin: 2px;
	}
	form div div {
		display: table-cell;
	}
	.center {
        margin-left: auto;
        margin-right: auto;
    }
    span {
		display: inline-block;
		width: 150px;
		text-align: left;
		font-weight: bold;
	}
	div.a {
        display: inline-block;
        width: 50%;
        height: auto;
        padding: 5px;
        border: 0px solid blue;    
        background-color: white; 
    }
    div.b {
        display: inline-block;
        width: 45%;
        height: auto;
        padding: 5px;
        border: 1px solid blue;    
        background-color: white;
    }
</style>
</head>
<body>

<nav class="navbar navbar-expand-md navbar-dark bg-success fixed-top justify-content-center">
		 <div align="center"> <h2>員工資料管理 - select_page.jsp</h2>
		 <h3><a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp"><img src="<%=request.getContextPath()%>/resources/images/back1.gif">回index.jsp</a></h3></div>
</nav>

	<h4><span>資料查詢:</span></h4>

	<div></div><br>
	<div class="a">
	  <ul>
		<li><h5><a href='<%=request.getContextPath()%>/back-end/emp/listAllEmp.jsp'>List</a> all Emps. <br><br></h5></li>

		<li>
			<form method="post" action="<%=request.getContextPath()%>/emp/emp.do">
				輸入員工編號:
				<input type="text" name="empno"><font color=red>${errorMsgs.empno}</font>
                <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出"> (輸入如7001)
			</form><br>
		</li>

        <jsp:useBean id="empSvc" scope="page" class="com.emp.model.EmpService" />

		<li><form method="post" action="<%=request.getContextPath()%>/emp/emp.do">
				選擇員工編號:
				<select size="1" name="empno">
                  <c:forEach var="empVO" items="${empSvc.all}" > 
                    <option value="${empVO.empno}">${empVO.empno}
                  </c:forEach>   
                </select>
                <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</form><br>
		</li>

		<li><form method="post" action="<%=request.getContextPath()%>/emp/emp.do">
				選擇員工姓名:
				<select size="1" name="empno">
                  <c:forEach var="empVO" items="${empSvc.all}" > 
                    <option value="${empVO.empno}">${empVO.ename}
                  </c:forEach>   
                </select>
                <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</form><br>
		</li>

<%-- 萬用複合查詢-以下欄位-可隨意增減 --%>
<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" />
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp/emp.do" name="form1">
        <font color=blue>萬用複合查詢:</font><br>
        輸入員工編號:
        <input type="text" name="empno" value="7001"><br>
           
        輸入員工姓名:
        <input type="text" name="ename" value="KING"><br>
       
        輸入員工職位:
        <input type="text" name="job" value="PRESIDENT"><br>
    
        選擇部門:
        <select size="1" name="deptno" >
            <option value="">
          <c:forEach var="deptVO" items="${deptSvc.all}" > 
            <option value="${deptVO.deptno}">${deptVO.dname}
          </c:forEach>   
       </select><br>
           
       雇用日期:
	   <input name="hiredate" type="date">
		        
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="listEmps_ByCompositeQuery">
     </FORM>
  </li>
</ul>

      <h4><span>員工管理</span></h4>
	  <ul>
		  <li><h5><a href='<%=request.getContextPath()%>/back-end/emp/addEmp.jsp'>Add</a> a new Emp.</h5></li>
	  </ul>
	</div>

    <c:if test="${getOne_For_Display}"><!-- 旗標getOne_For_Display見EmpServlet.java的第74行 -->
         <div class="b">
	      <%@ include file="listOneEmp-div-fragment.file" %> <%-- 或(也可) <jsp:include page="listOneEmp.jsp" /> --%>
	     </div>  
    </c:if>

</body>
</html>