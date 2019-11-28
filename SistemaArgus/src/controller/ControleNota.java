package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControleNota implements Initializable {

	
	 @FXML
	    private AnchorPane AnchoPane;

	    @FXML
	    private TabPane TabPane;

	    @FXML
	    private Tab TabNota;

	    @FXML
	    private TextField TXBuscarAluno;

	    @FXML
	    private TableView<?> tabelaAluno;

	    @FXML
	    private TableColumn<?, ?> TabAlunoNome;

	    @FXML
	    private TableColumn<?, ?> TabAlunoCPF;

	    @FXML
	    private TableView<?> tabelaCurriculo;

	    @FXML
	    private TableColumn<?, ?> TabDisciplinaNome;

	    @FXML
	    private TableColumn<?, ?> TabDisciplinaCarga;

	    @FXML
	    private Button BTBuscar;

	    @FXML
	    private Button BTSalvar;

	    @FXML
	    private Button BTselecionar;

	    @FXML
	    private TextField TXmedia1;

	    @FXML
	    private TextField TXmedia2;

	    @FXML
	    private TextField TXmedia3;

	    @FXML
	    private TextField TXmedia4;

	    @FXML
	    private TextField TXfinal;

	    @FXML
	    void action(ActionEvent event) {

	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
		}

}
