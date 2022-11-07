package br.edu.fateczl.AulaSpringREST.AulaSpringREST.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.dto.DeptoDTO;
import br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.dto.UsuarioDTO;
import br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.entity.Usuario;
import br.edu.fateczl.AulaSpringREST.AulaSpringREST.repository.IUsuarioRepository;

@RestController
@RequestMapping("/api")
public class UsuarioController implements IUsuarioController {

	@Autowired
	IUsuarioRepository uRep;
	
	@Override
	@GetMapping("/usuario")
	public List<UsuarioDTO> listaDepto() {
		List<Usuario> listaUsuario = uRep.findAll();
		List<UsuarioDTO> listaUsuarioDTO = converteListaUsuarioListaUsuarioDTO(listaUsuario);
		return listaUsuarioDTO;
	}

	private List<UsuarioDTO> converteListaUsuarioListaUsuarioDTO(List<Usuario> listaUsuario) {
		List<UsuarioDTO> listaUsuarioDTO = new ArrayList<>();
		for (Usuario usuario : listaUsuario) {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			DeptoDTO deptoDTO = new DeptoDTO();
			
			deptoDTO.setCodigo(usuario.getDepto().getCodigo());
			deptoDTO.setNome(usuario.getDepto().getNome());
			
			usuarioDTO.setDepto(deptoDTO);
			usuarioDTO.setId(usuario.getId());
			usuarioDTO.setNome(usuario.getNome());
			
			listaUsuarioDTO.add(usuarioDTO);
		}
		return listaUsuarioDTO;
	}

	@Override
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<UsuarioDTO> buscaDepto(@PathVariable(name = "usuarioId") int usuarioId) {
		Usuario usuario = uRep.findById(usuarioId).orElseThrow(() -> new ResourceNotFoundException("ID invalido"));
		UsuarioDTO usuarioDTO = converteUsuarioUsuarioDTO(usuario);
		return ResponseEntity.ok().body(usuarioDTO);
	}

	private UsuarioDTO converteUsuarioUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		DeptoDTO deptoDTO = new DeptoDTO();
		
		deptoDTO.setCodigo(usuario.getDepto().getCodigo());
		deptoDTO.setNome(usuario.getDepto().getNome());
		
		usuarioDTO.setDepto(deptoDTO);
		usuarioDTO.setId(usuario.getId());
		usuarioDTO.setNome(usuario.getNome());
		
		return usuarioDTO;
	}

	@Override
	@PostMapping("/usuario")
	public ResponseEntity<String> adicionaDepto(@Valid @RequestBody Usuario usuario) {
		uRep.save(usuario);
		String saida = "Usuario adicionado com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@PutMapping("/usuario")
	public ResponseEntity<String> atualizaDepto(@Valid @RequestBody Usuario usuario) {
		uRep.save(usuario);
		String saida = "Usuario atualizado com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@DeleteMapping("/usuario")
	public ResponseEntity<String> excluiDepto(@Valid @RequestBody Usuario usuario) {
		uRep.delete(usuario);
		String saida = "Usuario excluido com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@GetMapping("/usuario/login")
	public ResponseEntity<Integer> validaLogin(@Valid @RequestBody Usuario usuario) {
		Integer valida = 
			uRep.spValidaLogin(usuario.getLogin(), usuario.getSenha());
		return ResponseEntity.ok().body(valida);
	}
	
}