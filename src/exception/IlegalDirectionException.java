package exception;

public class IlegalDirectionException extends Exception {
	
	public IlegalDirectionException(int direccion) {
		
		super("No se puede generar el cuadrado en esa direccion");
	}
	

}
