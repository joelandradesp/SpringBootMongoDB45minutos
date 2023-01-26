package com.andradel.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.andradel.crud.api.documents.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {

}
