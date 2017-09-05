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
        // - Extrato (Listar ultimas trans��es)
        // - Saldo (Mostra soma das transa��es resultando no valor disponivel atual)
        // - Dep�sito (Criar nova transa��o de cr�dito)
        // - Saque (Criar nova transa��o de d�bito)
        // - Transferencia (Criar nova transa��o de d�bito para essa conta, e uma nova transa��o de cr�dito para outra conta)
    }

    public boolean logarConta() {
        // Escrever texto pedindo numero da conta
        // Ler numero inserido
        // Verificar numero com a lista de contas existentes
        // Se numero existir, colocar essa conta encontrada como conta atual e retornar true
        // Se n�o, retorna false para tentar novamente

        return false;
    }

    public int menuConta() {
        // Escrever op��es do menu
        // Ler op��o escolhida
        // Tratar cada op��o

        return 0;
    }

    public void extrato() {
        // Listar todas as transa��es dessa conta
    }

    public void saldo() {
        // Listar valor de saldo atual
    }

    public void deposito() {
        // Escrever texto pedindo valor a ser depositado
        // Ler valor
        // Criar transa��o do tipo credito com o valor fornecido
        // Adicionar transa��o a historico de conta
        // Atualizar saldo da conta
    }

    public void saque() {
        // Escrever texto pedindo valor a ser retirado
        // Ler valor
        // Criar transa��o do tipo debito com o valor fornecido
        // Adicionar transa��o a historico de conta
        // Atualizar saldo da conta
    }

    public void transferir() {
        // Escrever texto pedindo conta para onde valor sera transferido
        // Ler conta
        // Verificar se � uma conta valida, e se n�o for, pedir novamente ou perguntar se quer sair
        // Escrever texto pedindo valor a ser transferido
        // Ler valor
    }
}