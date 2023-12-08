import javafx.scene.layout.VBox;

public class VBoxState {
    private static VBox messageBox;

    public static VBox getMessageBox() {
        return messageBox;
    }

    public static void setMessageBox(VBox messageBox) {
        VBoxState.messageBox = messageBox;
    }
}