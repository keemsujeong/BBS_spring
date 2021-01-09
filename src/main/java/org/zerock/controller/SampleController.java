package org.zerock.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;


@Controller
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	//모든방식을 다허용
	@RequestMapping("")
	public void basic() {
		log.info("basic .....................");
		
	}
	
	//get방식만 허용
	@RequestMapping(value = "/basicOnlyGet",
			method = RequestMethod.GET)
	
	//@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basicOnlyGet .....................");
		//jsp파일은 /WEB-INF/views/ + sample + /basicOnlyGet.jsp
	}
	//다른 jsp를 선언해서 사용할 때 리턴타입을 string으로
	@GetMapping("/stringGet")
	public String stringGet() {
		log.info("stringGet...........");
		//WEB-INF/view/ + string + .jsp 를 찾음
		return "test/string"; 
	}
	
	@GetMapping("/modelAndView")
	public ModelAndView modelAndView() {
		ModelAndView mav = new ModelAndView();
		//찾아야할 jsp 정보 셋팅
		mav.setViewName("modelAndView");
		//jsp에서 사용할 데이터 셋팅->request에 담김
		mav.addObject("name","수정");
		return mav;
	}
	
	@GetMapping("/getObject")
	public @ResponseBody DataVO getObject() {
		DataVO vo = new DataVO();
		vo.setName("sujeong");
		vo.setAge(26);
		return vo;
	}
	
	
	//------------넘어 오는 파라미터 데이터 수집--------
	//요구하는 데이터가 String인 경우 데이터가 넘어오지않더라도 문제가 생기지 않음
	//localhost:8080/sample/name?name=sujeong
	@GetMapping("/name")
	public void getName(String name) {
		log.info(name);
	}
	@GetMapping("/age")
	public void getAge(int age) {
		log.info(age);
	}
	
//	http://localhost:8080/sample/list?page=10
	//요구하는 데이터가 int인 경우 데이터가 넘어오지 않으면 문제가 생기므로 기본값 셋팅
	@GetMapping("/list")
	public void getList(@RequestParam(defaultValue = "1", name ="p")  int page) {
		log.info(page);
	}
	
	//똑같은 파라미터로 여러개의 데이터 받기
	@GetMapping("/nos")
	public void getNos(int nos[]) {
		log.info(Arrays.toString(nos));
	}
	//형식이다른 여러개의 데이터들은 클래스로
	//http://localhost:8080/sample/data?name=sujeong&age=26
	@GetMapping("/data")
	public void getData(DataVO vo) {
		log.info(vo);
	}
	
	//파일업로드 처리 메서드
	//파일을 올릴 수 있는 입력 창으로 이동하는 메서드
	@GetMapping("/uploadForm")
	public String uploadForm() {
		return "uploadForm";
	}
	
	//전송되는 파일을 처리하는 메소드- 파일 여러개를 첨부할 수 있는 처리
	@PostMapping("/upload")
	public String upload(ArrayList<MultipartFile> files,
			Model model ) {
		
		//저장할 위치
		String path ="c:\\upload\\";
		//중복을 피하기위한 숫자->파일명 앞에 붙이는 것으로 함
		//int cnt = 0 ;
		
		ArrayList<FileInfo> list = new ArrayList<FileInfo>();
	
		//여러개의 파일을 files라는 이름으로받는다 
		//임시로 메모리에 올렸다가 저장하라는 명령이 없어서 사라지기 때문에 저장처리를 해야함
		files.forEach(file -> {
			log.info("--------------------");
			String fileName = file.getOriginalFilename();
			long size = file.getSize();
			
			FileInfo fi = new FileInfo();
			
			fi.setFileName(fileName);
			fi.setSize(size);
			list.add(fi);
			
			log.info("파일명:" + fileName);
			log.info("파일 사이즈: " +size) ;	
			
			//파일저장처리
			try {
				file.transferTo(new File(path, fileName));
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		//첨부된 파일의 정보를 jsp로 보내기 위해서 model에 담음
		model.addAttribute("list", list);
		return "upload";
	}
}
