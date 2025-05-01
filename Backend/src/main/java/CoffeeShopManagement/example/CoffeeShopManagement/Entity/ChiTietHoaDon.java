package CoffeeShopManagement.example.CoffeeShopManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "chitiethoadon")
public class ChiTietHoaDon {
    @Id
    @Column(name = "MAHD")
    private String maHd;
    @Column(name = "MADOUONG")
    private String maDoUong;
    @Column(name = "SOLUONG")
    private Integer soLuong;
    @Column(name = "DONGIA")
    private Double donGia;
    @Column(name = "THANHTIEN")
    private Double thanhTien;
    public String getMaHd() {
        return maHd;
    }

    public String getMaDoUong() {
        return maDoUong;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public Double getThanhTien() {
        return thanhTien;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public void setMaDoUong(String maDoUong) {
        this.maDoUong = maDoUong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public void setThanhTien(Double thanhTien) {
        this.thanhTien = thanhTien;
    }
}
