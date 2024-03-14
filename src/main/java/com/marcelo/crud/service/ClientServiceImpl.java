package com.marcelo.crud.service;

import com.marcelo.crud.common.GenericServiceImpl;
import com.marcelo.crud.dao.ClientDao;
import com.marcelo.crud.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl extends GenericServiceImpl<Client, Long> implements ClientService {

	@Autowired
	private ClientDao clientDao;
	
	@Override
	public CrudRepository<Client, Long> getDao() {
		return clientDao;
	}

}
