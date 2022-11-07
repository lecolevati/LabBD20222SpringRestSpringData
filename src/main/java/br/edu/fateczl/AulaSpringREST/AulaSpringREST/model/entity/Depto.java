package br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "depto")
@NamedNativeQuery(
		name = "Depto.fn_nome_depto",
		query = "SELECT codigo, nome FROM fn_nome_depto(?1)",
		resultClass = Depto.class
)
public class Depto {
	
	@Id
	@Column(name = "codigo", nullable = false)
	private int codigo;
	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

}
