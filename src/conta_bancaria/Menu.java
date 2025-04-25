package conta_bancaria;

import java.util.Scanner;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int opcao;

		while (true) {

			System.out.println(Cores.TEXT_AURORA + Cores.ANSI_BLACK_BACKGROUND
					+ "───────────────────────༺𓆩༒︎𓆪༻────────────────────────");
			System.out.println("                                                      ");
			System.out.println("                  ✧ BANCO AURORA ✧                   ");
			System.out.println("                                                      ");
			System.out.println("───────────────────────༺𓆩༒︎𓆪༻────────────────────────");
			System.out.println("                                                      ");
			System.out.println("            1 - Criar Conta                           ");
			System.out.println("            2 - Listar todas as Contas                ");
			System.out.println("            3 - Buscar Conta por Numero               ");
			System.out.println("            4 - Atualizar Dados da Conta              ");
			System.out.println("            5 - Apagar Conta                          ");
			System.out.println("            6 - Sacar                                 ");
			System.out.println("            7 - Depositar                             ");
			System.out.println("            8 - Transferir valores entre Contas       ");
			System.out.println("            9 - Sair                                  ");
			System.out.println("                                                      ");
			System.out.println("───────────────────────༺𓆩༒︎𓆪༻────────────────────────");
			System.out.println("Entre com a opção desejada:                           ");
			System.out.println("                                                      " + Cores.TEXT_RESET);

			opcao = sc.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_AURORA + Cores.ANSI_BLACK_BACKGROUND + "\n✧ Banco Aurora ✧ \nOnde suas finanças brilham como a aurora boreal.");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
				case 1:
					System.out.println(Cores.TEXT_AURORA + "Criar Conta\n\n");
					break;
				case 2:
					System.out.println(Cores.TEXT_AURORA + "Listar todas as Contas\n\n");
					break;
				case 3:
					System.out.println(Cores.TEXT_AURORA + "Consultar dados da Conta - por número\n\n");
					break;
				case 4:
					System.out.println(Cores.TEXT_AURORA + "Atualizar dados da Conta\n\n");
					break;
				case 5:
					System.out.println(Cores.TEXT_AURORA + "Apagar a Conta\n\n");
					break;
				case 6:
					System.out.println(Cores.TEXT_AURORA + "Saque\n\n");
					break;
				case 7:
					System.out.println(Cores.TEXT_AURORA + "Depósito\n\n");
					break;
				case 8:
					System.out.println(Cores.TEXT_AURORA + "Transferência entre Contas\n\n");
					break;
				default:
					System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
					break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n───────────────────────༺𓆩༒︎𓆪༻────────────────────────");
		System.out.println("Projeto Desenvolvido por: Maria Helena Squarcini      ");
		System.out.println("Maria Helena - maria.helen@live.com                   ");
		System.out.println("github.com/squarcinihelena                            ");
		System.out.println("───────────────────────༺𓆩༒︎𓆪༻────────────────────────");
	}
}
