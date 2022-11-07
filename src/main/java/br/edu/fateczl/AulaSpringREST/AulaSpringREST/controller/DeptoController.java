package br.edu.fateczl.AulaSpringREST.AulaSpringREST.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.entity.Depto;
import br.edu.fateczl.AulaSpringREST.AulaSpringREST.repository.IDeptoRepository;

@RestController
@RequestMapping("/api")
public class DeptoController implements IDeptoController {

	@Autowired
	IDeptoRepository dRep;
	
	private List<DeptoDTO> converteListaDeptoListaDeptoDTO(List<Depto> listaDepto) {
		List<DeptoDTO> listaDeptoDTO = new ArrayList<>();
		for (Depto depto : listaDepto) {
			DeptoDTO deptoDTO = new DeptoDTO();
			deptoDTO.setCodigo(depto.getCodigo());
			deptoDTO.setNome(depto.getNome());
			listaDeptoDTO.add(deptoDTO);
		}
		return listaDeptoDTO;
	}
	

	private DeptoDTO converteDeptoDpetoDTO(Depto depto) {
		DeptoDTO deptoDTO = new DeptoDTO();
		deptoDTO.setCodigo(depto.getCodigo());
		deptoDTO.setNome(depto.getNome());
		return deptoDTO;
	}


	@Override
	@GetMapping("/depto")
	public List<DeptoDTO> listaDepto() {
		List<Depto> deptos = dRep.findAll();
		List<DeptoDTO> deptosDTO = converteListaDeptoListaDeptoDTO(deptos);
		return deptosDTO;
	}


	@Override
	@GetMapping("/depto/{codigoDepto}")
	public ResponseEntity<DeptoDTO> buscaDepto(@PathVariable(value = "codigoDepto") int codigoDepto) {
		Optional<Depto> optionalDepto = dRep.findById(codigoDepto);
		Depto depto = optionalDepto.orElseThrow(() -> new ResourceNotFoundException("Código inválido"));
		DeptoDTO deptoDTO = converteDeptoDpetoDTO(depto);
		return ResponseEntity.ok().body(deptoDTO);
	}


	@Override
	@PostMapping("/depto")
	public ResponseEntity<String> adicionaDepto(@Valid @RequestBody Depto d) {
		dRep.save(d);
		String saida = "Depto inserido com sucesso";
		return ResponseEntity.ok().body(saida);
	}


	@Override
	@PutMapping("/depto")
	public ResponseEntity<String> atualizaDepto(@Valid @RequestBody Depto d) {
		dRep.save(d);
		String saida = "Depto atualizado com sucesso";
		return ResponseEntity.ok().body(saida);
	}


	@Override
	@DeleteMapping("/depto")
	public ResponseEntity<String> excluiDepto(@Valid @RequestBody Depto d) {
		dRep.delete(d);
		String saida = "Depto excluido com sucesso";
		return ResponseEntity.ok().body(saida);		
	}


	@Override
	@GetMapping("/depto/nomeCompleto")
	public ResponseEntity<String> nomeCompletoDepto(@Valid @RequestBody Depto d) {
		Depto depto = dRep.fn_nome_depto(d.getCodigo());
		return ResponseEntity.ok().body(depto.getNome());
	}
}







