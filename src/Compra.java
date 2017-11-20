import java.util.Date;

public class Compra {
	
	private Date Data;
	private int codecli;
	private int numeroSerie;
	private int numeroDeCompra;
	
	public Compra (Date Data, int codecli, int numeroSerie, int numeroDeCompra) {
		this.Data = Data;
		this.codecli = codecli;
		this.numeroSerie = numeroSerie;
		this.numeroDeCompra = numeroDeCompra;
	}
	
	public int getNumeroDeCompra() {
		return numeroDeCompra;
	}

	public void setNumeroDeCompra(int numeroDeCompra) {
		this.numeroDeCompra = numeroDeCompra;
	}

	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	public int getCodecli() {
		return codecli;
	}
	public void setCodecli(int codecli) {
		this.codecli = codecli;
	}
	public int getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	
	

}


