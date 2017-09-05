package com.diogo.opet;

import java.util.List;

import com.diogo.opet.conta.Conta;

public class Main
{
    List<Conta> contas;

    Conta contaLogada = null;

    public static void main(String[] args)
    {
        new Main();
    }

    public Main()
    {
        // Entrar com numero da conta para acessar a mesma
        // Escolher entre:
        // - Extrato (Listar ultimas transções)
        // - Saldo (Mostra soma das transações resultando no valor disponivel atual)
        // - Depósito (Criar nova transação de crédito)
        // - Saque (Criar nova transação de débito)
        // - Transferencia (Criar nova transação de débito para essa conta, e uma nova transação de crédito para outra conta)
    }

    public boolean logarConta() {
        // Escrever texto pedindo numero da conta
        // Ler numero inserido
        // Verificar numero com a lista de contas existentes
        // Se numero existir, colocar essa conta encontrada como conta atual e retornar true
        // Se não, retorna false para tentar novamente

        return false;
    }

    public int menuConta() {
        // Escrever opções do menu
        // Ler opção escolhida
        // Tratar cada opção

        return 0;
    }

    public void extrato() {
        // Listar todas as transações dessa conta
    }

    public void saldo() {
        // Listar valor de saldo atual
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
        // Verificar se é uma conta valida, e se não for, pedir novamente ou perguntar se quer sair
        // Escrever texto pedindo valor a ser transferido
        // Ler valor
    }
}