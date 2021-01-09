package org.zerock.service;

import java.util.List;

import org.zerock.domain.BoardVO;


public interface BoardService {

	//1.list
	public List<BoardVO> list();
	
	//2.view
	public BoardVO view(int no, int inc);
	
	//3.write
	public void write(BoardVO vo);
	
	//4.update
	public void update(BoardVO vo);
	
	//5.delete
	public void delete(BoardVO vo);
	
}
