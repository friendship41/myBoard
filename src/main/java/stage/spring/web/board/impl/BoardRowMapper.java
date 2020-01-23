package stage.spring.web.board.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import stage.spring.web.board.BoardVO;

public class BoardRowMapper implements RowMapper<BoardVO>
{
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		BoardVO board = new BoardVO();
		
		board.setSeq(rs.getInt("SEQ"));
		board.setTitle(rs.getString("TITLE"));
		board.setWriter(rs.getString("WRITER"));
		board.setContent(rs.getString("CONTENT"));
		board.setRegDate(rs.getDate("REGDATE"));
		board.setCnt(rs.getInt("CNT"));
		
		return board;
	}

}
