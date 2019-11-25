package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import EntidadeEnum.SiglasEstados;
import EntidadeEnum.TipoUsuario;
import exception.Menssagem;
import fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Aluno;
import model.Disciplina;
import model.Endereco;
import model.Professor;
import model.Responsavel;

public class ControleCadastroDisciplina implements Initializable{
	private List<Professor> professorTabAdapter;
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
	    private ToggleGroup genero11;

	    @FXML
	    private RadioButton RadioPai1;

	    @FXML
	    private Button BToutroResponsavel1;

	    @FXML
	    void action(ActionEvent event) {

	    	Object obj = event.getSource();
	    	
	    	
	    	if(obj ==JBnovoCadastroDisciplina ) {
				
				TabListaCadastro.getTabPane().getSelectionModel().select(TabNovocadastro);
				//aqui funciona
			}
	    	if(obj == JBbuscarCadastroDisciplina) {

				if (TXbuscarFuncionario.getText().trim().isEmpty()) {
					Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
							"Preencha a busca!");
				} else {

					try {

						tabelaDisciplinas.getItems().setAll(fachada.searchAllDisciplina(((TXbuscarFuncionario.getText()))));

					} catch (Exception e) {
						Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar Cliente",
								"Erro ao buscar cliente", e.getMessage());
						e.printStackTrace();
					}
				}
	    	}
	    	
	    	if(obj == BTcadastrarDisciplina) {
	    		
	    		disciplina = new Disciplina();
	    		Professor p = new Professor();
	    		professor = new Professor();
	    		
	    		disciplina.setCargaHoraria(TXdisciplinaCargah.getText().trim());
	    		disciplina.setNome(TXdisciplinaNome.getText().trim());
	    		p.setId( TabelaprofessorDisciplina.getSelectionModel().getSelectedItem().getId());
	    		disciplina.setProfessor(p);
				disciplina.setStatus(true);
	   
//	    		professor.setCpf(p.getCpf());
//	    		professor.setData_nasc(p.getData_nasc());
//	    		professor.setDisciplina(disciplina);
//	    		professor.setEndereco(p.getEndereco());
//	    		professor.setNaturalidade(p.getNaturalidade());
//	    		professor.setNome(p.getNome());
//	    		professor.setSenha(p.getSenha());
//	    		professor.setSituacao(p.getSituacao());
//	    		professor.setTipo(p.getTipo());
	    		
	    		
				try {
					//fachada.createOrUpdateEndereco(endereço);
					System.out.println(disciplina);
					fachada.createOrUpdateDisciplina(disciplina);
					
					System.out.println("o professor é" + p);
					Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
							"O Aluno foi salvo com sucesso!");
					
				} catch (Exception e) {
					
					Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Erro",
							"O Aluno não foi salvo com sucesso!");
					
				}
				
				//TabListaCadastro.getTabPane().getSelectionModel().select(TabListaCadastro);
	    		
	    	}
	    	
	    	
	    }

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			// TODO Auto-generated method stub
			TabnomeDisciplina.setCellValueFactory(new PropertyValueFactory<>("nome"));
			TabcpfDisciplina.setCellValueFactory(new PropertyValueFactory<>("cpf"));
			
			try {

				professorTabAdapter= fachada.getInstance().searchAllProfessor();
				TabelaprofessorDisciplina.getItems().setAll(professorTabAdapter);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}


}
