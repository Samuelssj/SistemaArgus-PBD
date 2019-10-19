package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class ControleCadastro {


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
    private Button JBnovoCadastro;

    @FXML
    private TableView<?> tabelaFuncionario;

    @FXML
    private TableColumn<?, ?> nomeTabelaFuncionario;

    @FXML
    private TableColumn<?, ?> cpfTabelaFuncionario;

    @FXML
    private TableColumn<?, ?> CargotabelaFuncionario;

    @FXML
    private TableColumn<?, ?> RuaTabFuncionario;

    @FXML
    private TableColumn<?, ?> BairroTabFuncionario;

    @FXML
    private TableColumn<?, ?> SituacaoTabFuncionario;

    @FXML
    private Button JBeditar;

    @FXML
    private Button JBdeletar;

    @FXML
    private Tab TabNovoFuncionario1;

    @FXML
    private TextField TXusuarioNome1;

    @FXML
    private TextField TXusuarioLogin1;

    @FXML
    private TextField TXusuarioCidade1;

    @FXML
    private TextField TXusuarioEstado1;

    @FXML
    private TextField TXusuarioCEP1;

    @FXML
    private TextField TXusuarioRua1;

    @FXML
    private TextField TXusuarioBairro1;

    @FXML
    private TextField TXusuarioNumero1;

    @FXML
    private Button BTcadastrarPessoa1;

    @FXML
    private RadioButton Radiomãe1;

    @FXML
    private ToggleGroup genero1;

    @FXML
    private RadioButton RadioPai1;

    @FXML
    private TextField TXusuarioPaiCPF1;

    @FXML
    private DatePicker TXusuarioPaiNasc1;

    @FXML
    private DatePicker TXusuarioMaeNasc1;

    @FXML
    private TextField TXusuarioMaeNome1;

    @FXML
    private TextField TXusuarioMaeCPF1;

    @FXML
    private TextField TXcpfResponsavel1;

    @FXML
    private TextField TXusuarioPaiNome1;

    @FXML
    private RadioButton RadioProprioresp1;

    @FXML
    private ComboBox<?> TXusuarioPaiNaturalidade1;

    @FXML
    private ComboBox<?> TXusuarioMaeNAturalidade1;

    @FXML
    private ComboBox<?> TXusuarioTipo1;

    @FXML
    private ComboBox<?> TXusuarioNaturalidade1;

    @FXML
    private PasswordField TXusuarioSenha1;

    @FXML
    private PasswordField TXusuarioSenhaConfirmar1;

    @FXML
    private DatePicker TXusuarioData_nasc1;

    @FXML
    private Button BToutroResponsavel1;

    @FXML
    private Tab TabNovoFuncionario11;

    @FXML
    private TextField TXresponsavelNome;

    @FXML
    private TextField TXresponsavelCPF;

    @FXML
    private Button BTcadastrarComResponsavel;

    @FXML
    private DatePicker TXresponsavelDataNasc;

    @FXML
    private Button BTvoltar;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() ==BTvoltar) {
			System.out.println("oi");
		}

	}

}
