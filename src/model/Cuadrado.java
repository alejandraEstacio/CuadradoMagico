package model;

import exception.IlegalDirectionException;
import exception.NumeroparException;

public class Cuadrado {
	
	
	public static final int SO = 1;
	public static final int SE = 2;
	public static final int NO = 3;
	public static final int NE = 4;
	
	
	public static final int arriba = 1;
	public static final int abajo = 2;
	public static final int izquierda = 3;
	public static final int derecha = 4;
	
	private int tamano;
	private int[][] matriz;
	

	public Cuadrado(int tamano) {
	
		if(tamano %2 == 0) {
			try {
				throw new NumeroparException(tamano);
			} catch (NumeroparException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			
			this.tamano = tamano;
			matriz = new int[tamano][tamano];
			for (int i =0; i< tamano; i++) {
				for (int j =0; j< tamano; j++) {
					
					matriz[i][j] =0;
				}
			}
		}
	}
	
	public void generarCuadradoMag(int direccion, int puntoInicio) throws IndexOutOfBoundsException {
		
		if((puntoInicio == arriba && (direccion == SO || direccion == SE ) )||
				(puntoInicio == derecha && (direccion == NO || direccion == SO ))||
				(puntoInicio == izquierda && (direccion == NE|| direccion == SE ))||
				(puntoInicio == abajo && (direccion == NO || direccion == NE))) {
			
			try {
				throw new IlegalDirectionException(direccion);
			} catch (IlegalDirectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
		
			try {
					int fila =0;
					int columna = 0;
					
					int filaAnt =0;
					int columnaAnt = 0;
					
					if(puntoInicio == arriba) {
						
						matriz[0][tamano/2] = 1;
						
						fila = 0;
						columna = tamano/2;
						
					}else if(puntoInicio == abajo) {
						
						matriz[tamano-1][tamano/2] = 1;
						fila = tamano-1;
						columna = tamano/2;
					}else if(puntoInicio == izquierda) {
						matriz[tamano/2][0] = 1;
						
						fila = tamano/2;
						columna = 0;
					
					}else {
						matriz[tamano/2][tamano-1]= 1;
						fila = tamano/2;
						columna = tamano-1;
					}
					
					for(int i= 1; i<tamano*tamano; i++) {
						
						filaAnt = fila;
						columnaAnt = columna;
						
						if(direccion == SO) {
							fila += 1;
							columna -=1;
						}else if(direccion == SE) {
							fila += 1;
							columna +=1;
						}else if(direccion == NE) {
							fila -= 1;
							columna +=1;
						}else {
							fila -= 1;
							columna -=1;	
							
						}
						
						if(fila > tamano-1 ) {
							fila =0;
						}else if(fila < 0) {
							fila = tamano-1;
						}
						if(columna > tamano-1) {
							columna =0;
						}else if(columna < 0) {
							columna = tamano -1;
						}
						
						if (matriz[fila][columna] == 0) {
							System.out.println("Fila - Columna - Valor: " + fila +"-"+columna+"-"+(i+1));
							matriz[fila][columna] = i+1;
						}else {
							
							fila = filaAnt;
							columna = columnaAnt;
							 fila +=1;
							 System.out.println("Fila - Columna - Valor: " + fila +"-"+columna+"-"+(i+1));
								matriz[fila][columna] = i+1;
						}
						
					}
			}catch (IndexOutOfBoundsException e) {
				
				System.err.println(e.getMessage());
				
			}
	}
	}


	public int[][] getMatriz() {
		
		int[][] resultado = new int[tamano][tamano];
		
		for( int i = 0; i<tamano; i++) {
			
			
			for (int j = 0; j<tamano; j++) {
				
				resultado[i][j]= matriz[i][j];
			}
			
		
		}
		
		return matriz;
	}

	public void setMatriz(int[][] matriz) {
		this.matriz = matriz;
	}
}
