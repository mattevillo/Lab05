package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResultCorretto;

    @FXML
    private TextArea txtResultErrato;

    @FXML
    void btnAnagrammi(ActionEvent event) {
    	
    	String parola = txtParola.getText();
    	txtResultCorretto.clear();
    	txtResultErrato.clear();
    	
    	if(parola.length()<2)
    		txtResultCorretto.setText("La parola inserita è troppo corta");
    	
    	if(parola.length()>8)
    		txtResultCorretto.setText("La parola inserita è troppo lunga");
    	
    	Set<String> anagrammi = this.model.calcolaAnagrammi(parola);
    	
    	for(String anagramma: anagrammi) {
    		if (this.model.isCorrect(anagramma)) {
    			txtResultCorretto.appendText(anagramma + "\n");
    			txtResultCorretto.setDisable(false);
    			}
    	else {
    		txtResultErrato.appendText(anagramma + "\n");
			txtResultErrato.setDisable(false);
    	}
    }

    }
    
    @FXML
    void btnReset(ActionEvent event) {
    	txtParola.clear();
    	txtResultCorretto.clear();
    	txtResultErrato.clear();
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultCorretto != null : "fx:id=\"txtResultCorretto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResultErrato != null : "fx:id=\"txtResultErrato\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    }

}