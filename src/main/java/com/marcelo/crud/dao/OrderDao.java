package com.marcelo.crud.dao;

import com.marcelo.crud.model.Client;
import com.marcelo.crud.model.OrderClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends JpaRepository<OrderClient, Long> {

}
