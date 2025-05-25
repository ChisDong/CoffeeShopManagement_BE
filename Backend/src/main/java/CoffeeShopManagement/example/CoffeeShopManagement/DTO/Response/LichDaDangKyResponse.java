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
public class LichDaDangKyResponse {
    String ngayBD;
    String ngayKT;
    String thoiGianBD;
    String thoiGianKT;
}
