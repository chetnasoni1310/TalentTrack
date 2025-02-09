package org.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ResumeUploader extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Resume Uploader");

        Label fileLabel = new Label("No file selected");
        Button uploadButton = new Button("Upload Resume");

        uploadButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Upload Resume");
            fileChooser.getExtensionFilters().add(
                    new FileChooser.ExtensionFilter("Resumes", "*.pdf", "*.doc", "*.docx")
            );

            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                fileLabel.setText("Uploaded: " + selectedFile.getName());
                System.out.println("Resume uploaded: " + selectedFile.getAbsolutePath());
            } else {
                fileLabel.setText("No file selected.");
            }
        });

        VBox layout = new VBox(10, uploadButton, fileLabel);
        layout.setStyle("-fx-padding: 20px; -fx-alignment: center;");

        primaryStage.setScene(new Scene(layout, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
