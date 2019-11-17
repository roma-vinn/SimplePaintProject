package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private final static int SCENE_WIDTH = 1100;
    private final static int SCENE_HEIGHT = 640;
    static Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        window = primaryStage;
        window.setTitle("Simple Paint");
        window.setScene(new Scene(root, SCENE_WIDTH, SCENE_HEIGHT));
        window.setResizable(false);
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
