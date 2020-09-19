package YouTube.ihc;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import YouTube.bd.VideoDAO;
import YouTube.entidades.Video;

public class MainFX extends Application {

	private Stage stage;
	private Pane pane;
	private String usuarioLogado;
	private Button btnSair;
	private Button btnCadastrarVideo;
	private Button btnAlterarVideo;
	private Button btnExcluirVideo;
	private ListView<String> listaVideo;

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
		stage.setTitle("Steam de " + usuarioLogado);
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() {
		listaVideo = new ListView<String>();
		ObservableList<String> items = FXCollections.observableArrayList(geraListaVideos());
		listaVideo.setItems(items);

		btnCadastrarVideo = new Button("Cadastrar Vídeo");
		btnCadastrarVideo.setOnAction(abrirCadastroVideo());

		btnAlterarVideo = new Button("Alterar Vídeo");
		btnAlterarVideo.setOnAction(abrirAlteracaoVideo());

		btnExcluirVideo = new Button("Excluir Vídeo");
		btnExcluirVideo.setOnAction(excluirVideo());

		btnSair = new Button("Sair");
		btnSair.setOnAction(sair());

		pane = new AnchorPane();
		pane.getChildren().addAll(listaVideo, btnCadastrarVideo, btnAlterarVideo, btnExcluirVideo, btnSair);

	}

	private void configLayout() {
		pane.setPrefSize(640, 480);

		listaVideo.setLayoutX(10);
		listaVideo.setLayoutY(10);
		listaVideo.setPrefHeight(pane.getPrefHeight() - 55);
		listaVideo.setPrefWidth(pane.getPrefWidth() - 20);

		btnCadastrarVideo.setLayoutX(pane.getPrefWidth() - 590);
		btnCadastrarVideo.setLayoutY(pane.getPrefHeight() - 35);
		btnCadastrarVideo.setPrefHeight(20);
		btnCadastrarVideo.setPrefWidth(150);

		btnAlterarVideo.setLayoutX(pane.getPrefWidth() - 430);
		btnAlterarVideo.setLayoutY(pane.getPrefHeight() - 35);
		btnAlterarVideo.setPrefHeight(20);
		btnAlterarVideo.setPrefWidth(150);

		btnExcluirVideo.setLayoutX(pane.getPrefWidth() - 270);
		btnExcluirVideo.setLayoutY(pane.getPrefHeight() - 35);
		btnExcluirVideo.setPrefHeight(20);
		btnExcluirVideo.setPrefWidth(150);

		btnSair.setLayoutX(pane.getPrefWidth() - 110);
		btnSair.setLayoutY(pane.getPrefHeight() - 35);
		btnSair.setPrefHeight(20);
		btnSair.setPrefWidth(100);
	}

	private List<String> geraListaVideos() {
		List<String> retorno = new ArrayList<String>();
		List<Video> videos = new VideoDAO().todos();
		for (Video video : videos)
			retorno.add(video.getNome());
		return retorno;
	}

	private EventHandler<ActionEvent> excluirVideo() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (listaVideo.getSelectionModel().isEmpty()) {
					AlertaFX.alerta("Selecione um jogo para ser excluído.");
					return;
				}

				VideoDAO dao = new VideoDAO();
				Video video = dao.get(listaVideo.getSelectionModel().getSelectedItem());
				dao.remover(video);
				atualizarLista();
			}
		};
	}

	private void atualizarLista() {
		ObservableList<String> items = FXCollections.observableArrayList(geraListaVideos());
		listaVideo.setItems(items);
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
					//new AlterarVideoFX(usuarioLogado, video).start(stage);
				} catch (Exception e) {
					AlertaFX.erro("Não foi possível iniciar a tela de cadastro de um jogo!");
				}
			}
		};
	}

	private EventHandler<ActionEvent> abrirCadastroVideo() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					//new CadastrarVideoFX(usuarioLogado).start(stage);
				} catch (Exception e) {
					AlertaFX.erro("Não foi possível iniciar a tela de cadastro de um jogo!");
				}
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
