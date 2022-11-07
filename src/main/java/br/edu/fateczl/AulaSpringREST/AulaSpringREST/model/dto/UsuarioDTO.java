package br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UsuarioDTO {

	private int id;
	private String nome;
	private DeptoDTO depto;
	
}
