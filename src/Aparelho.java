public class Aparelho {

	private int serie;
	private String modelo;
	private String marca;
	private String status;
	
	public Aparelho(int serie,String modelo,String marca, String status) {
		this.serie = serie;
		this.modelo = modelo;
		this.marca = marca;
		this.status = status;
		System.out.println("criou");
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
	
}
