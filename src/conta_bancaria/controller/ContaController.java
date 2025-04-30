package conta_bancaria.controller;

import java.util.ArrayList;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

public class ContaController implements ContaRepository {

	// criar a collection arraylist

	private ArrayList<Conta> listaContas = new ArrayList<Conta>();

	int numero = 0;

	@Override
	public void procurarPorNumero(int numero) {
		var conta = buscarNaCollection(numero);

		if (conta != null)
			conta.visualizar();
		else
			System.out.printf("\n A conta numero %d não foi encontrada", numero);

	}

	@Override
	public void listarTodas() { // implementado listar todas
		listaContas.forEach(conta -> conta.visualizar());

	}

	@Override
	public void cadastrar(Conta conta) {

		listaContas.add(conta);
		System.out.println("A Conta foi criada com sucesso!");
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deletar(int numero) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

	}

	// ao inves de passar o numero ele so chamará o metodo agora
	// metodos auxiliares
	public int gerarNumero() {
		return ++numero;
	}

	public Conta buscarNaCollection(int numero) {
		for (var conta : listaContas)
			if (conta.getNumero() == numero)
				return conta;

		return null;

	}
}
