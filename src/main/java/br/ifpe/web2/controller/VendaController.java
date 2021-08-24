package br.ifpe.web2.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web2.model.Produto;
import br.ifpe.web2.model.ProdutoDAO;
import br.ifpe.web2.model.Venda;
import br.ifpe.web2.model.VendaDAO;
import br.ifpe.web2.service.ClienteService;

@Controller
public class VendaController {


	@Autowired
	private ProdutoDAO produtoDAO;
	@Autowired
	private VendaDAO vendaDAO;
	@Autowired
	private ClienteService clienteService;
	
	@GetMapping("/exibirProdutosVenda")
	public String exibirProdutos(Model model) {
		PageRequest page = PageRequest.of(0, 15);
		model.addAttribute("listaProdutos", this.produtoDAO.findAll(page));
//		model.addAttribute("listaProdutos", this.produtoDAO.findByPrecoBetween(1, 3));
		return "vendas/produto-search";
	}
	
	@PostMapping("/pesquisarProdutos")
	public String pesquisarProdutos(String nomeProduto, Model model) {
		
	
		List<Produto> resultado = this.produtoDAO
			.findByNomeContainingIgnoreCase(nomeProduto, Sort.by("nome"));
		model.addAttribute("listaProdutos", resultado);
		return "vendas/produto-search";
	}
	
	@GetMapping("/exibirFormVenda")
	public String exibirFormVenda(Integer codigo, Venda venda, Model model) {
		model.addAttribute("produto", this.produtoDAO.findByCodigo(codigo));
		model.addAttribute("listaClientes", this.clienteService.listarTodos(Sort.by("nomeCompleto")));
		return "vendas/tabela-venda";
	}
	
	@PostMapping("/registrarVenda")
	public String realizarVenda(@Valid Venda venda, Produto  produto,			
			BindingResult result,RedirectAttributes ra, Model model) {
		if (result.hasErrors()) {
			//musar aq p receber venda.produto.codprod
			return "redirect:/exibirFormVenda";
		}
		//adicionando data na venda
		/*Date data = new Date(System.currentTimeMillis()); 
	    SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd"); 
	    System.out.print(formatarData.format(data));
	    */
	    LocalDate dataVenda = LocalDate.now();
	    venda.setDataVenda(dataVenda);
	    venda.setProduto(produto); 
	    
		this.vendaDAO.save(venda);
		return "redirect:/listarVendas";
	}
	
	@GetMapping("/listarVendas")
	public String exibirLista(Model model) {
		model.addAttribute("lista", this.vendaDAO.findAll(Sort.by("dataVenda")));
		return "vendas/vendas-realizadas";
	}

}
