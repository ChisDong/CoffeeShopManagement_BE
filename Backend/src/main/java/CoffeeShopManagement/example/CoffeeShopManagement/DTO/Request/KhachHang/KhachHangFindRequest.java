package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.KhachHang;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class KhachHangFindRequest {
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

    // Số điện thoại
    @JsonProperty("sdt")
    @Column(name = "SDT")
    private String sdt;

    // Getter & Setter
    // sdt
    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
    public String getSdt() {
        return sdt;
    }

    // maKh
    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }
    public String getMaKh() {
        return maKh;
    }

    // tenKH
    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }
    public String getTenKH() {
        return tenKH;
    }

    // tenDangNhap
    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }
    public String getTenDangNhap() {
        return tenDangNhap;
    }

    // matKhau
    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }  
    public String getMatKhau() {
        return matKhau;
    }
}
     