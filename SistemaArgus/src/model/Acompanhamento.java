package model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "acompanhamento")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Acompanhamento.sequence, initialValue = 1, allocationSize = 1)

public class Acompanhamento extends Entidade {

	
	@Column(length = 60, nullable = true)
	private String nome; 
	@Column(length = 60, nullable = true)
	private LocalDate data;
	@Column(length = 60, nullable = true)
	private int secao; 
	@Column(length = 60, nullable = true)
	private String TipoDeAcompanhamento; 
	@Column(length = 500, nullable = true)
	private String relatorio; 
	
	
	@ManyToOne
	@JoinColumn(name = "Id_usuario")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "pedagogo")
	private Pedagogo pedagogo;
	
	
	
	
private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "acompanhamento_sequence";
	
	



	@Override
	public String toString() {
		return relatorio;
	}



	public String getNome() {
		return nome;
	}






	public void setNome(String nome) {
		this.nome = nome;
	}



















	public LocalDate getData() {
		return data;
	}



	public void setData(LocalDate data) {
		this.data = data;
	}



	public int getSecao() {
		return secao;
	}






	public void setSecao(int secao) {
		this.secao = secao;
	}













	public String getTipoDeAcompanhamento() {
		return TipoDeAcompanhamento;
	}



	public void setTipoDeAcompanhamento(String tipoDeAcompanhamento) {
		TipoDeAcompanhamento = tipoDeAcompanhamento;
	}



	public String getRelatorio() {
		return relatorio;
	}



	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
