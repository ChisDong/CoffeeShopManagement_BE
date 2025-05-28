package CoffeeShopManagement.example.CoffeeShopManagement.Respository;

import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLich;
import CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich.DangKyLichId;
import jakarta.persistence.criteria.From;
import org.hibernate.annotations.SQLSelect;
import org.mapstruct.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DangKyLichRespository extends JpaRepository<DangKyLich, DangKyLichId> {
    List<DangKyLich> findAllByMaNv(String maNv);

    List<DangKyLich> findAllByMaLlv(String maLlv);

    @Query(value = """
        SELECT SUM(TIMESTAMPDIFF(MINUTE,
                    STR_TO_DATE(l.THOIGIANBATDAU, '%H:%i'),
                    STR_TO_DATE(l.THOIGIANKETHUC, '%H:%i'))) / 60 AS tong_gio_lam
       FROM dangky dk
       JOIN lichlamviec l ON dk.maLlv = l.id
       WHERE dk.maNv = :maNv """, nativeQuery = true)
    Integer getTongGioDangKy(@Param("maNv") String maNv);
}

