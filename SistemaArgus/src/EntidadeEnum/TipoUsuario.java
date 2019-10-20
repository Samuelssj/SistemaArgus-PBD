package EntidadeEnum;

public enum TipoUsuario {
	
	Aluno("Aluno"), Direção("Direção"), Pedagogo("Pedagogo"), Professor("Professor"), Responsável("Responsável"),
	Secretária("Secretária");
	
	private String tipo;

	private TipoUsuario(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return tipo;
	}
	

}
