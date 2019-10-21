package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.transaction.Transactional.TxType;

import EntidadeEnum.Estado;
import EntidadeEnum.SiglasEstados;
import EntidadeEnum.TipoUsuario;
import exception.BusinessException;
import exception.Menssagem;
import exception.ValidacaoException;
import fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import model.Endereco;
import model.Entidade;
import model.Professor;
import model.Tela;
import model.Usuario;

public class ControleCadastro implements Initializable {

	private Fachada fachada;
	private Endereco endereço;
	private Usuario usuario;
	
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
    private Tab TabNovocadastro;

    @FXML
    private TextField TXusuarioNome;

    @FXML
    private TextField TXusuarioLogin;

    @FXML
    private TextField TXusuarioCidade;

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
    private ComboBox<SiglasEstados> COMBOestadoUsuario;

    @FXML
    private TextField TXcpfUsuario;

    @FXML
    private Tab TabNovoResponsavel;

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

		Object obj = event.getSource(); // Disseram que tinha algo a ver com Evento haa blz mayk cara brigadão Porn v tentar passsa o usuario 

		
		if(obj ==JBnovoCadastro ) {
			
			TabListaCadastro.getTabPane().getSelectionModel().select(TabNovocadastro);
			//aqui funciona
		}
		if(obj.equals(BToutroResponsavel)) {
//			TabNovocadastro.getTabPane().getSelectionModel().select(TabNovoResponsavel); tem que se ligar nos listiner/eventoskkk
			//Aí ele vinha parar aki
			TabPane.getSelectionModel().select(TabNovoResponsavel);
		}
		
		
		if (obj == BTcadastrarUsuario) {
			
			usuario = new Usuario();
			endereço = new Endereco();
//			 (usuario != null) {
//				endereço = usuario.getEndereco();
//			}
//			else if (endereço == null) {
//				endereço = new Endereco();
//			}
			
			endereço.setCidade(TXusuarioCidade.getText().trim());
			endereço.setCep(TXusuarioCEP.getText().trim());
			endereço.setEstado(SiglasEstados.valueOf(COMBOestadoUsuario.getSelectionModel().getSelectedItem().toString()));
			endereço.setRua(TXusuarioRua.getText().trim());
			endereço.setBairro(TXusuarioBairro.getText().trim());
			endereço.setNumero(TXusuarioNumero.getText().trim());
			usuario.setEndereco(endereço);
			usuario.setNome(TXusuarioNome.getText().trim());
			usuario.setNome(TXusuarioNome.getText().trim());
			usuario.setEndereco(endereço);
			usuario.setData_nasc(TXusuarioData_nasc.getValue());
			usuario.setNaturalidade(COMBOusuarioNaturalidade.getSelectionModel().getSelectedItem().toString());
			usuario.setTipo(TipoUsuario.valueOf(COMBOusuarioTipo.getSelectionModel().getSelectedItem().toString()));
			usuario.setLogin(TXusuarioLogin.getText().trim());
			usuario.setSenha(TXusuarioSenha.getText().trim());
			
			System.out.println(usuario.getLogin());
			System.out.println(usuario.getNaturalidade());
			System.out.println(usuario.getNome());
			System.out.println(usuario.getSenha());
			System.out.println(usuario.getData_nasc());
			System.out.println(usuario.getEndereco());
			System.out.println(usuario.getTipo());
			System.out.println("endereço");
			
			System.out.println(endereço.getBairro());
			System.out.println(endereço.getCep());
			System.out.println(endereço.getCidade());
			System.out.println(endereço.getNumero());
			System.out.println(endereço.getRua());
			System.out.println(endereço.getEstado());
			
			
			
			
			try {
				//fachada.createOrUpdateEndereco(endereço);
				fachada.createOrUpdatePessoa(usuario);
				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
						"O Usuário foi salvo com sucesso!");
			} catch (Exception e) {
				// TODO: handle exception
				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Erro",
						"O Usuário não foi salvo com sucesso!");
				
			}
			
			
			


		}
	}



	
	
	private void carregar() {
		usuario = new Usuario();
		Endereco endereco = null;

		if (usuario != null)
			endereco = usuario.getEndereco();
		else if (endereco == null)
			endereco = new Endereco();

		endereco.setCidade(TXusuarioCidade.getText().trim());
		endereco.setCep(TXusuarioCEP.getText().trim());
		endereco.setEstado(SiglasEstados.valueOf(COMBOestadoUsuario.getSelectionModel().getSelectedItem().toString()));

						
		endereco.setRua(TXusuarioRua.getText().trim());
		endereco.setBairro(TXusuarioBairro.getText().trim());
		endereco.setNumero(TXusuarioNumero.getText().trim());

		usuario.setNome(TXusuarioNome.getText().trim());
		usuario.setEndereco(endereco);
		usuario.setData_nasc(TXusuarioData_nasc.getValue());
		usuario.setNaturalidade(COMBOusuarioNaturalidade.getSelectionModel().getSelectedItem().toString());
		usuario.setTipo(TipoUsuario.valueOf(COMBOusuarioTipo.getSelectionModel().getSelectedItem().toString()));
		usuario.setLogin(TXusuarioLogin.getText().trim());
		usuario.setSenha(TXusuarioSenha.getText().trim());


	
	}

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

		// COMBOBOX SIGLAS ESTADOS

		COMBOestadoUsuario.getItems().setAll(SiglasEstados.values());
		COMBOestadoUsuario.getItems().setAll(SiglasEstados.values());

		COMBOestadoUsuario.setButtonCell(new ListCell<SiglasEstados>() {
			@Override
			protected void updateItem(SiglasEstados item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Estado");
				} else {
					setText(item.toString());
				}
			}
		});

		COMBOestadoUsuario.setButtonCell(new ListCell<SiglasEstados>() {
			@Override
			protected void updateItem(SiglasEstados item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Estado");
				} else {
					setText(item.toString());
				}
			}
		});

	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		fachada = Fachada.getInstance();
		
		init();
		
		

		
	}
	
	
	//
//	if (obj == COMBOusuarioTipo) {
//
//		if (COMBOusuarioTipo.getValue() == TipoUsuario.Professor) {
//			
//			
//
//		} else if (COMBOusuarioTipo.getValue() == TipoUsuario.Aluno) {
//			
//		}
//
//	}

}
