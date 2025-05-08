package conta_bancaria;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		ContaController contas = new ContaController();

		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		// Dados para teste

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
			System.out.println("            9 - Listar Contas por Titular            ");
			System.out.println("            0 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("──────────────────────༺𓆩༒︎𓆪༻────────────────────────");

			// Prompt: fundo preto + texto ciano bold
			System.out.print(Cores.ANSI_BLACK_BACKGROUND + Cores.TEXT_AURORA + "\nEntre com a opção desejada: "
					+ Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE + "Criar Conta\n\n");

				System.out.println("Digite o número da Agência:");
				agencia = leia.nextInt();

				System.out.println("Digite o nome do Titular:");
				leia.skip("\\R");
				titular = leia.nextLine();

				System.out.println("Digite o tipo da conta (1 - CC | 2 - CP:");
				tipo = leia.nextInt();

				System.out.println("Digite o Saldo inicial da conta:");
				saldo = leia.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Digite o limite da conta:");
					limite = leia.nextFloat();
					contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
				}
				case 2 -> {
					System.out.println("Digite o dia do aniversário da conta:");
					aniversario = leia.nextInt();
					contas.cadastrar(
							new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
				}
				}

				keyPress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE + "Listar todas as Contas\n\n");
				contas.listarTodas();
				keyPress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE + "Consultar dados da Conta - por número\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.procurarPorNumero(numero);

				keyPress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				// Informe o numero da conta
				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				// Checar se a conta existe
				Optional<Conta> conta = contas.buscarNaCollection(numero);

				// Existe?
				if (conta.isPresent()) {

					// Atualizar o dados
					System.out.println("Digite o número da Agência:");
					agencia = leia.nextInt();

					System.out.println("Digite o nome do Titular:");
					leia.skip("\\R");
					titular = leia.nextLine();

					// Recuperar o tipo da conta
					tipo = conta.get().getTipo();

					System.out.println("Digite o novo Saldo da conta:");
					saldo = leia.nextFloat();

					// Identificar o tipo
					switch (tipo) {
					case 1 -> { // Se for Conta Corrente
						System.out.println("Digite o limite da conta:");
						limite = leia.nextFloat();
						contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
					}
					case 2 -> { // Se for Conta Poupança
						System.out.println("Digite o dia do aniversário da conta:");
						aniversario = leia.nextInt();
						contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
					}
					}
				} else // Caso não exista a conta
					System.out.printf("\n A conta número %d não existe!", numero);

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				contas.deletar(numero);

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				System.out.println("Digite o valor do saque: ");
				valor = leia.nextFloat();

				contas.sacar(numero, valor);

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				System.out.println("Digite o número da conta: ");
				numero = leia.nextInt();

				System.out.println("Digite o valor do depósito: ");
				valor = leia.nextFloat();

				contas.depositar(numero, valor);

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				System.out.println("Digite o número da conta de origem: ");
				numero = leia.nextInt();

				System.out.println("Digite o número da conta de destino: ");
				numeroDestino = leia.nextInt();

				System.out.println("Digite o valor do depósito: ");
				valor = leia.nextFloat();

				contas.transferir(numero, numeroDestino, valor);

				keyPress();
				break;
			case 9:
				System.out.println(Cores.TEXT_WHITE + "Consultar Contas por Titular\n\n");

				System.out.println("Digite o nome do titular: ");
				leia.skip("\\R");
				titular = leia.nextLine();

				contas.listarPorTitular(titular);

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
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
	        System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
	        
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