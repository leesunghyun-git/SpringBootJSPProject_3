package com.sist.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sist.web.service.MusicService;
import com.sist.web.vo.MusicVO;

@RestController
public class MusicRestController {
	@Autowired
	private MusicService service;
	
	@GetMapping("/list_vue")
	public Map music_list_vue(@RequestParam(name="page",required = false) int page)
	{
		Map map = new HashMap<>();
		int rowSize=12;
		int start=(page-1)*rowSize+1;
		int end = rowSize*page;
		
		map.put("start", start);
		map.put("end", end);
		
		List<MusicVO> list = service.musicListData(map);
		
		int totalPage= service.musicTotalPage();
		
		final int BLOCK =10;
		int startPage = ((page-1)/BLOCK*BLOCK)+1;
		int endPage = ((page-1)/BLOCK*BLOCK)+BLOCK;
		
		if(endPage>totalPage)
			endPage=totalPage;
		map=new HashMap();
		map.put("list", list);
		map.put("startPage", startPage);
		map.put("endPage", endPage);
		map.put("totalPage", totalPage);
		map.put("curPage", page);
		
		return map;
	}
}
