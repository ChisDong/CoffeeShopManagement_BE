package CoffeeShopManagement.example.CoffeeShopManagement.Service;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.LichResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import CoffeeShopManagement.example.CoffeeShopManagement.Exception.AppExceptionHandler;
import CoffeeShopManagement.example.CoffeeShopManagement.Exception.ErrorCode;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.LichResponsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LichService {
    @Autowired
    private LichResponsitory lichResponsitory;
    // nhớ thêm exception nếu thêm cái gì đó
    public Lich creationRequest(Lich request){
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
        if(!lichResponseList.isEmpty()){
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

    public LichResponse updateRequest(String id, Lich request) {
        Lich lich = lichResponsitory.findById(id).orElseThrow(() -> new AppExceptionHandler(ErrorCode.CALENDAR_NOT_EXISTED));
        LichResponse lichResponse = new LichResponse();
        if(request.getNgayBD() != null){
            lich.setNgayBD(request.getNgayBD());
            lichResponse.setNgayBD(lich.getNgayBD());
        }
        if(request.getNgayKT() != null){
            lich.setNgayKT(request.getNgayKT());
            lichResponse.setNgayKT(lich.getNgayKT());
        }
        if(request.getThoiGianBD() != null){
            lich.setThoiGianBD(request.getThoiGianBD());
            lichResponse.setThoiGianBD(lich.getThoiGianBD());
        }
        if(request.getThoiGianKT() != null){
            lich.setThoiGianKT(request.getThoiGianKT());
            lichResponse.setThoiGianKT(lich.getThoiGianKT());
        }
        if(request.getSoLuong() != null){
            lich.setSoLuong(request.getSoLuong());
            lichResponse.setSoLuong(lich.getSoLuong());
        }
        if(request.getMaNv() != null){
            lich.setMaNv(request.getMaNv());
        }
        lichResponsitory.save(lich);
        return lichResponse;
    }

    public void deleteLich(String id ){
        Lich lich = lichResponsitory.findById(id).orElseThrow(() -> new AppExceptionHandler(ErrorCode.CALENDAR_NOT_EXISTED));
        lichResponsitory.delete(lich);
    }

    public List<Lich> findByMaNv(String maNv) {
        return lichResponsitory.findByMaNv(maNv);
    }
}