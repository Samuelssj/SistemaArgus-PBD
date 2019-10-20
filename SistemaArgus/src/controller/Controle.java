package controller;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import application.Main;
import fachada.Fachada;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import model.Ouvinte;

public abstract class Controle implements Initializable , Ouvinte{
	@FXML
	protected AnchorPane pane;
	

	protected Fachada fachada;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		fachada = Fachada.getInstance();
			
		init();
		
	}

	protected String getDate(LocalDate date) {

		String data = null;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		data = formatter.format(date);
		
		return data;
	}
	
	@Override
	public void setColor(String color) {
		pane.setStyle("-fx-background-color:" + color + ";");
	}
	
	protected void setColor(AnchorPane pane, String color) {
		pane.setStyle("-fx-background-color:" + color + ";");
	}

	protected abstract void init();

	public abstract void action(ActionEvent event);

	protected abstract void limparCampos();
}