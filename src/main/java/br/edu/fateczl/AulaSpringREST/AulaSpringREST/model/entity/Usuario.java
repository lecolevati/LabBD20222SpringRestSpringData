package br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "usuario")
@NamedStoredProcedureQuery(
		name = "Usuario.sp_valida_login",
		procedureName = "sp_valida_login",
		parameters = {
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "login", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.IN, name = "senha", type = String.class),
			@StoredProcedureParameter(mode = ParameterMode.OUT, name = "id", type = Integer.class)
		}
)
public class Usuario {

	@Id
	@Column(name = "id", nullable = false)
	private int id;
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	@Column(name = "login", nullable = false, columnDefinition = "CHAR(8) CHECK (LEN(login) = 8)")
	private String login;
	@Column(name = "senha", nullable = false, columnDefinition = "CHAR(8) DEFAULT('123mudar')")
	private String senha;
	@ManyToOne(targetEntity = Depto.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "depto", nullable = false)
	private Depto depto;
	
}
