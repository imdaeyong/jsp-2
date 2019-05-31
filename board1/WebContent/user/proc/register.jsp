<%@page import="kr.co.board1.config.SQL"%>
<%@page import="kr.co.board1.config.DBConfig"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	//파라미터 수신
	String id 	 = request.getParameter("id");
	String pw1 	 = request.getParameter("pw1");
	String pw2 	 = request.getParameter("pw2");
	String name	 = request.getParameter("name");
	String nick	 = request.getParameter("nick");
	String email = request.getParameter("email");
	String hp 	 = request.getParameter("hp");
	String zip 	 = request.getParameter("zip");
	String addr1 = request.getParameter("addr1");
	String addr2 = request.getParameter("addr2");
	String regip = request.getRemoteAddr();
	
	//1단계, 2단계
	Connection conn = DBConfig.getConnection();
	
	//3단계		   
	PreparedStatement psmt = conn.prepareStatement(SQL.INSERT_USER);
	psmt.setString(1, id);
	psmt.setString(2, pw1);
	psmt.setString(3, name);
	psmt.setString(4, nick);
	psmt.setString(5, email);
	psmt.setString(6, hp);
	psmt.setString(7, zip);
	psmt.setString(8, addr1);
	psmt.setString(9, addr2);
	psmt.setString(10, regip);
	
	//4단계
	psmt.executeUpdate();
	
	//5단계
	//6단계
	psmt.close();
	conn.close();
	
	//로그인 화면 이동
	response.sendRedirect("../login.jsp");
	
%>

