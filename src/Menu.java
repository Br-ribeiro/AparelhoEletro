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
	
	public static void main(String[] args) throws Exception {

		Menu menu = new Menu();
		menu.lista();

	}

	public void lista() throws Exception {
		while(opcao != 0) {
			System.out.println(" \n O que deseja fazer?\n"+
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
			
			aparelho.cadastrarAparelho(serie,modelo,marca, status);
			break;
		case 2:
			aparelho.listarAparelho();
			break;
		case 3:
			
			ler.nextLine();
			System.out.println("Insira seu nome");
			String nome = ler.nextLine();
			
			System.out.println("Insira o seu endereço");
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
			
			ler.nextLine();
			System.out.println("insira qual foi o defeito");
			String defeito = ler.nextLine();
			
			troca.cadastrarTroca(dataTroca, numeroCompra, defeito);
			
			break;
		case 8:
			troca.listarTrocas();
			break;
		case 0:
			System.out.println("saindo flw vlw");
			break;

		default:
			System.out.println("Opção invalida");
			break;

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
