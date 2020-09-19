package YouTube.ihc;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
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
import YouTube.bd.CanalDAO;
import YouTube.bd.VideoDAO;
import YouTube.entidades.Canal;
import YouTube.entidades.Video;

public class AlterarVideoFX extends Application {

	private String usuarioLogado;
	private Stage stage;
	private Pane pane;
	private TextField txtNome;
	private TextField txtLink;
	private TextField txtPreco;
	private Label lblCanal;
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
		stage.setTitle("Altera��o de um V�deo");
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() {
		Canal C = new Canal(null, null, null, null, null);
		video = new Video(null, null, null, null, null, 0);
		video.setCanal(C);
		
		txtNome = new TextField();
		txtNome.setPromptText("Digite o Nome do V�deo");
		txtNome.setText(video.getNome());
		
		txtLink = new TextField();
		txtLink.setPromptText("Digite o Link do V�deo");
		txtLink.setText(video.getLink());
		
		txtPreco = new TextField();
		txtPreco.setPromptText("Digite o Preco do V�deo");
		txtPreco.setText(String.valueOf(video.getPreco()));

		btnAlterar = new Button("Alterar");
		btnAlterar.setOnAction(alterar());

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());

		pane = new AnchorPane();
		pane.getChildren().addAll(txtNome, txtLink, txtPreco, btnAlterar, btnVoltar);

	}

	private void configLayout() {
		pane.setPrefSize(320, 400);

		txtNome.setLayoutX(10);
		txtNome.setLayoutY(10);
		txtNome.setPrefHeight(30);
		txtNome.setPrefWidth(pane.getPrefWidth() - 20);
		
		txtLink.setLayoutX(10);
		txtLink.setLayoutY(50);
		txtLink.setPrefHeight(30);
		txtLink.setPrefWidth(pane.getPrefWidth() - 20);
		
		txtPreco.setLayoutX(10);
		txtPreco.setLayoutY(90);
		txtPreco.setPrefHeight(30);
		txtPreco.setPrefWidth(pane.getPrefWidth() - 20);
		
		btnAlterar.setLayoutX(10);
		btnAlterar.setLayoutY(370);
		btnAlterar.setPrefHeight(20);
		btnAlterar.setPrefWidth((pane.getPrefWidth() - 30) / 2);

		btnVoltar.setLayoutX(btnAlterar.getPrefWidth() + 20);
		btnVoltar.setLayoutY(370);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
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
				//if (txtPreco.getText().isBlank()) {
					//AlertaFX.alerta("Pre�o em branco!");
					return;
				}

				//video.setPreco(Double.valueOf(txtPreco.getText()));
				//new VideoDAO().atualizar(video, videoAtual.getNome());

				//AlertaFX.info("V�deo atualizado com sucesso :)");

				//abrirJanelaPrincipal();
			
		};
	}

	private void abrirJanelaPrincipal() {
		try {
			new MainFX(usuarioLogado).start(stage);
		} catch (Exception e) {
			AlertaFX.erro("N�o foi poss�vel iniciar a tela principal!");
		}
	}

}
