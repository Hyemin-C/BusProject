<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[ 2020. 9. 14.오후 3:26:59 ]</title>
<link rel="stylesheet" type="text/css" href="css/b_main.css"/>
<style type="text/css">
  body{
    padding: 0;
    background-image: url("img/main.jpg");
    background-repeat: no-repeat;
    background-size: cover;
  } 
</style>
<script type="text/javascript" src="js/b_timeCheck.js"></script>
</head>
<body>
  <div align="center" class="select">
  <form name="popformB">
    <button type="button" id="btn" value="서울" onclick="cityB(this.value)">서울</button> &nbsp;
    <button type="button" id="btn" value="인천" onclick="cityB(this.value)">인천</button> <p>
    <button type="button" id="btn" value="대전" onclick="cityB(this.value)">대전</button> &nbsp;
    <button type="button" id="btn" value="광주" onclick="cityB(this.value)">광주</button> <p>
    <button type="button" id="btn" value="부산" onclick="cityB(this.value)">부산</button> &nbsp;
    <button type="button" id="btn" value="도착" onclick="cityB(this.value)">취소</button>
  </form>
  </div>
</body>
</html>