package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class KhachHangUpdateRequest {
    // Mã khách hàng
    @Id
    @Column(name = "MAKH")
    @JsonProperty("makh")
    private String maKh;

    // Tên khách hàng
    @JsonProperty("tenkh")
    @Column(name = "TENKH")
    private String tenKH;

    // Tên đăng nhập
    @JsonProperty("tendangnhap")
    @Column(name = "TENDANGNHAP", unique = true)
    private String tenDangNhap;

    // Mật khẩu
    @JsonProperty("matkhau")
    @Column(name = "MATKHAU")
    private String matKhau;

    // Getter & Setter
    // Mã khách hàng
    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }
    public String getMaKh() {
        return maKh;
    }

    // Tên khách hàng
    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
    public String getTenKH() {
        return tenKH;
    }

    // Tên đăng nhập
    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    // Mật khẩu
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    public String getMatKhau() {
        return matKhau;
    }
}
