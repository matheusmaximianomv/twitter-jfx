package app.views;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */
public class Timeline extends Application {
    
    private final String PATH_LOGO_TWITTER = "digite_o_caminho\\src\\assets\\img\\twitter-logo.png";
    
    private AnchorPane anchorPane;
    private ImageView logo;
    private Button btPostar, btSair;
    private Separator sptrBase;
    private ScrollPane scrollPane;
    private Pane paneMain;
    private Scene scene;
    private static Stage stage;
    
    private void initComponents() throws Exception{
        
        anchorPane = new AnchorPane();
        anchorPane.setPrefSize(600, 411);
        anchorPane.setStyle("-fx-background-color: white;");
        
        Image image = new Image(new FileInputStream(PATH_LOGO_TWITTER));
        logo = new ImageView(image);
        logo.setFitHeight(70);
        logo.setFitWidth(236);
        logo.setPickOnBounds(true);
        logo.setPreserveRatio(true);
        
        btPostar = new Button("Enviar um Post");
        btPostar.setMnemonicParsing(false);
        
        sptrBase = new Separator();
        sptrBase.setPrefSize(510, 0);
        
        paneMain = new Pane();
        paneMain.setPrefWidth(494);
        initPaneMain();
        
        scrollPane = new ScrollPane();
        scrollPane.setPrefSize(510, 252);        
        scrollPane.setContent(paneMain);
        
        btSair = new Button("Sair");
        btSair.setMnemonicParsing(false);
        btSair.setMinSize(btPostar.getWidth(), btPostar.getHeight());
        
        anchorPane.getChildren().addAll(logo, btPostar, sptrBase, scrollPane, btSair);
        
    }

    private void initListeners() {
        
        /* Botão de Postar */
        btPostar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Post post = new Post();
                try {
                    post.start(new Stage());
                    Timeline.stage.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
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
        
        /* Botão de Sair */
        btSair.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Login login = new Login();
                try{
                    login.start(new Stage());
                    Timeline.stage.close();
                } catch(Exception e) {
                    e.printStackTrace();
                }
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
    
    private void initLayout() {
        
        logo.setLayoutX(44);
        logo.setLayoutY(20);
        
        btPostar.setLayoutX(463);
        btPostar.setLayoutY(37);
        btPostar.setStyle("-fx-background-color: #1da1f2; -fx-background-radius:10px;"
                + " -fx-border-radius: 10px; -fx-text-fill:white");
        btPostar.setCursor(Cursor.HAND);
        
        sptrBase.setLayoutX(44);
        sptrBase.setLayoutY(97);
        
        scrollPane.setLayoutX(44);
        scrollPane.setLayoutY(105);
        
        btSair.setLayoutX(scrollPane.getLayoutX() + ((scrollPane.getWidth() - btSair.getWidth()) / 2));
        btSair.setLayoutY(370);
        btSair.setStyle("-fx-background-color: white; -fx-background-radius:10px;"
                + "-fx-border-radius: 10px; -fx-border-color:#1da1f2; -fx-text-fill:#1da1f2");
        btSair.setCursor(Cursor.HAND);
    }
    
    private void initPaneMain() {
        
        double initLayoutY = 14.0;
        List<Pane> listPanes = new ArrayList<Pane>();
        
        for(int i = 0; i < 10; i++) {
            
            Pane panePost = new Pane();
            panePost.setPrefSize(462, 90);
            panePost.setLayoutX(16);
            panePost.setLayoutY(initLayoutY);
            
            Label username = new Label("username");
            username.setLayoutX(21);
            username.setLayoutY(1);
            
            Text postContent = new Text("");
            postContent.setLayoutX(21);
            postContent.setLayoutY(40);
            postContent.setWrappingWidth(400);
            postContent.setTextAlignment(TextAlignment.JUSTIFY);
            
            String text = "The quick brown fox jumps over the lazy dog: "+i;
            postContent.setText(text);
        
            Button like = new Button("Like");
            like.setLayoutX(21);
            like.setLayoutY(51);
            like.setMnemonicParsing(false);
            
            Text postLike = new Text("5");
            postLike.setLayoutX(75);
            postLike.setLayoutY(68);
            
            Separator sprtPost = new Separator();
            sprtPost.setLayoutX(-15);
            sprtPost.setLayoutY(84);
            sprtPost.setPrefSize(495, 3);
            
            initLayoutY += 95.0;
            
            panePost.getChildren().addAll(username, postContent, like, postLike, sprtPost);
            listPanes.add(panePost);
        }
        
        paneMain.getChildren().addAll(listPanes);
    }
    
    @Override
    public void start(Stage stage) throws Exception{
        
        initComponents();
        initListeners();
        
        scene = new Scene(anchorPane);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Twitter - Home");
        stage.show();
        
        initLayout();        
        
        Timeline.stage = stage;
    }
    
}
