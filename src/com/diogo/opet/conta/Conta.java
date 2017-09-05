package com.diogo.opet.conta;

import java.util.ArrayList;
import java.util.List;

import com.diogo.opet.transacao.Transacao;
import com.diogo.opet.transacao.Transferencia;

public class Conta
{
    public static final int TIPO_CONTA_CORRENTE = 0;
    public static final int TIPO_CONTA_POUPANCA = 1;

    private long numeroConta = 0;
    private int tipoConta = -1;
    private double saldo = 0;

    private List<Transacao> transacoes;
    private List<Transferencia> transferencias;

    protected Conta(int tipoConta, long numeroConta, double saldo)
    {
        this.tipoConta = tipoConta;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        
        this.transacoes = new ArrayList<Transacao>();
        this.transferencias = new ArrayList<Transferencia>();
    }

    public void saque(double valor) {
    	// TODO
    }

    public void deposito(double valor) {
    	// TODO
    }

    /**
     * @return the numeroConta
     */
    public long getNumeroConta()
    {
        return numeroConta;
    }

    /**
     * @param pNumeroConta the numeroConta to set
     */
    public void setNumeroConta(long numeroConta)
    {
        this.numeroConta = numeroConta;
    }

    /**
     * @return the tipoConta
     */
    public int getTipoConta()
    {
        return tipoConta;
    }

    /**
     * @param pTipoConta the tipoConta to set
     */
    public void setTipoConta(int tipoConta)
    {
        this.tipoConta = tipoConta;
    }

    /**
     * @return the saldo
     */
    public double getSaldo()
    {
        return saldo;
    }

    /**
     * @param pSaldo the saldo to set
     */
    public void setSaldo(double saldo)
    {
        this.saldo = saldo;
    }

	/**
	 * @return the transacoes
	 */
	public List<Transacao> getTransacoes() {
		return transacoes;
	}

	/**
	 * @param transacoes the transacoes to set
	 */
	public void setTransacoes(List<Transacao> transacoes) {
		this.transacoes = transacoes;
	}

	/**
	 * @return the transferencias
	 */
	public List<Transferencia> getTransferencias() {
		return transferencias;
	}

	/**
	 * @param transferencias the transferencias to set
	 */
	public void setTransferencias(List<Transferencia> transferencias) {
		this.transferencias = transferencias;
	}
}
