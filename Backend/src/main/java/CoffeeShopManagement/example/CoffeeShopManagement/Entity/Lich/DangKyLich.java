package CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "dangky")
@IdClass(DangKyLichId.class)
public class DangKyLich {
    @Column(name = "MALLV")
    @Id
    String maLlv;
    @Column(name = "MANV")
    @Id
    String maNv;
}
