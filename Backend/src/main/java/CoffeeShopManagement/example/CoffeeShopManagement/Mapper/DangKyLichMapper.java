package CoffeeShopManagement.example.CoffeeShopManagement.Mapper;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich.DangKyLichRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.DangKyLichReponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLich;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLichId;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface DangKyLichMapper {
    DangKyLichId toDangKyLichId(DangKyLichRequest request);
    DangKyLich toDangKyLich(DangKyLichRequest request);
    DangKyLichReponse toDangKyLichReponse(DangKyLich lich);
}
