package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import model.Entidade;
import model.Usuario;
import util.PostgresBackup;

public class ControleTelaMenu implements Initializable {

	private Pane CadastroPessoa, AlunoDetalhe, CadastroDisciplina, Curriculo, CadastroNota, cadastroMatricula, CadastroAcompanhamento;
   
	@FXML
	private AnchorPane AnchoPane;

	@FXML
	private MenuItem menuCadastroAluno;

	@FXML
	private MenuItem menuCadastroCurriculo;

    @FXML
    private MenuItem menuCadastroAcompanhamento;


	@FXML
	private MenuItem menuCadastroDisciplina;

	@FXML
	private MenuItem menuCadastroMatricula;

	@FXML
	private ImageView menuIcoCad;

	@FXML
	private Menu menuLogoff;

	@FXML
	private MenuItem menuAluno;

	@FXML
	private ImageView menuIcoAluno;

	@FXML
	private MenuItem menuResponsavel;

	@FXML
	private ImageView menuIcoResponsavel;

	@FXML
	private MenuItem menuProfessor;

	@FXML
	private ImageView menuIcoProfessor;

	@FXML
	private MenuItem menuPedagogo;

	@FXML
	private MenuItem menuCadastroNota;

	@FXML
	private ImageView menuIcoPedagogo;

	@FXML
	private MenuItem menuHistorico;

	@FXML
	private ImageView menuIcoHist;

	@FXML
	private MenuItem menuFinanceiro;

	@FXML
	private ImageView menuIcoFinan;

	@FXML
	private Label itemMenuCargo;

	@FXML
	private MenuItem menuSair;

	@FXML
	private MenuItem menuSobre;

	@FXML
	private MenuItem menuTrocarUser;

	@FXML
	private AnchorPane pane;

	@FXML
	void action(ActionEvent event) throws IOException, InterruptedException {

		if (event.getSource() == menuCadastroAluno) {

			atualizarTela("pessoa");
			//itemMenuCargo.setText();

		}
		if (event.getSource() == menuAluno) {
			atualizarTela("AlunoDetalhe");
		}
		if (event.getSource() == menuCadastroDisciplina) {
			atualizarTela("disciplina");
			
		}
		if (event.getSource() == menuSair) {
			 PostgresBackup b = new PostgresBackup();  
	        b.realizaBackup(); 
			System.exit(0);
		}
		if (event.getSource() == menuTrocarUser) {
			Main.changeStage("log");

		}

		if (event.getSource() == menuCadastroCurriculo) {
			atualizarTela("curriculo");

		}
		if (event.getSource() == menuCadastroNota) {
			atualizarTela("nota");

		}
		
		if (event.getSource() == menuCadastroMatricula) {
			atualizarTela("matricula");

		}
		if (event.getSource() ==menuCadastroAcompanhamento) {
			atualizarTela("acompanhamento");

		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		itemMenuCargo.setText(logi.getUsuario().getNome());

		try {
			CadastroPessoa = FXMLLoader.load(getClass().getClassLoader().getResource("view/Cadastro.fxml"));
			AlunoDetalhe = FXMLLoader.load(getClass().getClassLoader().getResource("view/Aluno.fxml"));
			CadastroDisciplina = FXMLLoader.load(getClass().getClassLoader().getResource("view/CadastroDisciplina.fxml"));
			Curriculo = FXMLLoader.load(getClass().getClassLoader().getResource("view/Curriculo.fxml"));
			CadastroNota = FXMLLoader.load(getClass().getClassLoader().getResource("view/CadastroNota.fxml"));
			cadastroMatricula  = FXMLLoader.load(getClass().getClassLoader().getResource("view/CadastroMatricula.fxml"));
			CadastroAcompanhamento = FXMLLoader.load(getClass().getClassLoader().getResource("view/Acompanhamento.fxml"));
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void atualizarTela(String tela) {

		if (tela.equalsIgnoreCase("pessoa")) {
			AnchorPane.setBottomAnchor(CadastroPessoa, 0.0);
			AnchorPane.setLeftAnchor(CadastroPessoa, 0.0);
			AnchorPane.setRightAnchor(CadastroPessoa, 0.0);
			AnchorPane.setTopAnchor(CadastroPessoa, 0.0);
			pane.getChildren().setAll(CadastroPessoa);
		}

		if (tela.equalsIgnoreCase("alunoDetalhe")) {
			AnchorPane.setBottomAnchor(AlunoDetalhe, 0.0);
			AnchorPane.setLeftAnchor(AlunoDetalhe, 0.0);
			AnchorPane.setRightAnchor(AlunoDetalhe, 0.0);
			AnchorPane.setTopAnchor(AlunoDetalhe, 0.0);
			pane.getChildren().setAll(AlunoDetalhe);
		}
		if (tela.equalsIgnoreCase("disciplina")) {
			AnchorPane.setBottomAnchor(CadastroDisciplina, 0.0);
			AnchorPane.setLeftAnchor(CadastroDisciplina, 0.0);
			AnchorPane.setRightAnchor(CadastroDisciplina, 0.0);
			AnchorPane.setTopAnchor(CadastroDisciplina, 0.0);
			pane.getChildren().setAll(CadastroDisciplina);
		}
		if (tela.equalsIgnoreCase("curriculo")) {
			AnchorPane.setBottomAnchor(Curriculo, 0.0);
			AnchorPane.setLeftAnchor(Curriculo, 0.0);
			AnchorPane.setRightAnchor(Curriculo, 0.0);
			AnchorPane.setTopAnchor(Curriculo, 0.0);
			pane.getChildren().setAll(Curriculo);
		}

		if (tela.equalsIgnoreCase("nota")) {
			AnchorPane.setBottomAnchor(CadastroNota, 0.0);
			AnchorPane.setLeftAnchor(CadastroNota, 0.0);
			AnchorPane.setRightAnchor(CadastroNota, 0.0);
			AnchorPane.setTopAnchor(CadastroNota, 0.0);
			pane.getChildren().setAll(CadastroNota);
		}
		
		if (tela.equalsIgnoreCase("matricula")) {
			AnchorPane.setBottomAnchor(cadastroMatricula, 0.0);
			AnchorPane.setLeftAnchor(cadastroMatricula, 0.0);
			AnchorPane.setRightAnchor(cadastroMatricula, 0.0);
			AnchorPane.setTopAnchor(cadastroMatricula, 0.0);
			pane.getChildren().setAll(cadastroMatricula);
		}
		if (tela.equalsIgnoreCase("acompanhamento")) {
			AnchorPane.setBottomAnchor(CadastroAcompanhamento, 0.0);
			AnchorPane.setLeftAnchor(CadastroAcompanhamento, 0.0);
			AnchorPane.setRightAnchor(CadastroAcompanhamento, 0.0);
			AnchorPane.setTopAnchor(CadastroAcompanhamento, 0.0);
			pane.getChildren().setAll(CadastroAcompanhamento);
		}
	}

}
