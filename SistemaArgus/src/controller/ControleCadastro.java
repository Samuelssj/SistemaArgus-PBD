package controller;

import javax.transaction.Transactional.TxType;

import EntidadeEnum.Estado;
import EntidadeEnum.TipoUsuario;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import model.Entidade;
import model.Tela;

public class ControleCadastro extends Controle {

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
	private TextField TXusuarioNome;

	@FXML
	private TextField TXusuarioLogin;

	@FXML
	private TextField TXusuarioCidade;

	@FXML
	private TextField TXusuarioEstado;

	@FXML
	private TextField TXusuarioCEP;

	@FXML
	private TextField TXusuarioRua;

	@FXML
	private TextField TXusuarioBairro;

	@FXML
	private TextField TXusuarioNumero;

	@FXML
	private Button BTcadastrarUsuario;

	@FXML
	private RadioButton Radiomãe;

	@FXML
	private ToggleGroup genero1;

	@FXML
	private RadioButton RadioPai;

	@FXML
	private TextField TXusuarioPaiCPF;

	@FXML
	private DatePicker TXusuarioPaiNasc;

	@FXML
	private DatePicker TXusuarioMaeNasc;

	@FXML
	private TextField TXusuarioMaeNome;

	@FXML
	private TextField TXusuarioMaeCPF;

	@FXML
	private TextField TXcpfResponsavel1;

	@FXML
	private TextField TXusuarioPaiNome;

	@FXML
	private RadioButton RadioProprioresp;

	@FXML
	private ComboBox<Estado> COMBOusuarioPaiNaturalidade;

	@FXML
	private ComboBox<Estado> COMBOusuarioMaeNAturalidade;

	@FXML
	private ComboBox<TipoUsuario> COMBOusuarioTipo;

	@FXML
	private ComboBox<Estado> COMBOusuarioNaturalidade;

	@FXML
	private PasswordField TXusuarioSenha;

	@FXML
	private PasswordField TXusuarioSenhaConfirmar;

	@FXML
	private DatePicker TXusuarioData_nasc;

	@FXML
	private Button BToutroResponsavel;

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

	public void action(ActionEvent event) {

		if (event.getSource() == BTvoltar) {
			System.out.println("oi");
		}

	}

	@Override
	public void update(Tela tela, Entidade entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void init() {
		// COMBOBOX TIPO DE USUARIO

		COMBOusuarioTipo.getItems().setAll(TipoUsuario.values());
		COMBOusuarioTipo.getItems().setAll(TipoUsuario.values());

		COMBOusuarioTipo.setButtonCell(new ListCell<TipoUsuario>() {
			@Override
			protected void updateItem(TipoUsuario item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Tipo de Usuário");
				} else {
					setText(item.toString());
				}
			}
		});

		COMBOusuarioTipo.setButtonCell(new ListCell<TipoUsuario>() {
			@Override
			protected void updateItem(TipoUsuario item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Tipo de Funcionário");
				} else {
					setText(item.toString());
				}
			}
		});

		// COMBOBOX NATURALIDADE

		COMBOusuarioNaturalidade.getItems().setAll(Estado.values());
		COMBOusuarioNaturalidade.getItems().setAll(Estado.values());

		COMBOusuarioNaturalidade.setButtonCell(new ListCell<Estado>() {
			@Override
			protected void updateItem(Estado item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Naturalidade");
				} else {
					setText(item.toString());
				}
			}
		});

		COMBOusuarioNaturalidade.setButtonCell(new ListCell<Estado>() {
			@Override
			protected void updateItem(Estado item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Naturalidade");
				} else {
					setText(item.toString());
				}
			}
		});

		// COMBOBOX NATURALIDADE PAI

		COMBOusuarioPaiNaturalidade.getItems().setAll(Estado.values());
		COMBOusuarioPaiNaturalidade.getItems().setAll(Estado.values());

		COMBOusuarioPaiNaturalidade.setButtonCell(new ListCell<Estado>() {
			@Override
			protected void updateItem(Estado item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Naturalidade Pai");
				} else {
					setText(item.toString());
				}
			}
		});

		COMBOusuarioPaiNaturalidade.setButtonCell(new ListCell<Estado>() {
			@Override
			protected void updateItem(Estado item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Naturalidade Pai");
				} else {
					setText(item.toString());
				}
			}
		});

		// COMBOBOX NATURALIDADE MAE

		COMBOusuarioMaeNAturalidade.getItems().setAll(Estado.values());
		COMBOusuarioMaeNAturalidade.getItems().setAll(Estado.values());

		COMBOusuarioMaeNAturalidade.setButtonCell(new ListCell<Estado>() {
			@Override
			protected void updateItem(Estado item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Naturalidade Mãe");
				} else {
					setText(item.toString());
				}
			}
		});

		COMBOusuarioMaeNAturalidade.setButtonCell(new ListCell<Estado>() {
			@Override
			protected void updateItem(Estado item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Naturalidade Mãe");
				} else {
					setText(item.toString());
				}
			}
		});

	}

	@Override
	protected void limparCampos() {
		// TODO Auto-generated method stub

	}

}
