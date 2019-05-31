package kr.co.board2.config;

public class SQL {

	// 회원관련
	public static final String SELECT_TERMS = "SELECT * FROM `JSP_TERMS`;";
	public static final String SELECT_USER = "SELECT * FROM `JSP_USER` WHERE uid=? AND pass=PASSWORD(?);";
	public static final String INSERT_USER = "INSERT INTO `JSP_USER` SET "
												+"uid=?,"
												+"pass=PASSWORD(?),"
												+"name=?,"
												+"nick=?,"
												+"email=?,"
												+"hp=?,"
												+"zip=?,"
												+"addr1=?,"
												+"addr2=?,"
												+"regip=?,"
												+"rdate=NOW();";
	
	public static final String SELECT_USER_COUNT = "SELECT COUNT(*) FROM `JSP_USER` WHERE uid=?;";
	public static final String SELECT_NICK_COUNT = "SELECT COUNT(*) FROM `JSP_USER` WHERE nick=?;";	
	public static final String SELECT_EMAIL_COUNT = "SELECT COUNT(*) FROM `JSP_USER` WHERE email=?;";	
	public static final String SELECT_HP_COUNT = "SELECT COUNT(*) FROM `JSP_USER` WHERE hp=?;";	
	
	
	
	// 게시판관련
	public static final String INSERT_BOARD = "INSERT INTO `JSP_BOARD` SET "
											+ "title=?,"
											+ "content=?,"
											+ "file=?,"
											+ "uid=?,"
											+ "regip=?,"
											+ "rdate=NOW()";
	
	public static final String SELECT_MAX_SEQ = "SELECT MAX(seq) FROM `JSP_BOARD`";
	public static final String INSERT_FILE = "INSERT INTO `JSP_FILE` (`parent`, `oldName`, `newName`, `rdate`) VALUES (?, ?, ?, NOW())";
	
	public static final String SELECT_LIST = "SELECT a.*, b.nick FROM `JSP_BOARD` AS a "
										   + "JOIN `JSP_USER` AS b ON a.uid = b.uid "
										   + "WHERE parent=0 "
										   + "ORDER BY seq DESC "
										   + "LIMIT ?, 10";
	
	public static final String SELECT_COUNT_TOTAL = "SELECT COUNT(*) FROM `JSP_BOARD`";
	public static final String SELECT_VIEW = "SELECT * FROM `JSP_BOARD` AS a "
											+ "LEFT JOIN `JSP_FILE` AS b "
											+ "ON a.seq = b.parent "
											+ "WHERE seq=?";
	
	
	public static final String UPDATE_HIT = "UPDATE `JSP_BOARD` SET hit=hit+1 WHERE seq=?";
	public static final String DELETE_BOARD = "DELETE FROM `JSP_BOARD` WHERE seq=?";
	
	
	public static final String INSERT_COMMENT = "INSERT INTO `JSP_BOARD` SET "
												+ "parent=?, "
												+ "content=?, "
												+ "uid=?, "
												+ "regip=?, "
												+ "rdate=NOW()";
	
	public static final String SELECT_COMMENT_LIST = "SELECT a.*, b.nick FROM JSP_BOARD AS a " 
													+ "JOIN JSP_USER AS b ON a.uid = b.uid " 
													+ "WHERE parent=? ORDER BY seq ASC";    
	
}










