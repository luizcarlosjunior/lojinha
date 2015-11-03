package ENUM;

public enum EnumGenero {

	M ("Maculino"),
	F ("Feminino");
	
	private String nome;

	public String getNome() {
		return nome;
	}

	private EnumGenero(String nome) {
		this.nome = nome;
	}

}
