package com.marcelo.crud.dao;

import com.marcelo.crud.model.Article;
import com.marcelo.crud.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ArticleDao extends JpaRepository<Article, Long> {

}
