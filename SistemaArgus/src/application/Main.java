package application;

import java.io.IOException;
import java.util.Date;

import EntidadeEnum.Estado;
import EntidadeEnum.TipoUsuario;
import dao.UsuarioDao;
import exception.BusinessException;
import fachada.Fachada;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Usuario;
import model.Endereco;
import model.Tela;

public class Main extends Application {
	private static Pane login, resetarSenha;
	private static Pane inicio;
	private static Scene sceneLogin, resetSenha;
	private static Scene sceneMenu;
	private static Stage stage;

	public static void main(String[] args) {
				
    //samuel ssj
	launch(args);

	}

	@Override
	public void start(Stage primaryStage) {

		try {

			login = FXMLLoader.load(getClass().getClassLoader().getResource("view/TelaLog.fxml"));

			inicio = FXMLLoader.load(getClass().getClassLoader().getResource("view/TelaMenu.fxml"));
			
			resetarSenha = FXMLLoader.load(getClass().getClassLoader().getResource("view/ResetarSenha.fxml"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("arquivo não encontrado");
		}

		sceneLogin = new Scene(login);
		primaryStage.setScene(sceneLogin);
	
		sceneMenu = new Scene(inicio);

	    resetSenha = new Scene(resetarSenha);	
		
		
		primaryStage.centerOnScreen();
		primaryStage.show();
		primaryStage.setTitle("Sistema (ARGUS-ACAD)");
		//primaryStage.setResizable(false);
		stage = primaryStage;

	}

	public static void changeStage(String nomeTela) {

		switch (nomeTela) {
		case "Menu":
			stage.setScene(sceneMenu);
			stage.centerOnScreen();
			break;

		case "resetar":
			stage.setScene(resetSenha);
			stage.centerOnScreen();
			stage.show();
			break;

		case "log":
			stage.setScene(sceneLogin);
			stage.centerOnScreen();
			stage.show();
			break;

		default:
			break;
		}

	}

//	public static Pane changePane(Tela tela) {
//		switch (tela) {
//
//		case telaCadastroPacientes:
//			return cadProfessorP;
//		default:
//			System.out.println("ajeite aqui");
//			break;
//
//		}
//		return new Pane();
//	}
}
