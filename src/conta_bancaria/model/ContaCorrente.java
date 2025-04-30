package conta_bancaria.model;

import java.text.NumberFormat;

public class ContaCorrente extends Conta {

	private float limite;

	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo);
		this.limite = limite;
	}

	// getters and setters
	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	@Override
	public boolean sacar(float valor) {

		if (this.getSaldo() + this.limite < valor) {
			System.out.println("\nSaldo é insuficiente");
			return false;
		}

		this.setSaldo(this.getSaldo() - valor);
		return true;
	}

	@Override
	public void visualizar() {
		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();
		super.visualizar();
		System.out.println("Limite da conta: " + nfMoeda.format(this.limite));
		System.out.println();
	}
}