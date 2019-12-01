package EntidadeEnum;

public enum TipoCurriculo {

	AnoI1("EI-AI-1º"),AnoI2("EI-AI-2º a 5º"),AnoF1("EF-AF-6º a 8º"),AnoF2("EF-AF-9º"),AnoM("EM-1º"),AnoM2("EM-2º"),AnoM3("EM-3º");
	
	private String tipo;
	
	private TipoCurriculo(String tipo) {
		this.tipo = tipo;
	}

	
	@Override
	public String toString() {
		return tipo;
	}
	
}
