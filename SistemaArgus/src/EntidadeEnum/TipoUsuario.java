package EntidadeEnum;

public enum TipoUsuario {
	
	Administrador("Administrador"), Aluno("Aluno"), Direcao("Direção"), Pedagogo("Pedagogo"), Professor("Professor"),
	Secretaria("Secretária");
	
	private String tipo;

	private TipoUsuario(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return tipo;
	}
	

}
