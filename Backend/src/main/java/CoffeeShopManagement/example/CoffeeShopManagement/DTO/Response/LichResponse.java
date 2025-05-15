package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LichResponse {
    String ngayBD;
    String ngayKT;
    String thoiGianBD;
    String thoiGianKT;
    Integer soLuong;
}