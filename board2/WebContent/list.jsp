<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>글목록</title> 
		<link rel="stylesheet" href="./css/style.css" />
	</head>
	<body>
		<div id="board">
			<h3>글목록</h3>
			<!-- 리스트 -->
			<div class="list">
				<p class="logout">${ user.nick }님! 반갑습니다. <a href="/board2/user/logout.do">[로그아웃]</a><p>
				<table>
					<tr>
						<td>번호</td>
						<td>제목</td>
						<td>글쓴이</td>
						<td>날짜</td>
						<td>조회</td>
					</tr>
								
					<tr>
						<td>1</td>
						<td><a href="#">타이틀</a>&nbsp;[3]</td>
						<td>홍길동</td>
						<td>19-05-31</td>
						<td>12</td>
					</tr>
					
				</table>
			</div>
			<!-- 페이징 -->
			<nav class="paging">
				<span> 
					<a href="#" class="prev">이전</a>
					<a href="#" class="num">1</a>
					<a href="#" class="next">다음</a>
				</span>
			</nav>
			<a href="/board2/write.jsp" class="btnWrite">글쓰기</a>
		</div>
	</body>

</html>










