package EntidadeEnum;

public enum TipodeAcompanhamento {
	
	
	
Acompanhamento("Acompanhamento"),Profissional("Profissional");
	
	private String tipo;
	
	private TipodeAcompanhamento(String tipo) {
		this.tipo = tipo;
	}

	
	@Override
	public String toString() {
		return tipo;
	}
	

}
