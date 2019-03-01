package exception;

public class NumeroparException extends Exception {
	
	public NumeroparException (int tamanio) {
		
		super("No se puede crear un cuadrado de orden par");
		
	}

	

}
