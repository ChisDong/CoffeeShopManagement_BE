package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich.DangKyLichRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.DangKyLichReponse;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.LichDanKyLichResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.NhanVienDangKyLichResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.NhanVienResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLich;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLichId;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.NhanVien;
import CoffeeShopManagement.example.CoffeeShopManagement.Exception.AppExceptionHandler;
import CoffeeShopManagement.example.CoffeeShopManagement.Exception.ErrorCode;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.DangKyLichRespository;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.LichResponsitory;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.NhanVienRespository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DangKyLichService {
    @Autowired
    private DangKyLichRespository dangKyLichRespository;
    @Autowired
    private LichResponsitory lichResponsitory;
    @Autowired
    private NhanVienService nhanVienService;
    private NhanVienRespository nhanVienRespository;

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
// lấy lịch đăng ký thể hiện cho nhân viên
    public List<LichDanKyLichResponse> getAllLichDangKyLich(String maNv){
        List<LichDanKyLichResponse> lichDangKyLichList = new ArrayList<>();
        for(DangKyLich dangKyLich : dangKyLichRespository.findAllByMaNv(maNv)){
            Lich lich = new Lich();
            lich = lichResponsitory.findById(dangKyLich.getMaLlv()).orElseThrow(()-> new AppExceptionHandler(ErrorCode.CALENDAR_NOT_EXISTED));
            LichDanKyLichResponse lichDangKyLichResponse = new LichDanKyLichResponse();
            lichDangKyLichResponse.setNgayBD(lich.getNgayBD());
            lichDangKyLichResponse.setNgayKT(lich.getNgayKT());
            lichDangKyLichResponse.setThoiGianBD(lich.getThoiGianBD());
            lichDangKyLichResponse.setThoiGianKT(lich.getThoiGianKT());
            lichDangKyLichList.add(lichDangKyLichResponse);
        }
        if(lichDangKyLichList != null){
            return lichDangKyLichList;
        }else{
            throw new AppExceptionHandler(ErrorCode.LIST_NOT_EXISTED);
        }
    }
    //hiển thị danh sách nhân viên bao gồm mã nhân viên, họ tên
    public List<NhanVienDangKyLichResponse> getAllNhanVienInLich(String maLlv){
        List<NhanVienDangKyLichResponse> nhanVienDangKyLichList = new ArrayList<>();
        for(DangKyLich lich : dangKyLichRespository.findAllByMaLlv(maLlv)){
            NhanVienDangKyLichResponse nhanVienDangKyLichResponse = new NhanVienDangKyLichResponse();
            NhanVien nhanVien = new NhanVien();
            nhanVien = nhanVienRespository.findById(lich.getMaNv()).orElseThrow(()-> new AppExceptionHandler(ErrorCode.USER_NOT_EXISTED));
            nhanVienDangKyLichResponse.setMaNv(lich.getMaNv());
            nhanVienDangKyLichResponse.setTenNv(nhanVien.getHoTenNv());
            nhanVienDangKyLichResponse.setViTriLam(nhanVien.getViTriLam());
            nhanVienDangKyLichList.add(nhanVienDangKyLichResponse);
        }
        if(nhanVienDangKyLichList != null){
            return nhanVienDangKyLichList;
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
