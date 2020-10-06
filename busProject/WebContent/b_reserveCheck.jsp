<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>

<%request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>[ 2020. 9. 15.오후 2:03:58 ]</title>
<style type="text/css"> 
  body{
    padding: 0;
    background-image: url("img/main.jpg");
    background-repeat: no-repeat;
    background-size: cover;
    background-attachment: fixed;   
  }     
  /*123  */
</style>
<link rel="stylesheet" type="text/css" href="css/b_info.css"/>
</head>
<body>
<div id="time">
   <h3 align="center">예약확인</h3>   
   <div id="time_main" style="overflow: auto;height: 600px; width: 625px;">
     <table border="0" width="620">
     <c:forEach var="rcdto" items="${reservelist}">
       <tr>
         <td colspan="5" class="line0">  
           예약내역
         </td>
       </tr>
       <tr>
         <td class="line1">출발</td>
         <td class="line1">도착</td>
         <td class="line1">고속사</td>
         <td class="line1">등급</td>
         <td class="line1">승차홈</td>
       </tr>                    
       <tr>
         <td class="line">${rcdto.depart} <br> ${rcdto.departDate} </td>
         <td class="line">${rcdto.arrival} <br> ${rcdto.arrivalDate} </td>
         <td class="line">${rcdto.company}</td>
         <td class="line">${rcdto.rank}</td>
         <td class="line">${rcdto.platform}</td>
       </tr>      
       <tr>         
         <td class="line1">성인 수</td>
         <td class="line1">학생 수</td>
         <td class="line1">총 인원</td>
         <td class="line1" colspan="2">요금</td>
       </tr>  
       <tr>
         <td class="line">${rcdto.adult}명</td>
         <td class="line">${rcdto.student}명</td>
         <td class="line">${rcdto.adult+rcdto.student}명</td>
         <td class="line" colspan="2">${rcdto.fare}원  </td>
       </tr>  
       <tr>
         <td class="line1" colspan="4">좌석</td>
         <td class="line1"></td>
       </tr>
       <tr>
         <td class="line" colspan="4">${rcdto.selected}번</td>
         <td class="line">
           <input type="button" value="취소" onclick="check('${rcdto.selected}','${rcdto.timeno}','${rcdto.routeno}','${id}')" id="btnP">
         </td>
       </tr>
      </c:forEach>
     </table>
   </div>
</div>
</body>
<script type="text/javascript">
	function check(code, timeno, routeno, id){
		var cf = confirm("정말 예약 취소 하시겠습니까?");
		if(cf){
			location.href="reserveDelete.do?code="+code+"&timeno="+timeno+"&routeno="+routeno+"&id="+id;
		}else{location.reload(true);}
	}
</script>
</html>