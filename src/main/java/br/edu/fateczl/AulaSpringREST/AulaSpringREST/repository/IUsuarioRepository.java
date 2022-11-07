package br.edu.fateczl.AulaSpringREST.AulaSpringREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Procedure(name = "Usuario.sp_valida_login")
	Integer spValidaLogin(@Param("login")String login, 
			@Param("senha") String senha); 
	
}
