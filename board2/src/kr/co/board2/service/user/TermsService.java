package kr.co.board2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board2.controller.CommonService;
import kr.co.board2.dao.UserDao;
import kr.co.board2.vo.TermsVO;

public class TermsService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		UserDao dao = UserDao.getInstance();
		TermsVO vo = null;
		
		try {
			vo = dao.getTerms();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("vo", vo);
		
		
		return "/user/terms.jsp";
	}

}

































