package br.edu.fateczl.AulaSpringREST.AulaSpringREST.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.fateczl.AulaSpringREST.AulaSpringREST.model.entity.Depto;

public interface IDeptoRepository extends JpaRepository<Depto, Integer> {
	Depto fn_nome_depto(int codigo);
}
