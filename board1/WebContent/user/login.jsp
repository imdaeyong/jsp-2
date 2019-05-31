<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	String result = request.getParameter("result");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>로그인</title>
		<link rel="stylesheet" href="/board1/css/style.css" />
		<script>
			var result = "<%= result %>";
			
			if(result == 'fail'){
				alert('로그인 실패\n아이디, 비밀번호를 다시 확인하십시요.');
			}
			
			if(result == '101'){
				alert('목록 실패\n로그인을 해야 합니다.');
			}
			
		</script>
	</head>
	<body>
		<div id="member">
			<section class="login">		
				<form action="/board1/user/proc/login.jsp" method="post">
					<table>
						<tr>
							<td><img src="/board1/img/login_ico_id.png" alt="아이디" /></td>
							<td><input type="text" name="id" required placeholder="아이디 입력" autocomplete="off" /></td>
						</tr>
						<tr>
							<td><img src="/board1/img/login_ico_pw.png" alt="비밀번호" /></td>
							<td><input type="password" name="pw" required placeholder="비밀번호 입력" /></td>
						</tr>
					</table>
					<input type="submit" class="btnLogin" value="로그인" />
				</form>			
				
				<div class="info">
					<h3>회원로그인 안내</h3>
					<p>아직 회원이 아니시면 회원으로 가입하세요.</p>
					<div><a href="/board1/user/terms.jsp">회원가입</a></div>
				</div>			
			</section>
		</div>
	
	</body>
</html>




