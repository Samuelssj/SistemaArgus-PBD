package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "nota")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Nota.sequence, initialValue = 1, allocationSize = 1)


public class Nota extends Entidade{

	
	@Column(length = 50, nullable = false)
	private Double nota1;
	
	@Column(length = 50, nullable = false)
	private Double nota2;
	
	@Column(length = 50, nullable = false)
	private Double nota3;
	
	@Column(length = 50, nullable = false)
	private Double nota4;
	
	@Column(length = 50, nullable = false)
	private Double media;
	
	

	private static final long serialVersionUID = 1L;

	protected static final String sequence = "nota_sequence";
	

	
	@Override
	public String detalhesEntidade() {
		// TODO Auto-generated method stub
		return null;
	}

}
