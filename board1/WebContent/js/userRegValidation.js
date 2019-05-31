/**
 * 날짜 : 2019/05/15
 * 이름 : 김철학
 * 내용 : 회원가입 데이터 유효성 검증(Validation)
 */
$(function(){
				
	// 폼전송 버튼을 클릭했을 때 실행되는 전송이벤트 함수
	$('#regForm').submit(function(){
		
		var uid = $('input[name=id]').val();
		var pw1 = $('input[name=pw1]').val();
		var pw2 = $('input[name=pw2]').val();
		
		// 아이디가 5자리 이하이면 폼전송 취소
		if(uid.length < 5){						
			alert('아이디는 최소 5자리 이상 이어야 합니다.');
			return false;
		}								
		
		// 비밀번호가 일치하지 않으면 폼전송 취소
		if(pw1 != pw2){						
			alert('비밀번호가 일치하지 않습니다.');
			return false;
		}
		
		// 모든 조건을 통과 한 후 폼전송 승인 					
		return true;
	});				
	
});