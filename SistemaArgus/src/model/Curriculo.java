package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "curriculo")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Curriculo.sequence, initialValue = 1, allocationSize = 1)

public class Curriculo extends Entidade {

	

	@Column(length = 60, nullable = false)
	private String nome; //rua VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private boolean tipoAno; //numero VARCHAR (50) NOT NULL,
	@Column(length = 60,nullable = false)
	private String AnoLetivo; //bairro VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String DiciplinasAlocadas; //cep VARCHAR (50) NOT NULL,
	@Column(length = 60, nullable = false)
	private String cidade; //cidade VARCHAR (50) NOT NULL, 
	@Column(length = 60, nullable = false)
	private boolean status;

	
	@OneToOne
	@JoinColumn(name = "disciplina")
	private Disciplina disciplina;
	
	@OneToOne
	@JoinColumn(name = "parcela")
	private Parcela parcela;
	
	
private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "curriculo_sequence";
	
	
	
	
	@Override
	public String toString() {
		return "Curriculo [nome=" + nome + ", tipoAno=" + tipoAno + ", AnoLetivo=" + AnoLetivo + ", DiciplinasAlocadas="
				+ DiciplinasAlocadas + ", cidade=" + cidade + ", status=" + status + ", disciplina=" + disciplina
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




	public String getCidade() {
		return cidade;
	}




	public void setCidade(String cidade) {
		this.cidade = cidade;
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
