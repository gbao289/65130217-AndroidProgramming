package bao.baith9_recyclerview;

public class LandScape {
    private String landscapeName;
    private String landscapeImage;

    public LandScape(String landscapeName, String landscapeImage) {
        this.landscapeName = landscapeName;
        this.landscapeImage = landscapeImage;
    }

    public String getLandscapeName() {
        return landscapeName;
    }

    public String getLandscapeImage() {
        return landscapeImage;
    }

    public void setLandscapeName(String landscapeName) {
        this.landscapeName = landscapeName;
    }

    public void setLandscapeImage(String landscapeImage) {
        this.landscapeImage = landscapeImage;
    }
}
