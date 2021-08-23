package br.ifpe.web2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.ifpe.web2.model.Cliente;
import br.ifpe.web2.model.ClienteDAO;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteDAO clienteDAO;

	public List<Cliente> listarTodos(Sort ordenacao) {
		return this.clienteDAO.findAll(ordenacao);
	}

	public Cliente obterPorId(Integer codigo) {
		return this.clienteDAO.getOne(codigo);
	}

	public void remover(Integer codigo) {
		this.clienteDAO.deleteById(codigo);
	}

	public boolean salvarCliente(Cliente cliente) {
		// Verificar a existencia de um cliente com o cpf
		
		Cliente clienteComCPFExistente = this.clienteDAO
				.findByCpf(cliente.getCpf());
		
		if (clienteComCPFExistente == null) {
			this.clienteDAO.save(cliente);	
			return true;
		}
		return false;
		
	}

}
