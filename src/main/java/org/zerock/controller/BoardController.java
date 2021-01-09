package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;


@Controller
@RequestMapping("/board")
public class BoardController {

		private final String MODULE = "board";
		
		@Autowired
		private BoardService service; 
		
		//1.리스트 -get
		@GetMapping("/list.do")
		//pageObject에서 데이터가 넘어오지 않으면 기본페이지 1, 페이지당 데이터의갯수는 10으로 한다
		public String list(Model model) {
			//model에 데이터를 담으면 request에 데이터가 담기게 된다
			//jsp에서 꺼내쓸때는 ${list}
			model.addAttribute("list", service.list());
			return MODULE + "/list";
		}
		
		//2.보기 -get
		@GetMapping("/view.do")
		public String view(Model model, int no, int inc) {
			model.addAttribute("vo", service.view(no, inc));
			return MODULE + "/view";
		}
		//3-1.글쓰기 폼 -get
		@GetMapping("/write.do")
		public String writeForm() {
			return MODULE + "/write";
		}
		
		//3-2.글쓰기 처리 -post
		@PostMapping("/write.do")
		public String write(BoardVO vo) {
			service.write(vo);
			return "redirect:list.do";
		}
		//4-1.글 수정 폼 - get
		@GetMapping("/update.do")
		public String updateForm(Model model, int no) {
			//데이터를 가져오기 위해 view()호출  inc = 0
			model.addAttribute("vo", service.view(no, 0));
			return MODULE + "/update";
		}
		//4-2.글 수정 처리 -post
		@PostMapping("/update.do")
		public String update(BoardVO vo) {
			service.update(vo);
			return "redirect:view.do?no=" + vo.getNo() + "&inc=0";
		}
		//5.삭제 - post
		@PostMapping("/delete.do")
		public String delete(BoardVO vo) {
			service.delete(vo);
			return "redirect:list.do";
		}
}
