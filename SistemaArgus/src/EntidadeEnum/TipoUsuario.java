package EntidadeEnum;

public enum TipoUsuario {
	
	ALUNO("Aluno"), DIRECAO("Direção"), PEDAGOGO("Pedagogo"), PROFESSOR("Professor"), RESPONSAVEL("Responsavel"),
	SECRETARIA("Secretária");
	
	private String tipo;

	private TipoUsuario(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return tipo;
	}
	

}
