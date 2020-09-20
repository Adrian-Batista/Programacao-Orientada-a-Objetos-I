package YouTube.ihc;

import java.awt.Desktop;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import YouTube.bd.CanalDAO;
import YouTube.bd.VideoDAO;
import YouTube.entidades.Canal;
import YouTube.entidades.Video;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainFX extends Application {

	private Stage stage;
	private Pane pane;
	private String usuarioLogado;
	private Label lblVideo;
	private Label lblCanal;
	private Button btnSair;
	private Button btnCadastrarVideo;
	private Button btnAlterarVideo;
	private Button btnExcluirVideo;
	private Button btnCadastrarCanal;
	private Button btnVizuBrowser;
	private ListView<String> listaVideo;
	private ListView<String> listaCanal;

	public MainFX(String usuarioLogado) {
		if (usuarioLogado.isBlank())
			usuarioLogado = "Erro - Nome de usuário em branco!";
		this.usuarioLogado = usuarioLogado;
	}

	@Override
	public void start(Stage stage) throws Exception {

		this.stage = stage;

		initComponentes();

		configLayout();

		Scene scene = new Scene(pane);
		btnSair.requestFocus();

		stage.setScene(scene);
		stage.setTitle("YouTube de " + usuarioLogado);
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() throws FileNotFoundException {

		lblVideo = new Label("Escolha um Vídeo:");
		lblVideo.styleProperty().set("-fx-text-fill: white;");
		listaVideo = new ListView<String>();
		ObservableList<String> items = FXCollections.observableArrayList(geraListaVideos());
		listaVideo.setItems(items);

		lblCanal = new Label("Lista de Canais:");
		lblCanal.styleProperty().set("-fx-text-fill: white;");
		listaCanal = new ListView<String>();
		ObservableList<String> item = FXCollections.observableArrayList(geraListaCanais());
		listaCanal.setItems(item);

		btnCadastrarVideo = new Button("Cadastrar Vídeo");
		btnCadastrarVideo.setOnAction(cadastrarVideo());
		btnCadastrarVideo.styleProperty().set("-fx-text-fill: white; -fx-background-color: #00EE00;");

		btnAlterarVideo = new Button("Alterar Vídeo");
		btnAlterarVideo.setOnAction(abrirAlteracaoVideo());
		btnAlterarVideo.styleProperty().set("-fx-text-fill: white; -fx-background-color: #00EE00;");

		btnExcluirVideo = new Button("Excluir Vídeo");
		btnExcluirVideo.setOnAction(excluirVideo());
		btnExcluirVideo.styleProperty().set("-fx-text-fill: white; -fx-background-color: #00EE00;");

		btnCadastrarCanal = new Button("Cadastrar Canal");
		btnCadastrarCanal.setOnAction(cadastrarCanal());
		btnCadastrarCanal.styleProperty().set("-fx-text-fill: white; -fx-background-color: #00EE00;");

		btnVizuBrowser = new Button("Visualizar no YouTube");
		btnVizuBrowser.setOnAction(abrirVideoBrowser());
		btnVizuBrowser.styleProperty().set("-fx-text-fill: white; -fx-background-color: #00EE00;");

		btnSair = new Button("Sair");
		btnSair.setOnAction(sair());
		btnSair.styleProperty().set("-fx-text-fill: white; -fx-background-color: red;");

		pane = new AnchorPane();
		pane.getChildren().addAll(lblVideo, lblCanal, listaVideo, listaCanal, btnCadastrarVideo, btnAlterarVideo, btnExcluirVideo,
				btnCadastrarCanal,btnVizuBrowser, btnSair);

		pane.styleProperty().set("-fx-background-color: #696969");
	}

	private void configLayout() {
		pane.setPrefSize(645, 440);

		lblVideo.setLayoutX(30);
		lblVideo.setLayoutY(35);
		listaVideo.setLayoutX(30);
		listaVideo.setLayoutY(55);
		listaVideo.setPrefHeight(280);
		listaVideo.setPrefWidth(385);

		lblCanal.setLayoutX(435);
		lblCanal.setLayoutY(35);
		listaCanal.setLayoutX(435);
		listaCanal.setLayoutY(55);
		listaCanal.setPrefHeight(280);
		listaCanal.setPrefWidth(185);

		btnCadastrarVideo.setLayoutX(30);
		btnCadastrarVideo.setLayoutY(355);
		btnCadastrarVideo.setPrefHeight(20);
		btnCadastrarVideo.setPrefWidth(185);

		btnAlterarVideo.setLayoutX(235);
		btnAlterarVideo.setLayoutY(355);
		btnAlterarVideo.setPrefHeight(20);
		btnAlterarVideo.setPrefWidth(185);

		btnExcluirVideo.setLayoutX(435);
		btnExcluirVideo.setLayoutY(355);
		btnExcluirVideo.setPrefHeight(20);
		btnExcluirVideo.setPrefWidth(185);

		btnCadastrarCanal.setLayoutX(30);
		btnCadastrarCanal.setLayoutY(395);
		btnCadastrarCanal.setPrefHeight(20);
		btnCadastrarCanal.setPrefWidth(185);

		btnVizuBrowser.setLayoutX(235);
		btnVizuBrowser.setLayoutY(395);
		btnVizuBrowser.setPrefHeight(20);
		btnVizuBrowser.setPrefWidth(185);

		btnSair.setLayoutX(435);
		btnSair.setLayoutY(395);
		btnSair.setPrefHeight(20);
		btnSair.setPrefWidth(185);
	}

	private EventHandler<ActionEvent> abrirAlteracaoVideo() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (listaVideo.getSelectionModel().isEmpty()) {
					AlertaFX.alerta("Selecione um Vídeo para ser alterado.");
					return;
				}

				String nomeVideo = listaVideo.getSelectionModel().getSelectedItem();
				Video video = new VideoDAO().get(nomeVideo);

				try {
					new AlterarVideoFX(usuarioLogado, video).start(stage);
				} catch (Exception e) {
					AlertaFX.erro("Não foi possível iniciar a tela de cadastro de um Vídeo!");
				}
			}
		};
	}

	private EventHandler<ActionEvent> cadastrarVideo() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new AdicionarVideoFX(usuarioLogado).start(stage);
				} catch (Exception e) {
					AlertaFX.erro("Não foi possível iniciar a tela de cadastro de um Vídeo!");
				}
			}
		};
	}

	private EventHandler<ActionEvent> cadastrarCanal() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new AdicionarCanalFX(usuarioLogado).start(stage);

				} catch (Exception e) {
					AlertaFX.erro("Não foi possível iniciar a tela de cadastro de um Canal!");
				}
			}
		};
	}

	private List<String> geraListaVideos() {
		List<String> retorno = new ArrayList<String>();
		List<Video> videos = new VideoDAO().todos();
		for (Video video : videos)
			retorno.add(video.getNome());
		return retorno;
	}

	private List<String> geraListaCanais() {
		List<String> retorno = new ArrayList<String>();
		List<Canal> canais = new CanalDAO().todos();
		for (Canal canal : canais)
			retorno.add(canal.getNome());
		return retorno;
	}

	private void atualizarListaVideo() {
		ObservableList<String> items = FXCollections.observableArrayList(geraListaVideos());
		listaVideo.setItems(items);
	}

	private EventHandler<ActionEvent> excluirVideo() {
		return new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (listaVideo.getSelectionModel().isEmpty()) {
					AlertaFX.alerta("Selecione um Vídeo para ser excluído.");
					return;
				}

				VideoDAO dao = new VideoDAO();
				Video video = dao.get(listaVideo.getSelectionModel().getSelectedItem());
				dao.remover(video);
				atualizarListaVideo();
				AlertaFX.info("Vídeo Removido com Sucesso!! :)");
			}
		};
	}

	private EventHandler<ActionEvent> abrirVideoBrowser() {
		return new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (listaVideo.getSelectionModel().isEmpty()) {
					AlertaFX.alerta("Selecione um Vídeo para ser aberto.");
					return;
				}

				VideoDAO dao = new VideoDAO();
				Video video = dao.get(listaVideo.getSelectionModel().getSelectedItem());
				video = dao.get(video.getNome());

				try {
					Desktop.getDesktop().browse(new URI(video.getLink()));
				} catch (IOException | URISyntaxException e) {
					AlertaFX.erro("Não foi Possivel Abrir o Navegador!");
					e.printStackTrace();
				}

				atualizarListaVideo();
			}
		};
	}

	private EventHandler<ActionEvent> sair() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new LoginFX().start(stage);
				} catch (Exception e) {
					AlertaFX.erro("Não foi possível iniciar a tela de login");
				}
			}
		};
	}

}
