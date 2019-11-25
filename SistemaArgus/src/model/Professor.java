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
@Table(name = "professor")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Professor.sequence, initialValue = 1, allocationSize = 1)

public class Professor extends Usuario {

	@Column(length = 50, nullable = false)
	private String nome; // nome VARCHAR (50) NOT NULL,
	@Column(length = 11, nullable = false, unique = true)
	private String cpf; // codigo VARCHAR (50) NOT NULL,

	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "disciplina")
	private Disciplina disciplina;
	
	private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "professor_sequence";

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
		return "Professor [nome=" + nome + ", cpf=" + cpf + ", endereco="  + "]";
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
	
	

	

}
