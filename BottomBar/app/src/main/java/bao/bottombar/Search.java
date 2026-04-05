package bao.bottombar;

public class Search {
    String imageName ,name;

    public Search(String imageName, String name) {
        this.imageName = imageName;
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public String getName() {
        return name;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setName(String name) {
        this.name = name;
    }
}
