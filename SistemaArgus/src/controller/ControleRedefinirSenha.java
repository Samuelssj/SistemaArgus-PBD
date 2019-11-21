package controller;

import application.Main;
import exception.Menssagem;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import model.Entidade;
import model.Tela;
import model.Usuario;

public class ControleRedefinirSenha extends Controle {
	Usuario usuario = new Usuario();

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
	private Button BTAtualizar;

	@FXML
	private Button BTvoltar;

	@FXML
	private Button BTlogin;

	@FXML
	private TextField TXnovaSenha;

	@FXML
	private TextField TXnovaSenhaConfirmar;

	@FXML
	public void action(ActionEvent event) {

		System.out.println("pegaaa");
		if (event.getSource() == BTvoltar) {

			Main.changeStage("log");

		}
		if (event.getSource() == BTlogin) {

			try {

				System.out.println(TXnomeLoginADM.getText().trim());
				System.out.println(TXnomeSenhaADM.getText().trim());

				System.out.println(fachada);
				usuario = fachada.searchUser(TXnomeLoginADM.getText().trim(), TXnomeSenhaADM.getText().trim());

				if (usuario != null) {
					Main.changeStage("Menu");
					//
					
					CamposEditavel
					//
					
					
					
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

		}

	}

	

	@Override
	public void update(Tela tela, Entidade entidade) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void limparCampos() {
		// TODO Auto-generated method stub

	}

}
