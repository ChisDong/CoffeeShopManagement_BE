package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class NhanVienResponse {
    String hoTenNv;
    String email;
    String soDienThoai;
    String viTriLam;
}
