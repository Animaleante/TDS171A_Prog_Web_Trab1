package com.diogo.opet.transacao;

public class Transferencia {
	private Transacao origem;
	private Transacao destino;
	
	public Transferencia(Transacao origem, Transacao destino) {
		this.origem = origem;
		this.destino = destino;
	}
	
	/**
	 * @return the origem
	 */
	public Transacao getOrigem() {
		return origem;
	}
	/**
	 * @param origem the origem to set
	 */
	public void setOrigem(Transacao origem) {
		this.origem = origem;
	}
	/**
	 * @return the destino
	 */
	public Transacao getDestino() {
		return destino;
	}
	/**
	 * @param destino the destino to set
	 */
	public void setDestino(Transacao destino) {
		this.destino = destino;
	}
}
