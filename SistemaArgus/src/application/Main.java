package application;

import java.io.IOException;

import dao.PessoaDao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Pessoa;
import model.Tela;

public class Main extends Application {
	private static Pane login;
	private static Pane inicio, cadProfessorP;
	private static Scene sceneLogin, cadProfessor;
	private static Scene sceneMenu;
	private static Stage stage;

	public static void main(String[] args) {
		
//		PessoaDao repositorioPessoa = new PessoaDao();
//		Pessoa pessoa = new Pessoa();
//		pessoa.setNome("juba");
//		pessoa.setIdade(12);
//		repositorioPessoa.salvar(pessoa);
//		
		
		

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) {

		try {

			login = FXMLLoader.load(getClass().getClassLoader().getResource("view/TelaLog.fxml"));

			inicio = FXMLLoader.load(getClass().getClassLoader().getResource("view/TelaMenu.fxml"));
		// = FXMLLoader.load(getClass().getClassLoader().getResource("view/CadastroProfessor.fxml"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("arquivo não encontrado");
		}

		sceneLogin = new Scene(login);
		primaryStage.setScene(sceneLogin);

		sceneMenu = new Scene(inicio);

		primaryStage.centerOnScreen();
		primaryStage.show();
		primaryStage.setTitle("Sistema (ARGUS-ACAD)");
		primaryStage.setResizable(false);
		stage = primaryStage;

	}

	public static void changeStage(String nomeTela) {

		switch (nomeTela) {
		case "Menu":
			stage.setScene(sceneMenu);
			stage.centerOnScreen();
			break;
//
//		case "cadProfessor":
//			stage.setScene(cadProfessor);
//			stage.centerOnScreen();
//			stage.show();
//			break;

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
