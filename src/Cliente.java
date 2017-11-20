public class Cliente {

	private int codiCli;
	private String nome;
	private String endereco;
	
	public Cliente (int codiCli, String nome, String endereco) {
		this.codiCli = codiCli;
		this.nome = nome;
		this.endereco = endereco;
		System.out.println("criou");
	}
	
	public int getCodiCli() {
		return codiCli;
	}

	public void setCodiCli(int codiCli) {
		this.codiCli = codiCli;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
	
	
}

