/*
 * @Controller(출력 화면 지정), @RestController(자바스크립트 전송, Ajax,Vue,React토딩)		//화면관련
 * 	- 사용형식(스프링에서 관리)
 * 		메소드 관리, 
 * 		메소드 관련
 * 			리턴형 : String(forward:데이터전송, redirect:이전 등록화면으로 이동), void(다운로드)
 * 		매개변수 :
 * 			DispatcherServlet : 매개변수 설정 
 * 			getParameter()-vo단위로 값을 받음-모든 데이터(String)
 * 				- 1. 값이 없는 경우 :String(default)
 * 				- 2. String[] : checkbox를 이용해 값을 받는 경우
 * 				- 3. 내장객체 : HttpServletRequest(사용자 IP,PORT노출. 사용금지 권장. Cookie값 읽기시 사용), HttpServletResponse(Cookie저장시, 다운로드에 사용. 사용금지 권장), HttpSession(로그인, 세션 필요위치에 사용), RedirectAttributes(redirect로 값 전송), Model(request대체하는 전송객체)
 *		메소드명 : 자율성 높음(URL주소만 매칭)
 * @Repository(table한개만 연결. 재사용 가능.), @Service(DAO가 여러개인 경우.)		//데이터베이스 연동
 * @ControllerAdvice(통합 예외처리)	//오류 처리
 * 
 * 스프링에서 주로 사용되는 패키지
	 * vo(사용자 정의 데이터형), 
	 * dao(데이터베이스 연동), 
	 * service(DAo여러개를 묶어서 사용),
	 * manager(API등 외부데이터 읽기), 
	 * web(Model. 조립후 결과값 전송), 
	 * intercept(중간에 처리가능한 사용자 요청), 
	 * aop(공통으로 사용), 
	 * commons(예외처리를 한번에 처리), 
	 * security(접근거부, 권한부터), 
	 * chat(webchat, 실시간 채팅)
 * 
 * DiapatherServlet
 * 	1. WebServlet은 스프링에 없다 : web.xml에 등록(서블릿과 jsp는 통캣에 의해 구동)
 */
package com.sist.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sist.dao.DataBoardDAO;
import com.sist.vo.DataBoardVO;

@Controller
@RequestMapping("databoard/") // 공통으로 사용되는 URL주소를 모아서 => 적용
public class DataBoardController {
	   @Autowired
	   private BCryptPasswordEncoder encoder;
	   @Autowired
	   private DataBoardDAO dao;
	   
	   // 사용자 요청에 대한 처리 
	   @GetMapping("list.do")
	   public String databoard_list(String page,Model model)
	   {
		   //String en=encoder.encode("1234");
		   //System.out.println(en);
		   
		   if(page==null)
			   page="1";
		   int curpage=Integer.parseInt(page);
		   int rowSize=10;
		   int start=(rowSize*curpage)-(rowSize-1);
		   int end=rowSize*curpage;
		   List<DataBoardVO> list=dao.databoardListData(start, end);
		   // 총페이지 
		   int count=dao.databoardRowCount();
		   int totalpage=(int)(Math.ceil(count/(double)rowSize));
		   count=count-((rowSize*curpage)-rowSize);
		   // 사용자로부터 받는 값 => Model : 결과값 전송 객체 
		   // 출력에 필요한 데이터를 list.jsp로 전송 
		   model.addAttribute("curpage", curpage);
		   model.addAttribute("totalpage", totalpage);
		   model.addAttribute("count", count);
		   model.addAttribute("list", list);
		   
		   return "databoard/list";
	   }
	   // 데이터 추가 
	   @GetMapping("insert.do")
	   public String databoard_insert()
	   {
		   return "databoard/insert";
	   }
	   // 실제 데이터 첨부 
	   @PostMapping("insert_ok.do")
	   public String databoard_insert_ok(DataBoardVO vo)
	   {
		   String en=encoder.encode(vo.getPwd());// 암호화 
		   vo.setPwd(en);
		   String path="c:\\spring_upload";
		   List<MultipartFile> list=vo.getFiles();
		   if(list==null)
		   {
			   vo.setFilename("");
			   vo.setFilesize("");
			   vo.setFilecount(0);
		   }
		   else // 업로드가 있는 경우
		   {
			  try
			  {
				   String filename="";
				   String filesize="";
				   for(MultipartFile mf:list)
				   {
					   String name=mf.getOriginalFilename(); // 사용자가 보내준 파일명
					   File file=new File(path+"\\"+name);
					   mf.transferTo(file);// 파일 업로드 
					   filename+=file.getName()+",";
					   filesize+=file.length()+",";
				   }
				   filename=filename.substring(0,filename.lastIndexOf(","));
				   filesize=filesize.substring(0,filesize.lastIndexOf(","));
				   
		s		   vo.setFilename(filename);
				   vo.setFilesize(filesize);
				   vo.setFilecount(list.size());
			  }catch(Exception ex){}
		   }
		   dao.databoardInsert(vo);
		   return "redirect:list.do";
	   }
	   // 상세보기 
	   @GetMapping("detail.do")
	   public String databoard_detail(int no,Model model){
		   DataBoardVO vo=dao.databoardDetailData(no);
		   if(vo.getFilecount()!=null) {
		   List<String> nList=new ArrayList<String>();
		   List<String> cList=new ArrayList<String>();
		   String[] names=vo.getFilename().split(",");
		   String[] lens=vo.getFilesize().split(",");
		   nList=Arrays.asList(names);
		   cList=Arrays.asList(lens);
		   // 배열 => List로 변경 
		   model.addAttribute("vo", vo);
		   model.addAttribute("nList", nList);
		   model.addAttribute("cList", cList); // a.jpg(1000byte)
		   }
		   return "databoard/detail";
	   }
	   // 다운로드 
	   @GetMapping("download.do")
	   public void databaord_download(String fn, HttpServletResponse response) {
		   try {
			   String path="c:\\spting_upload";	//서버에서 파일을 읽어서 한개의 매모리에 저장
			   BufferedInputStream bis=new BufferedInputStream(new FileInputStream(path+"\\"+fn));
			   //다운로드 요청한 클라이언트
			   BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
			   
			   //다운로드창  표시
			   response.setHeader("content-Disposition", "attachment;filename"=URLEncoder.encode(fn,"UTF-8");
			   File file=new File(path+"\\"+fn);
			   response.setContentLength((int)file.length());	//프로그래스바
			   
			   //실제 다운로드
			   byte[] buffer=new byte[1024];
			   int i=0;	//파일에서 읽은 바이트 크기
			   while((i=bis.read(buffer,0,1024)!=-1)) {
				   bos.write(buffer,0,i);
			   }
		   } catch (Exception ex) {	}
   }
	   
	public DataBoardVO databoardFileInfoData(int no) {
		return mapper.databoardFileInfoData(no);
	}
	
	public boolean databoardDelete(int no) {
		boolean bCheck=false;
		String db_pwd=mapper.databaordGetPassword(no);
		//복호화
		
		return bCheck;
	}
}




