package com.yh.service;



import java.util.List;


import com.yh.domain.Article;
import com.yh.domain.ArticleWithBLOBs;
import com.yh.domain.Vo;

public interface ArticleService {

	ArticleWithBLOBs selectByPrimaryKey(Integer id);
	

	List<Article> list(Vo vo);

}
