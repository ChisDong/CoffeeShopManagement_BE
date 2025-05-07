package CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table (name = "lichlamviec")
public class Lich {
    @Id
    @Column(name = "MALLV")
    private String maLlm;
    @Column(name = "MANV")
    private String maNv;
    @Column(name = "NGAYBATDAU")
    private Date ngayBD;
    @Column(name = "NGAYKETTHUC")
    private Date ngayKT;
    @Column(name = "THOIGIANBATDAU")
    private String thoiGianBD;
    @Column(name = "THOIGIANKETTHUC")
    private String thoiGianKT;

    public String getMaLlm() {
        return maLlm;
    }

    public String getMaNv() {
        return maNv;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public String getThoiGianBD() {
        return thoiGianBD;
    }

    public String getThoiGianKT() {
        return thoiGianKT;
    }

    public void setMaLlm(String maLlm) {
        this.maLlm = maLlm;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public void setThoiGianBD(String thoiGianBD) {
        this.thoiGianBD = thoiGianBD;
    }

    public void setThoiGianKT(String thoiGianKT) {
        this.thoiGianKT = thoiGianKT;
    }
}
