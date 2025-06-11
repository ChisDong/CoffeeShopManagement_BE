package CoffeeShopManagement.example.CoffeeShopManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "douong")
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoUong {
    @Id
    @Column(name = "MADOUONG")
     String maDoUong;
    @Column(name = "TENDOUONG")
     String tenDoUong;
    @Column(name = "LOAIDOUONG")
     String loaiDoUong;
    @Column(name = "GIADOUONG")
     Double giaDoUong;
    @Column(name = "TRANGTHAI")
    Boolean trangThai;
    @Column(name = "HINHANH")
    String hinhAnh;
}
