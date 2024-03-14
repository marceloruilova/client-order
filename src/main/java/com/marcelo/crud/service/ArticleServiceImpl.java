package com.marcelo.crud.service;

import com.marcelo.crud.common.GenericServiceImpl;
import com.marcelo.crud.dao.ArticleDao;
import com.marcelo.crud.dao.ClientDao;
import com.marcelo.crud.model.Article;
import com.marcelo.crud.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends GenericServiceImpl<Article, Long> implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public CrudRepository<Article, Long> getDao() {
		return articleDao;
	}

}
