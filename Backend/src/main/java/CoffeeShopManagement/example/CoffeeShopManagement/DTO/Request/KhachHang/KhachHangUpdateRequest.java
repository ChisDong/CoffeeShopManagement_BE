package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class KhachHangUpdateRequest {
    @Id
    @Column(name = "MAKH")
    @JsonProperty("makh")
    private String maKh;
    @JsonProperty("tenkh")
    @Column(name = "TENKH")
    private String tenKH;
    @JsonProperty("tendangnhap")
    @Column(name = "TENDANGNHAP", unique = true)
    private String tenDangNhap;
    @JsonProperty("matkhau")
    @Column(name = "MATKHAU")
    private String matKhau;

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
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

    public String getTenKH() {
        return tenKH;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }
}
