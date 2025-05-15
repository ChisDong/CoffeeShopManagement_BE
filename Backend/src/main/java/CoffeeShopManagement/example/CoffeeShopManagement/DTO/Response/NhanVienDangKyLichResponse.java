package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhanVienDangKyLichResponse {
    String maNv;
    String tenNv;
    String viTriLam;
}
