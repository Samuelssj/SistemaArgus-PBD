package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "curriculo")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Curriculo.sequence, initialValue = 1, allocationSize = 1)

public class Curriculo extends Entidade {

	

	@Column(length = 60, nullable = false)
	private String nome; //rua VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private boolean tipoAno; //numero VARCHAR (50) NOT NULL,
	@Column(length = 60,nullable = false)
	private String bairro; //bairro VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String cep; //cep VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String cidade; //cidade VARCHAR (50) NOT NULL, 
	
	
	
	
	
	
	
	@Override
	public String detalhesEntidade() {
		// TODO Auto-generated method stub
		return null;
	}

}
