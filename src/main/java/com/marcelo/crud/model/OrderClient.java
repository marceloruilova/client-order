package com.marcelo.crud.model;

import jakarta.persistence.*;

@Entity
public class OrderClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true)
	private String code;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name = "article_id")
	private Article article;


}
