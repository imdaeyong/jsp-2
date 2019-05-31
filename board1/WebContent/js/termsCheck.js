/**
 * 날짜 : 2019/05/15
 * 이름 : 김철학
 * 내용 : 회원약관 동의체크 구현
 */
$(document).ready(function(){			
				
				
	$('.btnNext').click(function(){
		
		var chk1 = $('input[name=chk1]').is(':checked');
		var chk2 = $('input[name=chk2]').is(':checked');
						
		if(!chk1){
			alert('이용약관에 동의 체크를 해주세요.');
			
			// a태그의 링크이동 취소
			return false;			
		}else if(!chk2){
			alert('개인정보 취급방침 동의 체크를 해주세요.');
			
			// a태그의 링크이동 취소
			return false;			
		}else{
			// a태그의 링크이동 
			return true;
		}							
		 
	});
});	



