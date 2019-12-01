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
@Table(name = "turma")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Turma.sequence, initialValue = 1, allocationSize = 1)

public class Turma extends Entidade {

	
	@Column(length = 60, nullable = false)
	private boolean situacao; //numero VARCHAR (50) NOT NULL,
	@Column(length = 60,nullable = false)
	private String vagas; //bairro VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String nome; //cep VARCHAR (50) NOT NULL,
	

	
private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "Turma_sequence";
	
	@OneToOne
	@JoinColumn(name = "aluno")
	private Aluno aluno;
	
	
	@OneToOne
	@JoinColumn(name = "disciplina")
	private Disciplina disciplina;
	
	@ManyToOne
	@JoinColumn(name = "id_curriculo")
	private Curriculo curriculo;
	
	@Override
	public String toString() {
		return "Turma [situacao=" + situacao + ", vagas=" + vagas + ", nome=" + nome + ", aluno=" + aluno
				+ ", disciplina=" + disciplina + "]";
	}






	public Curriculo getCurriculo() {
		return curriculo;
	}






	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}






	public boolean isSituacao() {
		return situacao;
	}






	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}






	public String getVagas() {
		return vagas;
	}






	public void setVagas(String vagas) {
		this.vagas = vagas;
	}






	public String getNome() {
		return nome;
	}






	public void setNome(String nome) {
		this.nome = nome;
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
