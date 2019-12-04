package controller;

import java.util.List;

import application.Main;
import exception.BusinessException;
import exception.Menssagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Entidade;
import model.Tela;
import model.Usuario;

public class ControleRedefinirSenha extends Controle {
	Usuario usuario = new Usuario();
	private List<Usuario> usuarioTabAdapters;

	  @FXML
	    private AnchorPane AnchoPane;

	    @FXML
	    private TabPane TabPane;

	    @FXML
	    private Tab TabNovoResponsavel;

	    @FXML
	    private TextField TXnomeLoginADM;

	    @FXML
	    private TextField TXnomeSenhaADM;

	    @FXML
	    private Button BTlogin;

	    @FXML
	    private TextField TXnovaSenha;

	    @FXML
	    private TextField TXnovaSenhaConfirmar;

	    @FXML
	    private TableView<Usuario> TabelaSenhas;

	    @FXML
	    private TableColumn<Usuario, String> Tabnome;

	    @FXML
	    private TableColumn<Usuario, String> TabCpf;

	    @FXML
	    private Button BTAtualizar;

	    @FXML
	    private Button BTvoltar;
	@FXML
	public void action(ActionEvent event) {

	
		if (event.getSource() == BTvoltar) {

			Main.changeStage("log");

		}
		if (event.getSource() == BTlogin) {

			try {

				System.out.println(fachada);
				usuario = fachada.searchUser(TXnomeLoginADM.getText().trim(), TXnomeSenhaADM.getText().trim());
			
				
				if (usuario != null) {
					
									
					TXnovaSenha.setDisable(false);
					TXnovaSenhaConfirmar.setDisable(false);
					
					
					
					limparCampos();
				} else {
					Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Fazer Login", "Erro",
							"Loguin ou senha erradaAAA");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Fazer Login", "Erro",
						"Loguin ou senha errada");
				e2.printStackTrace();
			}

		}if(event.getSource() == BTAtualizar) {
		
			
			Usuario u = new Usuario();
			u = TabelaSenhas.getSelectionModel().getSelectedItem();
			
			u.setSenha(TXnovaSenha.getText().trim());

			

			
			try {
				fachada.createOrUpdateAluno(u);
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "senha trocada", "OK",
						" A senha foi alterada");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "senha não foi trocada", "erro",
						" A senha não foi alterada");
			}
			
			limparCampos();
		}

	}

	

	@Override
	public void update(Tela tela, Entidade entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		Tabnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		TabCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		//SituacaoTabFuncionario.setCellValueFactory(new PropertyValueFactory<>("numero"));

		try {

			usuarioTabAdapters = fachada.getInstance().searchAllSuperUsuario();
			TabelaSenhas.getItems().setAll(usuarioTabAdapters);
			System.out.println(usuarioTabAdapters);
			//System.out.println(usuarioTabAdapters);
			
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

	@Override
	protected void limparCampos() {
		// TODO Auto-generated method stub

	}

}
