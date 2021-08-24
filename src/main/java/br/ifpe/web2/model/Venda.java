package br.ifpe.web2.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Venda {
	@Id @GeneratedValue(strategy =GenerationType.AUTO)
	private Integer codigo;
	@ManyToOne
	private Produto produto;
	@Min(value = 1, message = "Quantidade mínima: 1 unidade!")
	private int quantidade;
	@ManyToOne
	@NotNull(message = "Cliente deve ser selecionado")
	private Cliente cliente;
	private LocalDate dataVenda;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDate formatarData) {
		this.dataVenda = formatarData;
	}
	
	
}
