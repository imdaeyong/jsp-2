/**
 * 날짜 : 2019/05/14
 * 이름 : 김철학
 * 내용 : 사용자 아이디, 이메일, 닉네임, 휴대폰 중복체크
 */
$(function(){
				
	// 아이디 필드에 포커스가 빠져나갈때 실행되는 이벤트 함수
	$('input[name=id]').focusout(function(){
		
		var tag = $(this);
		var uid = tag.val();
		
		// AJAX통신(부분통신) 시작
		$.ajax({
			url: './proc/checkUid.jsp?uid='+uid,
			type: 'get',
			dataType: 'json',
			success: function(data){
				if(data.result == 1){
					$('.resultId').css('color', 'red').text('이미 사용 중인 아이디 입니다.');
					tag.focus();
				}else{
					$('.resultId').css('color', 'green').text('사용 가능한 아이디 입니다.');
				}
			}
		});
		
	});
	
	// 닉네임 중복체크
	$('input[name=nick]').focusout(function(){
		
		var tag = $(this);
		var nick = tag.val();
		
		// AJAX통신(부분통신) 시작
		$.ajax({
			url: './proc/checkNick.jsp?nick='+nick,
			type: 'get',
			dataType: 'json',
			success: function(data){
				if(data.result == 1){
					$('.resultNick').css('color', 'red').text('이미 사용 중인 별명 입니다.');
					tag.focus();
				}else{
					$('.resultNick').css('color', 'green').text('사용 가능한 별명 입니다.');
				}
			}
		});
		
	});
	
	
	// 이메일 중복체크
	
	
	
	// 휴대폰 중복체크
	
	
	
	
});