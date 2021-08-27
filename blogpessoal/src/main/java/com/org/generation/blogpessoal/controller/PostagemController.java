package com.org.generation.blogpessoal.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.generation.blogpessoal.model.Postagem;
import com.org.generation.blogpessoal.repository.PostagemRepository;

//indicando que é uma classe do tipo controladora
//recebe requisição http e responde a requisição
@RestController
@RequestMapping("/postagens")
//conceito SOLFIA
//permite back e front se acessarem em servidores diferente
// * deixa em modo promisso aceita qualquer origem
// modo de produção coloca o endereço de onde vem no lugar do *
//origins é a origem da requisição
//Headers é o cabeçalho
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PostagemController {
	
	
	//injeção de dependencia transfere o controle para o Spring
	//criando uma injeção de dependencia
	@Autowired 
	private PostagemRepository postagemRepository;
	
	//toda request exige um response
	@GetMapping
	public ResponseEntity<List<Postagem>> getAll(){
		//acessa a tabela, tras os dados e atraves do ResponseEntity.ok tras todos os dados da tabela
		return ResponseEntity.ok(postagemRepository.findAll());
	}
	//passando uma variavel de caminho ([id])
	@GetMapping("indifelse/[id]")
	
	//converte a variavel id em long
	public ResponseEntity<Postagem> getByIDIfElse(@PathVariable long id){
		
		//Optional impede um erro do tipo nullpointedexeprion
		Optional<Postagem> postagem = postagemRepository.findById(id);
		
	if (postagem.isPresent()) {
		return ResponseEntity.ok(postagem.get());
	}
	return null;
		
	}

}
