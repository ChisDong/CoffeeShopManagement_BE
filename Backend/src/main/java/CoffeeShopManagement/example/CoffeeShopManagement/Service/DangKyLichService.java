package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich.DangKyLichRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.DangKyLichReponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLich;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLichId;
import CoffeeShopManagement.example.CoffeeShopManagement.Exception.AppExceptionHandler;
import CoffeeShopManagement.example.CoffeeShopManagement.Exception.ErrorCode;
import CoffeeShopManagement.example.CoffeeShopManagement.Mapper.DangKyLichMapper;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.DangKyLichRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DangKyLichService {
    @Autowired
    private DangKyLichRespository dangKyLichRespository;
    @Autowired
    private DangKyLichMapper dangKyLichMapper;
    // nhớ thêm exception nếu như có gì đó
    public DangKyLich createRequest(DangKyLichRequest request){
        DangKyLich dangKyLich = dangKyLichMapper.toDangKyLich(request);
        return dangKyLichRespository.save(dangKyLich);
    }

    public List<DangKyLichReponse> getAllDangKyLich(String maNv){
        List<DangKyLichReponse> dangKyLich = dangKyLichRespository.findAllByMaNv(maNv).stream().map(dangKyLichMapper::toDangKyLichReponse).collect(Collectors.toList());
        if(dangKyLich != null){
            return dangKyLich;
        }else{
            throw new AppExceptionHandler(ErrorCode.LIST_NOT_EXISTED);
        }
    }

    public void deleteRequest(DangKyLichRequest request){
        DangKyLichId id = dangKyLichMapper.toDangKyLichId(request);
        DangKyLich dangKyLich = dangKyLichRespository.findById(id).orElseThrow(()-> new AppExceptionHandler(ErrorCode.REGISTRATION_NOT_EXISTED));
        dangKyLichRespository.delete(dangKyLich);
    }
}
