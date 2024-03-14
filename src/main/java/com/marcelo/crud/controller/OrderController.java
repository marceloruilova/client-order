package com.marcelo.crud.controller;

import com.marcelo.crud.model.Client;
import com.marcelo.crud.service.ClientService;
import io.micrometer.core.instrument.config.validate.ValidationException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/order")
@CrossOrigin("*")
public class OrderController {

	@Autowired
	private ClientService clientServiceAPI;

	@GetMapping(value = "/all")
	public ResponseEntity<List<Client>> getAll() {
		try {
			List<Client> persons = clientServiceAPI.getAll();
			if (persons.isEmpty()) {
				throw new EntityNotFoundException();
			}
			return ResponseEntity.ok(persons);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping(value = "/find/{id}")
	public ResponseEntity<Client> find(@PathVariable Long id) {
		try {
			if(clientServiceAPI.get(id)==null){
				throw new EntityNotFoundException();
			}
			Client person = clientServiceAPI.get(id);
			return ResponseEntity.ok(person);
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PostMapping(value = "/save")
	public ResponseEntity<Client> save(@RequestBody @Validated Client person) {
		try {
			Client obj = clientServiceAPI.save(person);
			return new ResponseEntity<>(obj, HttpStatus.OK);
		} catch (ValidationException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<Client> delete(@PathVariable Long id) {
		try {
			if (clientServiceAPI.get(id)==null) {
				throw new EntityNotFoundException();
			}
			clientServiceAPI.delete(id);
			return ResponseEntity.ok().build();
		} catch (EntityNotFoundException e) {
			return ResponseEntity.notFound().build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
