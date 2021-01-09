package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardMapper mapper;  

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		log.info("---게시판 리스트 service ---");
		return mapper.list(); //호출하려면 클래스가 필요한데 인터페이스밖에 없기 때문에 mybatis가 만들어준다
	}

	@Override
	public BoardVO view(int no, int inc) {
		//inc가 1일 때만 조회수 증가 ->데이터 가져오기
		if(inc == 1) mapper.increase(no);		
		return mapper.view(no);
	}

	@Override
	public void write(BoardVO vo) {
		mapper.write(vo); //mapper와 연결하여 vo를 보내줌
	}

	@Override
	public void update(BoardVO vo) {
		mapper.update(vo);
		
	}

	@Override
	public void delete(BoardVO vo) {
		mapper.delete(vo);
		
	}


}
