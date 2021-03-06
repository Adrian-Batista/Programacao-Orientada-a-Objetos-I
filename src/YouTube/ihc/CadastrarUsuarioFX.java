package YouTube.ihc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import YouTube.bd.UsuarioDAO;
import YouTube.entidades.Usuario;

public class CadastrarUsuarioFX extends Application {

	private Stage stage;
	private Pane pane;
	private Label lblYouTube;
	private TextField txtUsuario;
	private TextField txtEmail;
	private PasswordField txtSenha1;
	private PasswordField txtSenha2;
	private Button btnVoltar;
	private Button btnCadastrar;

	@Override
	public void start(Stage stage) throws Exception {
		this.stage = stage;

		initComponentes();

		configLayout();

		Scene scene = new Scene(pane);
		btnVoltar.requestFocus();

		stage.setScene(scene);
		stage.setTitle("Registro de um novo Usuario");
		stage.setResizable(false);
		stage.show();
	}

	private void initComponentes() {

		lblYouTube = new Label("Preencha todos os campos.");
		lblYouTube.styleProperty().set("-fx-text-fill: white");

		txtUsuario = new TextField();
		txtUsuario.setPromptText("Digite aqui seu usu�rio");
		txtUsuario.styleProperty().set("-fx-border-color: #00EE00;");

		txtEmail = new TextField();
		txtEmail.setPromptText("Digite aqui seu e-mail");
		txtEmail.styleProperty().set("-fx-border-color: #00EE00;");

		txtSenha1 = new PasswordField();
		txtSenha1.setPromptText("Digite aqui sua senha");
		txtSenha1.styleProperty().set("-fx-border-color: #00EE00;");

		txtSenha2 = new PasswordField();
		txtSenha2.setPromptText("Confirme sua senha");
		txtSenha2.styleProperty().set("-fx-border-color: #00EE00;");

		btnCadastrar = new Button("Cadastrar");
		btnCadastrar.setOnAction(cadastrar());
		btnCadastrar.styleProperty().set("-fx-text-fill: white; -fx-background-color: #00EE00;");

		btnVoltar = new Button("Voltar");
		btnVoltar.setOnAction(voltar());
		btnVoltar.styleProperty().set("-fx-text-fill: white; -fx-background-color: red;");

		pane = new AnchorPane();
		pane.getChildren().addAll(lblYouTube, txtUsuario, txtEmail, txtSenha1, txtSenha2, btnCadastrar, btnVoltar);
		pane.styleProperty().set("-fx-background-color: #696969");
	}

	private void configLayout() {
		pane.setPrefSize(320, 230);

		lblYouTube.setLayoutX(80);
		lblYouTube.setLayoutY(10);

		txtUsuario.setLayoutX(10);
		txtUsuario.setLayoutY(35);
		txtUsuario.setPrefHeight(30);
		txtUsuario.setPrefWidth(pane.getPrefWidth() - 20);

		txtEmail.setLayoutX(10);
		txtEmail.setLayoutY(75);
		txtEmail.setPrefHeight(30);
		txtEmail.setPrefWidth(pane.getPrefWidth() - 20);

		txtSenha1.setLayoutX(10);
		txtSenha1.setLayoutY(115);
		txtSenha1.setPrefHeight(30);
		txtSenha1.setPrefWidth(pane.getPrefWidth() - 20);

		txtSenha2.setLayoutX(10);
		txtSenha2.setLayoutY(155);
		txtSenha2.setPrefHeight(30);
		txtSenha2.setPrefWidth(pane.getPrefWidth() - 20);

		btnCadastrar.setLayoutX(10);
		btnCadastrar.setLayoutY(195);
		btnCadastrar.setPrefHeight(20);
		btnCadastrar.setPrefWidth((pane.getPrefWidth() - 30) / 2);

		btnVoltar.setLayoutX(btnCadastrar.getPrefWidth() + 20);
		btnVoltar.setLayoutY(195);
		btnVoltar.setPrefHeight(20);
		btnVoltar.setPrefWidth((pane.getPrefWidth() - 30) / 2);
	}

	private EventHandler<ActionEvent> voltar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				abrirJanelaLogin();
			}
		};
	}

	private EventHandler<ActionEvent> cadastrar() {
		return new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (txtUsuario.getText().isBlank()) {
					AlertaFX.alerta("Usu�rio em branco!");
					return;
				}
				if (txtEmail.getText().isBlank()) {
					AlertaFX.alerta("E-mail em branco!");
					return;
				}
				if (txtSenha1.getText().isBlank()) {
					AlertaFX.alerta("Senha em branco!");
					return;
				}
				if (txtSenha2.getText().isBlank()) {
					AlertaFX.alerta("Confirma��o da senha em branco!");
					return;
				}
				if (!txtSenha1.getText().contentEquals(txtSenha2.getText())) {
					AlertaFX.alerta("Confirma��o da senha difere da senha!");
					return;
				}

				new UsuarioDAO().adicionar(new Usuario(0, txtUsuario.getText(), txtEmail.getText(), txtSenha1.getText()));

				AlertaFX.info("Usu�rio cadastrado com sucesso :)");

				abrirJanelaLogin();
			}
		};
	}

	private void abrirJanelaLogin() {
		try {
			new LoginFX().start(stage);
		} catch (Exception e) {
			AlertaFX.erro("N�o foi poss�vel iniciar a tela de login!");
		}
	}
}
