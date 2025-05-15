package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NhanVienCreationRequest {
    String hoTenNv;
    String email;
    String soCccd;
    String viTriLam;
    String matKhau;
    String soDienThoai;
    String role;
}
