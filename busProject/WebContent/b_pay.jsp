<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="header.jsp" %>

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
<link rel="stylesheet" type="text/css" href="css/b_pay.css"/>
</head>
<body>
<div id="time">
   <h3 align="center">예약완료</h3>   
   <div id="time_main">
   <form>
     <table border="0" width="600">
       <tr>       
         <td colspan="5" class="line0"> 
            예약란                      
         </td>
       </tr>
       <tr>
        <td colspan="5" class="line1">
        <p><br>
        성공적으로 예매가 완료 되었습니다. <p>
        아래의 계좌로 입금 해 주시기 바랍니다. <p><br> 
        </td>
       </tr>
       <tr>
        <td colspan="4" class="line1"> 
        <p>
           은행명  <p>
           예금주  <p>
           계좌번호 <p>
        </td>
        <td class="line">
        <p>
          tis은행 <p>  
          tis고속 <p>
          110-920-786-1107
        </td>
       </tr>
       <tr>
        <td colspan="5"><p>
          <img src="img/tis.png" width="200px" height="200px">
        </td>
       </tr>

     </table>
   </form>
   </div>
</div>
</body>
</html>