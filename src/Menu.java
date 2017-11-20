import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Menu {
	static Scanner ler = new Scanner(System.in);
	static int opcao = 1;
	Aparelho apr;
	ArrayList<Aparelho> aparelho = new ArrayList<Aparelho>();
	ArrayList<Cliente>  cliente  = new ArrayList< Cliente>();
	ArrayList<Compra>   compras  = new ArrayList< Compra >();
	ArrayList<Troca>    trocas   = new ArrayList<  Troca >();
	public static void main(String[] args) throws Exception {

		Menu menu = new Menu();
		menu.lista();

	}

	public void lista() throws Exception {
		while(opcao != 0) {
			System.out.println(" O que deseja fazer?\n"+
					"1 - cadastrar celular\n"+
					"2 - Listar todos os celulares\n"+
					"3 - Castrar usuário\n"+
					"4 - Listar usuário\n"+
					"5 - Comprar\n"+
					"6 - listar compras\n"+
					"7 - Trocar aparelho\n"+
					"8 - Listar trocas\n"+
					"0 - Sair");
			opcao = ler.nextInt();
			escolha(opcao);	
		}
	}

	public void escolha (int escolha) throws Exception {
		switch (escolha) {

		case 1:
			System.out.println("Digite o numero de seríe do celular");
			int serie = ler.nextInt();
			ler.nextLine();
			System.out.println("Digite o modelo");
			String modelo = ler.nextLine();
			System.out.println("Digite a marca");
			String marca = ler.nextLine();
			String status = "novo";
			cadastrarAparelho(serie,modelo,marca, status);
			break;
		case 2:
			listarAparelho();
			break;
		case 3:
			ler.nextLine();
			System.out.println("Insira seu nome");
			String nome = ler.nextLine();
			System.out.println("Insira o seu endereço");
			String endereco = ler.nextLine();
			System.out.println("Insira o codigo do cliente");
			int codicli = ler.nextInt();
			cadastrarCliente(codicli, nome, endereco);
			break;
		case 4:
			listarCliente();
			break;
		case 5:
			listarAparelho();
			System.out.println("Decida qual vc quer comprar");
			System.out.println("Insira o numero de serie do aparelho");
			int numserie = ler.nextInt();
			System.out.println("insira seu codigo");
			int codecli = ler.nextInt();
			ler.nextLine();
			
			System.out.println("Insira a data de compra do aparelho");
			String DataString = ler.nextLine();
			Date data = formataData(DataString);
			
			System.out.println("crie o numero da compra");
			int numCompra = ler.nextInt();
			cadastrarCompra(data, codecli,numserie,numCompra);
			break;
		case 6:
			listarCompra();
			break;
		case 7:
			ler.nextLine();
			System.out.println("insira a data de hoje");
			String dataCompra = ler.nextLine();
			Date dataTroca = formataData(dataCompra);
			System.out.println("Insira o numero da compra para sabermos de qual compra se trata");
			int numeroCompra = ler.nextInt();
			ler.nextLine();
			System.out.println("insira qual foi o defeito");
			String defeito = ler.nextLine();
			cadastrarTroca(dataTroca, numeroCompra, defeito);
			break;
		case 8:
			listarTrocas();
			break;
		case 0:
			System.out.println("saindo flw vlw");
			break;

		default:
			System.out.println("Opção invalida");
			break;

		}
	}
	//=============================================================================

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

	public void cadastrarCompra(Date Data, int codecli, int numeroSerie, int numeroDeCompra) {
		boolean cont = true;
		for(Aparelho A : aparelho) {
			if(A.getSerie() == numeroSerie && A.getStatus().equalsIgnoreCase("novo")) {
				A.setStatus("Vendido");
				compras.add(new Compra(Data,codecli,numeroSerie,numeroDeCompra));
				System.out.println("compra realizada");
				cont = false;
				break;
			}
		}
		if(cont) {
			System.out.println("esse celular não está disponivel ou não existe");
		}
	}
	
	
	
	public void cadastrarTroca(Date data, int numeroCompra, String defeito) {
		float dataCompra = 0;
		float dataTroca  = 0;
		int numeroaparelho = 0;
		for(Compra A : compras) {
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
			for(Aparelho A : aparelho) {
				if(A.getSerie() == numeroaparelho) {
					A.setStatus("Quebrado");
					trocas.add(new Troca(defeito,data,numeroCompra));
					System.out.println("vc está com um celular a menos vá comprar mais para a loja");
				}
			}
			
		}
		//trocas.add(new Troca(defeito,data,numeroCompra));
	}
	
	
	//=======================================================================================
	
	public void listarTrocas() {
		System.out.println("minha quantidade total é: " + trocas.size());
		for(Troca A: trocas) {
			System.out.println("esses são os aparelhos trocados: "+ A.getData() + " || " + A.getDefeito() + " || " + A.getNumeroCompra());
		}
	}
	
	
	public void listarAparelho() {
		System.out.println("minha quantidade total é: " + aparelho.size());
		for(Aparelho A: aparelho) {
			System.out.println("esses são os aparelhos cadastrados: "+ A.getMarca() + " || " + A.getModelo() + " || " + A.getSerie() + "||" + A.getStatus());
		}
	}

	public void listarCliente() {
		System.out.println("minha quantidade total é: " + cliente.size());
		for(Cliente A: cliente) {
			System.out.println("esses são os aparelhos cadastrados: "+ A.getCodiCli() + " || " + A.getNome() + " || " + A.getEndereco());
		}
	}

	public void listarCompra() {
		System.out.println("minha quantidade total é: " + compras.size());
		for(Compra A: compras) {
			System.out.println("esses são os aparelhos cadastrados: "+ A.getCodecli() + " || " + A.getNumeroSerie() + " || " + A.getData());
		}
	}
	
	
	
	public static Date formataData(String data) throws Exception { 
		if (data == null || data.equals(""))
			return null;
        Date date = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date = (java.util.Date)formatter.parse(data);
        } catch (ParseException e) {            
            throw e;
        }
        return date;
	}

}
