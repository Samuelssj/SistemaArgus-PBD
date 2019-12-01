package EntidadeEnum;

public enum TipoAnoLetivo {
	
	Bibimestre("Bimestre"),trimestre("Trimestre");
	
	private String tipo;
	
	private TipoAnoLetivo(String tipo) {
		this.tipo = tipo;
	}

	
	@Override
	public String toString() {
		return tipo;
	}
	

}
