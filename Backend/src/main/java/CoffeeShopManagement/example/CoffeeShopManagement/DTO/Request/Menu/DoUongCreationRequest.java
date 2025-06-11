package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Menu;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoUongCreationRequest {
     String maDoUong;
     String tenDoUong;
     String loaiDoUong;
     String hinhAnh; // sửa thêm
     Double giaDoUong;
     Boolean trangThai;

}
