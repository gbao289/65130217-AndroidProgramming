package thigk2.volegiabao.thigk;

public class TouristAttraction {
    private String name;
    private String address;
    private int imageResId;

    public TouristAttraction(String name, String address, int imageResId) {
        this.name = name;
        this.address = address;
        this.imageResId = imageResId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getImageResId() {
        return imageResId;
    }
}