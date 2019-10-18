package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="usuario")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Usuario.sequence, initialValue = 1, allocationSize = 1)

//lembrar de ser abstrata e usar outras classes

public class Usuario extends Entidade {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 30, nullable = false)
	private Date data_nasc;
	@Column(length = 30, nullable = false)
	private String naturalidade;
	@Column(length = 30, nullable = false)
	private String tipo;
	@Column(length = 30, nullable = false)
	private String login;
	@Column(length = 30, nullable = false)
	private String senha;
	
	
	private static final long serialVersionUID = 1L;

	protected static final String sequence = "pessoa_sequence";
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String detalhesEntidade() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	

}
