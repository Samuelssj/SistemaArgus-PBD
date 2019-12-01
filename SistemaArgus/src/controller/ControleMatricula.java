package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import exception.BusinessException;
import fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Aluno;
import model.Curriculo;
import model.Turma;

public class ControleMatricula implements Initializable{

	private List<Curriculo> curriculos;
	private List<Aluno> alunos;
	private List<Turma> turmas;
	private Fachada fachada;
	
	
	

    @FXML
    private AnchorPane AnchoPane;

    @FXML
    private TabPane TabPane;

    @FXML
    private Tab TabNota;

    @FXML
    private TextField TXBuscarCurriculo;

    @FXML
    private TableView<Curriculo> tabelaCurriculo;

    @FXML
    private TableColumn<Curriculo, String> TabCurriculoCod;

    @FXML
    private TableColumn<Curriculo, String> TabCurriculoNome;

    @FXML
    private Button BTSalvar;

    @FXML
    private ComboBox<?> ComboAnoLetivo;

    @FXML
    private Tab TabNota1;

    @FXML
    private TextField TXBuscarAluno;

    @FXML
    private TableView<Aluno> tabelaAluno;

    @FXML
    private TableColumn<Aluno, String> TabAlunoNome;

    @FXML
    private TableColumn<Aluno, String> TabAlunoCPF;

    @FXML
    private TableView<Turma> tabelaTurma;

    @FXML
    private TableColumn<Turma, String> TabTurmaNome;

    @FXML
    private TableColumn<Turma, String> TabTurmaAno;

    @FXML
    private Button BTBuscar;

    @FXML
    private Button BTvoltar;

    @FXML
    void action(ActionEvent event) {

    }

	
	
	
	
	
	
	
	
	
	
	
	
    public void  CarregarTabelas(){
		   
    	
 			TabCurriculoCod.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
 			TabCurriculoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
 			
 			TabAlunoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
 			TabAlunoCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
 			
 			TabTurmaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
 			TabTurmaAno.setCellValueFactory(new PropertyValueFactory<>("vagas"));
 			
 			
 			try {
 				curriculos = Fachada.getInstance().searchAllCurriculo();
 				tabelaCurriculo.getItems().setAll(curriculos);
 				
 				alunos = Fachada.getInstance().searchAllAluno();
 				tabelaAluno.getItems().setAll(alunos);
 				
 				turmas = Fachada.getInstance().searchAllTurma();
 				tabelaTurma.getItems().setAll(turmas);
 				
 				
 			} catch (BusinessException e) {
 				e.printStackTrace();
 			}
 	    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
	CarregarTabelas();
	}

}
