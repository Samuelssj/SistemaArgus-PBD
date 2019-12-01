package controller;

import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javax.transaction.Transactional.TxType;

import EntidadeEnum.Estado;
import EntidadeEnum.SiglasEstados;
import EntidadeEnum.TipoUsuario;
import exception.BusinessException;
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
import model.Disciplina;
import model.Endereco;
import model.MaskFieldUtil;
import model.Pedagogo;
import model.Professor;
import model.Responsavel;
import model.Usuario;
import model.UsuarioTabAdapter;
import util.Criptografia;

public class ControleCadastro implements Initializable {

	private Fachada fachada = Fachada.getInstance();
	private Responsavel responsavel;
	private Usuario usuario;
	private Aluno aluno;
	private List<Usuario> usuarioTabAdapters;
	private List<Responsavel> responsavelTabAdapter;
	private Endereco endereco;
	private Professor professor;
	private Pedagogo pedagogo;

	@FXML
	private AnchorPane AnchoPane;

	@FXML
	private TabPane TabPane;

	@FXML
	private Tab TabListaCadastro;

	@FXML
	private Button BTListarTodos;

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
	private RadioButton Radiomae;

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
	private TableColumn<Usuario, String> nomeTabelaFuncionario;

	@FXML
	private TableColumn<Usuario, String> funcaoTabelaFuncionario;

	@FXML
	private TableColumn<Usuario, String> cpfTabFuncionario;

	@FXML
	private TableColumn<Usuario, String> SituacaoTabFuncionario;

	@FXML
	private TableView<Disciplina> tabelaDisciplinaProfessor;

	@FXML
	private TableColumn<Disciplina, String> TabDisciplinaProfessorNome;

	@FXML
	private TableColumn<Disciplina, String> TabDisciplinaProfessorCarga;

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

		if (obj == JBnovoCadastro) {

			TabListaCadastro.getTabPane().getSelectionModel().select(TabNovocadastro);
			// aqui funciona

		}
		if (obj == BTListarTodos) {
			CarregarTabelas();
			TXbuscarFuncionario.clear();
			BTListarTodos.setVisible(false);
		}

		if (obj == JBbuscarCadastro) {

			if (TXbuscarFuncionario.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
						"Preencha a busca!");
			} else {

				try {

					tabelaFuncionario.getItems().setAll(fachada.searchAllSuperUsuario((TXbuscarFuncionario.getText())));
					BTListarTodos.setVisible(true);
				} catch (Exception e) {
					Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar Cliente",
							"Erro ao buscar cliente", e.getMessage());
					e.printStackTrace();
				}
			}
		}

		if (obj.equals(BToutroResponsavel)) {

			TabPane.getSelectionModel().select(TabNovoResponsavel);
			
			
		}

		if (obj == BTcadastrarUsuario) {

			carregar();
			

		}
		if(obj == JBdeletar) {
			
			Usuario user = new Usuario();
			user = tabelaFuncionario.getSelectionModel().getSelectedItem();
			
		
			try {
				fachada.removeSuperUsuario(user.getId());
				System.out.println(user.getId());
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "DELETAR USUARIO", "Deletado",
						"Usuario Deletado!");
				CarregarTabelas();
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "DELETAR USUARIO", "Não Deletado",
						"Usuario não Deletado!");
			}
			
			
		}
		if (obj == JBbuscarCadastro) {
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

		if (obj == JBeditar) {
			preencherCampos();
			
		}
		if(obj == BTcadastrarComResponsavel) {
			
//			Aluno aluno1 = new Aluno();
//			Endereco endereco1 = new Endereco();
//			Responsavel res = new Responsavel();
//			endereco1.setCidade(TXusuarioCidade.getText().trim());
//			endereco1.setCep(TXusuarioCEP.getText().trim());
//			endereco1.setEstado(
//					SiglasEstados.valueOf(COMBOestadoUsuario.getSelectionModel().getSelectedItem().toString()));
//			endereco1.setRua(TXusuarioRua.getText().trim());
//			endereco1.setBairro(TXusuarioBairro.getText().trim());
//			endereco1.setNumero(TXusuarioNumero.getText().trim());
//			aluno1.setEndereco(endereco);
//			aluno1.setNome(TXusuarioNome.getText().trim());
//			aluno1.setEndereco(endereco);
//			aluno1.setData_nasc(TXusuarioData_nasc.getValue());
//			aluno1.setNaturalidade(COMBOusuarioNaturalidade.getSelectionModel().getSelectedItem());
//			aluno1.setTipo(TipoUsuario.valueOf(COMBOusuarioTipo.getSelectionModel().getSelectedItem().toString()));
//			aluno1.setPai(TXusuarioPaiNome.getText().trim());
//			aluno1.setMãe(TXusuarioMaeNome.getText().trim());
//			aluno1.setCpf(TXcpfUsuario.getText());
//			
//			if(tabelaResponsavel.getSelectionModel().getSelectedItem() == null) {
//				res = new Responsavel();
//				res.setNome(TXresponsavelNome.getText().trim());
//				res.setCpf(TXresponsavelCPF.getText().trim());
//				aluno1.setResponsavel(res);
//				
//			}else {
//				Usuario u = new Usuario();
//			
//				u = tabelaResponsavel.getSelectionModel().getSelectedItem();
//				
//				res.setNome(u.getNome());
//				res.setCpf(u.getCpf());
//				aluno1.setResponsavel(res);
//			}
//
//		
//			try {
//				// fachada.createOrUpdateEndereco(endereco);
//				fachada.createOrUpdateAluno(aluno1);
//				usuarioTabAdapters = fachada.searchAllSuperUsuario();
//				tabelaFuncionario.getItems().setAll(usuarioTabAdapters);
//				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
//						"O Aluno foi salvo com sucesso!");
//
//			} catch (Exception e) {
//
//				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Erro",
//						"O Aluno não foi salvo com sucesso!");
//
//			}
//
//			TabListaCadastro.getTabPane().getSelectionModel().select(TabListaCadastro);
//			LimparCampos();
//			
//			
			
			
		}
	}

	private void carregar() {

		if (COMBOusuarioTipo.getValue() == TipoUsuario.Aluno) {

			aluno = new Aluno();
			endereco = new Endereco();
			endereco.setCidade(TXusuarioCidade.getText().trim());
			endereco.setCep(TXusuarioCEP.getText().trim());
			endereco.setEstado(
					SiglasEstados.valueOf(COMBOestadoUsuario.getSelectionModel().getSelectedItem().toString()));
			endereco.setRua(TXusuarioRua.getText().trim());
			endereco.setBairro(TXusuarioBairro.getText().trim());
			endereco.setNumero(TXusuarioNumero.getText().trim());
			aluno.setEndereco(endereco);
			responsavel = new Responsavel();
			if (Radiomae.isSelected()) {
				responsavel.setNome(TXusuarioMaeNome.getText().trim());
				responsavel.setCpf(TXusuarioMaeCPF.getText().trim());
				aluno.setCpf("XXX.XXX.XXX-XX");

			}
			if (RadioPai.isSelected()) {
				responsavel.setNome(TXusuarioPaiNome.getText().trim());
				responsavel.setCpf(TXusuarioPaiCPF.getText().trim());
//				aluno.setCpf(TXusuarioPaiCPF.getText().trim());

			}
			if (RadioProprioresp.isSelected()) {
				aluno.setCpf(TXcpfUsuario.getText().trim());
			}
			aluno.setResponsavel(responsavel);

			aluno.setNome(TXusuarioNome.getText().trim());
			aluno.setEndereco(endereco);
			aluno.setData_nasc(TXusuarioData_nasc.getValue());
			aluno.setNaturalidade(COMBOusuarioNaturalidade.getSelectionModel().getSelectedItem());
			aluno.setTipo(TipoUsuario.valueOf(COMBOusuarioTipo.getSelectionModel().getSelectedItem().toString()));
			aluno.setPai(TXusuarioPaiNome.getText().trim());
			aluno.setMãe(TXusuarioMaeNome.getText().trim());
			 aluno.setCpf(TXcpfUsuario.getText());

		
			try {
				// fachada.createOrUpdateEndereco(endereco);
				fachada.createOrUpdateAluno(aluno);
				usuarioTabAdapters = fachada.searchAllSuperUsuario();
				tabelaFuncionario.getItems().setAll(usuarioTabAdapters);
				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
						"O Aluno foi salvo com sucesso!");

			} catch (Exception e) {

				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Erro",
						"O Aluno não foi salvo com sucesso!");

			}

			TabListaCadastro.getTabPane().getSelectionModel().select(TabListaCadastro);
			LimparCampos();
		} else if (COMBOusuarioTipo.getValue() == TipoUsuario.Administrador
				|| COMBOusuarioTipo.getValue() == TipoUsuario.Direcao
				|| COMBOusuarioTipo.getValue() == TipoUsuario.Secretaria) {

			usuario = new Usuario();
			endereco = new Endereco();
			endereco.setCidade(TXusuarioCidade.getText().trim());
			endereco.setCep(TXusuarioCEP.getText().trim());
			endereco.setEstado(
					SiglasEstados.valueOf(COMBOestadoUsuario.getSelectionModel().getSelectedItem().toString()));
			endereco.setRua(TXusuarioRua.getText().trim());
			endereco.setBairro(TXusuarioBairro.getText().trim());
			endereco.setNumero(TXusuarioNumero.getText().trim());
			usuario.setEndereco(endereco);
			usuario.setNome(TXusuarioNome.getText().trim());
			usuario.setNome(TXusuarioNome.getText().trim());
			usuario.setData_nasc(TXusuarioData_nasc.getValue());
			usuario.setNaturalidade(COMBOusuarioNaturalidade.getSelectionModel().getSelectedItem());
			usuario.setTipo(TipoUsuario.valueOf(COMBOusuarioTipo.getSelectionModel().getSelectedItem().toString()));
			usuario.setLogin(TXusuarioLogin.getText().trim());
			usuario.setSenha(TXusuarioSenha.getText().trim());
			usuario.setSituacao(true);
			try {

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
			LimparCampos();
		} else if (COMBOusuarioTipo.getValue() == TipoUsuario.Professor) {

			professor = new Professor();
			endereco = new Endereco();
			endereco.setCidade(TXusuarioCidade.getText().trim());
			endereco.setCep(TXusuarioCEP.getText().trim());
			endereco.setEstado(
					SiglasEstados.valueOf(COMBOestadoUsuario.getSelectionModel().getSelectedItem().toString()));
			endereco.setRua(TXusuarioRua.getText().trim());
			endereco.setBairro(TXusuarioBairro.getText().trim());
			endereco.setNumero(TXusuarioNumero.getText().trim());
			professor.setEndereco(endereco);
			professor.setNome(TXusuarioNome.getText().trim());
			professor.setNome(TXusuarioNome.getText().trim());
			professor.setData_nasc(TXusuarioData_nasc.getValue());
			professor.setNaturalidade(COMBOusuarioNaturalidade.getSelectionModel().getSelectedItem());
			professor.setTipo(TipoUsuario.valueOf(COMBOusuarioTipo.getSelectionModel().getSelectedItem().toString()));
			professor.setLogin(TXusuarioLogin.getText().trim());

			// professor.setSenha(Criptografia.criptografar((TXusuarioSenha.getText().trim().getBytes())));

			professor.setSenha(functioCrip2(TXusuarioSenha.getText().trim()));
			professor.setCpf(TXcpfUsuario.getText().trim());
			professor.setSituacao(true);

			try {

				fachada.createOrUpdateProfessor(professor);
				usuarioTabAdapters = fachada.searchAllSuperUsuario();
				tabelaFuncionario.getItems().setAll(usuarioTabAdapters);

				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
						"O Professor foi salvo com sucesso!");
			} catch (Exception e) {

				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Erro",
						"O Professor não foi salvo com sucesso!");

			}
			TabListaCadastro.getTabPane().getSelectionModel().select(TabListaCadastro);
			LimparCampos();
		} else if (COMBOusuarioTipo.getValue() == TipoUsuario.Pedagogo) {
			pedagogo = new Pedagogo();
			endereco = new Endereco();
			endereco.setCidade(TXusuarioCidade.getText().trim());
			endereco.setCep(TXusuarioCEP.getText().trim());
			endereco.setEstado(
					SiglasEstados.valueOf(COMBOestadoUsuario.getSelectionModel().getSelectedItem().toString()));
			endereco.setRua(TXusuarioRua.getText().trim());
			endereco.setBairro(TXusuarioBairro.getText().trim());
			endereco.setNumero(TXusuarioNumero.getText().trim());
			pedagogo.setEndereco(endereco);
			pedagogo.setNome(TXusuarioNome.getText().trim());
			pedagogo.setNome(TXusuarioNome.getText().trim());
			pedagogo.setData_nasc(TXusuarioData_nasc.getValue());
			pedagogo.setNaturalidade(COMBOusuarioNaturalidade.getSelectionModel().getSelectedItem());
			pedagogo.setTipo(TipoUsuario.valueOf(COMBOusuarioTipo.getSelectionModel().getSelectedItem().toString()));
			pedagogo.setLogin(TXusuarioLogin.getText().trim());
			pedagogo.setSenha(TXusuarioSenha.getText().trim());
			pedagogo.setCpf(TXcpfUsuario.getText().trim());
			pedagogo.setSituacao(true);
			try {

				fachada.createOrUpdatePedagogo(pedagogo);
				usuarioTabAdapters = fachada.searchAllSuperUsuario();
				tabelaFuncionario.getItems().setAll(usuarioTabAdapters);

				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
						"O Pedagogo foi salvo com sucesso!");
			} catch (Exception e) {

				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Erro",
						"O pedagogo não foi salvo com sucesso!");

			}
			TabListaCadastro.getTabPane().getSelectionModel().select(TabListaCadastro);
			LimparCampos();
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

		if (COMBOusuarioTipo.getValue() != TipoUsuario.Aluno) {
			TXusuarioMaeNome.setDisable(true);
			TXusuarioMaeCPF.setDisable(true);
			TXusuarioPaiNome.setDisable(true);
			TXusuarioPaiCPF.setDisable(true);

			Radiomae.setDisable(true);
			RadioPai.setDisable(true);
			RadioProprioresp.setSelected(true);
			TXcpfUsuario.setDisable(true);
			TXusuarioLogin.setDisable(false);
			TXusuarioSenha.setDisable(false);
			TXusuarioSenhaConfirmar.setDisable(false);
			RadioProprioresp.setSelected(true);
			

		} else {
			TXusuarioMaeNome.setDisable(false);
			TXusuarioMaeCPF.setDisable(false);
			TXusuarioPaiNome.setDisable(false);
			TXusuarioPaiCPF.setDisable(false);
			TXcpfUsuario.setDisable(false);
			TXusuarioLogin.setDisable(true);
			TXusuarioSenha.setDisable(true);
			TXusuarioSenhaConfirmar.setDisable(true);
			Radiomae.setDisable(false);
			RadioPai.setDisable(false);
			TXcpfUsuario.setDisable(true);

		}

		if (RadioProprioresp.isSelected()) {
			TXcpfUsuario.setDisable(false);
		} else {
			TXcpfUsuario.setDisable(true);
		}

	}

	public void preencherCampos() {

	
		Usuario user = new Usuario();
		user = tabelaFuncionario.getSelectionModel().getSelectedItem();
		
		if(user.getTipo() == TipoUsuario.Aluno) {
			Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro", "Erro",
					"edite o aluno no MENU ALUNO!");
			
		}else {
		TXusuarioNome.setText(user.getNome());
		TXusuarioCidade.setText(user.getEndereco().getCidade());
		TXusuarioCEP.setText(user.getEndereco().getCep());
		TXusuarioNumero.setText(user.getEndereco().getNumero());
		TXusuarioRua.setText(user.getEndereco().getRua());
		TXusuarioBairro.setText(user.getEndereco().getBairro());
		COMBOestadoUsuario.getSelectionModel().clearAndSelect(0);
		COMBOusuarioNaturalidade.getSelectionModel().clearAndSelect(0);
		COMBOusuarioTipo.getSelectionModel().clearAndSelect(0);
		TXusuarioData_nasc.setValue(user.getData_nasc());
		TXusuarioLogin.setText(user.getLogin());
		TXusuarioSenha.setText(user.getSenha());
		TXcpfUsuario.setText(user.getCpf());
		TabPane.getSelectionModel().select(TabNovocadastro);
		}
		
		
		
	}

	public void LimparCampos() {

		TXusuarioNome.clear();
		TXusuarioCidade.clear();
		TXusuarioCEP.clear();
		TXusuarioMaeNome.clear();
		TXusuarioPaiNome.clear();
		TXusuarioNumero.clear();
		TXusuarioRua.clear();
		TXusuarioBairro.clear();
		TXresponsavelNome.clear();
		TXresponsavelCPF.clear();
		TXcpfUsuario.clear();
		TXusuarioSenha.clear();
		TXusuarioSenhaConfirmar.clear();
		TXusuarioLogin.clear();
		TXusuarioPaiCPF.clear();
		TXusuarioMaeCPF.clear();
		COMBOestadoUsuario.getSelectionModel().clearSelection();
		COMBOusuarioNaturalidade.getSelectionModel().clearSelection();
		COMBOusuarioTipo.getSelectionModel().clearSelection();
		TXusuarioData_nasc.setValue(null);

	}

	public String functioCrip2(String senha) {

		String sen = "";

		MessageDigest md = null;

		try {

			md = MessageDigest.getInstance("MD5");

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();

		}

		BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));

		sen = hash.toString(16);

		return sen;

	}

	public void CarregarTabelas() {

		nomeTabelaFuncionario.setCellValueFactory(new PropertyValueFactory<>("nome"));
		funcaoTabelaFuncionario.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		cpfTabFuncionario.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		SituacaoTabFuncionario.setCellValueFactory(new PropertyValueFactory<>("situacao"));
		
		nomeTabResponsavel.setCellValueFactory(new PropertyValueFactory<>("nome"));
		cpfTabResponsavel.setCellValueFactory(new PropertyValueFactory<>("cpf"));

		try {

			usuarioTabAdapters = fachada.getInstance().searchAllSuperUsuario();
			tabelaFuncionario.getItems().setAll(usuarioTabAdapters);

			responsavelTabAdapter = fachada.getInstance().searchAllResponsavel();
			tabelaResponsavel.getItems().setAll(responsavelTabAdapter);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		init();
		CarregarTabelas();


	}

}


