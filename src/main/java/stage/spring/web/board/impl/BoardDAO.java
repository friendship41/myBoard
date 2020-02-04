package stage.spring.web.board.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import stage.spring.web.board.BoardVO;
import stage.spring.web.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO 
{
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private final String BOARD_INSERT = "insert into myboard(seq, title, writer, content) " + "values((select nvl(max(seq), 0)+1 from myboard), ?, ?, ?)";
	private final String BOARD_UPDATE = "update myboard set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete myboard where seq=?";
	private final String BOARD_GET = "select * from myboard where seq=?";
	private final String BOARD_LIST = "select * from myboard order by seq desc";
	private final String BOARD_SEARCH_TITLE_LIST = "select * from myboard where title like ? order by seq desc";
	private final String BOARD_SEARCH_CONTENT_LIST = "select * from myboard where content like ? order by seq desc";
	
	public void insertBoard(BoardVO boardVO)
	{
		System.out.println("JDBC로 insertBoard() 기능 처리");
		
		try 
		{
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_INSERT);
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2,  boardVO.getWriter());
			pstmt.setString(3, boardVO.getContent());
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCUtil.disConnect(pstmt, con);
		}
	}
	
	
	public void updateBoard(BoardVO boardVO)
	{
		System.out.println("JDBC로 updateBoard() 기능 처리");
		
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_UPDATE);
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getContent());
			pstmt.setInt(3, boardVO.getSeq());
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCUtil.disConnect(pstmt, con);
		}
	}
	
	
	public void deleteBoard(BoardVO boardVO)
	{
		System.out.println("JDBC로 deleteBoard() 기능 처리");
		
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_DELETE);
			pstmt.setInt(1, boardVO.getSeq());
			pstmt.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCUtil.disConnect(pstmt, con);
		}
	}
	
	
	public BoardVO getBoard(BoardVO vo)
	{
		System.out.println("JDBC로 getBoard() 기능 처리");
		
		BoardVO boardVO = new BoardVO();
		
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_GET);
			pstmt.setInt(1, vo.getSeq());
			
			rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				boardVO.setSeq(rs.getInt("SEQ"));
				boardVO.setTitle(rs.getString("TITLE"));
				boardVO.setWriter(rs.getString("WRITER"));
				boardVO.setContent(rs.getString("CONTENT"));
				boardVO.setRegDate(rs.getDate("REGDATE"));
				boardVO.setCnt(rs.getInt("CNT"));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCUtil.disConnect(rs, pstmt, con);
		}
		return boardVO;
	}
	
	
	public List<BoardVO> getBoardList(BoardVO vo)
	{
		System.out.println("JDBC로 getBoardList() 기능 처리");
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		
		try {
			con = JDBCUtil.getConnection();
			pstmt = con.prepareStatement(BOARD_LIST);
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				BoardVO boardVO = new BoardVO();
				boardVO.setSeq(rs.getInt("SEQ"));
				boardVO.setTitle(rs.getString("TITLE"));
				boardVO.setWriter(rs.getString("WRITER"));
				boardVO.setContent(rs.getString("CONTENT"));
				boardVO.setRegDate(rs.getDate("REGDATE"));
				boardVO.setCnt(rs.getInt("CNT"));
				list.add(boardVO);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCUtil.disConnect(rs, pstmt, con);
		}
		return list;
	}
	
	public List<BoardVO> searchBoardList(String condition, String keyword, BoardVO vo)
	{
		System.out.println("JDBC로 searchBoardList() 기능 처리");
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		
		try {
			con = JDBCUtil.getConnection();
			if(condition.equals("TITLE"))
			{
				pstmt = con.prepareStatement(BOARD_SEARCH_TITLE_LIST);				
			}
			else if(condition.equals("CONTENT"))
			{
				pstmt = con.prepareStatement(BOARD_SEARCH_CONTENT_LIST);
			}
			else
			{
				return list;
			}
			pstmt.setString(1, "%"+keyword+"%");
			
			rs = pstmt.executeQuery();
			
			while(rs.next())
			{
				BoardVO boardVO = new BoardVO();
				boardVO.setSeq(rs.getInt("SEQ"));
				boardVO.setTitle(rs.getString("TITLE"));
				boardVO.setWriter(rs.getString("WRITER"));
				boardVO.setContent(rs.getString("CONTENT"));
				boardVO.setRegDate(rs.getDate("REGDATE"));
				boardVO.setCnt(rs.getInt("CNT"));
				list.add(boardVO);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			JDBCUtil.disConnect(rs, pstmt, con);
		}
		return list;
	}
	
	

}
