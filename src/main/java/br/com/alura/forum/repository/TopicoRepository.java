package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

	// Filtrando por um atributo de uma entidade
	// Padrão: findBy{Entidade}{Atributo}
	// Ou ainda: findBy{Entidade}_{Atributo}
	List<Topico> findByCursoNome(String nomeCurso);
	
	
	// Caso precise declarar um método fora do padrão:
	// É necessário a anotação @Query e passar a query no padrão do JPQL
	// E ainda usar as anotações de @Param para relacionar os parâmetros do JPQL
	// com os parâmetros do método
	@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")
	List<Topico> carregarPorNomeCurso(@Param ("nomeCurso") String nomeCurso);
}
