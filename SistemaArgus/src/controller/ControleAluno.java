package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import EntidadeEnum.Estado;
import EntidadeEnum.SiglasEstados;
import EntidadeEnum.TipoUsuario;
import exception.Menssagem;
import fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Aluno;
import model.Endereco;
import model.Responsavel;

public class ControleAluno implements Initializable {
	private List<Aluno> alunoTabAdapters;
	private List<Responsavel> responsavelTabAdapter;
	private Fachada fachada = Fachada.getInstance();
	private Aluno aluno;
	private Responsavel responsavel;
	private Endereco endereço;

    @FXML
    private AnchorPane AnchoPane;

    @FXML
    private TabPane TabPane;

    @FXML
    private Tab TabListaCadastroAluno;

    @FXML
    private TextField TXbuscarAluno;

    @FXML
    private Button JBbuscarCadastro;

    @FXML
    private TableView<Aluno> tabelaAluno;

    @FXML
    private TableColumn<Aluno, String> Tabnomealuno;

   
    @FXML
    private TableColumn<Aluno, String> TabpaiAluno;

    @FXML
    private TableColumn<Aluno, String> TabmaeAluno;

    @FXML
    private Button JBeditar;

    @FXML
    private Button JBdeletar;

    @FXML
    private Tab Tabatualizaraluno;

    @FXML
    private TextField TXusuarioNome;

    @FXML
    private TextField TXusuarioCEP;

    @FXML
    private TextField TXusuarioRua;

    @FXML
    private TextField TXusuarioBairro;

    @FXML
    private TextField TXusuarioNumero;

    @FXML
    private Button BTatualizar;

    @FXML
    private TextField TXusuarioMaeNome;

    @FXML
    private TextField TXusuarioPaiNome;

    @FXML
    private ComboBox<TipoUsuario> COMBOusuarioTipo;

    @FXML
    private ComboBox<Estado> COMBOusuarioNaturalidade;

    @FXML
    private DatePicker TXusuarioData_nasc;

    @FXML
    private Button BToutroResponsavel;

    @FXML
    private ComboBox<SiglasEstados> COMBOestadoUsuario;

    @FXML
    private TextField TXusuarioCidade;

    @FXML
    private TextField TXResponsavelNome;

    @FXML
    private TextField TXResponsavelCPF;

    @FXML
    private TableView<?> TabelaNotas;

    @FXML
    private TableColumn<?, ?> TabDisciplina;

    @FXML
    private TableColumn<?, ?> TabNota1;

    @FXML
    private TableColumn<?, ?> TabNota2;

    @FXML
    private TableColumn<?, ?> TabNota3;

    @FXML
    private TableColumn<?, ?> TabNota4;

    @FXML
    private TableColumn<?, ?> TabMedia;

    @FXML
    private TableColumn<?, ?> TabSituacao;

    @FXML
    private Tab TabNovocadastro1;

    @FXML
    private Button BTatualizar1;

    @FXML
    private Tab TabNovoResponsavel;

    @FXML
    private TextField TXresponsavelNome;

    @FXML
    private TextField TXresponsavelCPF;

    @FXML
    private Button BTcadastrarComResponsavel;

    @FXML
    private Button BTvoltar1;

    @FXML
    private Button BTvoltar2;
    @FXML
    private Button BTvoltar3;
    
    @FXML
    private TableView<Responsavel> tabelaResponsavel;

    @FXML
    private TableColumn<Responsavel, String> nomeTabResponsavel;

    @FXML
    private TableColumn<Responsavel, String> cpfTabResponsavel;

    @FXML
    private Button BTbuscarResponsavel;

    @FXML
    private TextField TXBuscarResponsavel;

    

   

   
 



	    @FXML
	    void action(ActionEvent e) {
	    	
	    	if(e.getSource() == JBdeletar) {
	    		System.out.println("ai");
	    	}
	    	
	    	if(e.getSource() == JBbuscarCadastro) {
	    		
	    		if (TXbuscarAluno.getText().trim().isEmpty()) {
					Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
							"Preencha a busca!");
				} else {

					try {

						tabelaAluno.getItems().setAll(fachada.searchAllAluno((TXbuscarAluno.getText())));

					} catch (Exception event) {
						Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar Cliente",
								"Erro ao buscar cliente", event.getMessage());
						event.printStackTrace();
					}
				}
	    		
	    	}
	    	
	    	if(e.getSource() == JBeditar) {
	    		preencherCampos();
	    		TabPane.getSelectionModel().select(Tabatualizaraluno);    	
	    		}

	    	if(e.getSource() == BTvoltar1) {
	    		TabPane.getSelectionModel().select(TabListaCadastroAluno);
	    		LimparCampos();
	    	}

	    	if(e.getSource() == BTvoltar2) {
	    		TabPane.getSelectionModel().select(TabListaCadastroAluno);
	    		LimparCampos();
	    	}

	    	if(e.getSource() == BTvoltar3) {
	    		TabPane.getSelectionModel().select(TabListaCadastroAluno);
	    		LimparCampos();
	    	}
	    	if(e.getSource() == BTatualizar) {
	    		if(verificarCampos()) {
	    			
	    			aluno = new Aluno();
	    			endereço = new Endereco();
	    			endereço.setCidade(TXusuarioCidade.getText().trim());
	    			endereço.setCep(TXusuarioCEP.getText().trim());
	    			endereço.setEstado(SiglasEstados.valueOf(COMBOestadoUsuario.getSelectionModel().getSelectedItem().toString()));
	    			endereço.setRua(TXusuarioRua.getText().trim());
	    			endereço.setBairro(TXusuarioBairro.getText().trim());
	    			endereço.setNumero(TXusuarioNumero.getText().trim());
	    			aluno.setEndereco(endereço);
	    			responsavel = new Responsavel();
	    			aluno.setResponsavel(responsavel);
	    			aluno.setNome(TXusuarioNome.getText().trim());
	    			aluno.setEndereco(endereço);
	    			aluno.setData_nasc(TXusuarioData_nasc.getValue());
	    			aluno.setNaturalidade(COMBOusuarioNaturalidade.getSelectionModel().getSelectedItem());
	    			aluno.setTipo(TipoUsuario.valueOf(COMBOusuarioTipo.getSelectionModel().getSelectedItem().toString()));
	    			aluno.setPai(TXusuarioPaiNome.getText().trim());
	    			aluno.setMãe(TXusuarioMaeNome.getText().trim());
	    			
	    			
	    			System.out.println(aluno);
	    			try {
	    				
	    				fachada.createOrUpdateAluno(aluno);
	    				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao atualizar", "Atualizado",
	    						"O Aluno foi atualizado com sucesso!");
	    				
	    			} catch (Exception event) {
	    				
	    				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao atualizar", "Erro",
	    						"O Aluno não foi atualizado com sucesso!");
	    				
	    			}
	    			
	    			
	    			
	    		}
	    		
	    		
	    		
	    		
	    	}
	    }
	    

	    
	    
	    
	    public void preencherCampos() {
	    	Aluno user = new Aluno();
	    		 user = tabelaAluno.getSelectionModel().getSelectedItem();
	     
	    		 
	    		 
	    		
	 			TXusuarioNome.setText(user.getNome().trim());
	 			TXusuarioCidade.setText(user.getEndereco().getCidade().trim());
	 			TXusuarioCEP.setText(user.getEndereco().getCep().trim());
	 			TXusuarioMaeNome.setText(user.getMãe().trim());
	 			TXusuarioPaiNome.setText(user.getPai().trim());
	 			TXusuarioNumero.setText(user.getEndereco().getNumero().trim());
	 			TXusuarioRua.setText(user.getEndereco().getRua().trim());
	 			TXusuarioBairro.setText(user.getEndereco().getBairro().trim());
	 			TXresponsavelNome.setText(user.getResponsavel().getNome());
	 			TXresponsavelCPF.setText(user.getResponsavel().getCpf().toString().trim());
	 			
	 			
	 			COMBOestadoUsuario.getSelectionModel().select(user.getEndereco().getEstado());
	 		    COMBOusuarioNaturalidade.getSelectionModel().select(user.getNaturalidade());
	 		    COMBOusuarioTipo.getSelectionModel().select(user.getTipo());
	 			TXusuarioData_nasc.setValue(user.getData_nasc());
	 			    		 
	    }
	    
	    
	    public boolean verificarCampos() {
	    	if (TXusuarioNome.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NOME Vazio",
						"Preencha o NOME!");
				return false;
			}
	    	if (TXusuarioCidade.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CIDADE Vazia",
						"Preencha a CIDADE!");
				return false;
			}
	    	if (TXusuarioCEP.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CEP Vazio",
						"Preencha o CEP!");
				return false;
			}
	    	if (TXusuarioMaeNome.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NOME DA MÂE Vazio",
						"Preencha o NOME DA MÃE!");
				return false;
			}
	    	if (TXusuarioPaiNome.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NOME DO PAI Vazio",
						"Preencha o NOME DO PAI!");
				return false;
			}
	    	
	    	if (TXusuarioNumero.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NÚMERO Vazio",
						"Preencha o NÚMERO!");
				return false;
			}
	    	if (TXusuarioRua.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "RUA Vazio",
						"Preencha a RUA!");
				return false;
			}
	    	if (TXusuarioBairro.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "BAIRRO Vazio",
						"Preencha o BAIRRO!");
				return false;
			}
	    	if (COMBOestadoUsuario.getSelectionModel().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "ESTADO Vazio",
						"Preencha o ESTADO!");
				return false;
			}
	    	if (COMBOusuarioNaturalidade.getSelectionModel().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NATURALIDADE Vazio",
						"Preencha a NATURALIDADE!");
				return false;
			}
	    	if (COMBOusuarioTipo.getSelectionModel().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "CARGO Vazio",
						"Preencha o CARGO!");
				return false;
			}
	    	if (TXusuarioData_nasc.getValue() == null) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "NASCIMENTO Vazio",
						"Preencha o NASCIMENTO!");
				return false;
			}
	    	return true;
	    	
	    }
	    
	    public void LimparCampos() {
	    	

 			TXusuarioNome.clear();
 			TXusuarioCidade.clear();
 			TXusuarioCEP.clear();
 			TXusuarioMaeNome.clear();
 			TXusuarioPaiNome.clear();
 			TXusuarioNumero.clear();
 			TXusuarioRua.clear();
 			TXusuarioBairro.clear();
 			TXresponsavelNome.clear();
 			TXresponsavelCPF.clear();
 			
 			
 			COMBOestadoUsuario.getSelectionModel().clearAndSelect(0);
 		    COMBOusuarioNaturalidade.getSelectionModel().clearAndSelect(0);
 		    COMBOusuarioTipo.getSelectionModel().clearAndSelect(0);
 			TXusuarioData_nasc.setValue(null);
	    	
	    }
	    	
	    public void init() {

			COMBOusuarioTipo.getItems().setAll(TipoUsuario.values());
			COMBOusuarioTipo.getItems().setAll(TipoUsuario.values());

			COMBOusuarioTipo.setButtonCell(new ListCell<TipoUsuario>() {
				@Override
				protected void updateItem(TipoUsuario item, boolean empty) {
					super.updateItem(item, empty);
					if (empty || item == null) {
						setText("Tipo de Usuário");
					} else {
						setText(item.toString());
					}
				}
			});

			COMBOusuarioTipo.setButtonCell(new ListCell<TipoUsuario>() {
				@Override
				protected void updateItem(TipoUsuario item, boolean empty) {
					super.updateItem(item, empty);
					if (empty || item == null) {
						setText("Tipo de Funcionário");
					} else {
						setText(item.toString());
					}
				}
			});

			// COMBOBOX NATURALIDADE

			COMBOusuarioNaturalidade.getItems().setAll(Estado.values());
			COMBOusuarioNaturalidade.getItems().setAll(Estado.values());

			COMBOusuarioNaturalidade.setButtonCell(new ListCell<Estado>() {
				@Override
				protected void updateItem(Estado item, boolean empty) {
					super.updateItem(item, empty);
					if (empty || item == null) {
						setText("Naturalidade");
					} else {
						setText(item.toString());
					}
				}
			});

			COMBOusuarioNaturalidade.setButtonCell(new ListCell<Estado>() {
				@Override
				protected void updateItem(Estado item, boolean empty) {
					super.updateItem(item, empty);
					if (empty || item == null) {
						setText("Naturalidade");
					} else {
						setText(item.toString());
					}
				}
			});

			

			COMBOestadoUsuario.getItems().setAll(SiglasEstados.values());
			COMBOestadoUsuario.getItems().setAll(SiglasEstados.values());

			COMBOestadoUsuario.setButtonCell(new ListCell<SiglasEstados>() {
				@Override
				protected void updateItem(SiglasEstados item, boolean empty) {
					super.updateItem(item, empty);
					if (empty || item == null) {
						setText("Estado");
					} else {
						setText(item.toString());
					}
				}
			});

			COMBOestadoUsuario.setButtonCell(new ListCell<SiglasEstados>() {
				@Override
				protected void updateItem(SiglasEstados item, boolean empty) {
					super.updateItem(item, empty);
					if (empty || item == null) {
						setText("Estado");
					} else {
						setText(item.toString());
					}
				}
			});
			
	    }
	    			
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			init();

			Tabnomealuno.setCellValueFactory(new PropertyValueFactory<>("nome"));
			TabmaeAluno.setCellValueFactory(new PropertyValueFactory<>("mãe"));
			TabpaiAluno.setCellValueFactory(new PropertyValueFactory<>("pai"));
			
			nomeTabResponsavel.setCellValueFactory(new PropertyValueFactory<>("nome"));
			cpfTabResponsavel.setCellValueFactory(new PropertyValueFactory<>("nome"));
			
			try {

				alunoTabAdapters = fachada.getInstance().searchAllAluno();
				tabelaAluno.getItems().setAll(alunoTabAdapters);
				
				responsavelTabAdapter = fachada.getInstance().searchAllResponsavel();
				tabelaResponsavel.getItems().setAll(responsavelTabAdapter);
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
}
