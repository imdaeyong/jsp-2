<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// 세션 정보 삭제
	session.invalidate();

	// 로그인 이동
	response.sendRedirect("../login.jsp");
%>


