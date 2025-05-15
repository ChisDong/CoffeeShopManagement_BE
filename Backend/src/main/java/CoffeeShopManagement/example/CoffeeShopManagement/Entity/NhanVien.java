package CoffeeShopManagement.example.CoffeeShopManagement.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "NHANVIEN")
public class NhanVien {
    @Id
    @Column(name = "MANV")
    String maNv;
    @Column(name = "HOTENNV")
    String hoTenNv;
    @Column(name = "EMAIL")
    String email;
    @Column(name = "SOCCCD")
    String soCccd;
    @Column(name = "VITRILAM")
    String viTriLam;
    @Column(name = "MATKHAU")
    String matKhau;
    @Column(name = "SODIENTHOAI")
    String soDienThoai;
    @Column(name = "ROLE")
    String role;

}
