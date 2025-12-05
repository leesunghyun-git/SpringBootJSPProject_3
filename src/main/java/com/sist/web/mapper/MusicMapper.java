package com.sist.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/*
 * <select id="musicListData" resultType="com.sist.web.vo.MusicVO" parameterType="hashmap">
 		SELECT no,title,poster,singer,num
 		FROM (SELECT no,title,poster,singer,ROWNUM as num
 		FROM (SELECT no,title,poster,singer
 		FROM genie_music ORDER BY no ASC))
 		WHERE num BETWEEN #{start} AND #{end}
 	</select>
 	<select id="musicTotalPage" resultType="int">
		SELECT CEIL(COUNT(*)/12.0) FROM genie_music
 	</select>
 * 
 */
import java.util.*;
import com.sist.web.vo.*;
@Mapper
@Repository
public interface MusicMapper {
	public List<MusicVO> musicListData(Map map);
	public int musicTotalPage();
}
