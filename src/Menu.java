import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Menu {

	static Scanner ler = new Scanner(System.in);
	static int opcao = 1;

	Aparelho aparelho = new Aparelho();
	Cliente   cliente = new Cliente();;
	Compra     compra = new Compra();
	Troca       troca = new Troca();
//====================================================================================================	
	public static void main(String[] args) throws Exception {

		Menu menu = new Menu();


		menu.lista();
		System.out.println("fim do programa");


	}
//====================================================================================================	
	public void lista() throws Exception {
		while(opcao != 0) {
			System.out.println(" \n O que deseja fazer?\n"+
					"1 - cadastrar celular\n"+
					"2 - Listar todos os celulares\n"+
					"3 - Castrar usu�rio\n"+
					"4 - Listar usu�rio\n"+
					"5 - Comprar\n"+
					"6 - listar compras\n"+
					"7 - Trocar aparelho\n"+
					"8 - Listar trocas\n"+
					"0 - Sair");
			opcao = ler.nextInt();
			escolha(opcao);	
		}
	}
//====================================================================================================	
	public void escolha (int escolha) throws Exception {
		switch (escolha) {

		case 1:
			System.out.println("Digite o numero de ser�e do celular");
			int serie = ler.nextInt();

			ler.nextLine();
			System.out.println("Digite o modelo");
			String modelo = ler.nextLine();

			System.out.println("Digite a marca");
			String marca = ler.nextLine();

			String status = "novo";

			aparelho.cadastrarAparelho(serie,modelo,marca, status);
			break;
		case 2:
			aparelho.listarAparelho();
			break;
		case 3:

			ler.nextLine();
			System.out.println("Insira seu nome");
			String nome = ler.nextLine();

			System.out.println("Insira o seu endere�o");
			String endereco = ler.nextLine();

			System.out.println("Insira o codigo do cliente");
			int codicli = ler.nextInt();

			cliente.cadastrarCliente(codicli, nome, endereco);
			break;
		case 4:
			cliente.listarCliente();
			break;
		case 5:
			aparelho.listarAparelho();

			System.out.println("Decida qual vc quer comprar\n");
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

			compra.cadastrarCompra(data, codecli,numserie,numCompra);

			break;
		case 6:
			compra.listarCompra();
			break;
		case 7:
			ler.nextLine();
			System.out.println("insira a data de hoje");
			String dataCompra = ler.nextLine();
			Date dataTroca = formataData(dataCompra);

			System.out.println("Insira o numero da compra para sabermos de qual compra se trata");
			int numeroCompra = ler.nextInt();
			
			System.out.println("insira seu codigo de cliente");
			int codcli = ler.nextInt();

			ler.nextLine();
			System.out.println("insira qual foi o defeito");
			String defeito = ler.nextLine();

			troca.cadastrarTroca(dataTroca, numeroCompra, defeito,codcli);

			break;
		case 8:
			troca.listarTrocas();
			break;
		case 0:
			System.out.println("Va para a parte da prova agora");
			listaProva();
			break;

		default:
			System.out.println("Op��o invalida");
			break;

		}
	}
//====================================================================================================		
	public void listaProva() throws Exception {

		opcao = 1;
		while(opcao != 0) {
			System.out.println(" \n O que deseja fazer?\n"+
					"1 - listar aparelhos disponiveis\n"+
					"2 - Rela��o de aparelhos com defeito\n"+
					"3 - clientes que nunca tiveram problema\n"+
					"4 - voltar a cadastrar as coisas\n"+
					"0 - Sair");
			opcao = ler.nextInt();	
			escolhaProva(opcao);
		}

	}
//====================================================================================================	
	public void escolhaProva(int opcao) throws Exception {
		switch (opcao) {
		case 1:
			aparelhosDisponiveis();
			break;
		case 2:
			aparelhosComDefeito();
			break;
		case 3:
			clientesLimpos();
			break;
		case 4 :
			lista();
		case 0 :
			break;
		default:
			System.out.println("essa op��o n�o � valida");
			break;
		}

	}
	
//====================================================================================================
	
	public int Clientecod(){
		
		for(Compra C: compra.getCompras()) {
			int cont = 0;
			for(Troca T: troca.getTrocas()) {
				if(C.getCodecli() == T.getClienteComprador()) {
					cont = 1;
				}
				
			}
			if(cont == 0) {
				//System.out.println("os clientes limpos s�o: "+ C.getNome());
				return C.getCodecli();
			}
		}
		return 0;
	}
	
	
	public void clientesLimpos() {
		for(Cliente C: cliente.getCliente()){
			if(C.getCodiCli() == Clientecod()){
				System.out.println("os clientes limpos s�o: "+ C.getNome());
			}
		}
		
	}
//====================================================================================================	
	public int clienteTrocas() {
		for(Troca T: troca.getTrocas()) {
			return T.getClienteComprador();
		}
		return 0;
	}
//====================================================================================================	
	public void aparelhosComDefeito() {
		for(Troca A: troca.getTrocas()) {
			System.out.println("\n o nome do usu�rio que trocou �: "+ pesqeuisarNome(A.getClienteComprador())+
								"\n Esse aparelho foi trocado no dia: " + A.getData()+
								"\n Por causa do defeito: "+ A.getDefeito());
			
		}
	}
//====================================================================================================
	public String pesqeuisarNome( int codcli) {
		for(Cliente C: cliente.getCliente()) {
			if(codcli == C.getCodiCli()) {
				return C.getNome();
			}
		}
		return null;
	}
//====================================================================================================
	public void aparelhosDisponiveis() {
		
		for(Aparelho A: aparelho.getAparelho()) {
			if(A.getStatus().equalsIgnoreCase("novo")) {
				System.out.println("\n A marca do celular �: " + A.getMarca()+
								"\n O modelo �: "+ A.getModelo() + 
								"\n O numero de s�rie �: " + A.getSerie());
			}
		}
	}
//====================================================================================================
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
//====================================================================================================
}
