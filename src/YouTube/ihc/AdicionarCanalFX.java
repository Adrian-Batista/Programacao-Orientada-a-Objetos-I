package YouTube.ihc;

import java.util.List;

import YouTube.bd.CanalDAO;
import YouTube.entidades.Canal;
import YouTube.entidades.Inscricao;
import YouTube.entidades.PublicoAlvo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AdicionarCanalFX extends Application {

	private String usuarioLogado;
	private Stage stage;
	private Pane pane;
	private TextField txtNome;
	private TextField txtEmail;
	private TextField txtDescricao;
	private Label lblPublico;
	private ComboBox<String> cmbPublico;
	private Button btnVoltar;
	private Button btnCadastrar;
	private Canal canal;

	public AdicionarCanalFX(String usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;

		initComponentes();

		configLayout();

		Scene scene = new Scene(pane);
		btnVoltar.requestFocus();

		stage.setScene(scene);
		stage.setTitle("Cadastro de um Canal");
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() {
		PublicoAlvo P = new PublicoAlvo(null);
		Inscricao I = new Inscricao(null, 0);
		canal = new Canal(null, null, null, null, null);
		canal.setPublico(P);
		canal.setInscrito(I);

		txtNome = new TextField();
		txtNome.setPromptText("Digite o Nome do Canal");
		txtNome.setText(canal.getNome());

		txtEmail = new TextField();
		txtEmail.setPromptText("Digite o E-mail do Canal");
		txtEmail.setText(canal.getEmail());

		txtDescricao = new TextField();
		txtDescricao.setPromptText("Digite uma Descrição para o Canal");
		txtDescricao.setText(canal.getDescricao());

		lblPublico = new Label("Escolha o Público:");
		cmbPublico = new ComboBox<>();
		cmbPublico.setPromptText("Selecionar");
		cmbPublico.setItems(FXCollections.observableArrayList(geraListaPublico()));
		cmbPublico.getSelectionModel().select(canal.getPublico().getOpcao());

		btnCadastrar = new Button("Cadastrar");
		btnCadastrar.setOnAction(cadastrar());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(txtNome, txtEmail, txtDescricao, lblPublico, cmbPublico, btnCadastrar, btnVoltar);
		pane.styleProperty().set("-fx-background-color: #696969");
	}

	private void configLayout() {
		pane.setPrefSize(320, 230);

		txtNome.setLayoutX(10);
		txtNome.setLayoutY(10);
		txtNome.setPrefHeight(30);
		txtNome.setPrefWidth(pane.getPrefWidth() - 20);
		txtNome.styleProperty().set("-fx-border-color: #00EE00;");

		txtEmail.setLayoutX(10);
		txtEmail.setLayoutY(50);
		txtEmail.setPrefHeight(30);
		txtEmail.setPrefWidth(pane.getPrefWidth() - 20);
		txtEmail.styleProperty().set("-fx-border-color: #00EE00;");

		txtDescricao.setLayoutX(10);
		txtDescricao.setLayoutY(90);
		txtDescricao.setPrefHeight(30);
		txtDescricao.setPrefWidth(pane.getPrefWidth() - 20);
		txtDescricao.styleProperty().set("-fx-border-color: #00EE00;");

		lblPublico.setLayoutX(10);
		lblPublico.setLayoutY(130);
		lblPublico.styleProperty().set("-fx-text-fill: white;");
		cmbPublico.setLayoutX(10);
		cmbPublico.setLayoutY(150);
		cmbPublico.setPrefHeight(30);
		cmbPublico.setPrefWidth(pane.getPrefWidth() - 20);
		cmbPublico.styleProperty().set("-fx-text-fill: white; -fx-text-fill: white; -fx-background-color: white;");

		btnCadastrar.setLayoutX(10);
		btnCadastrar.setLayoutY(190);
		btnCadastrar.setPrefHeight(20);
		btnCadastrar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
		btnCadastrar.styleProperty().set("-fx-text-fill: white; -fx-background-color: #00EE00;");

		btnVoltar.setLayoutX(btnCadastrar.getPrefWidth() + 20);
		btnVoltar.setLayoutY(190);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
		btnVoltar.styleProperty().set("-fx-text-fill: white; -fx-background-color: red;");
	}

	private List<String> geraListaPublico() {
		ObservableList<String> itens = FXCollections.observableArrayList();
		itens.addAll("Crianças", "Jovens", "Adultos", "Idosos", "Todos");
		return itens;
	}

	private EventHandler<ActionEvent> voltar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				abrirJanelaPrincipal();
			}
		};
	}

	private EventHandler<ActionEvent> cadastrar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {

					if(txtNome.getText().isBlank()) {
						AlertaFX.alerta("Nome do Canal em branco!");
						return;
					}
					if(txtEmail.getText().isBlank()) {
						AlertaFX.alerta("E-mail do Canal em branco!");
						return;
					}
					if(cmbPublico.valueProperty().get()==null) {
						AlertaFX.alerta("Público em branco!");
						return;
					}

					canal.setNome(txtNome.getText());
					canal.setEmail(txtEmail.getText());
					canal.setDescricao(txtDescricao.getText());
					canal.getPublico().setOpcao(cmbPublico.valueProperty().get());
					canal.getInscrito().setNumeroInscritos(0);

					System.out.println(canal.getNome());
					System.out.println(canal.getEmail());
					System.out.println(canal.getDescricao());
					System.out.println(canal.getPublico().getOpcao());
					System.out.println(canal.getInscrito().getNumeroInscritos());

					new CanalDAO().adicionar(canal);

					AlertaFX.info("Canal Cadastrado com sucesso :)");

					abrirJanelaPrincipal();
				}catch(Exception e){
					AlertaFX.erro("Não foi Possível Adicionar o Canal!");
				}

			}
		};
	}

	private void abrirJanelaPrincipal() {
		try {
			new MainFX(usuarioLogado).start(stage);
		} catch (Exception e) {
			AlertaFX.erro("Não foi possível iniciar a tela principal!");
		}
	}

}
