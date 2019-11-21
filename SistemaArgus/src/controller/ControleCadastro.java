package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import EntidadeEnum.Estado;
import EntidadeEnum.SiglasEstados;
import EntidadeEnum.TipoUsuario;
import exception.Menssagem;
import fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Aluno;
import model.Endereco;
import model.MaskFieldUtil;
import model.Responsavel;
import model.Usuario;
import model.UsuarioTabAdapter;


public class ControleCadastro implements Initializable {

	private Fachada fachada = Fachada.getInstance();
	private Endereco endereço;
	private Responsavel responsavel;
	private Usuario usuario;
	private Aluno aluno;
	private List<Usuario> usuarioTabAdapters;
	private Endereco endereco;
	

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
    private TextField TXusuarioMaeNome;

    @FXML
    private TextField TXusuarioMaeCPF;

    @FXML
    private TextField TXusuarioPaiNome;

    @FXML
    private RadioButton RadioProprioresp;

    @FXML
    private PasswordField TXusuarioSenha;

    @FXML
    private PasswordField TXusuarioSenhaConfirmar;

    @FXML
    private DatePicker TXusuarioData_nasc;

    @FXML
    private Button BToutroResponsavel;

    @FXML
    private TextField TXcpfUsuario;

    @FXML
    private TextField TXusuarioCidade;

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
    private TableView<Responsavel> tabelaResponsavel;

    @FXML
    private TableColumn<Responsavel, String> nomeTabResponsavel;

    @FXML
    private TableColumn<Responsavel, String> cpfTabResponsavel;


    @FXML
    private TableView<Usuario> tabelaFuncionario;

    @FXML
    private TableColumn<UsuarioTabAdapter,String> nomeTabelaFuncionario;

    @FXML
    private TableColumn<UsuarioTabAdapter,String>funcaoTabelaFuncionario;

    @FXML
    private TableColumn<UsuarioTabAdapter,String>  cpfTabFuncionario;

    @FXML
    private TableColumn<UsuarioTabAdapter,String> SituacaoTabFuncionario;

 
    @FXML
    private ComboBox<Estado> COMBOusuarioNaturalidade;


    @FXML
    private ComboBox<TipoUsuario> COMBOusuarioTipo;
    
    @FXML
    private ComboBox<SiglasEstados> COMBOestadoUsuario;


    
	@FXML

	public void action(ActionEvent event) {

		Object obj = event.getSource(); //

		visibilidade();
		
		
		if(obj ==JBnovoCadastro ) {
			
			TabListaCadastro.getTabPane().getSelectionModel().select(TabNovocadastro);
			//aqui funciona
		}
		
		if(obj == JBbuscarCadastro) {
			
			
			if (TXbuscarFuncionario.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
						"Preencha a busca!");
			} else {

				try {

					tabelaFuncionario.getItems().setAll(fachada.searchAllSuperUsuario((TXbuscarFuncionario.getText())));

				} catch (Exception e) {
					Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar Cliente",
							"Erro ao buscar cliente", e.getMessage());
					e.printStackTrace();
				}
			}
		}
		
		if(obj.equals(BToutroResponsavel)) {
//			TabNovocadastro.getTabPane().getSelectionModel().select(TabNovoResponsavel); tem que se ligar nos listiner/eventoskkk
			//Aí ele vinha parar aki
			TabPane.getSelectionModel().select(TabNovoResponsavel);
		}
		
		
		if (obj == BTcadastrarUsuario) {
			
			carregar();
			
			

		}
		if(obj == JBbuscarCadastro) {
			if(TXbuscarFuncionario.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
						"Preencha a busca!");
				
			}else {
				try {
					tabelaFuncionario.getItems().setAll(fachada.searchAllAluno(TXbuscarFuncionario.getText()));
					
				} catch (Exception e) {
					Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar Cliente",
							"Erro ao buscar cliente", e.getMessage());
					e.printStackTrace();				}
			}
		}
	}



	
	
	private void carregar() {
		
		if(COMBOusuarioTipo.getValue() == TipoUsuario.Aluno) {
			
			aluno = new Aluno();
			endereço = new Endereco();
			endereço.setCidade(TXusuarioCidade.getText().trim());
			endereço.setCep(TXusuarioCEP.getText().trim());
			endereço.setEstado(SiglasEstados.valueOf(COMBOestadoUsuario.getSelectionModel().getSelectedItem().toString()));
			endereço.setRua(TXusuarioRua.getText().trim());
			endereço.setBairro(TXusuarioBairro.getText().trim());
			endereço.setNumero(TXusuarioNumero.getText().trim());
			aluno.setEndereco(endereço);
			responsavel = new Responsavel();
			if(Radiomãe.isSelected()) {
				responsavel.setNome(TXusuarioMaeNome.getText().trim());
				responsavel.setCpf(TXusuarioMaeCPF.getText().trim());
			}if(RadioPai.isSelected()) {
				responsavel.setNome(TXusuarioPaiNome.getText().trim());
				responsavel.setCpf(TXusuarioPaiCPF.getText().trim());
			}
			aluno.setResponsavel(responsavel);
			
			aluno.setNome(TXusuarioNome.getText().trim());
			aluno.setEndereco(endereço);
			aluno.setData_nasc(TXusuarioData_nasc.getValue());
			aluno.setNaturalidade(COMBOusuarioNaturalidade.getSelectionModel().getSelectedItem().toString());
			aluno.setTipo(TipoUsuario.valueOf(COMBOusuarioTipo.getSelectionModel().getSelectedItem().toString()));
			aluno.setPai(TXusuarioPaiNome.getText().trim());
			aluno.setMãe(TXusuarioMaeNome.getText().trim());
			aluno.setCpf(TXcpfUsuario.getText());
			
			System.out.println(aluno);
			try {
				//fachada.createOrUpdateEndereco(endereço);
				fachada.createOrUpdateAluno(aluno);
				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
						"O Aluno foi salvo com sucesso!");
			} catch (Exception e) {
				
				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Erro",
						"O Aluno não foi salvo com sucesso!");
				
			}
			
			
		}
		else if (COMBOusuarioTipo.getValue() == TipoUsuario.Administrador) {
			
			usuario = new Usuario();
			endereço = new Endereco();
			endereço.setCidade(TXusuarioCidade.getText().trim());
			endereço.setCep(TXusuarioCEP.getText().trim());
			endereço.setEstado(SiglasEstados.valueOf(COMBOestadoUsuario.getSelectionModel().getSelectedItem().toString()));
			endereço.setRua(TXusuarioRua.getText().trim());
			endereço.setBairro(TXusuarioBairro.getText().trim());
			endereço.setNumero(TXusuarioNumero.getText().trim());
			usuario.setEndereco(endereço);
			usuario.setNome(TXusuarioNome.getText().trim());
			usuario.setNome(TXusuarioNome.getText().trim());
			usuario.setData_nasc(TXusuarioData_nasc.getValue());
			usuario.setNaturalidade(COMBOusuarioNaturalidade.getSelectionModel().getSelectedItem().toString());
			usuario.setTipo(TipoUsuario.valueOf(COMBOusuarioTipo.getSelectionModel().getSelectedItem().toString()));
			usuario.setLogin(TXusuarioLogin.getText().trim());
			usuario.setSenha(TXusuarioSenha.getText().trim());
			usuario.setSituacao(true);
			try {
				//fachada.createOrUpdateEndereco(endereço);
				fachada.createOrUpdatePessoa(usuario);
				usuarioTabAdapters = fachada.searchAllSuperUsuario();
				tabelaFuncionario.getItems().setAll(usuarioTabAdapters);
				
				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
						"O Usuário foi salvo com sucesso!");
			} catch (Exception e) {
				
				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Erro",
						"O Usuário não foi salvo com sucesso!");
				
			}
			TabListaCadastro.getTabPane().getSelectionModel().select(TabListaCadastro);
		}
	

	
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
//
//		COMBOusuarioPaiNaturalidade.getItems().setAll(Estado.values());
//		COMBOusuarioPaiNaturalidade.getItems().setAll(Estado.values());
//
//		COMBOusuarioPaiNaturalidade.setButtonCell(new ListCell<Estado>() {
//			@Override
//			protected void updateItem(Estado item, boolean empty) {
//				super.updateItem(item, empty);
//				if (empty || item == null) {
//					setText("Naturalidade Pai");
//				} else {
//					setText(item.toString());
//				}
//			}
//		});
//
//		COMBOusuarioPaiNaturalidade.setButtonCell(new ListCell<Estado>() {
//			@Override
//			protected void updateItem(Estado item, boolean empty) {
//				super.updateItem(item, empty);
//				if (empty || item == null) {
//					setText("Naturalidade Pai");
//				} else {
//					setText(item.toString());
//				}
//			}
//		});

		// COMBOBOX NATURALIDADE MAE
//
//		COMBOusuarioMaeNAturalidade.getItems().setAll(Estado.values());
//		COMBOusuarioMaeNAturalidade.getItems().setAll(Estado.values());
//
//		COMBOusuarioMaeNAturalidade.setButtonCell(new ListCell<Estado>() {
//			@Override
//			protected void updateItem(Estado item, boolean empty) {
//				super.updateItem(item, empty);
//				if (empty || item == null) {
//					setText("Naturalidade Mãe");
//				} else {
//					setText(item.toString());
//				}
//			}
//		});
//
//		COMBOusuarioMaeNAturalidade.setButtonCell(new ListCell<Estado>() {
//			@Override
//			protected void updateItem(Estado item, boolean empty) {
//				super.updateItem(item, empty);
//				if (empty || item == null) {
//					setText("Naturalidade Mãe");
//				} else {
//					setText(item.toString());
//				}
//			}
//		});

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
	
	public void visibilidade() {
		
		if(COMBOusuarioTipo.getValue() != TipoUsuario.Aluno) {
			TXusuarioMaeNome.setDisable(true);
			TXusuarioMaeCPF.setDisable(true);
			TXusuarioPaiNome.setDisable(true);
			TXusuarioPaiCPF.setDisable(true);
	
			Radiomãe.setDisable(true);
			RadioPai.setDisable(true);
			RadioProprioresp.setSelected(true);
			TXcpfUsuario.setDisable(true);
			TXusuarioLogin.setDisable(false);
			TXusuarioSenha.setDisable(false);
			TXusuarioSenhaConfirmar.setDisable(false);
			RadioProprioresp.setSelected(true);
			
		}else{
			TXusuarioMaeNome.setDisable(false);
			TXusuarioMaeCPF.setDisable(false);
			TXusuarioPaiNome.setDisable(false);
			TXusuarioPaiCPF.setDisable(false);
			TXcpfUsuario.setDisable(false);
			TXusuarioLogin.setDisable(true);
			TXusuarioSenha.setDisable(true);
			TXusuarioSenhaConfirmar.setDisable(true);
			
			Radiomãe.setDisable(false);
			RadioPai.setDisable(false);
			TXcpfUsuario.setDisable(true);
		}
		
		if (RadioProprioresp.isSelected()) {
			TXcpfUsuario.setDisable(false);
		}else {
			TXcpfUsuario.setDisable(true);
		}
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		init();
		
//		MaskFieldUtil.cpfField(TXcpfUsuario);
//	MaskFieldUtil.foneField(TXusuarioCidade);
//		MaskFieldUtil.cepField(TXusuarioCEP);
//		

		nomeTabelaFuncionario.setCellValueFactory(new PropertyValueFactory<>("nome"));
		funcaoTabelaFuncionario.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		cpfTabFuncionario.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		SituacaoTabFuncionario.setCellValueFactory(new PropertyValueFactory<>("situacao"));
		//SituacaoTabFuncionario.setCellValueFactory(new PropertyValueFactory<>("numero"));

		try {

			usuarioTabAdapters = fachada.getInstance().searchAllSuperUsuario();
			tabelaFuncionario.getItems().setAll(usuarioTabAdapters);
			System.out.println(usuarioTabAdapters);
			//System.out.println(usuarioTabAdapters);
			
		} catch (Exception e) {
			e.printStackTrace();
		}


//
	}
		

		
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


