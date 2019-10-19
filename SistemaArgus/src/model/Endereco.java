package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import EntidadeEnum.Estado;


@Entity
@Table (name = "endereco")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Endereco.sequence, initialValue = 1, allocationSize = 1)

public class Endereco extends Entidade{
	
	@Column(length = 60, nullable = false)
	private String rua; //rua VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String numero; //numero VARCHAR (50) NOT NULL,
	@Column(length = 60,nullable = false)
	private String bairro; //bairro VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String cep; //cep VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String cidade; //cidade VARCHAR (50) NOT NULL, 
	@Column(length = 60)
	@Enumerated(EnumType.STRING)
	private Estado estado; //estado VARCHAR (50), 
	@Column(length = 60)
	private String pais; //pais VARCHAR (50), 
	@Column(length = 60)
	private String complemento; //complemento VARCHAR(50)

	private static final long serialVersionUID = 1L;

	protected static final String sequence = "endereco_sequence";
	

	@Override
	public String detalhesEntidade() {
		// TODO Auto-generated method stub
		return null;
	}

}
