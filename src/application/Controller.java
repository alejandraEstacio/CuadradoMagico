package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.*;

public class Controller implements Initializable {
	
	private Cuadrado c;

    @FXML
    private GridPane grilla1;

    @FXML
    private TextField orden;

    @FXML
    private TextField puntoInicio;

    @FXML
    private TextField sentido;
    
    @FXML
    private Label[][] matriz;

    @FXML
    void generarCuadrado(ActionEvent event)  {
    	
    	try {
    	
    	int tamanio = Integer.parseInt(orden.getText());
    	int direccion = Integer.parseInt(sentido.getText());
    	int puntoIni = Integer.parseInt(puntoInicio.getText());
    	
    	c= new Cuadrado(tamanio);
    	
    	matriz= new Label[tamanio][tamanio];
    	
    	c.generarCuadradoMag(direccion, puntoIni);
    	
	    	for(int i=0; i<tamanio;i++) {
	    		
	    		for(int j=0 ; j<tamanio;j++) {
	    			
	    			 matriz[i][j]= new Label(Integer.toString(c.getMatriz()[i][j]));
	    			 grilla1.setAlignment(Pos.CENTER);
	    			 grilla1.setHgap(8);
	    			 grilla1.setVgap(8);

	    			 grilla1.add(matriz[i][j], j, i);
	    		}
	    	}
    	}catch(NumberFormatException e) {
    		
    		Alert mensaje = new Alert(AlertType.ERROR);
    		mensaje.setContentText(e.getMessage()+" Debe ingresar los parametros");
    		mensaje.show();
    	}catch(IndexOutOfBoundsException e) {
    		
    		Alert mensaje = new Alert(AlertType.ERROR);
    		mensaje.setContentText(e.getMessage());
    		mensaje.show();
    		
    	}
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	}

}
