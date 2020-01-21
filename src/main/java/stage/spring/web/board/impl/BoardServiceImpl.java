package stage.spring.web.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stage.spring.web.board.BoardService;
import stage.spring.web.board.BoardVO;
import stage.spring.web.common.LogAdvice;

@Service
public class BoardServiceImpl implements BoardService
{
	@Autowired
	private BoardDAO boardDAO;
	private LogAdvice logAdvice;
	
	public BoardServiceImpl() {
		logAdvice = new LogAdvice();
	}

	@Override
	public void insertBoard(BoardVO boardVO) {
		logAdvice.printLog();
		boardDAO.insertBoard(boardVO);
	}

	@Override
	public void updateBoard(BoardVO boardVO) {
		logAdvice.printLog();
		boardDAO.updateBoard(boardVO);
	}

	@Override
	public void deleteBoard(BoardVO boardVO) {
		logAdvice.printLog();
		boardDAO.deleteBoard(boardVO);
	}

	@Override
	public BoardVO getBoard(BoardVO boardVO) {
		logAdvice.printLog();
		return boardDAO.getBoard(boardVO);
	}

	@Override
	public List<BoardVO> getBoardList(BoardVO boardVO) {
		logAdvice.printLog();
		return boardDAO.getBoardList(boardVO);
	}

}
