package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DangKyLichReponse {
    String maLlv;
    String ngayBD;
    String ngayKT;
    String thoiGianBD;
    String thoiGianKT;
}