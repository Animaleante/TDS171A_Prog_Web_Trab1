package com.diogo.opet.transacao;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao
{
	public static final int TIPO_TRANSACAO_DEBITO = 0;
	public static final int TIPO_TRANSACAO_CREDITO = 1;
	public static final int TIPO_TRANSACAO_TRANSFERENCIA_DEBITO = 2;
	public static final int TIPO_TRANSACAO_TRANSFERENCIA_CREDITO = 3; 
	
	public static int id = 0;
	
//	private long timestamp;
	private int idTransacao;
	private Date data;
	private double val;
	private int tipo;
	
	public Transacao(int tipo, double val) {
		this.idTransacao = Transacao.id++;
		this.tipo = tipo;
		this.val = val;
//		this.timestamp = System.currentTimeMillis();
		this.data = new Date();
	}

	public void print() {
		SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		DecimalFormat df = new DecimalFormat("#.00");
		// Print
		// - Data
		// - Horario
		// - Valor
		// - Tipo
		
		if(this.tipo == TIPO_TRANSACAO_DEBITO || this.tipo == TIPO_TRANSACAO_CREDITO)
			System.out.println("#"+this.idTransacao + " - " + ft.format(this.data) + " - " + (this.tipo == Transacao.TIPO_TRANSACAO_DEBITO ? "Débito : -" : "Crédito: +") + df.format(this.val)+"$");
		else
			System.out.println("#"+this.idTransacao + " - " + ft.format(this.data) + " - Transferência - " + (this.tipo == Transacao.TIPO_TRANSACAO_TRANSFERENCIA_DEBITO ? "Débito : -" : "Crédito: +") + df.format(this.val)+"$");
	}

	/**
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the val
	 */
	public double getValor() {
		return val;
	}

	/**
	 * @param val the val to set
	 */
	public void setValor(double val) {
		this.val = val;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}

	/**
	 * @return the idTransacao
	 */
	public int getIdTransacao() {
		return idTransacao;
	}

	/**
	 * @param idTransacao the idTransacao to set
	 */
	public void setIdTransacao(int idTransacao) {
		this.idTransacao = idTransacao;
	}
}
