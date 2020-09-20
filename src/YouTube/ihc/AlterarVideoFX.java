package YouTube.ihc;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import YouTube.bd.CanalDAO;
import YouTube.bd.VideoDAO;
import YouTube.entidades.Canal;
import YouTube.entidades.Video;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class AlterarVideoFX extends Application {

	private String usuarioLogado;
	private Stage stage;
	private Pane pane;
	private TextField txtNome;
	private TextField txtLink;
	private TextField txtDescricao;
	private TextField txtPreco;
	private Label lblPreco;
	private Label lblCanal;
	private Label lblData;
	private DatePicker lblDate;
	private ComboBox<String> cmbCanal;
	private Button btnVoltar;
	private Button btnAlterar;
	private Video video;
	private Video videoAtual;

	public AlterarVideoFX(String usuarioLogado, Video videoAtual) {
		this.usuarioLogado = usuarioLogado;
		this.videoAtual = videoAtual;
	}

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;

		initComponentes();

		configLayout();

		Scene scene = new Scene(pane);
		btnVoltar.requestFocus();

		stage.setScene(scene);
		stage.setTitle("Alteração de um Vídeo");
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() throws FileNotFoundException {
		Canal C = new Canal(null, null, null, null, null);
		video = new Video(null, null, null, null, null, 0);
		video.setCanal(C);

		txtNome = new TextField();
		txtNome.setPromptText("Digite o Nome do Vídeo");
		txtNome.setText(video.getNome());

		txtLink = new TextField();
		txtLink.setPromptText("Digite o Link do Vídeo");
		txtLink.setText(video.getLink());

		txtDescricao = new TextField();
		txtDescricao.setPromptText("Digite uma Descrição para o Vídeo");
		txtDescricao.setText(video.getDescricao());

		lblData = new Label("Escolha a Data:");
		DatePicker datePicker = new DatePicker();
		datePicker.setValue(LocalDate.of(2020, 9, 20));
		lblDate = datePicker;        

		lblPreco = new Label("Digite o Preço:");
		txtPreco = new TextField();
		txtPreco.setText(String.valueOf(video.getPreco()));

		lblCanal = new Label("Escolha o Canal:");
		cmbCanal = new ComboBox<>();
		cmbCanal.setPromptText("Selecionar");
		cmbCanal.setItems(FXCollections.observableArrayList(geraListaCanais()));
		cmbCanal.getSelectionModel().select(video.getCanal().getNome());

		btnAlterar = new Button("Alterar");
		btnAlterar.setOnAction(alterar());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(txtNome, txtLink, txtDescricao, lblPreco, txtPreco, lblCanal, cmbCanal,lblData, lblDate, btnAlterar, btnVoltar);
		pane.styleProperty().set("-fx-background-color: #696969");
	}

	private void configLayout() {
		pane.setPrefSize(320, 340);

		txtNome.setLayoutX(10);
		txtNome.setLayoutY(10);
		txtNome.setPrefHeight(30);
		txtNome.setPrefWidth(pane.getPrefWidth() - 20);
		txtNome.styleProperty().set("-fx-border-color: #00EE00;");

		txtLink.setLayoutX(10);
		txtLink.setLayoutY(50);
		txtLink.setPrefHeight(30);
		txtLink.setPrefWidth(pane.getPrefWidth() - 20);
		txtLink.styleProperty().set("-fx-border-color: #00EE00;");

		txtDescricao.setLayoutX(10);
		txtDescricao.setLayoutY(90);
		txtDescricao.setPrefHeight(30);
		txtDescricao.setPrefWidth(pane.getPrefWidth() - 20);
		txtDescricao.styleProperty().set("-fx-border-color: #00EE00;");

		lblPreco.setLayoutX(10);
		lblPreco.setLayoutY(130);
		lblPreco.styleProperty().set("-fx-text-fill: white;");
		txtPreco.setLayoutX(10);
		txtPreco.setLayoutY(150);
		txtPreco.setPrefHeight(30);
		txtPreco.setPrefWidth(pane.getPrefWidth() - 20);
		txtPreco.styleProperty().set("-fx-border-color: #00EE00;");

		lblCanal.setLayoutX(10);
		lblCanal.setLayoutY(190);
		lblCanal.styleProperty().set("-fx-text-fill: white;");
		cmbCanal.setLayoutX(10);
		cmbCanal.setLayoutY(210);
		cmbCanal.setPrefHeight(30);
		cmbCanal.setPrefWidth(pane.getPrefWidth() - 20);
		cmbCanal.styleProperty().set("-fx-text-fill: white; -fx-text-fill: white; -fx-background-color: white;");

		lblData.setLayoutX(10);
		lblData.setLayoutY(250);
		lblData.styleProperty().set("-fx-text-fill: white;");
		lblDate.setLayoutX(10);
		lblDate.setLayoutY(270);
		lblDate.styleProperty().set("-fx-text-fill: white; -fx-text-fill: white; -fx-background-color: #00EE00;");

		btnAlterar.setLayoutX(10);
		btnAlterar.setLayoutY(310);
		btnAlterar.setPrefHeight(20);
		btnAlterar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
		btnAlterar.styleProperty().set("-fx-text-fill: white; -fx-background-color: #00EE00;");

		btnVoltar.setLayoutX(btnAlterar.getPrefWidth() + 20);
		btnVoltar.setLayoutY(310);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
		btnVoltar.styleProperty().set("-fx-text-fill: white; -fx-background-color: red;");
	}

	private List<String> geraListaCanais() {
		List<String> retorno = new ArrayList<String>();
		List<Canal> canais = new CanalDAO().todos();
		for (Canal canal : canais)
			retorno.add(canal.getNome());
		return retorno;
	}

	private EventHandler<ActionEvent> voltar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				abrirJanelaPrincipal();
			}
		};
	}

	private EventHandler<ActionEvent> alterar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					if(txtNome.getText().isBlank()) {
						AlertaFX.alerta("Nome do Vídeo em branco!");
						return;
					}
					if(txtLink.getText().isBlank()) {
						AlertaFX.alerta("Link do Vídeo em branco!");
						return;
					}
					if (txtPreco.getText().isBlank()) {
						AlertaFX.alerta("Preço em branco!");
						return;
					}
					if(cmbCanal.valueProperty().get()==null) {
						AlertaFX.alerta("Canal em branco!");
						return;
					}

					video.setNome(txtNome.getText());
					video.setLink(txtLink.getText());
					video.setPreco(Double.valueOf(txtPreco.getText()));
					video.setDate(String.valueOf(lblDate.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
					video.getCanal().setNome(cmbCanal.valueProperty().get());
					video.setDescricao(txtDescricao.getText());

					new VideoDAO().atualizar(video, videoAtual.getNome());

					AlertaFX.info("Vídeo atualizado com sucesso :)");

					abrirJanelaPrincipal();
				}catch(Exception e){
					AlertaFX.erro("Não foi Possível Atualizar o Vídeo!");
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
