package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DangKyLichRequest {
    private String maLlv;
    private String maNv;
}
