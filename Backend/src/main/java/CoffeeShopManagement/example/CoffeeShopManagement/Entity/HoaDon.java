package CoffeeShopManagement.example.CoffeeShopManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "hoadon")
public class HoaDon {
    @Id
    @Column(name = "MAHD")
    private String maHd;
    @Column(name = "MAKH")
    private String maKh;
    @Column(name = "MANV")
    private String  maNv;
    @Column(name = "NGAYMUA")
    private Date ngayMua;
    @Column(name = "TONGTIEN")
    private Double tongTien;

    public String getMaHoaDon() {
        return maHd;
    }

    public String getMaKh() {
        return maKh;
    }

    public String getMaNv() {
        return maNv;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
}
