package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;

	@FXML
	private TextArea txtEsecuzione;

	@FXML
	private Button btnCancella;
	    
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	double inizio = System.nanoTime();
    	elenco.addParola(txtParola.getText());
    	double fine = System.nanoTime();
    	txtEsecuzione.appendText("Processo di Inserimento: " + (fine-inizio) + " nanoSecondi" + "\n");
    	txtResult.clear();
    	String risultato = "";
    	
    	for(String p : elenco.getElenco()) {
    		risultato += p + "\n";
    	}
    	txtParola.clear();
    	txtResult.setText(risultato);
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	double inizio = System.nanoTime();
    	elenco.reset();
    	double fine = System.nanoTime();
    	txtEsecuzione.appendText("Processo di Reset: " + (fine-inizio) + " nanoSecondi" + "\n");
    	txtResult.clear();
    }
    
    @FXML
    void doCancella(ActionEvent event) {
    	String p = txtResult.getSelectedText();
    	double inizio = System.nanoTime();
    	elenco.cancella(p);
    	double fine = System.nanoTime();
    	txtEsecuzione.appendText("Processo di Cancellazione della parola: " + (fine-inizio) + " nanoSecondi" + "\n");
    	txtResult.clear();
    	String risultato = "";
    	
    	for(String pi : elenco.getElenco()) {
    		risultato += pi + "\n";
    	}
    	txtParola.clear();
    	txtResult.setText(risultato);
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtEsecuzione != null : "fx:id=\"txtEsecuzione\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Scene.fxml'.";
        elenco = new Parole() ;
    }
}