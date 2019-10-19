package model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "usuario")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Usuario.sequence, initialValue = 1, allocationSize = 1)


public abstract class Usuario extends Entidade {

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

	

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getSequence() {
		return sequence;
	}

	private static final long serialVersionUID = 1L;

	protected static final String sequence = "usuario_sequence";

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String detalhesEntidade() {
		// TODO Auto-generated method stub
		return "Nome: " + nome + "\nLogin: " + login;
	}

}
