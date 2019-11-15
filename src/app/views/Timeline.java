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

import app.controllers.PostController;

import app.models.Post;

import app.controllers.UserController;

/**
 * @author Matheus Maximiano de Melo Vieira
 * @version 1.0.0
 * @since 2019
 */
public class Timeline extends Application {
    
    private final String PATH_LOGO_TWITTER = "digite_o_caminho\\src\\assets\\img\\twitter-logo.png";
    
    private AnchorPane anchorPane;
    private ImageView logo;
    private Label lbUsername;
    private Button btPostar, btSair, btLike;
    private Text txContent, txLike;
    private Separator sptrBase, sprtPost;
    private ScrollPane scrollPane;
    private Pane paneMain, panePost;
    private Scene scene;
    private static Stage stage;
    private PostController postController = new PostController();
    private List<Post> listPosts = new ArrayList<Post>();
    
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
                NewPost newPost = new NewPost();
                try {
                    newPost.start(new Stage());
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
    
    /* Iniciadores do PaneMain */
    private void initPaneMain() {
        
        double initLayoutY = 14.0;
        List<Pane> listPanes = new ArrayList<Pane>();
        
        listPosts = postController.listarPostagens();
        
        for(Post p : listPosts) {
            
            initComponentsPaneMain(p);
            initListenersPaneMain(p);
            initLayoutPaneMain(initLayoutY);
            
            initLayoutY += 95.0;
            
            listPanes.add(panePost);
            
        }
        
        paneMain.getChildren().addAll(listPanes);
    }
    
    private void initComponentsPaneMain(Post p) {
        
        panePost = new Pane();
        panePost.setPrefSize(462, 90);
        
        String usernameTwitter = "@"+p.getUser().getNome();
        lbUsername = new Label(usernameTwitter);
        
        txContent = new Text();
        txContent.setWrappingWidth(400);
        txContent.setTextAlignment(TextAlignment.JUSTIFY);
        txContent.setText(p.getContent());
        
        btLike = new Button("Like");
        btLike.setMnemonicParsing(false);
        
        String stringLikes = ""+p.getLikes()+"";
        txLike = new Text(stringLikes);
        
        sprtPost = new Separator();
        sprtPost.setPrefSize(495, 3);
        
        panePost.getChildren().addAll(lbUsername, txContent, btLike, txLike, sprtPost);
       
    }
    
    private void initListenersPaneMain(Post p) {
        
        btLike.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                
                p.setLike();
                postController.likePost(p);
                
                String stringLikes = ""+p.getLikes()+"";
                txLike.setText(stringLikes);
                
                listPosts.clear();
                paneMain.getChildren().clear();
                
                initPaneMain();
            }
        });
        
    }
    
    private void initLayoutPaneMain(double initLayoutY) {
        
        panePost.setLayoutX(16);
        panePost.setLayoutY(initLayoutY);
        
        lbUsername.setLayoutX(21);
        lbUsername.setLayoutY(1);
        
        txContent.setLayoutX(21);
        txContent.setLayoutY(40);
        
        btLike.setLayoutX(21);
        btLike.setLayoutY(51);
        
        txLike.setLayoutX(75);
        txLike.setLayoutY(68);
        
        sprtPost.setLayoutX(-15);
        sprtPost.setLayoutY(84);
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
