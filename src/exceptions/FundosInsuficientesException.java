package exceptions;

public class FundosInsuficientesException extends Exception {
	
	public FundosInsuficientesException() {
		super("O saldo é insuficiente para esta operação.");
	}
	
	public FundosInsuficientesException(String message) {
		super(message);
	}
}
