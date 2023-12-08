import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;


public class AddImagesController {
    @FXML
    private Button exit;
    @FXML
    private Button addImage;
    @FXML
    private Button open;
    @FXML
    private ImageView imageView;
    @FXML
    private AnchorPane anchorPane;

    public void chooseImage(ActionEvent event) {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Choose a image");
        FileChooser.ExtensionFilter imageFilter = new  FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png");
        fc.getExtensionFilters().add(imageFilter);
        File file = fc.showOpenDialog(stage);
        if (file != null) {
            Image image = new Image(file.toURI().toString(), 200, 150, false, true);
            imageView.setImage(image);
        }
    }

    @FXML
    public void initialize() {
        exit.setOnAction(event -> {
            Stage stage = (Stage) exit.getScene().getWindow();
            stage.close();
        });
        addImage.setOnAction(event -> {
            if (imageView.getImage() != null) {
                ImageModel.getInstance().setSelectedImage(imageView);
                Stage stage = (Stage) addImage.getScene().getWindow();
                stage.close();
            }
        });
    }

}
