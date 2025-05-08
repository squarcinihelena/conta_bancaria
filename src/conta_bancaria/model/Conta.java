package conta_bancaria.model;

import java.text.NumberFormat;

public abstract class Conta {

	// Atributos da Classe
	private int numero;
	private int agencia;
	private int tipo;
	private String titular;
	private float saldo;

	// Método Construtor
	public Conta(int numero, int agencia, int tipo, String titular, float saldo) {
		this.numero = numero;
		this.agencia = agencia;
		this.tipo = tipo;
		this.titular = titular;
		this.saldo = saldo;
	}

	public Conta() {}

	// Métodos Get e Set
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	// Métodos Bancários
	public boolean sacar(float valor) {
		if (this.saldo < valor) {
			System.out.println("\nSaldo é insuficiente");
			return false;
		}

		this.saldo -= valor;
		return true;
	}

	public void depositar(float valor) {
		this.saldo += valor;
	}

	// Método para visualizar os dados da conta
	public void visualizar() {

		NumberFormat nfMoeda = NumberFormat.getCurrencyInstance();

		String tipo = "";

		switch (this.tipo) {
		case 1 -> tipo = "Conta Corrente";
		case 2 -> tipo = "Conta Poupança";
		default -> tipo = "Inválido";
		}

		System.out.println("***************************************");
		System.out.println("DADOS DA CONTA                         ");
		System.out.println("***************************************");
		System.out.println("Número da Conta: " + this.numero);
		System.out.println("Número da Agência: " + this.agencia);
		System.out.println("Tipo da Conta: " + tipo);
		System.out.println("Titular da Conta: " + this.titular);
		System.out.println("Saldo da Conta: " + nfMoeda.format(this.saldo));
	}

}