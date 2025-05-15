package CoffeeShopManagement.example.CoffeeShopManagement.Entity.ChiTietHoaDon;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Objects;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChiTietHoaDonId implements Serializable {

    String maHd;
    String maDoUong;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ChiTietHoaDonId)) return false;
        ChiTietHoaDonId that = (ChiTietHoaDonId) o;
        return Objects.equals(maHd, that.maHd) &&
                Objects.equals(maDoUong, that.maDoUong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maHd, maDoUong);
    }
}
