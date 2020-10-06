<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> b_timeCheckList.jsp </title>
<style type="text/css"> 
  body{
    padding: 0;
    background-image: url("img/main.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    background-attachment: fixed;   
  }     
</style>
</head>
<body>
 <div id="timeCheckList" align="center">
   <form>
     <table border="0" width="600">
       <tr><br><br>
         <td class="line1">출발</td>
         <td class="line1">&nbsp;&nbsp;&nbsp;고속사&nbsp;&nbsp;&nbsp;</td>
         <td class="line1">&nbsp;등급&nbsp;</td>
         <td class="line1">&nbsp;어른요금&nbsp;</td>
         <td class="line1">&nbsp;학생요금&nbsp;</td>
         <td class="line1">잔여석/총좌석</td>
         
       </tr>              
           <c:forEach var="rdto" items="${timelistT}">       
           <tr>
             <td class="line">${rdto.depart}</td>
             <td class="line">${rdto.company}</td>
             <td class="line">${rdto.rank}</td>
             <td class="line">18,000원</td>
             <td class="line">9,000원</td>
             <td class="line">${rdto.seatrmd}/28</td>
              </tr>       
           </c:forEach>
     </table>
   </form>
   </div>
</body>
</html>