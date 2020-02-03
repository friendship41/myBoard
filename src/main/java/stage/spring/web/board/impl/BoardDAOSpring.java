package stage.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import stage.spring.web.board.BoardVO;

@Repository
public class BoardDAOSpring {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String BOARD_INSERT = "insert into myboard(seq, title, writer, content) " + "values((select nvl(max(seq), 0)+1 from myboard), ?, ?, ?)";
//	private final String BOARD_INSERT = "insert into myboard(seq, title, writer, content) " + "values(1000, ?, ?, ?)";
	private final String BOARD_UPDATE = "update myboard set title=?, content=? where seq=?";
	private final String BOARD_DELETE = "delete myboard where seq=?";
	private final String BOARD_GET = "select * from myboard where seq=?";
	private final String BOARD_LIST = "select * from myboard order by seq desc";
	
	
	public void insertBoard(BoardVO boardVO)
	{
		System.out.println("Spring JDBC로 insertBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_INSERT, boardVO.getTitle(), boardVO.getWriter(), boardVO.getContent());
	}
	
	
	public void updateBoard(BoardVO boardVO)
	{
		System.out.println("Spring JDBC로 updateBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_UPDATE, boardVO.getTitle(), boardVO.getContent(), boardVO.getSeq());
	}
	
	
	public void deleteBoard(BoardVO boardVO)
	{
		System.out.println("Spring JDBC로 deleteBoard() 기능 처리");
		
		jdbcTemplate.update(BOARD_DELETE, boardVO.getSeq());
	}
	
	
	public BoardVO getBoard(BoardVO vo)
	{
		System.out.println("Spring JDBC로 getBoard() 기능 처리");
		
		Object[] args = {vo.getSeq()};
		return jdbcTemplate.queryForObject(BOARD_GET, args, new BoardRowMapper());
	}
	
	
	public List<BoardVO> getBoardList(BoardVO vo)
	{
		System.out.println("Spring JDBC로 getBoardList() 기능 처리");
		
		return jdbcTemplate.query(BOARD_LIST, new BoardRowMapper());
	}
}
