package CoffeeShopManagement.example.CoffeeShopManagement.Entity;import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "KHACHHANG")
public class KhachHang {
    @Id
    @Column(name = "MAKH")
    private String maKh;

    @Column(name = "TENKH")
    private String tenKh;

    @Column(name = "SODIENTHOAI")
    private String sdt;

    @OneToMany(mappedBy = "khachHang")
    @JsonIgnore
    private List<HoaDon> hoaDons;

    // Getter & Setter

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMaKh() {
        return maKh;
    }

    public String getTenKh() {
        return tenKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public List<HoaDon> getHoaDons() {
        return hoaDons;
    }

    public void setHoaDons(List<HoaDon> hoaDons) {
        this.hoaDons = hoaDons;
    }
}
