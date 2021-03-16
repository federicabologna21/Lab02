/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.TreeMap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="btnTranslate"
    private Button btnTranslate; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader

    @FXML // fx:id="btnClear"
    private Button btnClear; // Value injected by FXMLLoader
    
    TreeMap <String, Dizionario> dizionario = new TreeMap <>();

    @FXML
    void doTranslate(ActionEvent event) {
    	
    	String parolaAliena = "";
    	String traduzione ="";
    	
    	String testoInserito = txtParola.getText().toLowerCase();
    	String array[] = testoInserito.split(" ");
    	
    	if (array.length == 2) {
    		parolaAliena = array[0];
    		traduzione = array[1];
    	
    		// controllo su dati inseriti --> solo lettere maiuscole o minuscole
        	if (parolaAliena.matches(".*[az].*") == false && traduzione.matches(".*[az].*")== false) {
        		txtRisultato.setText("Inserire parole nel formato corretto");
        		txtParola.clear(); // pulisco il campo di testo
        		return ;
        		
        	}
        	else {
    		// controllo se esiste gia in mappa --> restituisco traduzione ma non aggiungo parola Aliena
        		if (!dizionario.containsKey(parolaAliena)) {
        			txtRisultato.setText(traduzione);
        			Dizionario d = new Dizionario (parolaAliena, traduzione);
        			dizionario.put(parolaAliena, d);
        			txtParola.clear(); // pulisco il campo di testo
        		}
        		else {
        			txtRisultato.setText(traduzione);
        			txtParola.clear(); // pulisco il campo di testo
        		}
        			
    			
    		}
    	}
    	if (array.length ==1) {
    		parolaAliena = array[0];
    		
    		// controllo su dati inseriti --> solo lettere maiuscole o minuscole
        	if (parolaAliena.matches(".*[az].*") == false) {
        		txtRisultato.setText("Inserire parola nel formato corretto");
        		txtParola.clear(); // pulisco il campo di testo
        		return ;
        		
        	}
        	// se il dizionario non contiene la parola aliena
        	if (!dizionario.containsKey(parolaAliena)) {
        		txtRisultato.setText("Errore: la parola aliena '"+parolaAliena+"' non è presente nel dizionario");
        		txtParola.clear(); // pulisco il campo di testo
        		return ;
        	}
        	
        	for (Dizionario d: dizionario.values()) {
        		if (parolaAliena.equals(d.getParolaAliena())) {
        			txtRisultato.setText(d.getTraduzione());
        			txtParola.clear(); // pulisco il campo di testo
        		}
        	}
    	}
    }

    @FXML
    void handleClear(ActionEvent event) {
    	txtRisultato.clear();

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
