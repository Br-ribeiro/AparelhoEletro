import java.util.ArrayList;
import java.util.Date;

public class Troca {

	private static ArrayList<Troca>trocas = new ArrayList<Troca>();
	
	
	Compra compraClass = new Compra();
	Aparelho aparelhoClass = new Aparelho();
	
	private String defeito;
	private Date data;
	private int numeroCompra;
	private int clienteComprador;
	

	float dataCompra = 0;
	float dataTroca  = 0;
	int numeroaparelho = 0;
	
	
	public Troca() {}
	
	public Troca(String defeito,Date data, int numeroCompra, int clienteComprador) {
		this.defeito = defeito;
		this.data = data;
		this.numeroCompra = numeroCompra;
		this.clienteComprador = clienteComprador;
		System.out.println("trocou");
	}
	
	public void cadastrarTroca(Date data, int numeroCompra, String defeito, int codcli) {
		
		for(Compra A : compraClass.getCompras()) {
			if(A.getNumeroDeCompra() == numeroCompra) {
				dataCompra = A.getData().getTime();
				numeroaparelho = A.getNumeroSerie();
				System.out.println("entrou");
			}
		}
		dataTroca = data.getTime();
		float dias = ((dataTroca - dataCompra) / 86400000L);
		System.out.println("dias "+ dias);
		if(dias<=365) {
			for(Aparelho A : aparelhoClass.getAparelho()) {
				if(A.getSerie() == numeroaparelho) {
					A.setStatus("Quebrado");
					trocas.add(new Troca(defeito,data,numeroCompra,codcli));
					System.out.println("vc está com um celular a menos vá comprar mais para a loja");
				}
			}	
		}
	}
	
	public void listarTrocas() {
		for(Troca A: trocas) {
			System.out.println("\n Esse aparelho foi trocado no dia: " + A.getData()+
								"\n Por causa do defeito: "+ A.getDefeito() + 
								"\n O numero de compra dele é o: " + A.getNumeroCompra());
		}
	}

	public int getNumeroCompra() {
		return numeroCompra;
	}

	public void setNumeroCompra(int numeroCompra) {
		this.numeroCompra = numeroCompra;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	public int getClienteComprador() {
		return clienteComprador;
	}

	public void setClienteComprador(int clienteComprador) {
		this.clienteComprador = clienteComprador;
	}
	public static ArrayList<Troca> getTrocas() {
		return trocas;
	}

	public static void setTrocas(ArrayList<Troca> trocas) {
		Troca.trocas = trocas;
	}

	
}
