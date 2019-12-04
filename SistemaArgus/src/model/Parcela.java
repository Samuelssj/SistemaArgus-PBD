package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "parcela")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Parcela.sequence, initialValue = 1, allocationSize = 1)

public class Parcela extends Entidade {

	@Column(length = 50, nullable = true)
	private String nome; 
	@Column(nullable = true)
	private Double valor; 
	@Column(nullable = true)
	private int quantidade; 
	
private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "parcela_sequence";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Parcela [nome=" + nome + ", valor=" + valor + ", quantidade=" + quantidade + "]";
	}

	@Override
	public String detalhesEntidade() {
		// TODO Auto-generated method stub
		return null;
	}

}
