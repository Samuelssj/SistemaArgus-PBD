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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Disciplina;
import model.Professor;
import model.Responsavel;
import model.Usuario;

public class ControleCadastroDisciplina implements Initializable{
	private List<Professor> professorTabAdapter;
	private List<Disciplina> disciplinaTabAdapter;
	private Fachada fachada;
	private Disciplina disciplina;
	private Professor professor;
	

    @FXML
    private TableColumn<Disciplina, String> TabdisciplinaCod;
	    @FXML
	    private TableColumn<Disciplina, String> TabdisciplinaNome;

	    @FXML
	    private TableColumn<Disciplina, String> TabdisciplinaCarga;

	    @FXML
	    private TableColumn<Disciplina, String> TabdisciplinaSituacao;



	    @FXML
	    private TableView<Professor> TabelaprofessorDisciplina;

	    @FXML
	    private TableColumn<Professor, String> TabnomeDisciplina;

	    @FXML
	    private TableColumn<Professor, String> TabcpfDisciplina;
	    

	    

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
	    private Button BTvoltarDiciplina1;

	    

	    @FXML
	    private TextField TXdisciplinaCod;

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
	    private Button BTListarTodos;

	    @FXML
	    private Button BTvoltar;


	    @FXML
	    void action(ActionEvent event) throws BusinessException {

	    	Object obj = event.getSource();
	    	
	    	
	    	if(obj ==JBnovoCadastroDisciplina ) {
				
				CarregarTabelas();
				TabNovocadastro.setDisable(false);
	    		TabListaCadastro.getTabPane().getSelectionModel().select(TabNovocadastro);
	    		
				
			}
	    	
	    	if(obj == JBbuscarCadastroDisciplina) {
	    	

				if (TXbuscarFuncionario.getText().trim().isEmpty()) {
					Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
							"Preencha a busca!");
				} else {

					try {

						tabelaDisciplinas.getItems().setAll(fachada.getInstance().searchAllDisciplina(TXbuscarFuncionario.getText()));
						BTListarTodos.setVisible(true);
					} catch (Exception e) {
						Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar Cliente",
								"Erro ao buscar cliente", e.getMessage());
						e.printStackTrace();
					}
				
	    	}
				
	    	}
	    	if(obj == BTListarTodos) {
	    		BTListarTodos.setVisible(false);
	    		TXbuscarFuncionario.clear();
	    		CarregarTabelas();
	    		
	    	}
	    	if(obj == BTvoltarDiciplina1) {
	    	   
	    		CarregarTabelas();
	    		
	    		
	    		TabNovocadastro.getTabPane().getSelectionModel().select(TabListaCadastro);
	    		
	    	}
	    	
	    	if(obj == JBdeletar) {
	    		
	    		
	    		Disciplina dis = new Disciplina();
				dis = tabelaDisciplinas.getSelectionModel().getSelectedItem();
				
			
				try {
					fachada.getInstance().removeDisciplina(dis.getId());
					System.out.println(dis.getId());
					Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "DISCIPLINA DELETADA", "Deletado",
							"Disciplina Deletada!");
					CarregarTabelas();
				} catch (BusinessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "DISCIPLINA NÃO DELETADA", "Não Deletado",
							"Disciplina não Deletada!");
				}
				
	    	}
	    
	    	if(obj == BTcadastrarDisciplina) {
	    		
	    		try {
	    		
		    		disciplina = new Disciplina();
		    		Professor p = TabelaprofessorDisciplina.getSelectionModel().getSelectedItem();	    		
		    		disciplina.setCargaHoraria(TXdisciplinaCargah.getText().trim());
		    		disciplina.setNome(TXdisciplinaNome.getText().trim());	
		    		disciplina.setCodigo(TXdisciplinaCod.getText().trim());
		    		disciplina.setProfessor(p);
		    		disciplina.setStatus(true);
		    		fachada.getInstance().createOrUpdateDisciplina(disciplina);
		    		TabNovocadastro.getTabPane().getSelectionModel().select(TabListaCadastro);
		    		TabNovocadastro.setDisable(true);
		    		
		    		Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
					 		"A disciplina foi salva com sucesso!");
	    		
	    		
	    		} catch (Exception e) {
					e.printStackTrace();
					Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Erro",
							"A disciplina n�o foi salva com sucesso!");
					
				}
				
	    		CarregarTabelas();
	    		LimparCampos();
	    		
	    	}
	    	
	    	
	    	
	    
	    }
	    
	    public void LimparCampos() {
	    	
	    	TXdisciplinaNome.clear();
	    	TXdisciplinaCod.clear();
	    	TXdisciplinaNome.clear();
	    	TXdisciplinaCargah.clear();
	    	
	    }
	    
	    
	    public void CarregarTabelas() {
	    	
	    	TabnomeDisciplina.setCellValueFactory(new PropertyValueFactory<>("nome"));
			TabcpfDisciplina.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			
			TabdisciplinaCarga.setCellValueFactory(new PropertyValueFactory<>("cargaHoraria"));
			TabdisciplinaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
			TabdisciplinaSituacao.setCellValueFactory(new PropertyValueFactory<>("status"));
			TabdisciplinaCod.setCellValueFactory(new PropertyValueFactory<>("codigo"));
			try {

				professorTabAdapter= fachada.getInstance().searchAllProfessor();
				TabelaprofessorDisciplina.getItems().setAll(professorTabAdapter);
				
				
				disciplinaTabAdapter = fachada.getInstance().searchAllDisciplina();
				tabelaDisciplinas.getItems().setAll(disciplinaTabAdapter);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    	
	    }
	    
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			
			CarregarTabelas();
			
		}


}
