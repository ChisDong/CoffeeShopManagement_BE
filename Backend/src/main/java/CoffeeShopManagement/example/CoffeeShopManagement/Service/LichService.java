package CoffeeShopManagement.example.CoffeeShopManagement.Service;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich.LichCreationRequest;
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
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LichService {
    @Autowired
    private LichResponsitory lichResponsitory;
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

    // Phiên bản đã sửa lỗi cho getLichByDay
    public List<LichResponse> getLichByDay(String NgayBD, String NgayKT) {
        List<Lich> lichList = lichResponsitory.findByNgayBDBetween(NgayBD, NgayKT);

        if (lichList == null || lichList.isEmpty()) {
            // Có thể trả về danh sách rỗng hoặc throw exception tùy logic của bạn
            return new ArrayList<>();
        }

        // Sử dụng stream().map() để tạo đối tượng mới cho mỗi mục trong vòng lặp
        return lichList.stream()
                .map(lich -> {
                    LichResponse lichResponse = new LichResponse(); // <-- Tạo mới đối tượng ở đây
                    lichResponse.setId(lich.getId());
                    lichResponse.setNgayBD(lich.getNgayBD());
                    lichResponse.setNgayKT(lich.getNgayKT());
                    lichResponse.setThoiGianBD(lich.getThoiGianBD());
                    lichResponse.setThoiGianKT(lich.getThoiGianKT());
                    lichResponse.setSoLuong(lich.getSoLuong());
                    return lichResponse;
                }).collect(Collectors.toList());
    }

    public List<LichResponse>  getAllLich(){
        return lichResponsitory.findAll().stream()
                .map(lich -> {
                    LichResponse lichResponse = new LichResponse();
                    lichResponse.setId(lich.getId()); // <-- Thêm ID
                    lichResponse.setNgayBD(lich.getNgayBD());
                    lichResponse.setNgayKT(lich.getNgayKT());
                    lichResponse.setThoiGianBD(lich.getThoiGianBD());
                    lichResponse.setThoiGianKT(lich.getThoiGianKT());
                    lichResponse.setSoLuong(lich.getSoLuong());
                    return lichResponse;
                }).collect(Collectors.toList());
    }

    public LichResponse updateRequest(String id, LichCreationRequest request) {
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

}
