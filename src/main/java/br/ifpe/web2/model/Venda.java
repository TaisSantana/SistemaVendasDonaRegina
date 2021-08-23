package br.ifpe.web2.model;

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
	@NotBlank(message = "Erro: Venda sem produto!")
	@ManyToOne
	private Produto produto;
	@Min(value = 1, message = "Quantidade mínima: 1 unidade!")
	private int quantidade;
	@ManyToOne
	@NotNull(message = "Cliente deve ser selecionado")
	private Cliente cliente;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate dataVenda;
}
