import java.util.Date;

public class Troca {

	private String defeito;
	private Date data;
	private int numeroCompra;
	
	public Troca(String defeito,Date data, int numeroCompra) {
		this.defeito = defeito;
		this.data = data;
		this.numeroCompra = numeroCompra;
		System.out.println("trocou");
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
	
	
	
}
