package com.yh.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yh.domain.Article;
import com.yh.domain.ArticleWithBLOBs;
import com.yh.domain.Vo;
import com.yh.service.ArticleService;

/**
 * @于浩
 */
@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("list")
	public String list(Model m,@RequestParam(defaultValue = "1")Integer pageNum,Vo vo) {
		PageHelper.startPage(pageNum, 3);
		List<Article> list = articleService.list(vo);
		PageInfo<Article> info=new PageInfo<Article>(list);
		m.addAttribute("vo", vo);
		m.addAttribute("info", info);
		return "list";
		
	}
	
	@GetMapping("article")
	public String article(Integer id,Model m,HttpServletRequest rep) {
		ArticleWithBLOBs article=articleService.selectByPrimaryKey(id);
		m.addAttribute("article", article);
		return "article";
	}
}
