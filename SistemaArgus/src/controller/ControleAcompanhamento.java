package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControleAcompanhamento implements Initializable{

	
	
    @FXML
    private AnchorPane AnchoPane;

    @FXML
    private TabPane TabPane;

    @FXML
    private Tab Tabcurriculo;

    @FXML
    private TextField TXBuscarAluno;

    @FXML
    private ComboBox<?> ComboNome;

    @FXML
    private TableView<?> tabelaAluno;

    @FXML
    private TableColumn<?, ?> TabAlunoNome;

    @FXML
    private TableColumn<?, ?> TabAlunocpf;

    @FXML
    private TableView<?> tabelaPedagogo;

    @FXML
    private TableColumn<?, ?> TabPedagogoNome;

    @FXML
    private TableColumn<?, ?> TabPedagogocpf;

    @FXML
    private Button BTBuscar;

    @FXML
    private Button BTadcionar;

    @FXML
    private Button BTcadastrarCurriculo;

    @FXML
    private DatePicker TXdata;

    @FXML
    void action(ActionEvent event) {

    }

	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
