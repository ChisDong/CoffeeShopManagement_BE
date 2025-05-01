package CoffeeShopManagement.example.CoffeeShopManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "NHANVIEN")
public class NhanVien {
    @Id
    @Column(name = "MANV")
    private String maNv;
    @Column(name = "HOTENNV")
    private String hoTenNv;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "SOCCCD")
    private String soCccd;
    @Column(name = "VITRILAM")
    private String viTriLam;
    @Column(name = "MATKHAU")
    private String matKhau;

    //Getter & Setter


    public String getEmail() {
        return email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public String getMaNv() {
        return maNv;
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
