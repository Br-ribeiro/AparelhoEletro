import java.util.ArrayList;

public class Cliente {
	
	private static ArrayList<Cliente>  cliente  = new ArrayList< Cliente>();
	

	private int codiCli;
	private String nome;
	private String endereco;
	
	public Cliente () {}
	
	public Cliente (int codiCli, String nome, String endereco) {
		this.codiCli = codiCli;
		this.nome = nome;
		this.endereco = endereco;
		System.out.println("criou");
	}
	
	public void cadastrarCliente(int codecli,String nome,String endereco) {

		int cont = 0;

		if(cliente.size() == 0) {
			cliente.add(new Cliente(codecli,nome,endereco));
		}else {
			for(Cliente A : cliente) {
				if(A.getCodiCli() == codecli) {
					cont ++;
					System.out.println("Um cliente com esse codigo já existe");
					break;
				}else if(cont == 0) {
					cliente.add(new Cliente(codecli,nome,endereco));
					break;
				}
			}
		}
	}
	
	
	public void listarCliente() {
		for(Cliente A: cliente) {
			System.out.println("\n Nome do cliente " + A.getNome()+
								"\n O codigo dele é: "+ A.getCodiCli() + 
								"\n O endereço é o: " + A.getEndereco());
		}
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
	public static ArrayList<Cliente> getCliente() {
		return cliente;
	}

	public static void setCliente(ArrayList<Cliente> cliente) {
		Cliente.cliente = cliente;
	}

}

