<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%!
      private boolean isEmpty(String str){
          if(str == null || str.trim().equals("")){
             return true; 
            } 
      
            return false; 
      }
 
 
       private final String successHtml = "<h1>로그인 상태입니다</h1> \n"  + 
                                         "<a  href=\"Logout.do\">로그아웃</a>";
                                                   
%>

<html>
<head>
<meta charset="UTF-8">
<title>로그인 완료 페이지</title>
</head>
<body>
<%
    String m_id = request.getParameter("m_id");
    String m_pw = request.getParameter("m_pw");
    Boolean isLogined = (Boolean) session.getAttribute("isLogined");
 
 
    //로그인 상태인지 여부 확인
    if (isLogined != null && isLogined) {
        out.println(successHtml);
    } else {
        //로그인 상태가 아닌 경우
        //id와 비밀번호를 모두 입력했는지 여부 확인
        if (isEmpty(m_id) || isEmpty(m_pw)) {
            response.sendRedirect("Login.do");
        } else {
            //id와 비밀번호를 모두 입력했고 id와 password가 같다면  로그인처리
            if (m_id.equals(m_pw)) {
                session.setAttribute("isLogined", true);
                out.println(successHtml);
            } else { 
                //id와 password가 같은값이 아니면 로그인 실패로 간주
                response.sendRedirect("Login.do");
            }
        }
    }
%>

</body>
</html>