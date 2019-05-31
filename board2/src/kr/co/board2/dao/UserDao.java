package kr.co.board2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import kr.co.board2.config.DBConfig;
import kr.co.board2.config.SQL;
import kr.co.board2.vo.TermsVO;

public class UserDao {

	private static UserDao instance = new UserDao();
	
	public static UserDao getInstance() {
		return instance;
	}
	
	private UserDao() {}
	
	
	public TermsVO getTerms() throws Exception {
		
		//1단계, 2단계
		Connection conn = DBConfig.getConnection();
		//3단계
		Statement stmt = conn.createStatement();
		//4단계
		ResultSet rs = stmt.executeQuery(SQL.SELECT_TERMS);
		//5단계
		TermsVO vo = new TermsVO();
		if(rs.next()) {
			vo.setTerms(rs.getString(1));
			vo.setPrivacy(rs.getString(2));
		}
		
		//6단계
		rs.close();
		stmt.close();
		conn.close();
		
		return vo;
	}
	
	
	
	
}
