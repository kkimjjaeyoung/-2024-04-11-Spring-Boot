package com.sist.vo;
import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class DataBoardVO {
	private int no, hit, filecount;
	private String name, subject, content, pwd, dbday, filename, filesize;
	private List<MultipartFile> files;
	//List전송을 받는 경우
	//<input type=file name="file[0]">
}
