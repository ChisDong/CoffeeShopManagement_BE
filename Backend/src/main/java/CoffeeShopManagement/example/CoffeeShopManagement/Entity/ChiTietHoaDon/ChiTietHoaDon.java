package CoffeeShopManagement.example.CoffeeShopManagement.Entity.ChiTietHoaDon;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.HoaDon;
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
@Table(name = "chitiethoadon")
@IdClass(ChiTietHoaDonId.class)
public class ChiTietHoaDon {
    @Id
    @Column(name = "MAHD")
    String maHd;
    @Id
    @Column(name = "MADOUONG")
    String maDoUong;
    @Column(name = "SOLUONG")
    Integer soLuong;
    @Column(name = "DONGIA")
    Double donGia;
    @Column(name = "THANHTIEN")
    Double thanhTien;
}
