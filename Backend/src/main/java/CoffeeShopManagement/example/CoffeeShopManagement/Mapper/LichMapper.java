package CoffeeShopManagement.example.CoffeeShopManagement.Mapper;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich.LichCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.LichResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface LichMapper {
    Lich toLich(LichCreationRequest request);
    LichResponse toLichResponce(Lich lich);
    void updateLich(@MappingTarget LichCreationRequest request, Lich lich);
}
