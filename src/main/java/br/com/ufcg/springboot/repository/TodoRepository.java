package br.com.ufcg.springboot.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ufcg.springboot.model.TodoNote;


@Repository
@Transactional
public interface TodoRepository extends JpaRepository<TodoNote, Long> {
	
	@Query("SELECT t FROM TodoNote t WHERE LOWER(t.text) LIKE CONCAT('%', LOWER(:text), '%')")
	public List<TodoNote> searchByText(@Param("text") String text);
	
}
