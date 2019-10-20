package model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "professor")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Professor.sequence, initialValue = 1, allocationSize = 1)

public abstract class Professor extends Usuario {

	@Column(length = 50, nullable = false)
	private String nome; // nome VARCHAR (50) NOT NULL,
	@Column(length = 11, nullable = false)
	private String cpf; // codigo VARCHAR (50) NOT NULL,

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "endereco")
	private Endereco endereco; // id_endereco INTEGER REFERENCES ENDERECO(id)

	// fazer referencia com turma
	
	private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "professor_sequence";
	
	
	

	

}
