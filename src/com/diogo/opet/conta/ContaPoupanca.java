package com.diogo.opet.conta;

public class ContaPoupanca extends Conta
{

    public ContaPoupanca(long numeroConta, double saldo)
    {
        super(Conta.TIPO_CONTA_POUPANCA, numeroConta, saldo);
    }

}
