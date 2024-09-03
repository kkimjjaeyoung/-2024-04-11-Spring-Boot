package com.sist.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.sist.vo.MusicVO;

public interface MusicMapper {
	/*
	 * @Select("SELECT mno, title, singer,album, idcrement, state" +
	 * "FROM genie_music ORDER BY mno ASC") public List<MusicVO> musicListData();
	 * 
	 * @Select("SELECT mno, title, singer, album, idcrement,state" +
	 * "FROM genie_music" + "WHERE title=#{title") public List<MusicVO>
	 * musicTitleFindData(String singer);
	 * 
	 * @Select("SELECT mno, title, singer, album, idcrement, state" +
	 * "FROM genie_music" + "WHERE album=#{alnum}") public List<MusicVO>
	 * musicAlbumFindData(String album);
	 */

	public List<MusicVO> musicTitleFindData(String title{
		return 
	})
}
