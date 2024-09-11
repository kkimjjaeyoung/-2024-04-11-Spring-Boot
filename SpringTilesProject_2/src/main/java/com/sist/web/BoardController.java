package com.sist.web;

import java.util.*;
import com.sist.vo.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sist.dao.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
   @Autowired
   private BoardDAO bDao;
   
   @GetMapping("board/list.do")
   public String board_list()
   {
	   return "board/list";
   }
}