import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class MeetingController {
    @FXML
    private ImageView endMeet;
    private SwitchScene switchScene = new SwitchScene();

    public void initialize() {
        endMeet.setOnMouseClicked(event -> {
            try {
                switchScene.SwitchToScene(event, "MainFace.fxml");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
