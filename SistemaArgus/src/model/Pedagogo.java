package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "pedagogo")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Pedagogo.sequence, initialValue = 1, allocationSize = 1)

public class Pedagogo extends Usuario{
	

	@Column(length = 50, nullable = false)
	private String nome; // nome VARCHAR (50) NOT NULL,
	
	
	
	
private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "pedagogo_sequence";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getSequence() {
		return sequence;
	}

	@Override
	public String toString() {
		return "Pedagogo [nome=" + nome + "]";
	}

	
}
