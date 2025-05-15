package CoffeeShopManagement.example.CoffeeShopManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.ChiTietHoaDon.ChiTietHoaDon;

@Entity
@Table(name = "hoadon")
@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HoaDon {
    @Id
    @Column(name = "MAHD")
    String maHd;
    @Column(name = "MAKH")
    String maKh;
    @Column(name = "MANV")
    String  maNv;
    @Column(name = "NGAYMUA")
    Date ngayMua;
    @Column(name = "TONGTIEN")
    Double tongTien;
}
