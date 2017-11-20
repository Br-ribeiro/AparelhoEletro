import java.util.ArrayList;

public class Compra {
	
	private String Data;
	private int codecli;
	private int numeroSerie;
	
	public Compra (String Data, int codecli, int numeroSerie) {
		this.Data = Data;
		this.codecli = codecli;
		this.numeroSerie = numeroSerie;
	}
	
	public String getData() {
		return Data;
	}
	public void setData(String data) {
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


