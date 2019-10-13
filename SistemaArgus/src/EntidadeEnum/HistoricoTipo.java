package EntidadeEnum;

public enum HistoricoTipo {

	INSERT("Insert","INSERT"), UPDATE("Update","UPDATE"), DELETE("Delete","DELETE"), TODOS("Todos","");
	
	private String tipo, valor;

	private HistoricoTipo(String tipo, String valor) {
		this.tipo = tipo;
		this.valor = valor;
	}
	
	public String getValor() {
		return valor;
	}
	
	@Override
	public String toString() {
		return tipo;
	}
}
