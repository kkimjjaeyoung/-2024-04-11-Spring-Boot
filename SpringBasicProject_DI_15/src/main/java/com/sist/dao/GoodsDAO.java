package com.sist.dao;
import java.util.*;
import org.springframework.stereotype.Repository;

import com.sist.mapper.*;
import com.sist.vo.*;

@Repository("dao")

public class GoodsDAO {
	private goodsMapper mapper;		//스프링에서 구현한 클래스 주소를 받아온다
	
public List<GoodsVO> goodsListData(Map map){
	return mapper.goodsListData(map);
}

public List<GoodsVO> goodsTotalPage(Map map){
	return mapper.goodsTotalPage(map);
}

public List<GoodsVO> goodsDetailData(Map map){
	return mapper.goodsDetailData(map);s
}


}
