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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LichService {
    @Autowired
    private LichResponsitory lichResponsitory;
    @Autowired
    private LichMapper lichMapper;
    // nhớ thêm exception nếu thêm cái gì đó
    public Lich creationRequest(LichCreationRequest request){
        Lich lich = new Lich();
        lich.setMaNv(request.getMaNv());
        lich.setNgayBD(request.getNgayBD());
        lich.setNgayKT(request.getNgayKT());
        lich.setThoiGianBD(request.getThoiGianBD());
        lich.setThoiGianKT(request.getThoiGianKT());
        lich.setSoLuong(request.getSoLuong());
        return lichResponsitory.save(lich);
    }

    public List<LichResponse> getLichByDay(String NgayBD, String NgayKT){
        List<LichResponse> lichResponseList = new ArrayList<>();
        LichResponse lichResponse = new LichResponse();
        for(Lich lich : lichResponsitory.findByNgayBDBetween(NgayBD, NgayKT)){
            lichResponse.setNgayBD(lich.getNgayBD());
            lichResponse.setNgayKT(lich.getNgayKT());
            lichResponse.setThoiGianBD(lich.getThoiGianBD());
            lichResponse.setThoiGianKT(lich.getThoiGianKT());
            lichResponse.setSoLuong(lich.getSoLuong());
            lichResponseList.add(lichResponse);
        }
        if(lichResponseList != null){
            return lichResponseList;
        }else{
            throw new AppExceptionHandler(ErrorCode.CALENDAR_NOT_EXISTED);
        }
    }

    public List<LichResponse>  getAllLich(){
        List<LichResponse> lichResponseList = new ArrayList<>();
        LichResponse lichResponse = new LichResponse();
        for(Lich lich : lichResponsitory.findAll()){
            lichResponse.setNgayBD(lich.getNgayBD());
            lichResponse.setNgayKT(lich.getNgayKT());
            lichResponse.setThoiGianBD(lich.getThoiGianBD());
            lichResponse.setThoiGianKT(lich.getThoiGianKT());
            lichResponse.setSoLuong(lich.getSoLuong());
            lichResponseList.add(lichResponse);
        }
        return lichResponseList;
    }

    public LichResponse updateRequest(String id, LichCreationRequest request) {
        Lich lich = lichResponsitory.findById(id).orElseThrow(() -> new AppExceptionHandler(ErrorCode.CALENDAR_NOT_EXISTED));
        lichMapper.updateLich(request, lich);
        return lichMapper.toLichResponse(lichResponsitory.save(lich));
    }

    public void deleteLich(String id ){
        Lich lich = lichResponsitory.findById(id).orElseThrow(() -> new AppExceptionHandler(ErrorCode.CALENDAR_NOT_EXISTED));
        lichResponsitory.delete(lich);
    }

}
