package model;

public class UsuarioTabAdapter  extends Entidade{

	private Integer id;
	private String nome;
	private String cpf;
//	private String data_nascimento;
//	private String rua;
//	private String bairro;
//	private String numero;
	private String cep;
	private String cidade;

	
	
	
	public Integer getId() {
		return id;
	}

	
	public String getCidade() {
		return cidade;
	}


	public void setCidade(String cidade) {
		this.cidade = cidade;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	@Override
	public String detalhesEntidade() {
		// TODO Auto-generated method stub
		return null;
	}

//	public String getData_nascimento() {
//		return data_nascimento;
//	}
//
//	public void setData_nascimento(String data_nascimento) {
//		this.data_nascimento = data_nascimento;
//	}
//
//	public String getRua() {
//		return rua;
//	}
//
//	public void setRua(String rua) {
//		this.rua = rua;
//	}
//
//	public String getBairro() {
//		return bairro;
//	}
//
//	public void setBairro(String bairro) {
//		this.bairro = bairro;
//	}
//
//	public String getNumero() {
//		return numero;
//	}
//
//	public void setNumero(String numero) {
//		this.numero = numero;
//	}



}
