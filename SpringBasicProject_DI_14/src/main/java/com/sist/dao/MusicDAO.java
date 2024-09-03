package com.sist.dao;

import java.util.*;

import org.springframework.stereotype.Repository;

import com.sist.vo.*;
import com.sist.mapper.*;

//메모리 할당
@Repository("dao")
public class MusicDAO {
	// spring안에 mybatis에서 자동구현(자동주소호출)
	private MusicMapper mapper;

	public List<MusicVO> musicListData() {

		return mapper.musicListData();
	}

}
