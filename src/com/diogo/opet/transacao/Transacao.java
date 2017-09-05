package com.diogo.opet.transacao;

import java.util.Date;

public class Transacao
{
	public static final int TIPO_TRANSACAO_DEBITO = 0;
	public static final int TIPO_TRANSACAO_CREDITO = 1;
	public static final int TIPO_TRANSACAO_TRANSFERENCIA_DEBITO = 2;
	public static final int TIPO_TRANSACAO_TRANSFERENCIA_CREDITO = 3;
	
//	private long timestamp;
	private Date data;
	private double val;
	private int tipo;
	
	public Transacao(int tipo, double val) {
		this.tipo = tipo;
		this.val = val;
//		this.timestamp = System.currentTimeMillis();
		this.data = new Date();
	}

	public void print() {
		// Print
		// - Data
		// - Horario
		// - Valor
		// - Tipo
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
}
