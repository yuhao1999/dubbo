package com.yh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.dao.ArticleMapper;
import com.yh.domain.Article;
import com.yh.domain.ArticleWithBLOBs;
import com.yh.domain.Vo;
import com.yh.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public ArticleWithBLOBs selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return articleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Article> list(Vo vo) {
		// TODO Auto-generated method stub
		return articleMapper.list(vo);
	}
}
