package CoffeeShopManagement.example.CoffeeShopManagement.Service;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich.LichCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.LichResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import CoffeeShopManagement.example.CoffeeShopManagement.Exception.AppExceptionHandler;
import CoffeeShopManagement.example.CoffeeShopManagement.Exception.ErrorCode;
import CoffeeShopManagement.example.CoffeeShopManagement.Mapper.LichMapper;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.LichResponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LichService {
    @Autowired
    private LichResponsitory lichResponsitory;
    @Autowired
    private LichMapper lichMapper;

    public Lich creationRequest(LichCreationRequest request){
        System.out.println(request);
        Lich lich = lichMapper.toLich(request);
        return lichResponsitory.save(lich);
    }

    public LichResponse updateRequest(String id, LichCreationRequest request) {
        Lich lich = lichResponsitory.findById(id).orElseThrow(() -> new AppExceptionHandler(ErrorCode.CALENDAR_NOT_EXISTED));
        lichMapper.updateLich(request, lich);
        return lichMapper.toLichResponce(lichResponsitory.save(lich));
    }

}
