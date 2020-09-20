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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private Button btnCadastrarCanal;
	private Button btnRemoverCanal;
	private ListView<String> listaVideo;
	private final String IMG_URL = "http://www.oracle.com/ocom/groups/public/@otn/documents/digitalasset/402460.gif";


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
		
		 Image imagem = new Image(IMG_URL); // 1
		 ImageView visualizadorImagem = new ImageView(imagem); // 2
		 visualizadorImagem.setTranslateX(80); // 3
		 visualizadorImagem.setTranslateY(5); // 4

		
		
		listaVideo = new ListView<String>();
		ObservableList<String> items = FXCollections.observableArrayList(geraListaVideos());
		listaVideo.setItems(items);

		btnCadastrarVideo = new Button("Cadastrar Vídeo");
		btnCadastrarVideo.setOnAction(abrirCadastroVideo());
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
		
		btnRemoverCanal = new Button("Remover Canal");
		btnRemoverCanal.setOnAction(removerCanal());
		btnRemoverCanal.styleProperty().set("-fx-text-fill: white; -fx-background-color: #00EE00;");

		btnSair = new Button("Sair");
		btnSair.setOnAction(sair());
		btnSair.styleProperty().set("-fx-text-fill: white; -fx-background-color: red;");

		pane = new AnchorPane();
		pane.getChildren().addAll(visualizadorImagem, listaVideo, btnCadastrarVideo, btnAlterarVideo, btnExcluirVideo,
				btnCadastrarCanal,btnRemoverCanal, btnSair);
		
		pane.styleProperty().set("-fx-background-color: #696969");
	}

	private void configLayout() {
		pane.setPrefSize(645, 480);
		
		
		listaVideo.setLayoutX(35);
		listaVideo.setLayoutY(115);
		listaVideo.setPrefHeight(pane.getPrefHeight() - 200);
		listaVideo.setPrefWidth(pane.getPrefWidth() - 60);

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
		
		btnRemoverCanal.setLayoutX(pane.getPrefWidth() - 410);
		btnRemoverCanal.setLayoutY(pane.getPrefHeight() - 35);
		btnRemoverCanal.setPrefHeight(20);
		btnRemoverCanal.setPrefWidth(185);

		btnSair.setLayoutX(pane.getPrefWidth() - 210);
		btnSair.setLayoutY(pane.getPrefHeight() - 35);
		btnSair.setPrefHeight(20);
		btnSair.setPrefWidth(185);
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
					AlertaFX.alerta("Selecione um Vídeo para ser excluído.");
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
					new AlterarVideoFX(usuarioLogado, video).start(stage);
				} catch (Exception e) {
					AlertaFX.erro("Não foi possível iniciar a tela de cadastro de um Vídeo!");
				}
			}
		};
	}

	private EventHandler<ActionEvent> abrirCadastroVideo() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new AdicionarVideoFX(usuarioLogado).start(stage);
				} catch (Exception e) {
					AlertaFX.erro("Não foi possível iniciar a tela de cadastro de um jogo!");
				}
			}
		};
	}
	
	private EventHandler<ActionEvent> cadastrarCanal() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try {
					new AdicionarVideoFX(usuarioLogado).start(stage);
				} catch (Exception e) {
					AlertaFX.erro("Não foi possível iniciar a tela de cadastro de um Canal!");
				}
			}
		};
	}
	
	private EventHandler<ActionEvent> removerCanal() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (listaVideo.getSelectionModel().isEmpty()) {
					AlertaFX.alerta("Selecione um Canal para ser excluído.");
					return;
				}

				VideoDAO dao = new VideoDAO();
				Video video = dao.get(listaVideo.getSelectionModel().getSelectedItem());
				dao.remover(video);
				atualizarLista();
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
