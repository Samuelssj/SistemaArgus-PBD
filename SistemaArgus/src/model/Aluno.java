package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "aluno")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Aluno.sequence, initialValue = 1, allocationSize = 1)

public class Aluno extends Entidade {

	
	@Column(length = 60, nullable = false)
	private String nome; //rua VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String pai; //rua VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String mãe; //rua VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String cpf; //rua VARCHAR (50) NOT NULL,
	
	@OneToOne
	@JoinColumn(name = "curriculo")
	private Curriculo curriculo;
	
	@OneToOne
	@JoinColumn(name = "nota")
	private Nota nota;
	
	@ManyToOne
	@JoinColumn(name = "responsavel")
	private Responsavel responsavel;
	

	
private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "aluno_sequence";
	
	
	
	
	
	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", pai=" + pai + ", mãe=" + mãe + ", cpf=" + cpf + ", curriculo=" + curriculo
				+ ", nota=" + nota + ", responsavel=" + responsavel + "]";
	}





	public String getNome() {
		return nome;
	}





	public void setNome(String nome) {
		this.nome = nome;
	}





	public String getPai() {
		return pai;
	}





	public void setPai(String pai) {
		this.pai = pai;
	}





	public String getMãe() {
		return mãe;
	}





	public void setMãe(String mãe) {
		this.mãe = mãe;
	}





	public String getCpf() {
		return cpf;
	}





	public void setCpf(String cpf) {
		this.cpf = cpf;
	}





	public Curriculo getCurriculo() {
		return curriculo;
	}





	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}





	public Nota getNota() {
		return nota;
	}





	public void setNota(Nota nota) {
		this.nota = nota;
	}





	public Responsavel getResponsavel() {
		return responsavel;
	}





	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
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
