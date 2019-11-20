package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "responsavel")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Responsavel.sequence, initialValue = 1, allocationSize = 1)

public class Responsavel extends Usuario{


	@Column(length = 50)
	private String nome;
	@Column(length = 11)
	private String cpf; 

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "aluno")
	//private Aluno aluno; // id_endereco INTEGER REFERENCES ENDERECO(id)
	
//	@OneToOne
//	@JoinColumn(name = "aluno")
//	private Aluno aluno;
//	
	private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "responsavel_sequence";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getSequence() {
		return sequence;
	}

	@Override
	public String toString() {
		return "Responsavel [nome=" + nome + ", cpf=" + cpf + "]";
	}
	
	
	

	
	
}
