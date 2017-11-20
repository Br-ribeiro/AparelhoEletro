import java.util.ArrayList;

public class Aparelho {
	
	private static ArrayList<Aparelho> aparelho = new ArrayList<Aparelho>();
	
	private int serie;
	private String modelo;
	private String marca;
	private String status;
	
	public Aparelho() {}
	
	public Aparelho(int serie,String modelo,String marca, String status) {
		this.serie = serie;
		this.modelo = modelo;
		this.marca = marca;
		this.status = status;
		System.out.println("criou");
	}
	
	
	
	public void cadastrarAparelho(int serie,String modelo,String marca, String status) {
		int cont = 0;

		if(aparelho.size() == 0) {
			aparelho.add(new Aparelho(serie, modelo, marca, status));
		}else {
			for(Aparelho A : aparelho) {
				if(A.getSerie() == serie) {
					cont ++;
					System.out.println("Um aparelho com esse numero de serie já existe");
					break;
				}else if(cont == 0) {
					aparelho.add(new Aparelho(serie, modelo, marca, status));
					break;
				}
			}
		}

	}
	
	
	public void listarAparelho() {
		for(Aparelho A: aparelho) {
			System.out.println("\n A marca do celular é: " + A.getMarca()+
								"\n O modelo é: "+ A.getModelo() + 
								"\n O numero de série é: " + A.getSerie()+
								"\n Seu status é: "+ A.getStatus());
		}
	}
	
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSerie() {
		return serie;
	}

	public void setSerie(int serie) {
		this.serie = serie;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public ArrayList<Aparelho> getAparelho() {
		return aparelho;
	}

	public void setAparelho(ArrayList<Aparelho> aparelho) {
		Aparelho.aparelho = aparelho;
	}
	
}
