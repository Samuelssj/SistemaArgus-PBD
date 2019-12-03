package controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import EntidadeEnum.TipoUsuario;
import EntidadeEnum.TipodeAcompanhamento;
import exception.BusinessException;
import exception.Menssagem;
import fachada.Fachada;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Acompanhamento;
import model.Aluno;
import model.Pedagogo;
import model.Usuario;

public class ControleAcompanhamento implements Initializable {
	private List<Usuario> user;
	private List<Pedagogo> pedagogos;
	private List<Acompanhamento> acompanhamentos;
	private Fachada fachada;

	@FXML
	private TableView<Usuario> tabelaUsuario;

	@FXML
	private Tab TabAcompanhamento;

	@FXML
	private Tab TabRelatorio;

	@FXML
	private Label LBrelatorio;

	@FXML
	private Button BTeditar;

	@FXML
	private TableColumn<Usuario, String> TabUsuarioNome;

	@FXML
	private TableColumn<Usuario, String> TabUsuariocpf;

	@FXML
	private TableView<Pedagogo> tabelaPedagogo;

	@FXML
	private TableColumn<Pedagogo, String> TabPedagogoNome;

	@FXML
	private TableColumn<Pedagogo, String> TabPedagogocpf;

	@FXML
	private ComboBox<TipodeAcompanhamento> ComboTipo;

	@FXML
	private TableView<Acompanhamento> tabelaRelatorios;

	@FXML
	private TableColumn<Acompanhamento, String> TabNomeac;

	@FXML
	private TableColumn<Acompanhamento, String> TabPedagogoac;

	@FXML
	private Button BTlistarTodos1;

	@FXML
	private AnchorPane AnchoPane;

	@FXML
	private TabPane TabPane;

	@FXML
	private Tab Tabcurriculo;

	@FXML
	private TextField TXBuscarAluno;

	@FXML
	private Button BTBuscar;

	@FXML
	private Button BTcriaracompanhamento;

	@FXML
	private DatePicker TXdata;

	@FXML
	private TextField TXsessão;

	@FXML
	private Button BTListartodos;

	@FXML
	private Button BTproximo;

	@FXML
	private TextField TXnome;

	@FXML
	private TextArea TXrelatorio;

	@FXML
	private Button BTvoltar;

	@FXML
	private Button BTsalvarRelatorio;

	@FXML
	private Button BTbuscarRelat;

	@FXML
	private TextField TXbuscarRelat;

	@FXML
	private Button BTselecionar;

	@FXML
	void action(ActionEvent event) {
		Object obj = event.getSource();

		if (obj == BTBuscar) {

			if (TXBuscarAluno.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
						"Preencha a busca!");
			} else {

				try {

					tabelaUsuario.getItems()
							.setAll(fachada.getInstance().searchAllSuperUsuario((TXBuscarAluno.getText())));
					// BTListartodos.setVisible(true);
				} catch (Exception e) {
					Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar a Pessoa",
							"Erro ao buscar cliente", e.getMessage());
					e.printStackTrace();
				}
			}

		}

		if (obj == BTListartodos) {
			CarregarTabelas();
			TXBuscarAluno.clear();
		}
		if(obj == BTproximo) {
		
			TabAcompanhamento.getTabPane().getSelectionModel().select(TabRelatorio);
		}
		if(obj == BTvoltar) {
			TabRelatorio.getTabPane().getSelectionModel().select(TabAcompanhamento);
		}

		if (obj == BTcriaracompanhamento) {

			Acompanhamento acompanhamento = new Acompanhamento();
			Usuario usuario = new Usuario();
			Pedagogo pedagogo = new model.Pedagogo();

			usuario = tabelaUsuario.getSelectionModel().getSelectedItem();
			pedagogo = tabelaPedagogo.getSelectionModel().getSelectedItem();

			acompanhamento.setUsuario(usuario);
			acompanhamento.setPedagogo(pedagogo);
			acompanhamento.setNome(TXnome.getText().trim());
			acompanhamento.setSecao(Integer.parseInt(TXsessão.getText().trim()));
			acompanhamento.setData(TXdata.getValue());
			acompanhamento.setTipoDeAcompanhamento(ComboTipo.getSelectionModel().getSelectedItem().toString());

			try {

				fachada.getInstance().createOrUpdateAcompanhamento(acompanhamento);
				CarregarTabelas();
				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
						"O Acompanhamento foi salvo com sucesso!");

			} catch (Exception e) {

				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Erro",
						"O Acompanhamento não foi salvo com sucesso!");

			}

		}

		if (obj == BTbuscarRelat) {

			if (TXbuscarRelat.getText().trim().isEmpty()) {
				Menssagem.getInstancia().exibirMensagem(AlertType.INFORMATION, "Campo Vazio", "PREENCHA A BUSCA",
						"Preencha a busca!");
			} else {

				try {

					tabelaRelatorios.getItems()
							.setAll(fachada.getInstance().searchAllAcompanhamento((TXbuscarRelat.getText())));
					BTlistarTodos1.setVisible(true);
				} catch (Exception e) {
					Menssagem.getInstancia().exibirMensagem(AlertType.ERROR, "Erro Buscar a Pessoa",
							"Erro ao buscar cliente", e.getMessage());
					e.printStackTrace();
				}
			}

		}

		if (obj == BTlistarTodos1) {
			CarregarTabelas();
			TXbuscarRelat.clear();
			BTlistarTodos1.setVisible(false);

		}

		if (obj == BTselecionar) {

			LBrelatorio.setVisible(true);
			TXrelatorio.setVisible(true);
			BTsalvarRelatorio.setVisible(true);
			TXrelatorio.setEditable(false);
			TXrelatorio.setText(tabelaRelatorios.getSelectionModel().getSelectedItem().toString());
		}
		if (obj == BTeditar) {
			TXrelatorio.setEditable(true);
		}
		if (obj == BTsalvarRelatorio) {

			Acompanhamento acompanhamento = new Acompanhamento();

			LBrelatorio.setVisible(false);
			TXrelatorio.setVisible(false);
			BTsalvarRelatorio.setVisible(false);

			acompanhamento = tabelaRelatorios.getSelectionModel().getSelectedItem();
			acompanhamento.setRelatorio(TXrelatorio.getText().trim());

			try {

				fachada.getInstance().createOrUpdateAcompanhamento(acompanhamento);
				TXrelatorio.clear();
				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Sucesso ao salvar", "Salvo",
						"O Relatório foi salvo com sucesso!");

			} catch (Exception e) {

				Menssagem.getInstancia().exibirMensagem(AlertType.CONFIRMATION, "Erro ao salvar", "Erro",
						"O Relatório não foi salvo com sucesso!");

			}
		}

	}

	public void init() {

		ComboTipo.getItems().setAll(TipodeAcompanhamento.values());
		ComboTipo.getItems().setAll(TipodeAcompanhamento.values());

		ComboTipo.setButtonCell(new ListCell<TipodeAcompanhamento>() {
			@Override
			protected void updateItem(TipodeAcompanhamento item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Tipo de Usuário");
				} else {
					setText(item.toString());
				}
			}
		});

		ComboTipo.setButtonCell(new ListCell<TipodeAcompanhamento>() {
			@Override
			protected void updateItem(TipodeAcompanhamento item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText("Tipo de Funcionário");
				} else {
					setText(item.toString());
				}
			}
		});
	}

	public void CarregarTabelas() {

		TabPedagogocpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		TabPedagogoNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		TabUsuarioNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		TabUsuariocpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));

		TabNomeac.setCellValueFactory(new PropertyValueFactory<>("nome"));
		TabPedagogoac.setCellValueFactory(new PropertyValueFactory<>("TipoDeAcompanhamento"));

		try {

			user = Fachada.getInstance().searchAllSuperUsuario();
			tabelaUsuario.getItems().setAll(user);

			pedagogos = Fachada.getInstance().searchAllPedagogo();
			tabelaPedagogo.getItems().setAll(pedagogos);

			acompanhamentos = fachada.getInstance().searchAllAcompanhamento();
			tabelaRelatorios.getItems().setAll(acompanhamentos);

		} catch (BusinessException e) {
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
