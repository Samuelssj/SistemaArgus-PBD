package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import EntidadeEnum.Estado;
import EntidadeEnum.TipoAnoLetivo;
import EntidadeEnum.TipoCurriculo;
import exception.BusinessException;
import exception.Menssagem;
import fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Curriculo;
import model.Disciplina;

public class ControleCurriculo implements Initializable {
private List<Disciplina> disciplinas;
private List<Curriculo> curriculos;
private Fachada fachada;



    @FXML
    private AnchorPane AnchoPane;

    @FXML
    private TabPane TabPane;

    @FXML
    private Tab Tabcurriculo;

    @FXML
    private TextField TXcodigo;

    @FXML
    private TextField TXBuscarDisciplina;

    @FXML
    private Button BTListar;
    
    @FXML
    private ComboBox<TipoCurriculo> ComboNome;

    @FXML
    private TableView<Disciplina> tabelaDisciplina;

    @FXML
    private TableColumn<Disciplina, String> TabDisciplonaCodigo;

    @FXML
    private TableColumn<Disciplina, String> TabDisciplonanome;

    @FXML
    private TableColumn<Disciplina, String> TabDisciplonaCarga;

    @FXML
    private TableView<Curriculo> tabelaCurriculo;

    @FXML
    private TableColumn<Curriculo, String> TabCurriculoCod;

    @FXML
    private TableColumn<Curriculo, String> TabCurriculoTipo;

   
    @FXML
    private Button BTBuscar;

    @FXML
    private Button BTadcionar;

    @FXML
    private Button BTcadastrarCurriculo;

 
    @FXML
    private ComboBox<TipoAnoLetivo> ComboTipoAno;

    @FXML
    private Button BTmostrarDisciplinas;

    @FXML
    private TextField TXAnoLetivo;


    @FXML
    void action(ActionEvent event) {
    	
    	Object obj = event.getSource();
    	
    	if(obj == BTcadastrarCurriculo) {
    		
    		Curriculo c = new Curriculo();
    		
    		c.setCodigo(TXcodigo.getText().trim());
    		c.setNome((ComboNome.getSelectionModel().getSelectedItem().toString()));
    		c.setAnoLetivo(TXAnoLetivo.getText().trim());
    		c.setTipoAno((ComboTipoAno.getSelectionModel().getSelectedItem().toString()));
    		
    		try {
				fachada.getInstance().createOrUpdateCurriculo(c);
				CarregarTabelas();
				TXcodigo.clear();
				ComboNome.getSelectionModel().clearSelection();
				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
						"O curriculo foi salvo com sucesso!");
			} catch (Exception e) {
				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Salvo",
						"O curriculo não foi salvo!");
			}
    		
    		
    		
    		
    	}
    	if(obj == BTmostrarDisciplinas) {
    		CarregarTabelas();
    	}
    	if(obj == BTBuscar) {
    		
    		if (TXBuscarDisciplina.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
						"Preencha a busca!");

			} else {
				try {
					tabelaDisciplina.getItems().setAll(fachada.getInstance().searchAllDisciplina((TXBuscarDisciplina.getText())));
					BTListar.setVisible(true);
				} catch (Exception e) {
					Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar Cliente",
							"Erro ao buscar cliente", e.getMessage());
					e.printStackTrace();
				}
			}
    		
    	}
    	if(obj == BTListar) {
    		CarregarTabelas();
    		TXBuscarDisciplina.clear();
    		TXAnoLetivo.clear();
    		BTListar.setVisible(false);
    	}
    	
    	
    	if(obj == BTadcionar) {
    		
    		Curriculo curriculo = new Curriculo();
    		Disciplina disciplina = new Disciplina();
    		
    		
    		curriculo = tabelaCurriculo.getSelectionModel().getSelectedItem();
    		disciplina = tabelaDisciplina.getSelectionModel().getSelectedItem();
    		
    		disciplina.setCurriculo(curriculo);
    		
    		try {
				fachada.getInstance().createOrUpdateDisciplina(disciplina);
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Adicionado com sucesso", "",
						"A Disciplina foi adicionada com sucesso!");
			} catch (BusinessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    		
    		
    		
    	}
    	
    	
    }

    
    public void init() {
    	
    	ComboNome.getItems().setAll(TipoCurriculo.values());

		ComboNome.setButtonCell(new ListCell<TipoCurriculo>() {
			@Override
			protected void updateItem(TipoCurriculo item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Nome Curiculo");
				} else {
					setText(item.toString());
				}
			}
		});

		ComboNome.setButtonCell(new ListCell<TipoCurriculo>() {
			@Override
			protected void updateItem(TipoCurriculo item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Nome Curiculo");
				} else {
					setText(item.toString());
				}
			}
		});
		
		ComboTipoAno.getItems().setAll(TipoAnoLetivo.values());

		ComboTipoAno.setButtonCell(new ListCell<TipoAnoLetivo>() {
			@Override
			protected void updateItem(TipoAnoLetivo item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Ano Letivo");
				} else {
					setText(item.toString());
				}
			}
		});

		ComboTipoAno.setButtonCell(new ListCell<TipoAnoLetivo>() {
			@Override
			protected void updateItem(TipoAnoLetivo item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Ano Letivo");
				} else {
					setText(item.toString());
				}
			}
		});
    	
    }
    
    
    
    
    public void CarregarTabelas() {
    	
    	TabDisciplonanome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		TabDisciplonaCarga.setCellValueFactory(new PropertyValueFactory<>("cargaHoraria"));
		TabDisciplonaCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		
		
		TabCurriculoCod.setCellValueFactory(new PropertyValueFactory<>("Codigo"));
		TabCurriculoTipo.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		try {

			
			disciplinas = fachada.getInstance().searchAllDisciplina();
			tabelaDisciplina.getItems().setAll(disciplinas);
			
			curriculos = fachada.getInstance().searchAllCurriculo();
			tabelaCurriculo.getItems().setAll(curriculos);
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    	
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		init();
		CarregarTabelas();
	}
}
