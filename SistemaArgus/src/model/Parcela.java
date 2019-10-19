package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table (name = "parcela")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Parcela.sequence, initialValue = 1, allocationSize = 1)

public class Parcela extends Entidade {

	@Column(length = 50, nullable = false)
	private String nome; //nome VARCHAR (50),
	@Column(nullable = false)
	private Double valor; //login VARCHAR (20) NOT NULL UNIQUE,
	@Column(nullable = false)
	private int quantidade; //senha VARCHAR (11) NOT NULL
	
	
	
	
	
	
	
	@Override
	public String detalhesEntidade() {
		// TODO Auto-generated method stub
		return null;
	}

}
