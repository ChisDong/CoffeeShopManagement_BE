package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class NhanVienCreationRequest {
    @Id
    @Column(name = "MANV")
    @JsonProperty("makh")
    private String maNv;
    @Column(name = "HOTENNV")
    @JsonProperty("hotennv")
    private String hoTenNv;
    @Column(name = "EMAIL")
    @JsonProperty("email")
    private String email;
    @Column(name = "SOCCCD")
    @JsonProperty("socccd")
    private String soCccd;
    @Column(name = "VITRILAM")
    @JsonProperty("vitrilam")
    private String viTriLam;
    @Column(name = "MATKHAU")
    @JsonProperty("matkhau")
    private String matKhau;

    public String getMatKhau() {
        return matKhau;
    }

    public String getMaNv() {
        return maNv;
    }

    public String getEmail() {
        return email;
    }

    public String getHoTenNv() {
        return hoTenNv;
    }

    public String getSoCccd() {
        return soCccd;
    }

    public String getViTriLam() {
        return viTriLam;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public void setHoTenNv(String hoTenNv) {
        this.hoTenNv = hoTenNv;
    }

    public void setSoCccd(String soCccd) {
        this.soCccd = soCccd;
    }

    public void setViTriLam(String viTriLam) {
        this.viTriLam = viTriLam;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
