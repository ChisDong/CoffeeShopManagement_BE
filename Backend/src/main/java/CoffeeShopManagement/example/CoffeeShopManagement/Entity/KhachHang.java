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
    @Column(name = "TENDANGNHAP", unique = true)
    private String tenDangNhap;
    @Column(name = "MATKHAU")
    private String matKhau ;
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

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
