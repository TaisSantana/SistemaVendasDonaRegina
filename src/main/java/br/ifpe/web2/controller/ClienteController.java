package br.ifpe.web2.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web2.model.Cliente;
import br.ifpe.web2.service.ClienteService;

@Controller
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/listarClientes")
	public String exibirLista(Model model) {
		//model atua dentro do request, acaba no controller que ele ta
		model.addAttribute("lista", this.clienteService.listarTodos(Sort.by("nomeCompleto")));
		return "cliente/cliente-list";
	}
	
	@GetMapping("/exibirFormCliente")
	public String exibirForm(Cliente cliente) {
		return "cliente/cliente-form";
	}
	
	@PostMapping("/salvarCliente")
	public String salvarCliente(@Valid Cliente cliente, 
			BindingResult br, RedirectAttributes ra, Model model) {
		if (br.hasErrors()) {
			return this.exibirForm(cliente);
		}
		boolean retorno = 
			this.clienteService.salvarCliente(cliente);
		if (retorno == false) {
			model.addAttribute("mensagem", "Já existe cliente com este CPF");
			return this.exibirForm(cliente);
		}
		return "redirect:/listarClientes";
	}

	@GetMapping("/editarCliente")
	public String editarCliente(Integer codigo, Model model) {
		model.addAttribute("cliente", this.clienteService.obterPorId(codigo));
		return "cliente/cliente-form";
	}

	@GetMapping("/removerCliente")
	public String removerCliente(Integer codigo) {
		this.clienteService.remover(codigo);
		return "redirect:/listarClientes";
	}
	
	//-------
	@GetMapping("/paginaInicial")
	public String exibirPaginaInicial() {
		return "index";
	}
	
	@GetMapping("/acessoNegado")
	public String exibirAcessoNegado() {
		return "acesso-negado";
	}
	
	@PostMapping("/efetuarLogin")
	public String efetuarLogin(Cliente cliente, RedirectAttributes ra, HttpSession session) {
	if (cliente.getApelido().equals("admin") && cliente.getSenha().equals("adm123")) {
		session.setAttribute("usuarioLogado", cliente);
		return "redirect:/exibirProdutosVenda";
	} else {
	ra.addFlashAttribute("mensagemErro", "Usuário/senha inválidos"); 
		return "redirect:/paginaInicial";
	}
		
	}
	
	@PostMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
