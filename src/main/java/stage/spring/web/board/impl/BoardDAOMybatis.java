package stage.spring.web.board.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import stage.spring.web.board.BoardVO;

@Repository
public class BoardDAOMybatis 
{
//	@Autowired
//	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
//		super.setSqlSessionFactory(sqlSessionFactory);
//	}
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void insertBoard(BoardVO boardVO)
	{
		System.out.println("Mybatis로 insertBoard 처리");
		sqlSessionTemplate.insert("BoardDAO.insertBoard", boardVO);
	}
	
	public void updateBoard(BoardVO boardVO)
	{
		System.out.println("Mybatis로 updateBoard 처리");
		sqlSessionTemplate.update("BoardDAO.updateBoard", boardVO);
	}
	
	public void deleteBoard(BoardVO boardVO)
	{
		System.out.println("Mybatis로 deleteBoard 처리");
		sqlSessionTemplate.delete("BoardDAO.deleteBoard", boardVO);
	}
	
	public BoardVO getBoard(BoardVO boardVO)
	{
		System.out.println("Mybatis로 getBoard 처리");
		return sqlSessionTemplate.selectOne("BoardDAO.getBoard", boardVO);
	}
	
	public List<BoardVO> getBoardList(BoardVO boardVO)
	{
		System.out.println("Mybatis로 getBoardList 처리");
		return sqlSessionTemplate.selectList("BoardDAO.getBoardList", boardVO);
	}
	
}
