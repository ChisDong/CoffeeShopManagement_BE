package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.NhanVienCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.NhanVienResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.NhanVien;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.NhanVienRespository;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.LichResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
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
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        //encode mật khẩu khi tạo để tránh mất mát
        nhanVien.setMatKhau(passwordEncoder.encode(request.getMatKhau()));
        return nhanVienRespository.save(nhanVien);
    }

    // Lấy danh sách tất cả nhân viên
    public List<NhanVien> findAll() {
        return nhanVienRespository.findAll();
    }

    // tinh tổng giờ làm việc của nhân viên
    public double tinhTongGioLam(String maNv) {
        NhanVien nhanVien = nhanVienRespository.findByMaNv(maNv);
        if (nhanVien == null) {
            throw new RuntimeException("Không tìm thấy nhân viên với mã: " + maNv);
        }

        List<Lich> lichList = lichResponsitory.findByMaNv(maNv);

        double tongGioLam = 0;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        for (Lich lich : lichList) {
            LocalDate ngayBD = LocalDate.parse(lich.getNgayBD(), dateFormatter);
            LocalDate ngayKT = LocalDate.parse(lich.getNgayKT(), dateFormatter);
            long soNgay = ChronoUnit.DAYS.between(ngayBD, ngayKT) + 1;

            LocalTime gioBD = LocalTime.parse(lich.getThoiGianBD(), timeFormatter);
            LocalTime gioKT = LocalTime.parse(lich.getThoiGianKT(), timeFormatter);
            double soGioTrongNgay = Duration.between(gioBD, gioKT).toMinutes() / 60.0;

            tongGioLam += soNgay * soGioTrongNgay;
        }
        return tongGioLam;
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



}
