package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.Lich.LichCreationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.KhachHang;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.Lich;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.LichId;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.LichResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LichService {
    @Autowired
    private LichResponsitory lichResponsitory;
    public Lich creationRequest(LichCreationRequest request){
        Lich lich = new Lich();
        LichId id = new LichId(
                request.getMaLlv(),
                request.getThoiGianBD(),
                request.getThoiGianKT()
        );
        lich.setId(id);
        lich.setMaNv(request.getMaNv());
        lich.setNgayBD(request.getNgayBD());
        lich.setNgayKT(request.getNgayKT());
        lich.setSoLuong(request.getSoLuong());
        return lichResponsitory.save(lich);
    }

    public List<Lich> layLich(){
        return lichResponsitory.findAll();
    }

    /*public void deleteLich(String maLich){
       Lich lich = lichResponsitory.
        if
        lichResponsitory.deleteById(maLich);
    }*/



}
