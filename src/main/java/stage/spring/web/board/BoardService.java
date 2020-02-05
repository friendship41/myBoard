package stage.spring.web.board;

import java.util.List;

public interface BoardService {
	void insertBoard(BoardVO boardVO);
	void updateBoard(BoardVO boardVO);
	void deleteBoard(BoardVO boardVO);
	BoardVO getBoard(BoardVO boardVO);
	List<BoardVO> getBoardList(BoardVO boardVO);
//	List<BoardVO> searchBoardList(String condition, String keyword, BoardVO vo);
}
