package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhanVienResponse {
    String hoTenNv;
    String email;
    String soDienThoai;
    String viTriLam;
}
