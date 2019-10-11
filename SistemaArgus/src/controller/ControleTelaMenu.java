package controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class ControleTelaMenu implements Initializable {

	private Pane CadastroPessoa,CadProfessor;

    @FXML
    private AnchorPane AnchoPane;

    @FXML
    private MenuItem menuCadastroAluno;

    @FXML
    private MenuItem menuCadastroProfessor;

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
    private MenuItem menuSair;

    @FXML
    private MenuItem menuSobre;

    @FXML
    private MenuItem menuTrocarUser;

    @FXML
    private ImageView menuIcoLogoff;

    @FXML
    private AnchorPane pane;

	@FXML
	void action(ActionEvent event) {

		if (event.getSource() == menuCadastroAluno) {

			atualizarTela("pessoa");
		}
		if(event.getSource() == menuCadastroProfessor) {
			atualizarTela("CadProfessor");
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			CadastroPessoa = FXMLLoader.load(getClass().getClassLoader().getResource("view/CadastroAluno.fxml"));
			CadProfessor = FXMLLoader.load(getClass().getClassLoader().getResource("view/CadastroProfessor.fxml"));
			
			
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
		
		if (tela.equalsIgnoreCase("CadProfessor")) {
			AnchorPane.setBottomAnchor(CadProfessor, 0.0);
			AnchorPane.setLeftAnchor(CadProfessor, 0.0);
			AnchorPane.setRightAnchor(CadProfessor, 0.0);
			AnchorPane.setTopAnchor(CadProfessor, 0.0);
			pane.getChildren().setAll(CadProfessor);
		}
		
	}
}
