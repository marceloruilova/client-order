package com.marcelo.crud.service;

import com.marcelo.crud.common.GenericServiceImpl;
import com.marcelo.crud.dao.ArticleDao;
import com.marcelo.crud.dao.ClientDao;
import com.marcelo.crud.dao.OrderDao;
import com.marcelo.crud.model.Article;
import com.marcelo.crud.model.Client;
import com.marcelo.crud.model.OrderClient;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends GenericServiceImpl<OrderClient, Long> implements OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private ClientDao clientDao;
	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public CrudRepository<OrderClient, Long> getDao() {
		return orderDao;
	}

	public OrderClient processOrder(Long clientId, Long articleId) {
		Article article = articleDao.findById(articleId)
				.orElseThrow(() -> new EntityNotFoundException("Article not found"));
		Client client = clientDao.findById(clientId)
				.orElseThrow(() -> new EntityNotFoundException("Client not found"));
		if (article.getQuantity() <= 0) {
			throw new IllegalArgumentException("Article empty wait for stock.");
		}
		OrderClient order = orderDao.findByClientIdAndArticleId(client, article).orElse(createOrder(client, article));

		updateArticleStock(article, order.getArticle().getQuantity());
		return order;
	}

	private OrderClient updateOrder(OrderClient order) {
		return orderDao.save(order);
	}

	private OrderClient createOrder(Client client, Article article) {
		OrderClient newOrder = new OrderClient();
		newOrder.setClient(client);
		newOrder.setArticle(article);
		return orderDao.save(newOrder);
	}

	private void updateArticleStock(Article article, int quantity) {
		int newStock = Math.max(0, article.getQuantity() - quantity);
		article.setQuantity(newStock);
		articleDao.save(article);
	}
}
