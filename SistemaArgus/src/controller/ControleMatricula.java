package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import exception.BusinessException;
import exception.Menssagem;
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
import javafx.scene.control.Alert.AlertType;
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
	private Turma turma = new Turma();
	
	

    @FXML
    private AnchorPane AnchoPane;

    @FXML
    private TextField TXVagas; 
    
    @FXML
    private TabPane TabPane;

    @FXML
    private Tab TabNota;

    @FXML
    private Button BTMostrarCurriculos;
    
    @FXML
    private TextField TXBuscarCurriculo;

    @FXML
    private TableView<Curriculo> tabelaCurriculo;

    @FXML
    private TableColumn<Curriculo, String> TabCurriculoCod;
    
    @FXML
    private Button BTSalvar1;

    @FXML
    private Button BTproximo;

    @FXML
    private TableColumn<Curriculo, String> TabCurriculoNome;

    @FXML
    private Button BTSalvar2;

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

    	Object obj = event.getSource();
    	
    	if(obj == BTMostrarCurriculos) {
    		
    		CarregarTabelas();
    	}
    	
    	if(obj == BTSalvar1) {
    		//certo
    		Turma turma1 = new Turma();
    		
    		turma1.setCurriculo(tabelaCurriculo.getSelectionModel().getSelectedItem());
    		turma1.setNome(TXBuscarCurriculo.getText().trim());
    		turma1.setVagas(Integer.parseInt(TXVagas.getText().trim()));
    		turma1.setSituacao(true);
    		
    		
    		try {
    			fachada.getInstance().createOrUpdateTurma(turma1);
    			LimparCampos();
    			CarregarTabelas();

	    		Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
				 		"A Turma foi salva com sucesso!");
    		
			} catch (Exception e) {
				// TODO: handle exception

	    		Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
				 		"A turma não foi salva com sucesso!");
    		
			}
    	}
    	if(obj == BTproximo) {
    		TabNota.getTabPane().getSelectionModel().select(TabNota1);
    	}
    	if(obj == BTvoltar) {
    		TabNota1.getTabPane().getSelectionModel().select(TabNota);
    	}
    	
    	if(obj == BTSalvar2) {
    		
    		Turma t = new Turma();
    		t = tabelaTurma.getSelectionModel().getSelectedItem();
    		t.setAluno(tabelaAluno.getSelectionModel().getSelectedItem());
    		t.setCurriculo(tabelaTurma.getSelectionModel().getSelectedItem().getCurriculo());
    		t.setNome(tabelaTurma.getSelectionModel().getSelectedItem().getNome());
    		t.setVagas(t.getVagas() -1);
    		t.setSituacao(true);
    		validarturma();
    		
    		try {
    			
    			fachada.getInstance().createOrUpdateTurma(t);
    			LimparCampos();
    			CarregarTabelas();

	    		Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
				 		"A Turma foi salva com sucesso!");
    		
			} catch (Exception e) {
				// TODO: handle exception

	    		Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
				 		"A turma não foi salva com sucesso!");
    		
			}
    		
    	}
    	
    }

	
	
	
	
	
	public void validarturma() {
		
		if(turma.getVagas() <= 0 ) {
			turma.setSituacao(false);
		}else {
			turma.setSituacao(true);
		}
		
			
	}
	
	
	public void LimparCampos() {
		
		TXBuscarCurriculo.clear();
		TXVagas.clear();
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
