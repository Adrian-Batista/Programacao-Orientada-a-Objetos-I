package YouTube.ihc;

import java.awt.Desktop;
import java.io.FileInputStream;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainFX extends Application {

	private Stage stage;
	private Pane pane;
	private String usuarioLogado;
	private Label lblVideo;
	private Label lblCanal;
	private ImageView lblFundo;
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
			usuarioLogado = "Erro - Nome de usu�rio em branco!";
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
		
		FileInputStream inputstream = new FileInputStream("C:/Users/adria/OneDrive/Documentos/GitHub/Programacao-Orientada-a-Objetos-I/src/img/logo.png"); 
		Image image = new Image(inputstream); 
		ImageView imageView = new ImageView(image);
		lblFundo = imageView;

		lblVideo = new Label("Escolha um V�deo:");
		lblVideo.styleProperty().set("-fx-text-fill: white;");
		listaVideo = new ListView<String>();
		ObservableList<String> items = FXCollections.observableArrayList(geraListaVideos());
		listaVideo.setItems(items);
		
		lblCanal = new Label("Lista de Canais:");
		lblCanal.styleProperty().set("-fx-text-fill: white;");
		listaCanal = new ListView<String>();
		ObservableList<String> item = FXCollections.observableArrayList(geraListaCanais());
		listaCanal.setItems(item);

		btnCadastrarVideo = new Button("Cadastrar V�deo");
		btnCadastrarVideo.setOnAction(cadastrarVideo());
		btnCadastrarVideo.styleProperty().set("-fx-text-fill: white; -fx-background-color: #00EE00;");

		btnAlterarVideo = new Button("Alterar V�deo");
		btnAlterarVideo.setOnAction(abrirAlteracaoVideo());
		btnAlterarVideo.styleProperty().set("-fx-text-fill: white; -fx-background-color: #00EE00;");

		btnExcluirVideo = new Button("Excluir V�deo");
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
		pane.getChildren().addAll(lblFundo, lblVideo, lblCanal, listaVideo, listaCanal, btnCadastrarVideo, btnAlterarVideo, btnExcluirVideo,
				btnCadastrarCanal,btnVizuBrowser, btnSair);
		
		pane.styleProperty().set("-fx-background-color: #696969");
	}

	private void configLayout() {
		pane.setPrefSize(645, 480);
		
		lblFundo.setFitHeight(pane.getPrefHeight());
		lblFundo.setFitWidth(pane.getPrefWidth());
		
		lblVideo.setLayoutX(pane.getPrefWidth() - 610);
		lblVideo.setLayoutY(95);
		listaVideo.setLayoutX(pane.getPrefWidth() - 610);
		listaVideo.setLayoutY(115);
		listaVideo.setPrefHeight(pane.getPrefHeight() - 200);
		listaVideo.setPrefWidth(385);
		
		lblCanal.setLayoutX(pane.getPrefWidth() - 210);
		lblCanal.setLayoutY(95);
		listaCanal.setLayoutX(pane.getPrefWidth() - 210);
		listaCanal.setLayoutY(115);
		listaCanal.setPrefHeight(pane.getPrefHeight() - 200);
		listaCanal.setPrefWidth(185);

		btnCadastrarVideo.setLayoutX(pane.getPrefWidth() - 610);
		btnCadastrarVideo.setLayoutY(pane.getPrefHeight() - 70);
		btnCadastrarVideo.setPrefHeight(20);
		btnCadastrarVideo.setPrefWidth(185);

		btnAlterarVideo.setLayoutX(pane.getPrefWidth() - 410);
		btnAlterarVideo.setLayoutY(pane.getPrefHeight() - 70);
		btnAlterarVideo.setPrefHeight(20);
		btnAlterarVideo.setPrefWidth(185);

		btnExcluirVideo.setLayoutX(pane.getPrefWidth() - 210);
		btnExcluirVideo.setLayoutY(pane.getPrefHeight() - 70);
		btnExcluirVideo.setPrefHeight(20);
		btnExcluirVideo.setPrefWidth(185);
		
		btnCadastrarCanal.setLayoutX(pane.getPrefWidth() - 610);
		btnCadastrarCanal.setLayoutY(pane.getPrefHeight() - 35);
		btnCadastrarCanal.setPrefHeight(20);
		btnCadastrarCanal.setPrefWidth(185);
		
		btnVizuBrowser.setLayoutX(pane.getPrefWidth() - 410);
		btnVizuBrowser.setLayoutY(pane.getPrefHeight() - 35);
		btnVizuBrowser.setPrefHeight(20);
		btnVizuBrowser.setPrefWidth(185);

		btnSair.setLayoutX(pane.getPrefWidth() - 210);
		btnSair.setLayoutY(pane.getPrefHeight() - 35);
		btnSair.setPrefHeight(20);
		btnSair.setPrefWidth(185);
	}
	
	private EventHandler<ActionEvent> abrirAlteracaoVideo() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (listaVideo.getSelectionModel().isEmpty()) {
					AlertaFX.alerta("Selecione um jogo para ser alterado.");
					return;
				}
				
				String nomeVideo = listaVideo.getSelectionModel().getSelectedItem();
				Video video = new VideoDAO().get(nomeVideo);
				
				try {
					new AlterarVideoFX(usuarioLogado, video).start(stage);
				} catch (Exception e) {
					AlertaFX.erro("N�o foi poss�vel iniciar a tela de cadastro de um V�deo!");
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
					AlertaFX.erro("N�o foi poss�vel iniciar a tela de cadastro de um jogo!");
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
					AlertaFX.erro("N�o foi poss�vel iniciar a tela de cadastro de um Canal!");
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
					AlertaFX.alerta("Selecione um V�deo para ser exclu�do.");
					return;
				}

				VideoDAO dao = new VideoDAO();
				Video video = dao.get(listaVideo.getSelectionModel().getSelectedItem());
				dao.remover(video);
				atualizarListaVideo();
			}
		};
	}
	
	private EventHandler<ActionEvent> abrirVideoBrowser() {
		return new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if (listaVideo.getSelectionModel().isEmpty()) {
					AlertaFX.alerta("Selecione um V�deo para ser aberto.");
					return;
				}

				VideoDAO dao = new VideoDAO();
				Video video = dao.get(listaVideo.getSelectionModel().getSelectedItem());
				video = dao.get(video.getNome());
				
				try {
					Desktop.getDesktop().browse(new URI(video.getLink()));
				} catch (IOException | URISyntaxException e) {
					AlertaFX.erro("N�o foi Possivel Abrir o Navegador!");
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
					AlertaFX.erro("N�o foi poss�vel iniciar a tela de login");
				}
			}
		};
	}

}
