package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="pessoa")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Pessoa.sequence, initialValue = 1, allocationSize = 1)

//lembrar de ser abstrata e usar outras classes

public class Pessoa {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	@Column
	private int idade;
	
	private static final long serialVersionUID = 1L;

	protected static final String sequence = "pessoa_sequence";
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	
	
	

}
