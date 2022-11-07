package br.edu.fateczl.AulaSpringREST.AulaSpringREST.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.dto.UsuarioDTO;
import br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.entity.Usuario;

public interface IUsuarioController {
	public List<UsuarioDTO> listaDepto();
	public ResponseEntity<UsuarioDTO> buscaDepto(int usuarioId);
	public ResponseEntity<String> adicionaDepto(Usuario usuario);
	public ResponseEntity<String> atualizaDepto(Usuario usuario);
	public ResponseEntity<String> excluiDepto(Usuario usuario);
	public ResponseEntity<Integer> validaLogin(Usuario usuario);
}
