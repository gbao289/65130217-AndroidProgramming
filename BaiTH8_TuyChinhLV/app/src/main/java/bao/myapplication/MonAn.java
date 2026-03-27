package bao.myapplication;

public class MonAn {
    private String tenMonAn;
    private double donGia;
    private String moTa;
    private int idAnhMonAn;

    public MonAn(String tenMonAn, double donGia, String moTa, int idAnhMonAn) {
        this.tenMonAn = tenMonAn;
        this.donGia = donGia;
        this.moTa = moTa;
        this.idAnhMonAn = idAnhMonAn;
    }
    // Getter, Setter

    public void setTenMonAn(String tenMonAn) {
        this.tenMonAn = tenMonAn;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public void setIdAnhMonAn(int idAnhMonAn) {
        this.idAnhMonAn = idAnhMonAn;
    }

    public String getTenMonAn() {
        return tenMonAn;
    }

    public double getDonGia() {
        return donGia;
    }

    public String getMoTa() {
        return moTa;
    }

    public int getIdAnhMonAn() {
        return idAnhMonAn;
    }
}
