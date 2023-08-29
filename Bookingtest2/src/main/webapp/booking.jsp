<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<head>
<title>IBM Emp: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM Emp: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Emp: Home</p>

<h3>資料查詢:</h3>

<%-- 錯誤表列 --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">請修正以下錯誤:</font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message.value}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<ul>
  <li><a href='listOneBook.jsp'>List</a> all Emps.  <br><br></li>


  <li>
    <FORM METHOD="get" ACTION="web.booking.controller.BookingServlet" >
        <b>輸入員工編號 (如7001):</b>
        <input type="text" name="bookingno" value="${param.bookingno}"><font color=red>${errorMsgs.bookingno}</font>
        <input type="hidden" name="action" value="getOne">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="bookSvc" scope="page" class="web.booking.service.BookingServiceImpl" />



  <li>
     <FORM METHOD="post" ACTION="web.booking.controller.BookingServlet" >
       <b>選擇預約單號:</b>
       <select size="1" name="bookingno">
         <c:forEach var="bookVO" items="${bookSvc.all}" >
          <option value="${bookVO.bookingno}">${bookVO.bookingno}
         </c:forEach>
       </select>
       <!-- 綁定BookingServlet-->
       <input type="hidden" name="action" value="getOne">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


</body>
</html>