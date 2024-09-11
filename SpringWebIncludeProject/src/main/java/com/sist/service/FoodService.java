package com.sist.service;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.dao.*;
import com.sist.vo.*;


public interface FoodService {
	public List<FoodVO> foodListData(Map map);
	public int foodRowCount();
	public void foodHitIncrement(int no);
	public FoodVO foodDetailData(int no);
}
