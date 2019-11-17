package sample;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

class ConfirmBox {

    //Create variable
    private static int answer;

    static int display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setWidth(300);
        window.setHeight(100);
        window.setResizable(false);
        Label label = new Label();
        label.setText(message);

        //Create two buttons
        Button saveButton = new Button("Save");
        Button noSaveButton = new Button("Don`t save");
        Button cancelButton = new Button("Cancel");

        //Clicking will set answer and close window
        saveButton.setOnAction(e -> {
            answer = 1;
            window.close();
        });
        noSaveButton.setOnAction(e -> {
            answer = 0;
            window.close();
        });
        cancelButton.setOnAction(e -> {
            answer = -1;
            window.close();
        });

        VBox vBox = new VBox(10);
        HBox hBox = new HBox(10);

        //Add buttons
        hBox.getChildren().addAll(cancelButton, noSaveButton, saveButton);
        hBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(label, hBox);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();

        //Make sure to return answer
        return answer;
    }

}