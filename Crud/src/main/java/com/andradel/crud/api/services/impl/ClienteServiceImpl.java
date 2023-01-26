package com.andradel.crud.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andradel.crud.api.documents.Cliente;
import com.andradel.crud.api.repositories.ClienteRepository;
import com.andradel.crud.api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente listarPorId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub

	}

}
