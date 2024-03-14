package com.marcelo.crud.dao;

import com.marcelo.crud.model.Article;
import com.marcelo.crud.model.Client;
import com.marcelo.crud.model.OrderClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface OrderDao extends JpaRepository<OrderClient, Long> {
    Optional<OrderClient> findByClientIdAndArticleId(Client client, Article article);
    List<OrderClient> findByClient(Client client);

}
