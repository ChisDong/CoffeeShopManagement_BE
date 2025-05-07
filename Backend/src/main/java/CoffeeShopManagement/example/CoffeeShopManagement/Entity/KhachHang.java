package CoffeeShopManagement.example.CoffeeShopManagement.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
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


}
