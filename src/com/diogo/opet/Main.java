package com.diogo.opet;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.diogo.opet.conta.Conta;
import com.diogo.opet.conta.ContaCorrente;
import com.diogo.opet.conta.ContaPoupanca;
import com.diogo.opet.transacao.Transacao;
import com.diogo.opet.utils.Leitor;

import exceptions.FundosInsuficientesException;

public class Main {
	List<Conta> contas;

	Conta contaLogada = null;

	public static void main(String[] args) {
		new Main();
	}

	public Main() {
		
		contas = new ArrayList<Conta>();
		contas.add(new ContaCorrente(123, 512.24));
		contas.add(new ContaPoupanca(456, 2.46));
		contas.add(new ContaCorrente(111, 1327.52));
		
		while(mainLoop()) {}
		
		System.out.println("Aplica��o finalizada.");
	}
	
	public boolean mainLoop() {
		if(logarConta()) {
			// Escolher entre:
			// - Extrato (Listar ultimas trans��es)
			// - Saldo (Mostra soma das transa��es resultando no valor disponivel atual)
			// - Dep�sito (Criar nova transa��o de cr�dito)
			// - Saque (Criar nova transa��o de d�bito)
			// - Transferencia (Criar nova transa��o de d�bito para essa conta, e uma nova
			// transa��o de cr�dito para outra conta)
			
			int op = -1;
			while(op != 6) {
				op = menuConta();
			}
			
			String sOp = Leitor.readString("Deseja entrar com uma nova conta (S / N)? ");
			if(sOp.equalsIgnoreCase("s"))
				return true;
		}
		
		return false;
	}

	public boolean logarConta() {
		long numConta = Leitor.readLong("Entre com o n�mero da conta, ou com 0 para sair: ");
		
		contaLogada = pegarConta(numConta);
		
		if(contaLogada != null) {
			return true;
		}

		return false;
	}

	public int menuConta() {
		System.out.println(" --- MENU PARA CONTA "+(contaLogada instanceof ContaCorrente ? "CORRENTE" : "POUPAN�A")+" #"+contaLogada.getNumeroConta()+" ---");
		System.out.println("1 - Extrato");
		System.out.println("2 - Saldo");
		System.out.println("3 - Dep�sito");
		System.out.println("4 - Saque");
		System.out.println("5 - Transferencia");
		System.out.println("6 - Sair");

		int op = Leitor.readInt("Entre com a op��o desejada: ");
		switch (op) {
			case 1:
				extrato();
				break;
			case 2:
				saldo();
				break;
			case 3:
				deposito();
				break;
			case 4:
				saque();
				break;
			case 5:
				transferir();
				break;
			case 6:
				break;
			default:
				System.out.println("Op��o inv�lida");
				break;
		}

		return op;
	}

	public void extrato() {
		// Listar todas as transa��es dessa conta
		List<Transacao> list = contaLogada.getTransacoes();
		
		for (int i = 0; i < list.size(); i++) {
			Transacao transacao = list.get(i);
			transacao.print();
		}
		
		System.out.println("");
		
		saldo();
	}

	public void saldo() {
		// Listar valor de saldo atual
		DecimalFormat df = new DecimalFormat("#.00");
		System.out.println("Saldo atual: $" + df.format(contaLogada.getSaldo()));
	}

	public void deposito() {
		// Escrever texto pedindo valor a ser depositado
		// Ler valor
		double val = Leitor.readDouble("Entre com o valor a ser depositado: ");
		
		contaLogada.deposito(val);
		
		saldo();
	}

	public void saque() {
		// Escrever texto pedindo valor a ser retirado
		// Ler valor
		double val = Leitor.readDouble("Entre com o valor a ser sacado: ");
		
		try {
			contaLogada.saque(val);
			
			saldo();
		} catch (FundosInsuficientesException e) {
			//e.printStackTrace();
			System.out.println("N�o foi poss�vel realizar essa opera��o. Voc� n�o tem saldo suficiente em sua conta.");
		}
	}

	public void transferir() {
		// Escrever texto pedindo conta para onde valor sera transferido
		// Ler conta
		long numContaDestino = Leitor.readLong("Entre com a conta que vai receber a transfer�ncia: ");
		Conta contaDestino = pegarConta(numContaDestino);
		// Verificar se � uma conta valida, e se n�o for, pedir novamente ou perguntar
		// se quer sair
		if(contaDestino == null) {
			String op = Leitor.readString("N�o existe uma conta cadastrada com esse n�mero. Deseja entrar com outra conta (S / N)? ");
			if(op.equalsIgnoreCase("s")) {
				transferir();
			}
		} else {
			double val = Leitor.readDouble("Entre com o valor a ser transferido: ");
			try {
				contaLogada.saqueTransferencia(val);
				
				contaDestino.depositoTransferencia(val);
				
				System.out.println("Transfer�ncia realizada com sucesso!");
				
				saldo();
			} catch (FundosInsuficientesException e) {
				//e.printStackTrace();
				System.out.println("N�o foi poss�vel realizar essa opera��o. Voc� n�o tem saldo suficiente em sua conta.");
			}
		}
	}
	
	public Conta pegarConta(long numConta) {
		for (int i = 0; i < contas.size(); i++) {
			if(contas.get(i).getNumeroConta() == numConta) {
				return contas.get(i);
			}
		}
		
		return null;
	}
}