package br.edu.fateczl.AulaSpringREST.AulaSpringREST;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.entity.Depto;
import br.edu.fateczl.AulaSpringREST.AulaSpringREST.repository.IDeptoRepository;

@SpringBootTest
public class TesteDepto {

	@Autowired
	IDeptoRepository dRep;
	
	@Test
	void testaUDF() {
		Depto depto = dRep.fn_nome_depto(1);
		assertEquals(depto.getNome(), "Departamento de Informática");
	}
	
}
