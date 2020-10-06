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
   <h3 align="center">예약정보</h3>   
   <div id="time_main">
   <form>
     <table border="0" width="600">
       <tr>
         <td colspan="5" class="line0"> 
         <c:choose>
          <c:when test="${!empty departO}"> 가는날 : ${dateO}</c:when>
          <c:when test="${!empty dateR1}"> 
            가는날 : ${dateR1}               
          </c:when>
         </c:choose>         
         </td>
       </tr>
       <tr>
         <td class="line1">출발</td>
         <td class="line1">도착</td>
         <td class="line1">고속사</td>
         <td class="line1">등급</td>
         <td class="line1">승차홈</td>
       </tr>                 
       <c:choose>
         <c:when test="${!empty departO}">      
           <tr>
             <td class="line">${departO} <br> ${depart} </td>
             <td class="line">${arrivalO} <br> ${arrival} </td>
             <td class="line">${company}</td>
             <td class="line">${levelO}</td>
             <td class="line">${platform}</td>
           </tr>      
           <tr>         
             <td class="line1">성인 수</td>
             <td class="line1">학생 수</td>
             <td class="line1">총 인원</td>
             <td class="line1" colspan="2">요금</td>
           </tr>  
           <tr>
             <td class="line">${busAdult} 명</td>
             <td class="line">${busStudent} 명</td>
             <td class="line">${seatCount} 명</td>
             <td class="line" colspan="2">
              ${busFare}원                 
             </td>
           </tr>  
           <tr>
            <td class="line1" colspan="4">선택좌석</td>
            <td class="line1"></td>
           </tr>
           <tr>
            <td class="line" colspan="4">
            <% 
             String []seatList = request.getParameterValues("seatlist");
             String tmpSeatList="";
             if (seatList != null){                
               for(int i = 0;i < seatList.length;i++){
               out.println(seatList[i]+"번 ");
               tmpSeatList += "&seatlist="+seatList[i];
               }               
             }             
            %>
            </td>
            <td class="line">
<a href="info.do?busAdult=${busAdult}&busStudent=${busStudent}&seatCount=${seatCount}<%= tmpSeatList %>&userid=${userid}&busRoute=${busRoute}&busFare=${busFare}&busList=${busList}" id="btnP">예약</a>
            </td>
           </tr>
           <tr>
            <td colspan="5"></td>
           </tr>       
         </c:when>
         <c:when test="${!empty dateR1}">   
           <tr>
             <td class="line">${departR} <br> ${depart}</td>
             <td class="line">${arrivalR} <br> ${arrival} </td>
             <td class="line">${company}</td>
             <td class="line">${levelR}</td>
             <td class="line">${platform}</td>
           </tr> 
           <tr>         
             <td class="line1">성인 수</td>
             <td class="line1">학생 수</td>
             <td class="line1">총 인원</td>
             <td class="line1" colspan="2">요금</td>
           </tr> 
           <tr>
             <td class="line">${prebusAdult} 명</td>
             <td class="line">${prebusStudent} 명</td>
             <td class="line">${preseatCount} 명</td>
             <td class="line" colspan="2">
              ${prefare}원   
             </td>
           </tr>           
           <tr>
            <td class="line1" colspan="4">선택좌석</td>
            <td class="line1"></td>
           </tr>
           <tr>
            <td class="line" colspan="4">
            <% 
              String preseatSel = request.getParameter("preseatSel");
              String []preseatSel2 = preseatSel.split(",");
              String tmpSeatList2 = "";
              if (preseatSel2 != null){ 
                for(int i = 0;i < preseatSel2.length;i++){
                out.println(preseatSel2[i]+"번 ");
                tmpSeatList2 += "&preseatSel="+preseatSel2[i];
                }
              } 
             %>    
            </td>
            <td class="line"></td>
           </tr> 
           
           
           <tr>
             <td colspan="5" class="line0">
              오는날 : ${dateR2}
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
             <td class="line">${arrivalR} <br> ${arrival} </td>
             <td class="line">${departR} <br> ${depart}</td>
             <td class="line">${company}</td>
             <td class="line">${levelR}</td>
             <td class="line">${platform}</td>
           </tr>               
           
           <tr>         
             <td class="line1">성인 수</td>
             <td class="line1">학생 수</td>
             <td class="line1">총 인원</td>
             <td class="line1" colspan="2">요금</td>
           </tr> 
           <tr>
             <td class="line">${busAdult} 명</td>
             <td class="line">${busStudent} 명</td>
             <td class="line">${seatCount} 명</td>
             <td class="line" colspan="2">
              ${busFare}원  
             </td>
           </tr>
           <tr>
            <td class="line1" colspan="4">선택좌석</td>
            <td class="line1"></td>
           </tr>
           <tr>
            <td class="line" colspan="4">
            <% 
              String []seatList = request.getParameterValues("seatlist");
              String tmpSeatList="";
              if (seatList != null){ 
                for(int i = 0;i < seatList.length;i++){
                out.println(seatList[i]+"번 ");
                tmpSeatList += "&seatlist="+seatList[i];
                }
              } 
             %>    
            </td>
            <td class="line">
<a href="info2.do?busAdult=${busAdult}&busStudent=${busStudent}&seatCount=${seatCount}<%= tmpSeatList %>&userid=${userid}&busRoute=${busRoute}&busFare=${busFare}&busList=${busList}&prebusAdult=${prebusAdult}&prebusStudent=${prebusStudent}&preseatCount=${preseatCount}<%= tmpSeatList2 %>&preuserid=${preuserid}&prebusRoute=${prebusRoute}&prefare=${prefare}&prebusList=${prebusList}" id="btnP">예약</a>
            </td>
           </tr> 
         </c:when>    
       </c:choose>              

     </table>
   </form>
   </div>
</div>
</body>
</html>