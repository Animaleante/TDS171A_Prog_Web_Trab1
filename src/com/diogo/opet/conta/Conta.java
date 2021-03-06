package com.diogo.opet.conta;

import java.util.ArrayList;
import java.util.List;

import com.diogo.opet.exceptions.FundosInsuficientesException;
import com.diogo.opet.transacao.Transacao;
import com.diogo.opet.transacao.Transferencia;
import com.diogo.opet.utils.Utils;

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

    public void extrato() {
		for (int i = 0; i < transacoes.size(); i++) {
			Transacao transacao = transacoes.get(i);
			transacao.print();
		}
    }

    public void saldo() {
//		DecimalFormat df = new DecimalFormat("0.00");
//		System.out.println("Saldo atual: " + df.format(this.saldo)+"$");

//		NumberFormat formatter = NumberFormat.getCurrencyInstance(new Locale("br", "BR"));
		System.out.println(Utils.formatter.format(saldo));

    }

    public void saque(double valor) throws FundosInsuficientesException {
    	if(saldo - valor < 0)
    		throw new FundosInsuficientesException("Voce nao possui saldo suficiente para realizar esse saque.");

		// Criar transaï¿½ï¿½o do tipo debito com o valor fornecido
    	Transacao t = new Transacao(Transacao.TIPO_TRANSACAO_DEBITO, valor);

		// Adicionar transaï¿½ï¿½o a historico de conta
    	transacoes.add(t);

		// Atualizar saldo da conta
        atualizarSaldo(valor);
    }

	public void saqueTransferencia(double valor) throws FundosInsuficientesException {
    	if(saldo - valor < 0)
    		throw new FundosInsuficientesException("Voce nao possui saldo suficiente para realizar esse saque.");

		// Criar transaï¿½ï¿½o do tipo debito com o valor fornecido
    	Transacao t = new Transacao(Transacao.TIPO_TRANSACAO_TRANSFERENCIA_DEBITO, valor);

		// Adicionar transaï¿½ï¿½o a historico de conta
    	transacoes.add(t);

		// Atualizar saldo da conta
        atualizarSaldo(valor);
	}

    public void deposito(double valor) {
		// Criar transaï¿½ï¿½o do tipo credito com o valor fornecido
    	Transacao t = new Transacao(Transacao.TIPO_TRANSACAO_CREDITO, valor);

		// Adicionar transaï¿½ï¿½o a historico de conta
    	transacoes.add(t);

		// Atualizar saldo da conta
        atualizarSaldo(valor);
    }

    public void depositoTransferencia(double valor) {
		// Criar transaï¿½ï¿½o do tipo credito com o valor fornecido
    	Transacao t = new Transacao(Transacao.TIPO_TRANSACAO_TRANSFERENCIA_CREDITO, valor);

		// Adicionar transaï¿½ï¿½o a historico de conta
    	transacoes.add(t);

		// Atualizar saldo da conta
    	atualizarSaldo(valor);
    }

    private void atualizarSaldo(double valor) {
        saldo = (double) Math.round((saldo + valor)*100)/100;
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
