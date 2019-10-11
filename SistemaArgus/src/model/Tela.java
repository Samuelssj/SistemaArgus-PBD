package model;

public enum Tela {

		CADPROFESSOR("cadProfessor"),CADRESPONSAVEL("cadResponsavel");
	
	
	private String tela, caminho;
	private Tela(String tela, String caminho) {
		this.tela = tela;
		this.caminho = caminho;
	}
	private Tela(String caminho) {
		this.caminho = caminho;
		this.tela = caminho;
	}
	
	public String getCaminho() {
		return caminho;
	}
	
	@Override
	public String toString() {
		return tela;
	}
	

}
