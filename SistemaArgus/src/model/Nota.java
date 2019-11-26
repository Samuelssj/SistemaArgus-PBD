package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "nota")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Nota.sequence, initialValue = 1, allocationSize = 1)


public class Nota extends Entidade{

	
	@Column(length = 50, nullable = false)
	private Double nota;
	
	@Column(length = 6)
	private String tipoNota;
	
	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Disciplina disciplina;
	
	

	private static long serialVersionUID = 1L;

	protected static final String sequence = "nota_sequence";
	



	public Double getNota() {
		return nota;
	}




	public void setNota(Double nota) {
		this.nota = nota;
	}




	public String getTipoNota() {
		return tipoNota;
	}




	public void setTipoNota(String tipoNota) {
		this.tipoNota = tipoNota;
	}




	public Aluno getAluno() {
		return aluno;
	}




	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}




	public Disciplina getDisciplina() {
		return disciplina;
	}




	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}




	public static void setSerialversionuid(long serialversionuid) {
		serialVersionUID = serialversionuid;
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
