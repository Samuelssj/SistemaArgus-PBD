package model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import EntidadeEnum.TipoUsuario;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "usuario")
@SequenceGenerator(name = Entidade.sequence, sequenceName = Usuario.sequence, initialValue = 1, allocationSize = 1)


public class  Usuario extends Entidade {

	@Column(length = 50, nullable = false)
	private String nome;
	@Column(length = 30, nullable = false)
	private LocalDate data_nasc;
	@Column(length = 30, nullable = false)
	private String naturalidade;
	@Column(length = 30, nullable = false)
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipo;
	@Column(length = 30, nullable = false)
	private String login;
	@Column(length = 30, nullable = false)
	private String senha;


	@Override
	public String toString() {
		return "Usuario [nome=" + nome + ", data_nasc=" + data_nasc + ", naturalidade=" + naturalidade + ", tipo="
				+ tipo + ", login=" + login + ", senha=" + senha + ", endereco=" + endereco + "]";
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco")
	private Endereco endereco; //id_endereco INTEGER REFERENCES ENDERECO(id)
	
	private static final long serialVersionUID = 1L;
	
	protected static final String sequence = "usuario_sequence";
	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public LocalDate getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(LocalDate localDate) {
		this.data_nasc = localDate;
	}

	public String getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
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


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	@Override
	public String detalhesEntidade() {
		// TODO Auto-generated method stub
		return "Cargo: " + nome + "\ntipo: " + nome;
	}

}
