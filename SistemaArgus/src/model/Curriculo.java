package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "curriculo")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Curriculo.sequence, initialValue = 1, allocationSize = 1)

public class Curriculo extends Entidade {

	@Column(length = 60)
	private String nome;
	@Column(length = 60)
	private String tipoAno;
	@Column(length = 60)
	private String AnoLetivo;
	@Column(length = 60)
	private String Codigo;
	@Column(length = 60)
	private boolean status;

//	@ManyToOne
//	@JoinColumn(name = "id_turma")
//	private Turma turma;

	@ManyToOne
	@JoinColumn(name = "parcela")
	private Parcela parcela;

	@ManyToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;

	private static final long serialVersionUID = 1L;

	protected static final String sequence = "curriculo_sequence";

	
	

	@Override
	public String toString() {
		return "Curriculo [nome=" + nome + ", tipoAno=" + tipoAno + ", AnoLetivo=" + AnoLetivo + ", Codigo=" + Codigo
				+ ", status=" + status + ", disciplina=" +", parcela=" + parcela + ", aluno=" + aluno
				+ "]";
	}







	public String getNome() {
		return nome;
	}
	
	

	public String getCodigo() {
		return Codigo;
	}

	public void setCodigo(String codigo) {
		Codigo = codigo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getTipoAno() {
		return tipoAno;
	}



	public void setTipoAno(String tipoAno) {
		this.tipoAno = tipoAno;
	}



	public String getAnoLetivo() {
		return AnoLetivo;
	}

	public void setAnoLetivo(String anoLetivo) {
		AnoLetivo = anoLetivo;
	}
	

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	

	public Parcela getParcela() {
		return parcela;
	}

	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
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
