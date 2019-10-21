package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "acompanhamento")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Acompanhamento.sequence, initialValue = 1, allocationSize = 1)

public class Acompanhamento extends Entidade {

	
	@Column(length = 60, nullable = false)
	private String nome; //rua VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private Date data; //rua VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private int secao; //rua VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String relatoriAcompanhamento; //rua VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String relatorioProfissional; //rua VARCHAR (50) NOT NULL,
	
	
	@OneToOne
	@JoinColumn(name = "aluno")
	private Aluno aluno;
	
	@OneToOne
	@JoinColumn(name = "pedagogo")
	private Pedagogo pedagogo;
	
private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "acompanhamento_sequence";
	
	



	@Override
	public String toString() {
		return "Acompanhamento [nome=" + nome + ", data=" + data + ", secao=" + secao + ", relatoriAcompanhamento="
				+ relatoriAcompanhamento + ", relatorioProfissional=" + relatorioProfissional + ", aluno=" + aluno
				+ ", pedagogo=" + pedagogo + "]";
	}



	public String getNome() {
		return nome;
	}






	public void setNome(String nome) {
		this.nome = nome;
	}






	public Date getData() {
		return data;
	}






	public void setData(Date data) {
		this.data = data;
	}






	public int getSecao() {
		return secao;
	}






	public void setSecao(int secao) {
		this.secao = secao;
	}






	public String getRelatoriAcompanhamento() {
		return relatoriAcompanhamento;
	}






	public void setRelatoriAcompanhamento(String relatoriAcompanhamento) {
		this.relatoriAcompanhamento = relatoriAcompanhamento;
	}






	public String getRelatorioProfissional() {
		return relatorioProfissional;
	}






	public void setRelatorioProfissional(String relatorioProfissional) {
		this.relatorioProfissional = relatorioProfissional;
	}






	public Aluno getAluno() {
		return aluno;
	}






	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}






	public Pedagogo getPedagogo() {
		return pedagogo;
	}






	public void setPedagogo(Pedagogo pedagogo) {
		this.pedagogo = pedagogo;
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
