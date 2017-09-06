package com.diogo.opet.exceptions;

public class FundosInsuficientesException extends Exception {
	
	public FundosInsuficientesException() {
		super("O saldo � insuficiente para esta opera��o.");
	}
	
	public FundosInsuficientesException(String message) {
		super(message);
	}
}
