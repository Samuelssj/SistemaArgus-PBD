package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControleAluno {

	 @FXML
	    private AnchorPane AnchoPane;

	    @FXML
	    private TabPane TabPane;

	    @FXML
	    private Tab TabListaCadastro;

	    @FXML
	    private TextField TXbuscarFuncionario;

	    @FXML
	    private Button JBbuscarCadastro;

	    @FXML
	    private TableView<?> tabelaFuncionario;

	    @FXML
	    private TableColumn<?, ?> nomeTabelaFuncionario;

	    @FXML
	    private TableColumn<?, ?> funcaoTabelaFuncionario;

	    @FXML
	    private TableColumn<?, ?> cpfTabFuncionario;

	    @FXML
	    private TableColumn<?, ?> SituacaoTabFuncionario;

	    @FXML
	    private Button JBeditar;

	    @FXML
	    private Button JBdeletar;

	    @FXML
	    private Tab TabNovocadastro;

	    @FXML
	    private TextField TXusuarioNome;

	    @FXML
	    private TextField TXusuarioCEP;

	    @FXML
	    private TextField TXusuarioRua;

	    @FXML
	    private TextField TXusuarioBairro;

	    @FXML
	    private TextField TXusuarioNumero;

	    @FXML
	    private Button BTatualizar;

	    @FXML
	    private TextField TXusuarioMaeNome;

	    @FXML
	    private TextField TXusuarioPaiNome;

	    @FXML
	    private ComboBox<?> COMBOusuarioTipo;

	    @FXML
	    private ComboBox<?> COMBOusuarioNaturalidade;

	    @FXML
	    private DatePicker TXusuarioData_nasc;

	    @FXML
	    private Button BToutroResponsavel;

	    @FXML
	    private ComboBox<?> COMBOestadoUsuario;

	    @FXML
	    private TextField TXusuarioCidade;

	    @FXML
	    private TextField TXResponsavelNome;

	    @FXML
	    private TextField TXResponsavelCPF;

	    @FXML
	    private Tab TabNovoResponsavel;

	    @FXML
	    private TextField TXresponsavelNome;

	    @FXML
	    private TextField TXresponsavelCPF;

	    @FXML
	    private Button BTcadastrarComResponsavel;

	    @FXML
	    private Button BTvoltar;

	    @FXML
	    private TableView<?> tabelaResponsavel;

	    @FXML
	    private TableColumn<?, ?> nomeTabResponsavel;

	    @FXML
	    private TableColumn<?, ?> cpfTabResponsavel;

	    @FXML
	    private Button BTbuscarResponsavel;

	    @FXML
	    private TextField TXBuscarResponsavel;

	    @FXML
	    void action(ActionEvent event) {
	    	
	    	if(event.getSource() == JBdeletar) {
	    		System.out.println("ai");
	    	}

	    }
}
