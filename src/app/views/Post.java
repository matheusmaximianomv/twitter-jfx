package app.views;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Matheus Max
 */
public class Post extends Application{
    
    private AnchorPane pane;
    private Label lbTitulo;
    private TextArea taMessage;
    private Button btCancelar, btPostar;
    private static Stage stage;
    
    private void initComponents() {
        
        pane = new AnchorPane();
        pane.setPrefSize(429, 295);
        
        lbTitulo = new Label("Digite seu Post:");
        
        taMessage = new TextArea();
        taMessage.setPromptText("No que você esta pensando...");
        taMessage.setPrefSize(369, 117);
        taMessage.setPickOnBounds(true);
        
        btCancelar = new Button("Cancelar");
        btPostar = new Button("Postar");
        
        pane.getChildren().addAll(lbTitulo, taMessage, btCancelar, btPostar);
        
    }
    
    private void initListeners() {
        
        /* Botão de Postar */
        btPostar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //Postar
            }
        });
        
        // Mudando a estilização quando o mouse passa por cima do botão
        btPostar.setOnMouseEntered( e -> {
            btPostar.setStyle("-fx-background-color: #006dbf; -fx-background-radius:10px;"
                + " -fx-border-radius: 10px; -fx-text-fill:white");
        });
        
        // Mudando a estilização quando o mouse sai de cima do botão
        btPostar.setOnMouseExited(e -> {
            btPostar.setStyle("-fx-background-color: #1da1f2; -fx-background-radius:10px;"
                + " -fx-border-radius: 10px; -fx-text-fill:white");
        });
        
        /* Botão de Voltar */
        btCancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Timeline timeline = new Timeline();
                try{
                    timeline.start(new Stage());
                    Post.stage.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        // Mudando a estilização quando o mouse passa por cima do botão
        btCancelar.setOnMouseEntered( e -> {
            btCancelar.setStyle("-fx-background-color: #eaf5fd; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        });
        
        // Mudando a estilização quando o mouse sai de cima do botão
        btCancelar.setOnMouseExited(e -> {
            btCancelar.setStyle("-fx-background-color: white; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        });
        
    }
    
    private void initLayout() {
        
        pane.setStyle("-fx-background-color: white;");
        
        lbTitulo.setFont(Font.font(21));
        lbTitulo.setLayoutX(35);
        lbTitulo.setLayoutY(34);
        
        taMessage.setLayoutX(35);
        taMessage.setLayoutY(89);
        
        btCancelar.setLayoutX(87);
        btCancelar.setLayoutY(233);
        btCancelar.setMnemonicParsing(false);
        btCancelar.setStyle("-fx-background-color: white; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        btCancelar.setCursor(Cursor.HAND);
        
        btPostar.setLayoutX(296);
        btPostar.setLayoutY(233);
        btPostar.setMnemonicParsing(false);
        btPostar.setStyle("-fx-background-color: #1da1f2; -fx-background-radius:10px;"
                + " -fx-border-radius: 10px; -fx-text-fill:white");
        btPostar.setCursor(Cursor.HAND);
        
                
    }
    
    @Override
    public void start(Stage stage) {
        
        initComponents();
        initListeners();
        
        Scene scene = new Scene(pane);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Twitter - Postagem");
        stage.show();
        
        initLayout();
        
        Post.stage = stage;
        
    }
    
}
