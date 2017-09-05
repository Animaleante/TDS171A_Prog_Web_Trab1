package com.diogo.opet;

import java.util.ArrayList;
import java.util.List;

import com.diogo.opet.conta.Conta;
import com.diogo.opet.conta.ContaCorrente;
import com.diogo.opet.conta.ContaPoupanca;
import com.diogo.opet.transacao.Transacao;
import com.diogo.opet.utils.Leitor;

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
		
		if(logarConta()) {
			// Escolher entre:
			// - Extrato (Listar ultimas transções)
			// - Saldo (Mostra soma das transações resultando no valor disponivel atual)
			// - Depósito (Criar nova transação de crédito)
			// - Saque (Criar nova transação de débito)
			// - Transferencia (Criar nova transação de débito para essa conta, e uma nova
			// transação de crédito para outra conta)
			
			int op = -1;
			while(op != 6) {
				op = menuConta();
			}
		}
	}

	public boolean logarConta() {
		int numConta = Leitor.readInt("Entre com o número da conta, ou com 0 para sair: ");
		
		for (int i = 0; i < contas.size(); i++) {
			if(contas.get(i).getNumeroConta() == numConta) {
				contaLogada = contas.get(i);
				break;
			}
		}
		
		// Se numero existir, colocar essa conta encontrada como conta atual e retorna true
		if(contaLogada != null) {
			return true;
		}

		return false;
	}

	public int menuConta() {
		System.out.println(" --- MENU PARA CONTA "+(contaLogada instanceof ContaCorrente ? "CORRENTE" : "POUPANÇA")+" #"+contaLogada.getNumeroConta()+" ---");
		System.out.println("1 - Extrato");
		System.out.println("2 - Saldo");
		System.out.println("3 - Depósito");
		System.out.println("4 - Saque");
		System.out.println("5 - Transferencia");
		System.out.println("6 - Sair");

		int op = Leitor.readInt("Entre com a opção desejada: ");
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
				System.out.println("Opção inválida");
				break;
		}

		return op;
	}

	public void extrato() {
		// Listar todas as transações dessa conta
		List<Transacao> list = contaLogada.getTransacoes();
		
		for (int i = 0; i < list.size(); i++) {
			Transacao transacao = list.get(i);
			transacao.print();
		}
	}

	public void saldo() {
		// Listar valor de saldo atual
		System.out.println("Saldo atual: $" + contaLogada.getSaldo());
	}

	public void deposito() {
		// Escrever texto pedindo valor a ser depositado
		// Ler valor
		// Criar transação do tipo credito com o valor fornecido
		// Adicionar transação a historico de conta
		// Atualizar saldo da conta
	}

	public void saque() {
		// Escrever texto pedindo valor a ser retirado
		// Ler valor
		// Criar transação do tipo debito com o valor fornecido
		// Adicionar transação a historico de conta
		// Atualizar saldo da conta
	}

	public void transferir() {
		// Escrever texto pedindo conta para onde valor sera transferido
		// Ler conta
		// Verificar se é uma conta valida, e se não for, pedir novamente ou perguntar
		// se quer sair
		// Escrever texto pedindo valor a ser transferido
		// Ler valor
		// Criar transação do tipo debito com o valor fornecido
		// Adicionar transação a historico de conta
		// Atualizar saldo da conta
		// Criar transação do tipo credito com o valor fornecido para a outra
		// Adicionar transação a historico de conta
		// Atualizar saldo da conta
	}
}