package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.NhanVienCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.NhanVienResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.ThongKeGioVaLuongResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.NhanVien;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.DangKyLichRespository;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.NhanVienRespository;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.LichResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.Duration;


@Service
public class NhanVienService {
    @Autowired
    private NhanVienRespository nhanVienRespository;
    @Autowired
    private LichResponsitory lichResponsitory;
    @Autowired
    private DangKyLichRespository dangKyLichRespository;

    private String generateMaNhanVien(){
        return "NV" + UUID.randomUUID().toString().substring(0, 2).toUpperCase();
    }
    private String generateMatKhau(){
        return UUID.randomUUID().toString().substring(0,4).toUpperCase();
    }
    public NhanVien createRequest(NhanVienCreationRequest request){
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNv(generateMaNhanVien());
        nhanVien.setHoTenNv(request.getHoTenNv());
        nhanVien.setMatKhau(generateMatKhau());
        nhanVien.setEmail(request.getEmail());
        nhanVien.setSoCccd(request.getSoCccd());
        nhanVien.setViTriLam(request.getViTriLam());
        nhanVien.setRole(request.getRole());
        nhanVien.setLuong(request.getLuong());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        //encode mật khẩu khi tạo để tránh mất mát
        nhanVien.setMatKhau(passwordEncoder.encode(request.getMatKhau()));
        return nhanVienRespository.save(nhanVien);
    }

    // Lấy danh sách tất cả nhân viên
    public List<NhanVien> findAll() {
        return nhanVienRespository.findAll();
    }

    // tinh tổng giờ làm việc của nhân viên (khả năng sai)
    public double tinhTongGioLam(String maNv) {
        if (maNv == null || maNv.trim().isEmpty()) {
            throw new IllegalArgumentException("Mã nhân viên không được để trống");
        }

        NhanVien nhanVien = nhanVienRespository.findByMaNv(maNv);
        if (nhanVien == null) {
            throw new RuntimeException("Không tìm thấy nhân viên với mã: " + maNv);
        }

        List<Lich> lichList = lichResponsitory.findByMaNv(maNv);
        if (lichList == null || lichList.isEmpty()) {
            return 0.0;
        }

        double tongGioLam = 0;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        for (Lich lich : lichList) {
            try {
                LocalDate ngayBD = LocalDate.parse(lich.getNgayBD(), dateFormatter);
                LocalDate ngayKT = LocalDate.parse(lich.getNgayKT(), dateFormatter);
                
                if (ngayKT.isBefore(ngayBD)) {
                    throw new IllegalArgumentException("Ngày kết thúc không được trước ngày bắt đầu");
                }

                long soNgay = ChronoUnit.DAYS.between(ngayBD, ngayKT) + 1;

                LocalTime gioBD = LocalTime.parse(lich.getThoiGianBD(), timeFormatter);
                LocalTime gioKT = LocalTime.parse(lich.getThoiGianKT(), timeFormatter);
                
                double soGioTrongNgay;
                if (gioKT.isBefore(gioBD)) {
                    // Handle overnight shifts
                    soGioTrongNgay = (Duration.between(gioBD, LocalTime.MAX).toMinutes() + 
                                    Duration.between(LocalTime.MIN, gioKT).toMinutes() + 1) / 60.0;
                } else {
                    soGioTrongNgay = Duration.between(gioBD, gioKT).toMinutes() / 60.0;
                }

                tongGioLam += soNgay * soGioTrongNgay;
            } catch (Exception e) {
                throw new RuntimeException("Lỗi khi xử lý lịch làm việc: " + e.getMessage());
            }
        }
        
        // Round to 2 decimal places
        return Math.round(tongGioLam * 100.0) / 100.0;
    }

    // Cập nhật thông tin nhân viên
    public NhanVien update(NhanVien nhanVien) {
        NhanVien existing = nhanVienRespository.findByMaNv(nhanVien.getMaNv());
        if (existing == null) {
            throw new RuntimeException("Không tìm thấy nhân viên với mã: " + nhanVien.getMaNv());
        }
        existing.setHoTenNv(nhanVien.getHoTenNv());
        existing.setEmail(nhanVien.getEmail());
        existing.setSoCccd(nhanVien.getSoCccd());
        existing.setViTriLam(nhanVien.getViTriLam());
        return nhanVienRespository.save(existing);
    }

    // Xoa nhân viên
    public void deleteNhanVien(String maNv) {
        NhanVien existing = nhanVienRespository.findByMaNv(maNv);
        if (existing == null) {
            throw new RuntimeException("Không tìm thấy nhân viên với mã: " + maNv);
        }
        nhanVienRespository.delete(existing);
    }

    // lấy tất cả nhân viên
    public List<NhanVienResponse> getAllNhanVien(){
        List<NhanVienResponse> nhanVienResponseList = new ArrayList<>();
        NhanVienResponse nhanVienResponse = new NhanVienResponse();
        for(NhanVien nhanVien : nhanVienRespository.findAll()){
            nhanVienResponse.setHoTenNv(nhanVien.getHoTenNv());
            nhanVienResponse.setEmail(nhanVien.getEmail());
            nhanVienResponse.setViTriLam(nhanVien.getViTriLam());
            nhanVienResponse.setSoDienThoai(nhanVien.getSoDienThoai());
            nhanVienResponseList.add(nhanVienResponse);
        }
        return nhanVienResponseList;
    }

    // thống kê giờ làm việc và lương
    public ThongKeGioVaLuongResponse thongKeGioVaLuongResponse(String maNv){
        Object[] result = dangKyLichRespository.getThongKeGioVaLuong(maNv);
        Double tongGio = result[0] != null ? ((Number) result[0]).doubleValue():0.0;
        Double tongLuong = result[1] !=null ? ((Number) result[1]).doubleValue():0.0;
        return new ThongKeGioVaLuongResponse(tongGio, tongLuong);
    }



}
