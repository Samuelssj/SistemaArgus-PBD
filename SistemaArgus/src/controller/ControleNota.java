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
import model.Disciplina;
import model.Nota;

public class ControleNota implements Initializable {
	
	private List<Aluno> alunoAdapter;
	private List<Disciplina> disciplinaAdapter;
	private Fachada fachada;
	
	 @FXML
	    private AnchorPane AnchoPane;

	    @FXML
	    private TabPane TabPane;

	    @FXML
	    private Tab TabNota;

	    @FXML
	    private TextField TXBuscarAluno;

	    @FXML
	    private TableView<Aluno> tabelaAluno;

	    @FXML
	    private TableColumn<Aluno, String> TabAlunoNome;

	    @FXML
	    private TableColumn<Aluno, String> TabAlunoCPF;

	    @FXML
	    private TableView<Disciplina> tabelaCurriculo;
	    

	    @FXML
	    private TableColumn<?, ?> TabDisciplinaNome;

	    @FXML
	    private TableColumn<?, ?> TabDisciplinaCarga;

	    @FXML
	    private Button BTBuscar;

	    @FXML
	    private Button BTSalvar;

	    @FXML
	    private Button BTselecionar;

	    @FXML
	    private TextField TXmedia1;

	    @FXML
	    private TextField TXmedia2;

	    @FXML
	    private TextField TXmedia3;

	    @FXML
	    private TextField TXmedia4;

	    @FXML
	    private TextField TXfinal;

	    @FXML
	    void action(ActionEvent event) {
	    	Object obj = event.getSource();
	    	
	    	
	    	if(obj == BTSalvar) {
	    		Nota nota1 = new Nota();
	    		Nota nota2 = new Nota();
	    		Nota nota3 = new Nota();
	    		
	    		nota1.setAluno(tabelaAluno.getSelectionModel().getSelectedItem());
	    		nota1.setDisciplina(tabelaCurriculo.getSelectionModel().getSelectedItem());
	    		nota1.setNota(Double.parseDouble(TXmedia1.getText()));
	    		nota1.setTipoNota("nota1");
	    		
	    		nota2.setAluno(tabelaAluno.getSelectionModel().getSelectedItem());
	    		nota2.setDisciplina(tabelaCurriculo.getSelectionModel().getSelectedItem());
	    		nota2.setNota(Double.parseDouble(TXmedia2.getText()));
	    		nota2.setTipoNota("nota2");
	    		
	    		nota3.setAluno(tabelaAluno.getSelectionModel().getSelectedItem());
	    		nota3.setDisciplina(tabelaCurriculo.getSelectionModel().getSelectedItem());
	    		nota3.setNota(Double.parseDouble(TXmedia3.getText()));
	    		nota3.setTipoNota("nota3");
	    		
	    		
	    		try {
	    			Fachada.getInstance().createOrUpdateNota(nota1);
	    			Fachada.getInstance().createOrUpdateNota(nota2);
	    			Fachada.getInstance().createOrUpdateNota(nota3);
	    			
	    			Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Salvo com sucesso", "",
							"A nota foi salva com sucesso!");
	    			
	    		} catch (Exception e) {
					e.printStackTrace();
					Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro ao salvar", "Erro",
							"A nota n�o foi salva com sucesso!");
					
				}
	    		
	    		
	    	}
				
	    }
	    
	   public void  CarregarTabelas(){
		   
			TabAlunoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			TabAlunoCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			
			TabDisciplinaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			TabDisciplinaCarga.setCellValueFactory(new PropertyValueFactory<>("cargaHoraria"));
			
			try {
				alunoAdapter = Fachada.getInstance().searchAllAluno();
				tabelaAluno.getItems().setAll(alunoAdapter);
				
				disciplinaAdapter = Fachada.getInstance().searchAllDisciplina();
				tabelaCurriculo.getItems().setAll(disciplinaAdapter);
				
				
			} catch (BusinessException e) {
				e.printStackTrace();
			}
	    }
	   
	   public void CarregarTabelaAluno() {
		   
			TabAlunoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			TabAlunoCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			
			try {
				alunoAdapter = Fachada.getInstance().searchAllAluno();
				tabelaAluno.getItems().setAll(alunoAdapter);
				
				
			} catch (BusinessException e) {
				e.printStackTrace();
			}
	   }
	   
	   
	   
	   
	
	   
	   
	   
	   
	   
	   
//	   public void CarregarTabelaDisciplina() {
//		 List<Disciplina> alu, auxiliarD;
//		 Aluno aluno = new Aluno();
//		 Curriculo c = new Curriculo();
//		   
//		   
//			TabDisciplinaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
//			TabDisciplinaCarga.setCellValueFactory(new PropertyValueFactory<>("cargaHoraria"));
////			
////			try {
////				
//////			alu = Fachada.getInstance().searchAllAluno();
////			aluno = tabelaAluno.getSelectionModel().getSelectedItem();
////			
////
////				
////	//			if(alu.getClass().get) {
////					
////				}
////				
////				tabelaCurriculo.getItems().setAll(disciplinaAdapter);
////				
////				
////			} catch (BusinessException e) {
////				e.printStackTrace();
////			}
//		   
//		   
//	   }
//	   

		@Override
		public void initialize(URL location, ResourceBundle resources) {
		
			CarregarTabelas();
			
		}

}
