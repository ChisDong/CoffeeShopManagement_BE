package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.ChiTietHoaDon.ChiTietHoaDon;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Normalized;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DatHangCreationRequest {
   String maNv;
   String soDienThoai;
   String tenKhachHang;
   String ghiChu;
   List<ChiTietHoaDon> giohang1;
   Map<String, Integer> gioHang;
   String hinhThucThanhToan;
}
