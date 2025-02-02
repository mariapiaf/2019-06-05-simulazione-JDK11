/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.crimes;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.Month;
import java.time.Year;
import java.util.ResourceBundle;

import it.polito.tdp.crimes.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	private Model model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="boxAnno"
    private ComboBox<Year> boxAnno; // Value injected by FXMLLoader

    @FXML // fx:id="boxMese"
    private ComboBox<Integer> boxMese; // Value injected by FXMLLoader

    @FXML // fx:id="boxGiorno"
    private ComboBox<Integer> boxGiorno; // Value injected by FXMLLoader

    @FXML // fx:id="btnCreaReteCittadina"
    private Button btnCreaReteCittadina; // Value injected by FXMLLoader

    @FXML // fx:id="btnSimula"
    private Button btnSimula; // Value injected by FXMLLoader

    @FXML // fx:id="txtN"
    private TextField txtN; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader

    @FXML
    void doCreaReteCittadina(ActionEvent event) {

    	txtResult.clear();
    	Year anno = boxAnno.getValue();
    	if(anno == null) {
    		txtResult.appendText("Devi scegliere un anno");
    		return;
    	}
    	
    	this.model.creaGrafo(anno);
    	txtResult.appendText("GRAFO CREATO! \n");
    	txtResult.appendText("# VERTICI: " + this.model.nVertici()+"\n");
    	txtResult.appendText("# ARCHI: " + this.model.nArchi());
    	
    }

    @FXML
    void doSimula(ActionEvent event) {
    	Year anno = boxAnno.getValue();
    	Integer mese = boxMese.getValue();
    	Integer giorno = boxGiorno.getValue();
    	String sn = txtN.getText();
    	
    	if(anno == null || mese == null || giorno == null) {
    		txtResult.appendText("Devi selezionare giorno, mese e anno per proseguire!");
    		return;
    	}
    	int N = -1;
    	try {
    		N = Integer.parseInt(sn);
    	} catch(NumberFormatException ne) {
    		txtResult.appendText("Devi inserire un numero Intero!!");
    		return;
    	}
    	if(N<1 || N > 10) {
    		txtResult.appendText("Devi inserire un numero compreso tra 1 e 10");
    		return;
    	}
    	
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert boxAnno != null : "fx:id=\"boxAnno\" was not injected: check your FXML file 'Scene.fxml'.";
        assert boxMese != null : "fx:id=\"boxMese\" was not injected: check your FXML file 'Scene.fxml'.";
        assert boxGiorno != null : "fx:id=\"boxGiorno\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCreaReteCittadina != null : "fx:id=\"btnCreaReteCittadina\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSimula != null : "fx:id=\"btnSimula\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtN != null : "fx:id=\"txtN\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
    
    public void setModel(Model model) {
    	this.model = model;
    	boxAnno.getItems().addAll(this.model.getAnni());
    	boxMese.getItems().addAll(this.model.getMesi());
    	boxGiorno.getItems().addAll(this.model.getGiorni());
    }
}
