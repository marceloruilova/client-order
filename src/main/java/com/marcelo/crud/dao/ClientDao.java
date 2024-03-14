package com.marcelo.crud.dao;

import com.marcelo.crud.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientDao extends CrudRepository<Client, Long> {

}
