<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[ 2020. 9. 15.오후 2:03:58 ]</title>
<style type="text/css"> 
  body{
    padding: 0;
    background-image: url("img/main.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    background-attachment: fixed;   
  }     
</style>
<link rel="stylesheet" type="text/css" href="css/b_time.css"/>
</head>
<body>
<div id="time">
   <h3 align="center">배차조회</h3>
   <div id="time_left"><br><br>
   <form>
     <table align="center">     
     <tr>
       <td class="dt">
       <c:choose>
         <c:when test="${!empty dateO}">
           ${dateO}
         </c:when>
         <c:when test="${!empty dateR1}">
           ${dateR1}
         </c:when>
         <c:when test="${!empty dateR2}">
           ${dateR2}
         </c:when>
       </c:choose> <p>
       </td> 
     </tr>
     <tr>
       <td> 
         <input type="button" id="btn" value="출발"> 
         ${departO} ${departR} <p> 
       </td> 
     </tr>
     <tr>
       <td> 
         <input type="button" id="btn" value="도착"> 
         ${arrivalO} ${arrivalR} <p>
       </td> 
     </tr>
     </table>   
   </form>
   </div> 
   
   <div id="time_main">
   <form>
     <table border="0" width="600">
       <tr>
         <td colspan="5" class="line0"> ${dateO} 
         <c:choose>
           <c:when test="${!empty dateR1}">${dateR1}</c:when>
           <c:when test="${!empty dateR2}">${dateR2}</c:when>
         </c:choose>
         </td>
       </tr>
       <tr>
         <td class="line1">출발</td>
         <td class="line1">고속사</td>
         <td class="line1">등급</td>
         <td class="line1">잔여석</td>
         <td class="line1"></td>
       </tr>
       <c:if test="${data != 1 and data != 2}">       
         <tr>
          <td colspan="5"> 
            <p><br><p> *조회된 배차 목록이 없습니다* <p>
            <a href="b_main.jsp">[메인으로]</a>
          </td>
         </tr>
       </c:if>                    
       <c:choose>
         <c:when test="${!empty departO}">
           <c:forEach var="rdto" items="${timelistO}">       
           <tr>
             <td class="line">${rdto.depart}</td>
             <td class="line">${rdto.company}</td>
             <td class="line">${rdto.rank}</td>
             <td class="line">${rdto.seatrmd}</td>
             <td class="line">
              <a href="time.do?data=${data}&routeno=${rdto.routeno}&timeno=${rdto.timeno}&dateO=${dateO}&departO=${departO}&arrivalO=${arrivalO}&levelO=${levelO}&depart=${rdto.depart}&arrival=${rdto.arrival}&company=${rdto.company}&platform=${rdto.platform}">선택</a>
             </td>
           </tr>       
           </c:forEach>
         </c:when>
         <c:when test="${!empty dateR1}">
           <c:forEach var="rdto" items="${timelistR1}">       
           <tr>
             <td class="line">${rdto.depart}</td>
             <td class="line">${rdto.company}</td>
             <td class="line">${rdto.rank}</td>
             <td class="line">${rdto.seatrmd}</td>
             <td class="line">
              <a href="time.do?data=${data}&dateR1=${dateR1}&dateR2=${dateR2}&departR=${departR}&arrivalR=${arrivalR}&levelR=${levelR}&routeno=${rdto.routeno}&timeno=${rdto.timeno}&depart=${rdto.depart}&arrival=${rdto.arrival}&company=${rdto.company}&platform=${rdto.platform}">선택</a>
             </td>
           </tr>       
           </c:forEach>
         </c:when> 
       </c:choose>
     </table>
   </form>
   </div>
</div>
<%-- <c:if test="${data==2}"> <jsp:forward page="b_timeR.jsp"/> </c:if> --%>
</body>
</html>