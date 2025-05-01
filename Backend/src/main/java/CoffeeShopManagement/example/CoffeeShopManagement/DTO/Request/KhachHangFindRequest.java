package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class KhachHangFindRequest {

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
    @JsonProperty("sdt")
    @Column(name = "SDT")
    private String std;

    public void setStd(String std) {
        this.std = std;
    }

    public String getTenKH() {
        return tenKH;
    }

    public String getStd() {
        return std;
    }

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

    public String getTenKh() {
        return tenKH;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }
}
