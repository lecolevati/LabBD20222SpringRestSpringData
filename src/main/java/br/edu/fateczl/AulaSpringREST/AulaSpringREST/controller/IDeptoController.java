package br.edu.fateczl.AulaSpringREST.AulaSpringREST.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.dto.DeptoDTO;
import br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.entity.Depto;

public interface IDeptoController {
	public List<DeptoDTO> listaDepto();
	public ResponseEntity<DeptoDTO> buscaDepto(int codigoDepto);
	public ResponseEntity<String> adicionaDepto(Depto d);
	public ResponseEntity<String> atualizaDepto(Depto d);
	public ResponseEntity<String> excluiDepto(Depto d);
	public ResponseEntity<String> nomeCompletoDepto(Depto d);
}
