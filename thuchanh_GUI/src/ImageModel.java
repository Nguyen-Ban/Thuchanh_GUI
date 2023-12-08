import javafx.scene.image.ImageView;

public class ImageModel {
    private static final ImageModel instance = new ImageModel();

    private ImageView selectedImage;

    private ImageModel() {}

    public static ImageModel getInstance() {
        return instance;
    }

    public ImageView getSelectedImage() {
        return selectedImage;
    }

    public void setSelectedImage(ImageView selectedImage) {
        this.selectedImage = selectedImage;
    }
}
