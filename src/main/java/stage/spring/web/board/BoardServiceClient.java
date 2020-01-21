package stage.spring.web.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient 
{

	public static void main(String[] args) 
	{
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService boardService = container.getBean(BoardService.class);
		
		BoardVO vo = new BoardVO();
		vo.setTitle("제목입니다5");
		vo.setWriter("최창호");
		vo.setContent("내용입니다아아아아아아5");
		
		boardService.insertBoard(vo);
		
		List<BoardVO> list = boardService.getBoardList(null);
		for(BoardVO boardVO : list)
		{
			System.out.println("-----> " + boardVO);
		}
		
		container.close();
	}

}
