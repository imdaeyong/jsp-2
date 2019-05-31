package kr.co.board1.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.catalina.LifecycleListener;

import kr.co.board1.bean.BoardBean;
import kr.co.board1.config.DBConfig;
import kr.co.board1.config.SQL;

public class BoardService {

	// �̱��� ��ü
	private static BoardService service = new BoardService();
	
	private BoardService() {}
	public static BoardService getIntance(){
		return service;
	}
	
	// ��Ͽ� ī��Ʈ ��ȣ ���ϱ�
	public int getListStartCount(int total, int start) {
		return total-start;
	}
	
	// ���� ������ 
	public int getCurrentPage(String pg) {
		
		int current = 0;
		
		if(pg == null) {
			current = 1;
		}else {
			current = Integer.parseInt(pg);
		}
		
		return current;
	}
	
	// Limit�� Start�� ���ϱ�
	public int getStartForLimit(String pg) {
		
		int start = 0;
		
		// null üũ
		if(pg == null) {
			start = 1;
		}else {
			start = Integer.parseInt(pg);	
		}
				
		return (start - 1) * 10;
	}
	
	// �������׷� ����ϱ�
	public int[] getPageGroupStartEnd(String pg, int totalPage) {
		int[] groupStartEnd = new int[2];
		
		int current = getCurrentPage(pg);
		int currentGroup = (int) Math.ceil(current/10.0);
		int groupStart = (currentGroup - 1) * 10 + 1;
		int groupEnd   = currentGroup * 10;
		
		if(groupEnd > totalPage){
			groupEnd = totalPage;
		}
		
		groupStartEnd[0] = groupStart;
		groupStartEnd[1] = groupEnd;
		
		return groupStartEnd;
	}
	
	// ��ü ������ �� ���ϱ�
	public int getTotalPage(int boardTotal) {
		
		int pageTotal = 0;
		
		if(boardTotal % 10 == 0){
			pageTotal = boardTotal / 10;	
		}else{
			pageTotal = boardTotal / 10 + 1;
		}
		
		return pageTotal;		
	}
	
	// ��ü �Խù� ���ϱ�
	public int getTotalBoard() throws Exception {
		// 1�ܰ�, 2�ܰ�
		Connection conn = DBConfig.getConnection();

		// 3�ܰ� 
		Statement stmt = conn.createStatement();
		
		// 4�ܰ�
		ResultSet rs = stmt.executeQuery(SQL.SELECT_COUNT_TOTAL);
		
		// 5�ܰ�
		int total = 0;
		
		if(rs.next()) {
			total = rs.getInt(1);
		}
		
		// 6�ܰ�
		rs.close();
		stmt.close();
		conn.close();
		
		return total;
	}
	
	// �Խù� ��� ���ϱ�
	public List<BoardBean> getBoardList(int start) throws Exception {
		
		//1�ܰ�, 2�ܰ�
 		Connection conn = DBConfig.getConnection();
		
		//3�ܰ�
		PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_LIST);
		psmt.setInt(1, start);
		
		//4�ܰ�
		ResultSet rs = psmt.executeQuery();
		
		//5�ܰ�
		List<BoardBean> list = new ArrayList<>(); 
		
		while(rs.next()){
			BoardBean bb = new BoardBean();
			bb.setSeq(rs.getInt(1));
			bb.setParent(rs.getInt(2));
			bb.setComment(rs.getInt(3));
			bb.setCate(rs.getString(4));
			bb.setTitle(rs.getString(5));
			bb.setContent(rs.getString(6));
			bb.setFile(rs.getInt(7));
			bb.setHit(rs.getInt(8));
			bb.setUid(rs.getString(9));
			bb.setRegip(rs.getString(10));
			bb.setRdate(rs.getString(11));
			bb.setNick(rs.getString(12));
			
			list.add(bb);
		}
		
		//6�ܰ�
		rs.close();
		psmt.close();
		conn.close();
		
		return list;
	}
	
	// �Խù� �߰��ϱ�
	public void insertBoard() {}
	
	// ��ȸ�� ��������
	public void updateHit(String seq) throws Exception {
		//1�ܰ�, 2�ܰ�
		Connection conn = DBConfig.getConnection();
		
		//3�ܰ�
		PreparedStatement psmt = conn.prepareStatement(SQL.UPDATE_HIT);
		psmt.setString(1, seq);	
		
		//4�ܰ�
		psmt.executeUpdate();
		
		//5�ܰ�		
		//6�ܰ�
		psmt.close();
		conn.close();		
	}
	
	// �ۺ��� SELECT
	public BoardBean viewBoard(String seq) throws Exception {
		//1�ܰ�, 2�ܰ�
		Connection conn = DBConfig.getConnection();
		
		//3�ܰ�
		PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_VIEW);
		psmt.setString(1, seq);
		
		//4�ܰ�
		ResultSet rs = psmt.executeQuery();
		
		//5�ܰ�
		BoardBean bb = new BoardBean();
		
		if(rs.next()){		
			bb.setSeq(rs.getInt(1));
			bb.setParent(rs.getInt(2));
			bb.setComment(rs.getInt(3));
			bb.setCate(rs.getString(4));
			bb.setTitle(rs.getString(5));
			bb.setContent(rs.getString(6));
			bb.setFile(rs.getInt(7));
			bb.setHit(rs.getInt(8));
			bb.setUid(rs.getString(9));
			bb.setRegip(rs.getString(10));
			bb.setRdate(rs.getString(11));
			bb.setOldName(rs.getString(13));
			bb.setNewName(rs.getString(14));
			bb.setDownload(rs.getInt(15));
		}
		
		//6�ܰ�
		rs.close();
		psmt.close();
		conn.close();
		
		return bb;
	}
	
	// ��� ����Ʈ
	public List<BoardBean> commentList(String parent) throws Exception {
		//1�ܰ�, 2�ܰ�
		Connection conn = DBConfig.getConnection();
		//3�ܰ�
		PreparedStatement psmt = conn.prepareStatement(SQL.SELECT_COMMENT_LIST);
		psmt.setString(1, parent);
				
		//4�ܰ�
		ResultSet rs = psmt.executeQuery();
		
		//5�ܰ�
		List<BoardBean> list = new ArrayList<>();
		
		while(rs.next()) {
			BoardBean bb = new BoardBean();
			bb.setSeq(rs.getInt(1));
			bb.setParent(rs.getInt(2));
			bb.setComment(rs.getInt(3));
			bb.setCate(rs.getString(4));
			bb.setTitle(rs.getString(5));
			bb.setContent(rs.getString(6));
			bb.setFile(rs.getInt(7));
			bb.setHit(rs.getInt(8));
			bb.setUid(rs.getString(9));
			bb.setRegip(rs.getString(10));
			bb.setRdate(rs.getString(11));
			bb.setNick(rs.getString(12));
			
			list.add(bb);			
		}
		
		//6�ܰ�
		rs.close();
		psmt.close();
		conn.close();
		
		return list;
	}
	
	
}














