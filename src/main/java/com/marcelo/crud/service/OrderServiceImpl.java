package com.marcelo.crud.service;

import com.marcelo.crud.common.GenericServiceImpl;
import com.marcelo.crud.dao.ClientDao;
import com.marcelo.crud.dao.OrderDao;
import com.marcelo.crud.model.Client;
import com.marcelo.crud.model.OrderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends GenericServiceImpl<OrderClient, Long> implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public CrudRepository<OrderClient, Long> getDao() {
		return orderDao;
	}

}
