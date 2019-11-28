package controller;

import java.net.URL;
import java.util.ResourceBundle;

import EntidadeEnum.Estado;
import EntidadeEnum.TipoAnoLetivo;
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
import javafx.scene.layout.AnchorPane;
import model.Curriculo;
import model.Disciplina;

public class ControleCurriculo implements Initializable {



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
    private ComboBox<TipoAnoLetivo> ComboNome;

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
    void action(ActionEvent event) {
    	
    	Object obj = event.getSource();
    	
    	if(obj == BTcadastrarCurriculo) {
    		System.out.println("teste");
    	}
    	
    }

    
    public void init() {
    	
    	ComboNome.getItems().setAll(TipoAnoLetivo.values());

		ComboNome.setButtonCell(new ListCell<TipoAnoLetivo>() {
			@Override
			protected void updateItem(TipoAnoLetivo item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Naturalidade");
				} else {
					setText(item.toString());
				}
			}
		});

		ComboNome.setButtonCell(new ListCell<TipoAnoLetivo>() {
			@Override
			protected void updateItem(TipoAnoLetivo item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Naturalidade");
				} else {
					setText(item.toString());
				}
			}
		});
    	
    }
    
    
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		init();
		
	}
}
