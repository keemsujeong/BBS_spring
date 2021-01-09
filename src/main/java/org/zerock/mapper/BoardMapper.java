package org.zerock.mapper;

import java.util.List;

import org.zerock.domain.BoardVO;


public interface BoardMapper {
	//1.list -전체 데이터 구하기(페이지처리)

	 public List<BoardVO> list(); 
	 public Integer getRow();
	//2.view -조회수 1증가
	public BoardVO view(int no);
	public void increase(int no);
	//3.write
	public void write(BoardVO vo);
	//4.update
	public void update(BoardVO vo);
	//5.delete
	public void delete(BoardVO vo);
	
//	public int getTotalCount(Criteria cri);
	
}
