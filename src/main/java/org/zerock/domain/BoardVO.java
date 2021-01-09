package org.zerock.domain;

import java.util.Date;

import lombok.Data;

//자동으로 getter/setter, 생성자, toString()가 생성됨
@Data
public class BoardVO {
	
	private int no;
	private String title, content, writer ;
	private Date writeDate;
	private int hit;
	private String pw;
	
}
