package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class KhachHangCreationRequest {
    // Mã khách hàng
    @Id
    @Column(name = "MAKH")
    @JsonProperty("makh")
    private String maKh;
    @JsonProperty("tenkh")

    // Tên khách hàng
    @Column(name = "TENKH")
    private String tenKh;

    // Tên đăng nhập
    @JsonProperty("tendangnhap")
    @Column(name = "TENDANGNHAP", unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9_.]+$", message = "Tên tài khoản không được chứa khoảng trắng, dấu hoặc ký tự đặc biệt")
    @Size(min = 8, message = "Tên đăng nhập phải có ít nhât 8 kí tự")
    private String tenDangNhap;

    // Mật khẩu
    @JsonProperty("matkhau")
    @Size(min = 8, message = "Mật khẩu phải có ít nhất 8 kí tự")
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
    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
    }
    public String getTenKh() {
        return tenKh;
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
