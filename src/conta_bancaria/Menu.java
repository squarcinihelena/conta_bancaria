package conta_bancaria;

import java.io.IOException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

		// DADOS PARA TESTE
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000.00f, 100.00f);
		contas.cadastrar(cc1);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 123, 2, "Maria da Silva", 1000.00f, 12);
		contas.cadastrar(cp1);

		while (true) {

			// Cabeçalho: fundo preto + texto azul ciano
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA
					+ "───────────────────────༺𓆩༒︎𓆪༻───────────────────────");
			System.out.println("                                                     ");
			System.out.println("                  ✧ BANCO AURORA ✧                  ");
			System.out.println("                                                     ");
			System.out.println("───────────────────────༺𓆩༒︎𓆪༻───────────────────────");

			// Corpo do menu: fundo azul petróleo escuro + texto branco
			System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA
					+ "                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Número              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("──────────────────────༺𓆩༒︎𓆪༻────────────────────────");

			// Prompt: fundo preto + texto ciano bold
			System.out.print(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "\nEntre com a opção desejada: "
					+ Cores.TEXT_RESET);

			opcao = sc.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA
						+ "\n✧ Banco Aurora ✧ \nOnde suas finanças brilham como a aurora boreal.");
				sobre();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "Criar Conta\n\n");

				System.out.println("Digite o número da Agência: ");
				agencia = sc.nextInt();

				System.out.println("Digite o nome do Titular: ");
				sc.skip("\\R");
				titular = sc.nextLine();

				System.out.println("Digite o tipo da conta (1 - CC | 2 - CP:");
				tipo = sc.nextInt();

				System.out.println("Digite o Saldo inicial da conta: ");
				saldo = sc.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite da conta: ");
					limite = sc.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}

				case 2 -> {
					System.out.println("Digite o aniversário da conta: ");
					aniversario = sc.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}

				}
				keyPress();
				break;

			case 2:
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;

			case 3:
				System.out.println(
						Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "Consultar dados da Conta - por número\n\n");

				System.out.println("Digite o numero da conta: ");
				numero = sc.nextInt();

				contas.procurarPorNumero(numero);
				keyPress();
				break;

			case 4:
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "Atualizar dados da Conta\n\n");
				keyPress();
				break;

			case 5:
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "Apagar a Conta\n\n");
				keyPress();
				break;

			case 6:
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "Saque\n\n");
				keyPress();
				break;

			case 7:
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "Depósito\n\n");
				keyPress();
				break;

			case 8:
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "Transferência entre Contas\n\n");
				keyPress();
				break;

			default:
				System.out.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "\nOpção Inválida!\n");
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

	public static void keyPress() {
		try {
			System.out
					.println(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "\n\nPressione Enter para Continuar...");

			// Lê apenas a tecla Enter e ignora outras teclas
			int input;
			while ((input = System.in.read()) != '\n') {
				// Ignora qualquer outra tecla diferente do Enter
				if (input == -1) {
					throw new IOException("Entrada encerrada inesperadamente");
				}
			}

		} catch (IOException e) {
			System.err.println("Erro de entrada/saída: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Ocorreu um erro ao processar a entrada: " + e.getMessage());
		}
	}

}