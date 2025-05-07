package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class KhachHangCreationRequest {
    @Id
    @Column(name = "MAKH")
    @JsonProperty("makh")
    private String maKh;
    @JsonProperty("tenkh")
    @Column(name = "TENKH")
    private String tenKh;
    @JsonProperty("tendangnhap")
    @Column(name = "TENDANGNHAP", unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9_.]+$", message = "Tên tài khoản không được chứa khoảng trắng, dấu hoặc ký tự đặc biệt")
    @Size(min = 8, message = "Tên đăng nhập phải có ít nhât 8 kí tự")
    private String tenDangNhap;
    @JsonProperty("matkhau")
    @Size(min = 8, message = "Mật khẩu phải có ít nhất 8 kí tự")
    @Column(name = "MATKHAU")
    private String matKhau;

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
}
