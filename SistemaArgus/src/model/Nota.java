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
	public String toString() {
		return "Nota [nota1=" + nota1 + ", nota2=" + nota2 + ", nota3=" + nota3 + ", nota4=" + nota4 + ", media="
				+ media + "]";
	}




	public Double getNota1() {
		return nota1;
	}




	public void setNota1(Double nota1) {
		this.nota1 = nota1;
	}




	public Double getNota2() {
		return nota2;
	}




	public void setNota2(Double nota2) {
		this.nota2 = nota2;
	}




	public Double getNota3() {
		return nota3;
	}




	public void setNota3(Double nota3) {
		this.nota3 = nota3;
	}




	public Double getNota4() {
		return nota4;
	}




	public void setNota4(Double nota4) {
		this.nota4 = nota4;
	}




	public Double getMedia() {
		return media;
	}




	public void setMedia(Double media) {
		this.media = media;
	}




	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public static String getSequence() {
		return sequence;
	}




	@Override
	public String detalhesEntidade() {
		// TODO Auto-generated method stub
		return null;
	}

}
