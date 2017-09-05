package com.diogo.opet.conta;

public class ContaCorrente extends Conta
{

    public ContaCorrente(long numeroConta, double saldo)
    {
        super(Conta.TIPO_CONTA_CORRENTE, numeroConta, saldo);
    }

}
