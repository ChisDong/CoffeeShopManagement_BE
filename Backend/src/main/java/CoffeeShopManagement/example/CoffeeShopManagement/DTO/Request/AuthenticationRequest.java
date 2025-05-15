package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {
   private String maNv;
   private String matKhau;

}
