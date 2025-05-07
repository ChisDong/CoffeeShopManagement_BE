package CoffeeShopManagement.example.CoffeeShopManagement.Entity.ChiTietHoaDon;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;
public class ChiTietHoaDonId implements Serializable {

    private String maHd;
    private String maDoUong;

    public ChiTietHoaDonId() {}

    public ChiTietHoaDonId(String maHd, String maDoUong) {
        this.maHd = maHd;
        this.maDoUong = maDoUong;
    }

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
