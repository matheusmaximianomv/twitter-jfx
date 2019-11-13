package app.views;

import app.controllers.RegisterController;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */

public class Register extends Application {
    
    private final String PATH_LOGO_TWITTER = "caminho_ate_o_projeto\\src\\assets\\"
            + "img\\twitter-logo.png";
    
    private AnchorPane pane;
    private Label lbUsername, lbEmail, lbPassword;
    private TextField txUsername, txEmail;
    private PasswordField txPassword;
    private Button btVoltar, btCadastrar;
    private ImageView logo;
    private static Stage stage;
    
    private void initComponents() throws Exception{
        
        pane = new AnchorPane();
        pane.setPrefSize(323, 345);
        
        Image image = new Image(new FileInputStream(PATH_LOGO_TWITTER));
        logo = new ImageView(image);
        logo.setFitHeight(70);
        logo.setFitWidth(236);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);
        
        lbUsername = new Label("Username");
        txUsername = new TextField();
        
        lbEmail = new Label("Email");
        txEmail = new TextField();
        
        lbPassword = new Label("Password");
        txPassword = new PasswordField();
        
        btVoltar = new Button("Voltar");
        btCadastrar = new Button("Cadastrar");
        
        pane.getChildren().addAll(logo, lbUsername, txUsername, lbEmail, txEmail, lbPassword, txPassword, btVoltar, btCadastrar);
    }
    
    private void initListeners() {
        
        /* Botão de Cadastrar */
        btCadastrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RegisterController register = new RegisterController(txUsername.getText(), txEmail.getText(), txPassword.getText());
                int registerResult = register.registerUser();
                
                
                if(registerResult == 2) {
                    
                    Alert successRegistro = new Alert(Alert.AlertType.CONFIRMATION);
                    successRegistro.setContentText("Cadastro realizado com sucesso.");
                    successRegistro.setTitle("Cadastro");
                    successRegistro.setHeaderText(null);
                    successRegistro.showAndWait();
                    
                    Login login = new Login();
                    
                    try {
                        login.start(new Stage());
                        Register.stage.close();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                } else if(registerResult == 1) {
                    Alert errorRegistro = new Alert(Alert.AlertType.ERROR);
                    errorRegistro.setContentText("Uma conta com esse email já existe.");
                    errorRegistro.setTitle("Falha no Cadastro");
                    errorRegistro.setHeaderText(null);
                    errorRegistro.showAndWait();
                } else {
                    Alert errorRegistro = new Alert(Alert.AlertType.ERROR);
                    errorRegistro.setContentText("Alguns campos estão vazios.");
                    errorRegistro.setTitle("Falha no Cadastro");
                    errorRegistro.setHeaderText(null);
                    errorRegistro.showAndWait();
                }
            }
        });
        
        // Mudando a estilização quando o mouse passa por cima do botão
        btCadastrar.setOnMouseEntered( e -> {
            btCadastrar.setStyle("-fx-background-color: #006dbf; -fx-background-radius:10px;"
                + " -fx-border-radius: 10px; -fx-text-fill:white");
        });
        
        // Mudando a estilização quando o mouse sai de cima do botão
        btCadastrar.setOnMouseExited(e -> {
            btCadastrar.setStyle("-fx-background-color: #1da1f2; -fx-background-radius:10px;"
                + " -fx-border-radius: 10px; -fx-text-fill:white");
        });
        
        /* Botão de Voltar */
        btVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login login = new Login();
                try{
                    login.start(new Stage());
                    Register.stage.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        // Mudando a estilização quando o mouse passa por cima do botão
        btVoltar.setOnMouseEntered( e -> {
            btVoltar.setStyle("-fx-background-color: #eaf5fd; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        });
        
        // Mudando a estilização quando o mouse sai de cima do botão
        btVoltar.setOnMouseExited(e -> {
            btVoltar.setStyle("-fx-background-color: white; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        });
    }
    
    private void initLayouts() {
        
        pane.setStyle("-fx-background-color: white;");
        
        logo.setLayoutX(51);
        logo.setLayoutY(14);
        
        lbUsername.setFont(Font.font(14));
        lbUsername.setLayoutX(44);
        lbUsername.setLayoutY(106);
        
        txUsername.setPrefHeight(25);
        txUsername.setPrefWidth(236);
        txUsername.setLayoutX(lbUsername.getLayoutX());
        txUsername.setLayoutY(126);
        
        lbEmail.setFont(Font.font(14));
        lbEmail.setLayoutX(44);
        lbEmail.setLayoutY(157);
        
        txEmail.setPrefHeight(25);
        txEmail.setPrefWidth(236);
        txEmail.setLayoutX(44);
        txEmail.setLayoutY(177);
        
        lbPassword.setFont(Font.font(14));
        lbPassword.setLayoutX(44);
        lbPassword.setLayoutY(211);
        
        txPassword.setPrefHeight(25);
        txPassword.setPrefWidth(236);
        txPassword.setLayoutX(44);
        txPassword.setLayoutY(231);
        
        btVoltar.setMnemonicParsing(false);
        btVoltar.setPrefHeight(25);
        btVoltar.setPrefWidth(59);
        btVoltar.setLayoutX(44);
        btVoltar.setLayoutY(282);
        btVoltar.setStyle("-fx-background-color: white; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        btVoltar.setCursor(Cursor.HAND);
        
        btCadastrar.setMnemonicParsing(false);
        btCadastrar.setLayoutX(213);
        btCadastrar.setLayoutY(282);
        btCadastrar.setStyle("-fx-background-color: #1da1f2; -fx-background-radius:10px;"
                + " -fx-border-radius: 10px; -fx-text-fill:white");
        btCadastrar.setCursor(Cursor.HAND);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
     
        initComponents();
        initListeners();
        
        Scene scene = new Scene(pane);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Cadastro Twitter");
        stage.show();
        
        initLayouts();
        
        Register.stage = stage;
        
    }
    
}
