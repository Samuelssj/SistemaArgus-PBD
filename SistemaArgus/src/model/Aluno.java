package model;

import java.util.List;

import javax.persistence.CascadeType;
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

public class Aluno extends Usuario {

	@Column(length = 60, nullable = false)
	private String nome;
	@Column(length = 60, nullable = false)
	private String pai;
	@Column(length = 60, nullable = false)
	private String mãe; 
	@Column(length = 60)
	private String cpf; 
	
//	@Column(length = 60, nullable = true)
//	private String responsavel; 
	

	
	@OneToOne
	@JoinColumn(name = "curriculo")
	private Curriculo curriculo;

//	@OneToMany
//	@JoinColumn(name = "turma")
//	private List<Turma> turmas;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "responsavel")
	private Responsavel responsavel;

//	@OneToMany
//	@JoinColumn(name = "acompanhamento")
//	private List<Acompanhamento> acompanhamentos;

	private static final long serialVersionUID = 1L;

	protected static final String sequence = "aluno_sequence";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Responsavel getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}

//	public List<Turma> getTurmas() {
//		return turmas;
//	}
//
//	public void setTurmas(List<Turma> turmas) {
//		this.turmas = turmas;
//	}
//
//	public List<Acompanhamento> getAcompanhamentos() {
//		return acompanhamentos;
//	}
//
//	public void setAcompanhamentos(List<Acompanhamento> acompanhamentos) {
//		this.acompanhamentos = acompanhamentos;
//	}

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
