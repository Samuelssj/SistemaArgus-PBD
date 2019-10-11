package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ControleTelaLog implements Initializable {

	
	
    @FXML
    private Button JBentrar;

    @FXML
    private PasswordField TxSenha;

    @FXML
    private TextField TxLogin;

    @FXML
    private Label LBesquecerSenha;
    
    @FXML
    private Button JBsair;

    @FXML
    void action(ActionEvent e) {
    	if(e.getSource() == JBentrar) {
    		Main.changeStage("Menu");
    	}
    	
    	if(e.getSource() == LBesquecerSenha) {
    		System.out.println("mudar a senha");
    	}
    	
    	

    }
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		
	}

}
