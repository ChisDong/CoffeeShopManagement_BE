package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich.DangKyLichRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.DangKyLichReponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLich;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLichId;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import CoffeeShopManagement.example.CoffeeShopManagement.Exception.AppExceptionHandler;
import CoffeeShopManagement.example.CoffeeShopManagement.Exception.ErrorCode;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.DangKyLichRespository;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.LichResponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DangKyLichService {
    @Autowired
    private DangKyLichRespository dangKyLichRespository;
    @Autowired
    private LichResponsitory lichResponsitory;
    // nhớ thêm exception nếu như có gì đó
    public DangKyLich createRequest(DangKyLichRequest request){
        DangKyLich dangKyLich = new DangKyLich();
        Lich lich = lichResponsitory.findById(request.getMaLlv()).orElseThrow(()-> new AppExceptionHandler(ErrorCode.REGISTRATION_NOT_EXISTED));
        if(lich.getSoLuong() == 0){
            dangKyLich.setMaNv(request.getMaNv());
            dangKyLich.setMaNv(request.getMaLlv());
            return dangKyLichRespository.save(dangKyLich);
        }else{
            throw new AppExceptionHandler(ErrorCode.REGISTRATION_IS_FUll);
        }

    }

    public List<DangKyLichReponse> getAllDangKyLich(String maNv){
        List<DangKyLichReponse> dangKyLich = new ArrayList<>();
        for(DangKyLich lich : dangKyLichRespository.findAllByMaNv(maNv)){
            DangKyLichReponse dangKyLichReponse = new DangKyLichReponse();
            dangKyLichReponse.setMaLlv(lich.getMaLlv());
            dangKyLich.add(dangKyLichReponse);
        }
        if(dangKyLich != null){
            return dangKyLich;
        }else{
            throw new AppExceptionHandler(ErrorCode.LIST_NOT_EXISTED);
        }
    }

    public void deleteRequest(DangKyLichRequest request){
        DangKyLichId id = new DangKyLichId();
        id.setMaNv(request.getMaNv());
        id.setMaLlv(request.getMaLlv());
        DangKyLich dangKyLich = dangKyLichRespository.findById(id).orElseThrow(()-> new AppExceptionHandler(ErrorCode.REGISTRATION_NOT_EXISTED));
        dangKyLichRespository.delete(dangKyLich);
    }
}
