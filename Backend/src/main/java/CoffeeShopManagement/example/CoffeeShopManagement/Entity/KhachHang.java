package CoffeeShopManagement.example.CoffeeShopManagement.Entity;import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "KHACHHANG")
public class KhachHang {
    @Id
    @Column(name = "MAKH")
    String maKh;

    @Column(name = "TENKH")
    String tenKh;

    @Column(name = "SODIENTHOAI")
    String sdt;

    @OneToMany(mappedBy = "maKh")
    @JsonIgnore
    List<HoaDon> hoaDons;

}
