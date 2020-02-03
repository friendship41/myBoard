package stage.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stage.spring.web.board.BoardService;
import stage.spring.web.board.BoardVO;

/*
@Service("boardService")
public class BoardServiceImpl implements BoardService
{
	@Autowired
	private BoardDAOSpring boardDAO;
	
	@Override
	public void insertBoard(BoardVO boardVO) {
//		throw new IllegalArgumentException("에러가 났습니다 삐약삐약 뺙뺙");
		boardDAO.insertBoard(boardVO);
//		boardDAO.insertBoard(boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		boardDAO.updateBoard(boardVO);
	}

	@Override
	public void deleteBoard(BoardVO boardVO) {
		boardDAO.deleteBoard(boardVO);
	}

	@Override
	public BoardVO getBoard(BoardVO boardVO) {
		return boardDAO.getBoard(boardVO);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO boardVO) {
		return boardDAO.getBoardList(boardVO);
	}

}
*/