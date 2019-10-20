package controller;

import javax.transaction.Transactional.TxType;

import EntidadeEnum.Estado;
import EntidadeEnum.SiglasEstados;
import EntidadeEnum.TipoUsuario;
import exception.ValidacaoException;
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
import model.Endereco;
import model.Entidade;
import model.Tela;
import model.Usuario;

public class ControleCadastro extends Controle {
	
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
	private TableView<Usuario> tabelaFuncionario;

	@FXML
	private TableColumn<Usuario, String> nomeTabelaFuncionario;

	@FXML
	private TableColumn<Usuario, String> cpfTabelaFuncionario;

	@FXML
	private TableColumn<Usuario, String> CargotabelaFuncionario;

	@FXML
	private TableColumn<Endereco, String> RuaTabFuncionario;

	@FXML
	private TableColumn<Endereco, String> BairroTabFuncionario;

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
     
		Object obj = event.getSource();
		
		if (obj == COMBOusuarioTipo) {
			
			if(COMBOusuarioTipo.getValue() == TipoUsuario.Professor) {
				TXusuarioMaeNasc.setVisible(false);
				TXusuarioMaeNasc.setDisable(true);
				
			}
			else if (COMBOusuarioTipo.getValue() == TipoUsuario.Aluno) {
				TXusuarioMaeNasc.setVisible(true);
				TXusuarioMaeNasc.setDisable(false);
			}
			
			
		}
		if(obj == BToutroResponsavel) {

			System.out.println(TipoUsuario.valueOf(COMBOusuarioTipo.getSelectionModel().getSelectedItem().toString()));
			
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

//	private void carregar(Usuario usuario)
//	{
//		Endereco endereco = null;
//		
//		if(usuario != null)
//			endereco = usuario.getEndereco();
//		else if(endereco == null)
//			endereco = new Endereco();
//		
//		endereco.setCidade(TXusuarioCidade.getText().trim());
//		endereco.setCep(TXusuarioCEP.getText().trim());
//		endereco.setEstado(SiglasEstados.valueOf((COMBOestadoUsuario.getSelectionModel().getSelectedItem().toString())));
//		endereco.setRua(TXusuarioRua.getText().trim());
//		endereco.setBairro(TXusuarioBairro.getText().trim());
//		endereco.setNumero(TXusuarioNumero.getText().trim());
//	
//		
//		
//		
//			usuario.setNome(TXusuarioNome.getText().trim());
//			usuario.setEndereco(endereco); 
//			usuario.setData_nasc(TXusuarioData_nasc.getValue());
//			usuario.setNaturalidade(COMBOusuarioNaturalidade.getSelectionModel().getSelectedItem().toString());
//			usuario.setTipo(TipoUsuario.valueOf(COMBOusuarioTipo.getSelectionModel().getSelectedItem().toString()));
//			usuario.setLogin(TXusuarioLogin.getText().trim());
//			usuario.setSenha(TXusuarioSenha.getText().trim());
//			
//			if(TXusuarioSenha.getText() == TXusuarioSenhaConfirmar.getText()) {
//			usuario.setSenha(TXusuarioSenha.getText());
//			}else {
//			new ValidacaoException("Senhas não correspondem!!");	
//			}
//				
//			
//			usuario.setCpf(TXusuario.getText().trim());
//			
//			usuario.setNumero_habilitacao(tfdNumeroHabilitacao.getText().trim());
//			
//	
//			fisica.setVencimento_habilitacao(dtpVencimento.getValue());
//			
//			//usuário
//			//usuário
//			fisica.setLogin(MaskFieldUtil.removerMascaraCpf(tfdCpf.getText().trim()));
//			fisica.setSenha(MaskFieldUtil.removerMascaraCpf(tfdCpf.getText().trim()));
//		}
//		else if(cbxTipo.getValue() == TipoCliente.JURIDICO)
//		{
//			if(juridica == null)
//				juridica = new Juridica();
//			juridica.setCodigo(tfdCodigo.getText().trim());
//			juridica.setNome(tfdNome.getText().trim());
//			juridica.setEndereco(endereco); 
//			
//			juridica.setCnpj(tfdCnpj.getText().trim());
//			juridica.setInscricao_estadual(tfdInscricao.getText().trim());
//			
//			//usuário
//			juridica.setLogin(MaskFieldUtil.removerMascaraCpf(tfdCodigo.getText().trim()));
//			juridica.setSenha(MaskFieldUtil.removerMascaraCpf(tfdCodigo.getText().trim()));
//			
//		}
//	}
//	
//	
	
	@Override
	protected void limparCampos() {
		// TODO Auto-generated method stub

	}

}
