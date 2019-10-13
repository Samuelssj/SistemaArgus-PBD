package EntidadeEnum;

public enum TipoPessoa {
	
	ALUNO("aluno"), PROFESSOR("professor"), PEDAGOGO("pedagogo"), DIRECAO("direcao"), OUTROS("outros");
	
	private String tipo;

	private TipoPessoa(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return tipo;
	}
	

}
