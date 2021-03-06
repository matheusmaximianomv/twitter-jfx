package app.views;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import app.controllers.LoginController;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */
public class Login extends Application {

    private final String PATH_LOGO_TWITTER = "digite_o_caminho\\src\\assets\\img\\twitter-logo.png";
    
    private AnchorPane pane;
    private TextField txLogin;
    private PasswordField txSenha;
    private Button btEntrar, btCadastrar, btSair;
    private ImageView logo;
    private static Stage stage;
    
    private LoginController auth = new LoginController();
    
    @Override
    public void start(Stage stage) throws Exception {
        
        initComponents();
        initListeners();
        
        Scene scene = new Scene(pane);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Twitter");
        stage.show();
        
        initLayout();
        
        Login.stage = stage;
    }
    
    private void initComponents() throws Exception {
        pane = new AnchorPane();
        pane.setPrefSize(400, 300);
        pane.setStyle("-fx-background-color: white;");
        
        Image image = new Image(new FileInputStream(PATH_LOGO_TWITTER));
        logo = new ImageView(image);
        
        txLogin = new TextField();
        txLogin.setPromptText("Digite seu login...");
        
        txSenha = new PasswordField();
        txSenha.setPromptText("Digite sua senha...");
        
        btEntrar = new Button("Entrar");
        btCadastrar = new Button("Cadastrar");
        btSair = new Button("Fechar");
        
        pane.getChildren().addAll(logo, txLogin, txSenha, btEntrar, btCadastrar, btSair);
        
    }
    
    private void initLayout() {
        
        logo.setFitHeight(50);
        logo.setFitWidth(txLogin.getWidth());
        logo.autosize();
        logo.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
        logo.setLayoutY(30);
        
        txLogin.setLayoutX((pane.getWidth() - txLogin.getWidth()) / 2);
        txLogin.setLayoutY(logo.getLayoutY() + 60);
        
        txSenha.setLayoutX((pane.getWidth() - txSenha.getWidth()) / 2);
        txSenha.setLayoutY(txLogin.getLayoutY() + 30);
        
        btEntrar.setLayoutX(txSenha.getLayoutX());
        btEntrar.setLayoutY(txSenha.getLayoutY() + 40);
        btEntrar.setMinWidth(txSenha.getWidth());
        btEntrar.setStyle("-fx-background-color: #1da1f2; -fx-background-radius:10px;"
                + " -fx-border-radius: 10px; -fx-text-fill:white");
        btEntrar.setCursor(Cursor.HAND);
        
        btCadastrar.setLayoutX(btEntrar.getLayoutX());
        btCadastrar.setLayoutY(btEntrar.getLayoutY() + 30);
        btCadastrar.setMinWidth(txSenha.getWidth());
        btCadastrar.setStyle("-fx-background-color: white; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        btCadastrar.setCursor(Cursor.HAND);
        
        btSair.setLayoutX(btCadastrar.getLayoutX());
        btSair.setLayoutY(btCadastrar.getLayoutY() + 60);
        btSair.setMinWidth(txSenha.getWidth());
        btSair.setStyle("-fx-background-color: white; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        btSair.setCursor(Cursor.HAND);
        
    }

    private void initListeners() {
        
        /* Botão de Entrar*/
        // Iniciando o Processo de Autenticação */
        btEntrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) { 
                
                if(auth.logarAplicacao(txLogin.getText(), txSenha.getText())) {
                    Timeline timeline = new Timeline();
                    try {
                        timeline.start(new Stage());
                        Login.stage.close();
                    } catch(Exception e) {
                        e.printStackTrace();

                        Alert errorLogar = new Alert(AlertType.ERROR);
                        errorLogar.setContentText("Não foi possível conectar o usuário na aplicação. Por favor tente mais tarde...");
                        errorLogar.setTitle("Falha na Autenticação");
                        errorLogar.setHeaderText(null);
                        errorLogar.showAndWait();
                    }
                } else {
                    Alert errorLogar = new Alert(Alert.AlertType.ERROR);
                    errorLogar.setContentText("Email ou senha errados.");
                    errorLogar.setTitle("Falha na Autenticação");
                    errorLogar.setHeaderText(null);
                    errorLogar.showAndWait();
                }
            }
        });
        
        // Mudando a estilização quando o mouse passa por cima do botão
        btEntrar.setOnMouseEntered( e -> {
            btEntrar.setStyle("-fx-background-color: #006dbf; -fx-background-radius:10px;"
                + " -fx-border-radius: 10px; -fx-text-fill:white");
        });
        
        // Mudando a estilização quando o mouse sai de cima do botão
        btEntrar.setOnMouseExited(e -> {
            btEntrar.setStyle("-fx-background-color: #1da1f2; -fx-background-radius:10px;"
                + " -fx-border-radius: 10px; -fx-text-fill:white");
        });
        
        /* Botão de Cadastro */
        btCadastrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Register register = new Register();
                try {
                    register.start(new Stage());
                    Login.stage.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        // Mudando a estilização quando o mouse passa por cima do botão
        btCadastrar.setOnMouseEntered( e -> {
            btCadastrar.setStyle("-fx-background-color: #eaf5fd; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        });
        
        // Mudando a estilização quando o mouse sai de cima do botão
        btCadastrar.setOnMouseExited(e -> {
            btCadastrar.setStyle("-fx-background-color: white; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        });
        
        /* Botão de Sair */
        btSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                auth.fecharAplicacao();
            }
        });
        
        // Mudando a estilização quando o mouse passa por cima do botão
        btSair.setOnMouseEntered( e -> {
            btSair.setStyle("-fx-background-color: #eaf5fd; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        });
        
        // Mudando a estilização quando o mouse sai de cima do botão
        btSair.setOnMouseExited(e -> {
            btSair.setStyle("-fx-background-color: white; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        });
    }
    
    public static void main(String[] args) {
        launch(args);
    }

}
