package EntidadeEnum;

public enum TipoAnoLetivo {

	AnoInicial("");
	
	private String tipo;
	
	private TipoAnoLetivo(String tipo) {
		this.tipo = tipo;
	}

	
	@Override
	public String toString() {
		return tipo;
	}
	
}
