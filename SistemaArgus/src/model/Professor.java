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

	@Column(length = 50, nullable = true)
	private String nome; // 
	 // 


	private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "professor_sequence";

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
		return "Professor [nome=" + nome  + ", id_professor="  +getId() + "]";
	}

	
	

}
