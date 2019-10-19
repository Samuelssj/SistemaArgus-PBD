package EntidadeEnum;

public enum TipoUsuario {
	
	ALUNO("aluno"), PROFESSOR("professor"), PEDAGOGO("pedagogo"), DIRECAO("direção"), RESPONSAVEL("responsavel"),
	SECRETARIA("secretaria");
	
	private String tipo;

	private TipoUsuario(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return tipo;
	}
	

}
