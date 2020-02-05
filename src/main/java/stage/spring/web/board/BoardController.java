package stage.spring.web.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import stage.spring.web.board.impl.BoardDAO;

@Controller
public class BoardController 
{
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/dataTransformJson.do")
	@ResponseBody
	public List<BoardVO> dataTransformJson(BoardVO vo)
	{
		List<BoardVO> boardList = boardService.getBoardList(vo);
		return boardList;
	}
	
	@RequestMapping("/dataTransformXml.do")
	@ResponseBody
	public BoardListVO dataTransformXml(BoardVO vo)
	{
		BoardListVO boardListVO = new BoardListVO();
		boardListVO.setBoardList(boardService.getBoardList(vo));
		return boardListVO;
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) 
	{
		List<BoardVO> boardList;
		
		System.out.println(vo.getSearchCondition());
		System.out.println(vo.getSearchKeyword());
		
		if(vo.getSearchKeyword() == null || vo.getSearchKeyword().equals(""))
		{
			vo.setSearchCondition("TITLE");
			vo.setSearchKeyword("");
		}
		boardList = boardService.getBoardList(vo);
		
		model.addAttribute("boardList", boardList);
		return "getBoardList.jsp";
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap()
	{
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) 
	{
		BoardVO board = boardService.getBoard(vo);
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}
	
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException
	{
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty())
		{
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("x:/"+fileName));
		}
		
		
		boardService.insertBoard(vo);
		return "getBoardList.do";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) 
	{
		boardService.updateBoard(vo);
		return "redirect:getBoard.do?seq="+vo.getSeq();
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) 
	{
		boardService.deleteBoard(vo);
		return "getBoardList.do";
	}
	
	
}
