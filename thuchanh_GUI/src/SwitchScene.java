import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

public class SwitchScene {
    private Scene scene;
    private Stage stage;
    private Parent root;
    public static final String CURRENT = Paths.get("").toAbsolutePath() + "/";
    public static final String PATH = "src/";

    public void SwitchToScene(MouseEvent event, String path) throws IOException {
        URL url = new File(PATH + path).toURI().toURL();
        root = FXMLLoader.load(url);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
