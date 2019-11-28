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
	private boolean tipoAno; 
	@Column(length = 60)
	private String AnoLetivo; 
	@Column(length = 60)
	private String DiciplinasAlocadas; 
	@Column(length = 60)
	private boolean status;

	
	@ManyToOne
	@JoinColumn(name = "disciplina")
	private Disciplina disciplina;
	
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
		return "Curriculo [nome=" + nome + ", tipoAno=" + tipoAno + ", AnoLetivo=" + AnoLetivo + ", DiciplinasAlocadas="
				+ DiciplinasAlocadas + ", cidade="  + ", status=" + status + ", disciplina=" + disciplina
				+ ", parcela=" + parcela + "]";
	}




	public String getNome() {
		return nome;
	}




	public void setNome(String nome) {
		this.nome = nome;
	}




	public boolean isTipoAno() {
		return tipoAno;
	}




	public void setTipoAno(boolean tipoAno) {
		this.tipoAno = tipoAno;
	}




	public String getAnoLetivo() {
		return AnoLetivo;
	}




	public void setAnoLetivo(String anoLetivo) {
		AnoLetivo = anoLetivo;
	}




	public String getDiciplinasAlocadas() {
		return DiciplinasAlocadas;
	}




	public void setDiciplinasAlocadas(String diciplinasAlocadas) {
		DiciplinasAlocadas = diciplinasAlocadas;
	}





	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}




	public Disciplina getDisciplina() {
		return disciplina;
	}




	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
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
