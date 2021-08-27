
//interface é obrigatoria para conseguir mexer no banco de dados
package com.org.generation.blogpessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.org.generation.blogpessoal.model.Postagem;

//indicando que ela é uma interface do tipo repository
@Repository
											//fazendo herança de uma interface responsavel por fornecer os metodos de manipulção do banco de dados
														//objeto postagem é o primeiroobjeto pq é o repository da casse postagem
														
public interface PostagemRepository extends JpaRepository <Postagem, Long> {
	
	// Dentro do db faz um: Select * where titulo like "%titulo%";
	public List <Postagem> findAllByTituloContainingIngnoreCase(String titulo);
	
}
