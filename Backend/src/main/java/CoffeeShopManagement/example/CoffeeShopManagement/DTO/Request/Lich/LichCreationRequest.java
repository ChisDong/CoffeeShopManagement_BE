package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LichCreationRequest {
    String maNv;
    String ngayBD;
    String ngayKT;
    String thoiGianBD;
    String thoiGianKT;
    Integer soLuong;
}
