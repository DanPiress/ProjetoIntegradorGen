package com.org.generation.blogpessoal.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
//Declarando que é um classe model (que ela gera uma tabela no banco de dados)
@Entity

//Declarando o nome da tabela
@Table (name = "tb_postagens")

public class Postagem {
	
	//@id informa que ele é chave primaria
	@Id 
	//@GeneratedVaue informa que é auto incremento
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//Mostra que o atributo e not null
	@NotNull (message = "O atributo titulo é obrigatorio!")
	//Configura um valor minimo e um valor maximo para o texto
	@Size(min = 5, max = 100, message = "o atribuo titulo deve ter no minimo 5 e no maximo 100 carac")
	private String titulo;

	@NotNull (message = "O atributo texto é obrigatorio!")
	@Size(min = 5, max = 1000, message = "o atribuo texto deve ter no minimo 5 e no maximo 1000 carac")
	private String texto;
	
	//Indica que sera do tipo timestamp (pega a data do sistema)
	@Temporal (TemporalType.TIMESTAMP)
						//grava dias, horas, minutos, segundos e milisegundos
	private Date data = new java.sql.Date(System.currentTimeMillis());
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}



}
