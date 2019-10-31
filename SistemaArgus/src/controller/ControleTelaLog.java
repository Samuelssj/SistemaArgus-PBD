package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import dao.Dao;
import exception.BusinessException;
import exception.Menssagem;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Entidade;
import model.Tela;
import model.Usuario;

public class ControleTelaLog extends Controle {
	
	private Usuario usuario;

	@FXML
	private Button JBentrar;

	@FXML
	private PasswordField TxSenha;

	@FXML
	private TextField TxLogin;

	@FXML
	private Button JBsair;

	@FXML
	private Button JBresetarSenha;

	@FXML
	public void action(ActionEvent e) {
		if (e.getSource() == JBentrar) {
			
			
			Main.changeStage("Menu");
//			
//			try {
//				usuario = fachada.searchUser(TxLogin.getText().trim(), TxSenha.getText().trim());
//				
//				if(usuario != null) {
//					Main.changeStage("Menu");
//					limparCampos();
//				}else {
//				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION,"Fazer Login", "Erro", "Loguin ou senha erradaAAA");
//				}
//			} catch (Exception e2) {
//				// TODO: handle exception
//				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION,"Fazer Login", "Erro", "Loguin ou senha errada");
//				e2.printStackTrace();
//			}
			
			
			
		}

		if (e.getSource() == JBresetarSenha) {
			System.out.println("mudar a senha");
		}

		if(e.getSource() ==JBsair) {
//			if(Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sair", "sair do sistema ", "Deseja sair do Sistema?")) {
//				System.exit(0);
//			}
			System.exit(0);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Tela tela, Entidade entidade) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		try {
			Long cont = fachada.searchCont(Usuario.class);

			if (cont == 0) {
				Dao.resetConnection();
				model.Usuario usuario = fachada.searchUsuario(1);
				fachada.createOrUpdatePessoa(usuario);
			}

		} catch (BusinessException e) {

			e.printStackTrace();
		}

		
	}

	@Override
	protected void limparCampos() {
		TxLogin.setText("");
		TxSenha.setText("");
		
	}
	
	

	
}
