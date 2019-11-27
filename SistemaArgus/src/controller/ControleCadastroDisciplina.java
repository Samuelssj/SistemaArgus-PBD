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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Disciplina;
import model.Professor;
import model.Responsavel;

public class ControleCadastroDisciplina implements Initializable{
	private List<Professor> professorTabAdapter;
	private List<Disciplina> disciplinaTabAdapter;
	private Fachada fachada;
	private Disciplina disciplina;
	private Professor professor;

	  @FXML
	    private AnchorPane AnchoPane;

	    @FXML
	    private TabPane TabPane;

	    @FXML
	    private Tab TabListaCadastro;

	    @FXML
	    private TextField TXbuscarFuncionario;

	    @FXML
	    private Button JBbuscarCadastroDisciplina;

	    @FXML
	    private Button JBnovoCadastroDisciplina;

	    @FXML
	    private TableView<Disciplina> tabelaDisciplinas;

	    @FXML
	    private TableColumn<Disciplina, String> TabdisciplinaNome;

	    @FXML
	    private TableColumn<Disciplina, String> TabdisciplinaCarga;

	    @FXML
	    private TableColumn<Disciplina, String> TabdisciplinaSituacao;

	    @FXML
	    private Button JBeditar;

	    @FXML
	    private Button JBdeletar;

	    @FXML
	    private Tab TabNovocadastro;

	    @FXML
	    private TextField TXdisciplinaNome;

	    @FXML
	    private Button BTcadastrarDisciplina;

	    @FXML
	    private TextField TXdisciplinaCargah;

	    @FXML
	    private TableView<Professor> TabelaprofessorDisciplina;

	    @FXML
	    private TableColumn<Professor, String> TabnomeDisciplina;

	    @FXML
	    private TableColumn<Professor, String> TabcpfDisciplina;

	    @FXML
	    private Tab TabNovoResponsavel;

	    @FXML
	    private TextField TXresponsavelNome;

	    @FXML
	    private TextField TXresponsavelCPF;

	    @FXML
	    private Button BTcadastrarComResponsavel;

	    @FXML
	    private DatePicker TXresponsavelDataNasc;

	    @FXML
	    private Button BTvoltar;

	    @FXML
	    private Tab TabNovocadastro1;

	    @FXML
	    private TextField TXusuarioNome1;

	    @FXML
	    private Button BTcadastrarUsuario1;

	    @FXML
	    private RadioButton Radiomãe1;
	    @FXML
	    private Button BTvoltarDiciplina1;

	    @FXML
	    private ToggleGroup genero11;

	    @FXML
	    private RadioButton RadioPai1;

	    @FXML
	    private Button BToutroResponsavel1;

	    @FXML
	    void action(ActionEvent event) throws BusinessException {

	    	Object obj = event.getSource();
	    	
	    	
	    	if(obj ==JBnovoCadastroDisciplina ) {
				
				
	    		TabListaCadastro.getTabPane().getSelectionModel().select(TabNovocadastro);
	    		
				try {

					professorTabAdapter= Fachada.getInstance().searchAllProfessor();
					TabelaprofessorDisciplina.getItems().setAll(professorTabAdapter);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
	    	
	    	if(obj == JBbuscarCadastroDisciplina) {
	    		

				if (TXbuscarFuncionario.getText().trim().isEmpty()) {
					Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
							"Preencha a busca!");
				} else {

					try {

						tabelaDisciplinas.getItems().setAll(fachada.searchAllDisciplina(TXbuscarFuncionario.getText()));
						
					} catch (Exception e) {
						Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar Cliente",
								"Erro ao buscar cliente", e.getMessage());
						e.printStackTrace();
					}
				
	    	}
	    	if(obj == BTvoltarDiciplina1) {
	    	   
	    		TabNovocadastro.getTabPane().getSelectionModel().select(TabListaCadastro);
	    		
	    	}
	    	if(obj == BTcadastrarComResponsavel) {
	    		
	    		Responsavel r = new Responsavel();
	    		
	    
	    		
	    	}
	    	if(obj == BTcadastrarDisciplina) {
	    		
	    		try {
	    		
		    		disciplina = new Disciplina();
		    		Professor p = TabelaprofessorDisciplina.getSelectionModel().getSelectedItem();	    		
		    		disciplina.setCargaHoraria(TXdisciplinaCargah.getText().trim());
		    		disciplina.setNome(TXdisciplinaNome.getText().trim());	
		    		disciplina.setStatus(true);
		    		disciplina.setProfessor(p);
		    		fachada.getInstance().createOrUpdateDisciplina(disciplina);
		    		TabNovocadastro.getTabPane().getSelectionModel().select(TabListaCadastro);
		    		
		    		
		    		Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
							"A disciplina foi salva com sucesso!");
	    		
	    		
	    		} catch (Exception e) {
					e.printStackTrace();
					Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Erro",
							"A disciplina n�o foi salva com sucesso!");
					
				}
				
	    		try {

					professorTabAdapter= fachada.getInstance().searchAllProfessor();
					TabelaprofessorDisciplina.getItems().setAll(professorTabAdapter);
					disciplinaTabAdapter = fachada.getInstance().searchAllDisciplina();
					tabelaDisciplinas.getItems().setAll(disciplinaTabAdapter);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
	    		
	    	}
	    	
	    	}
	    }

	    
	    
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			TabnomeDisciplina.setCellValueFactory(new PropertyValueFactory<>("nome"));
			TabcpfDisciplina.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			
			TabdisciplinaCarga.setCellValueFactory(new PropertyValueFactory<>("cargaHoraria"));
			TabdisciplinaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			TabdisciplinaSituacao.setCellValueFactory(new PropertyValueFactory<>("status"));
			
			try {

				professorTabAdapter= fachada.getInstance().searchAllProfessor();
				TabelaprofessorDisciplina.getItems().setAll(professorTabAdapter);
				
				
				disciplinaTabAdapter = fachada.getInstance().searchAllDisciplina();
				tabelaDisciplinas.getItems().setAll(disciplinaTabAdapter);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}


}
