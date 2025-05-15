package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DatHangCreationRequest {
   String maNv;
   String soDienThoai;
   String tenKhachHang;
   Map<String, Integer> gioHang;
   String hinhThucThanhToan;
}
