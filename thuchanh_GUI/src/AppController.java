import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javafx.scene.input.MouseEvent;
import java.io.IOException;

public class AppController {
    @FXML
    private ImageView calling;
    @FXML
    private ImageView meeting;
    @FXML
    private ImageView images;
    @FXML
    private ImageView audio;
    @FXML
    private VBox messageBox;
    @FXML
    private TextField writeMessage;
    @FXML
    private ImageView send;
    @FXML
    private ImageView exit;
    private SwitchScene switchScene = new SwitchScene();

    @FXML
    public void initialize() {
        VBoxState.setMessageBox(messageBox);
        messageBox = VBoxState.getMessageBox();

        meeting.setOnMouseClicked(event -> {
            try {
                switchScene.SwitchToScene(event, "Meeting.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        updateMessageBox();

        exit.setOnMouseClicked(e -> {
            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close(); // Đóng cửa sổ khi nhấn nút thoát
        });
    }

    @FXML
    public void handleAddImage(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddImages.fxml"));

        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.initModality(Modality.WINDOW_MODAL);
        primaryStage.showAndWait(); // Sử dụng showAndWait để đảm bảo rằng cửa sổ này được đóng trước khi tiếp tục

        updateMessageBox(); // Cập nhật messageBox sau khi quay lại từ AddImages.fxml
        primaryStage.show();
    }

    @FXML
    public void sendMessage(MouseEvent event) throws  IOException {
        Label messageLabel = new Label(writeMessage.getText());
        messageLabel.setStyle("-fx-background-color: #0084ff;" +
                "    -fx-border-radius: 18 3 18 18;" +
                "    -fx-background-radius: 18 3 18 18;" +
                "    -fx-padding: 10;" +
                "    -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.6), 10, 0, 0, 0);" +
                "    -fx-text-fill: #ffffff;" +
                "    -fx-font-size: 14px;");
        messageBox.getChildren().add(messageLabel);
        writeMessage.clear();

        if (messageBox.getPrefHeight() > 500) {
            messageBox.getChildren().remove(0); // Xóa Label đầu tiên
        }
    }

    private void updateMessageBox() {
        ImageView selectedImage = ImageModel.getInstance().getSelectedImage();
        if (selectedImage != null) {
            messageBox.getChildren().add(selectedImage);
        }
    }

}
