import java.util.ArrayList;
import java.util.Date;

public class Compra {
	
	private static ArrayList<Compra> compras  = new ArrayList< Compra >();

	Aparelho aparelhoClass = new Aparelho();
	
	private Date Data;
	private int codecli;
	private int numeroSerie;
	private int numeroDeCompra;
	
	public Compra () {}
	
	
	public Compra (Date Data, int codecli, int numeroSerie, int numeroDeCompra) {
		this.Data = Data;
		this.codecli = codecli;
		this.numeroSerie = numeroSerie;
		this.numeroDeCompra = numeroDeCompra;
	}
	
	
	public void cadastrarCompra(Date Data, int codecli, int numeroSerie, int numeroDeCompra) {
		boolean cont = true;
		for(Aparelho A : aparelhoClass.getAparelho()) {
			if(A.getAparelho().size() == 0 && A.getStatus().equalsIgnoreCase("novo") ){
				A.setStatus("Vendido");
				compras.add(new Compra(Data,codecli,numeroSerie,numeroDeCompra));
				System.out.println("primeira compra realizada");
				break;
			}else {
				boolean existecompra = verificarCompra(numeroDeCompra);
					if(A.getSerie() == numeroSerie && A.getStatus().equalsIgnoreCase("novo") && existecompra) {
						A.setStatus("Vendido");
						compras.add(new Compra(Data,codecli,numeroSerie,numeroDeCompra));
						System.out.println("compra realizada");
						cont = false;
						break;
					}
				}
		     }
		if(cont) {
			System.out.println("esse celular não está disponivel ou não existe");
		}
	}
	
	public boolean verificarCompra( int numeroCompraVerificar){
		
		for(Compra C : compras){
			if(C.getNumeroDeCompra() == numeroCompraVerificar){
				System.out.println("Esse Numero de compra já existe");
				return false;
			}
		}
		return true;
	}
	
	public void listarCompra() {
		for(Compra A: compras) {
			System.out.println("\n O codigo do cliente que comprou é: "+ A.getCodecli() + 
								"\n O numero de Série do aparelho comprado é: " + A.getNumeroSerie() + 
								"\n Esse aparelho foi comprado no dia: " + A.getData());
		}
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
	
	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		Compra.compras = compras;
	}

}


