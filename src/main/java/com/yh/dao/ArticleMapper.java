package com.yh.dao;

import java.util.List;
import com.yh.domain.Article;
import com.yh.domain.ArticleWithBLOBs;
import com.yh.domain.Vo;

public interface ArticleMapper {
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询文章
	 * @param article
	 * @return
	 * @return: List<Article>
	 */
	List<Article> selects(Article article);
	
	List<Article> all();

    ArticleWithBLOBs selectByPrimaryKey(Integer id);


	List<Article> list(Vo vo);
}