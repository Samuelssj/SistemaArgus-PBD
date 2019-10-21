package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "disciplina")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Disciplina.sequence, initialValue = 1, allocationSize = 1)

public class Disciplina extends Entidade {

	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 10, nullable = false)
	private String cargaHoraria;
	@Column(nullable = false)
	private boolean status;
	
	
private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "disciplina_sequence";
	

	@Override
	public String toString() {
		return "Disciplina [nome=" + nome + ", cargaHoraria=" + cargaHoraria + ", status=" + status + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getSequence() {
		return sequence;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String detalhesEntidade() {
		// TODO Auto-generated method stub
		return null;
	}

}
