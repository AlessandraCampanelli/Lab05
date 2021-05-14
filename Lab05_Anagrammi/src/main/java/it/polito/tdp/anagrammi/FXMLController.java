package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtSbagliati;
 
    @FXML
    void doAanagramma(ActionEvent event) {
String parola= txtParola.getText();
//VERIFICARE CHE SIANO SOLO LETTERE
//SE HO CARATTERI SPECIALI LI SOSTITUISCO CON UNO SPAZIO 
String  testo= parola.replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]", "");
if(testo.contains("[a-zA-Z]+") ) {
	txtCorretti.setText("Il formato inserito è corretto ");
}
Set <String> anagrammi= new HashSet<String>(model.sottoProblemaAnagrammi(testo));

for(String a :anagrammi) {
	if(this.model.isCorrect(a))
		txtCorretti.appendText(a+"\n");
	else
		txtSbagliati.appendText(a+"\n");
}
    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtSbagliati != null : "fx:id=\"txtSbagliati\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    public void setModel(Model model) {
    	this.model = model;
    }
    
}
