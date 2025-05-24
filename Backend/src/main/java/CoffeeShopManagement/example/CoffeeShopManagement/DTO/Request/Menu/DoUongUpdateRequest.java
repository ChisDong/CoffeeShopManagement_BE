package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Menu;

public class DoUongUpdateRequest {
    private String maDoUong;
    private String tenDoUong;
    private String loaiDoUong;
    private Double giaDoUong;
    private Boolean trangThai;

    public String getMaDoUong() {
        return maDoUong;
    }

    public void setMaDoUong(String maDoUong) {
        this.maDoUong = maDoUong;
    }

    public String getTenDoUong() {
        return tenDoUong;
    }

    public void setTenDoUong(String tenDoUong) {
        this.tenDoUong = tenDoUong;
    }

    public String getLoaiDoUong() {
        return loaiDoUong;
    }

    public void setLoaiDoUong(String loaiDoUong) {
        this.loaiDoUong = loaiDoUong;
    }

    public Double getGiaDoUong() {
        return giaDoUong;
    }

    public void setGiaDoUong(Double giaDoUong) {
        this.giaDoUong = giaDoUong;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
}
