package controller;

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

public class ControleTelaMenu implements Initializable {

	private Pane CadastroPessoa,AlunoDetalhe, CadastroDisciplina;

	 @FXML
	    private AnchorPane AnchoPane;

	    @FXML
	    private MenuItem menuCadastroAluno;

	    @FXML
	    private MenuItem menuCadastroDisciplina;
	    
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
	void action(ActionEvent event) {

		if (event.getSource() == menuCadastroAluno) {

			atualizarTela("pessoa");
			itemMenuCargo.setText("Pessoa");
			
		}
		if(event.getSource() == menuAluno) {
			atualizarTela("AlunoDetalhe");
		}
		if(event.getSource() == menuCadastroDisciplina) {
			atualizarTela("disciplina");
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			CadastroPessoa = FXMLLoader.load(getClass().getClassLoader().getResource("view/Cadastro.fxml"));
			AlunoDetalhe = FXMLLoader.load(getClass().getClassLoader().getResource("view/Aluno.fxml"));
			CadastroDisciplina = FXMLLoader.load(getClass().getClassLoader().getResource("view/CadastroDisciplina.fxml"));
			
			
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
	}
}
