package kr.co.board2.service.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.board2.controller.CommonService;
import kr.co.board2.dao.UserDao;
import kr.co.board2.vo.UserVO;

public class RegisterService implements CommonService {

	@Override
	public String requestProc(HttpServletRequest req, HttpServletResponse resp) {
		
		if(req.getMethod().equals("GET")) {
		
			return "/user/register.jsp";	
			
		}else {
			
			UserVO vo = new UserVO();
			vo.setUid(req.getParameter("id"));
			vo.setPass(req.getParameter("pw1"));
			vo.setName(req.getParameter("name"));
			vo.setNick(req.getParameter("nick"));
			vo.setEmail(req.getParameter("email"));
			vo.setHp(req.getParameter("hp"));
			vo.setZip(req.getParameter("zip"));
			vo.setAddr1(req.getParameter("addr1"));
			vo.setAddr2(req.getParameter("addr2"));
			vo.setRegip(req.getRemoteAddr());
			
			UserDao dao = UserDao.getInstance();
			
			try {
				dao.insertUser(vo);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return "redirect:/board2/user/login.do";
		}
				
		
	}

}


















