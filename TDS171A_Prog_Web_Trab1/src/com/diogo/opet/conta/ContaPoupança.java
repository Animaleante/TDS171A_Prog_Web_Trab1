package com.diogo.opet.conta;

public class ContaPoupança extends Conta
{

    public ContaPoupança(long numeroConta, double saldo)
    {
        super(Conta.TIPO_CONTA_POUPANCA, numeroConta, saldo);
    }

}
