package tranminhduc.project.com.demo.uploadfile.Model;

public class ImageModel {
    private Long imageId;
    private String imageName;
    private String imageDescription;


    public ImageModel() {
    }

    public Long getImageId() {
        return imageId;
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }

    public ImageModel(Long imageId, String imageName, String imageDescription) {
        this.imageId = imageId;
        this.imageName = imageName;
        this.imageDescription = imageDescription;
    }
}
