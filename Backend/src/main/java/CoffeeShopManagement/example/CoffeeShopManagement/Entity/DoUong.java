package CoffeeShopManagement.example.CoffeeShopManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "douong")
public class DoUong {
    @Id
    @Column(name = "MADOUONG")
    private String maDoUong;
    @Column(name = "TENDOUONG")
    private String tenDoUong;
    @Column(name = "LOAIDOUONG")
    private String loaiDoUong;
    @Column(name = "GIADOUONG")
    private Double giaDoUong;
    @Column(name = "TRANGTHAI")
    private Boolean trangThai;

    public String getMaDoUong() {
        return maDoUong;
    }

    public String getTenDoUong() {
        return tenDoUong;
    }

    public String getLoaiDoUong() {
        return loaiDoUong;
    }

    public Double getGiaDoUong() {
        return giaDoUong;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setMaDoUong(String maDoUong) {
        this.maDoUong = maDoUong;
    }

    public void setTenDoUong(String tenDoUong) {
        this.tenDoUong = tenDoUong;
    }

    public void setLoaiDoUong(String loaiDoUong) {
        this.loaiDoUong = loaiDoUong;
    }

    public void setGiaDoUong(Double giaDoUong) {
        this.giaDoUong = giaDoUong;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }
}
