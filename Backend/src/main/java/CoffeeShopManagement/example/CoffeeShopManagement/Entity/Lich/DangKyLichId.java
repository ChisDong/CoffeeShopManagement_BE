package CoffeeShopManagement.example.CoffeeShopManagement.Entity.Lich;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DangKyLichId {
    String maLlv;
    String maNv;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof DangKyLichId)) return false;
        DangKyLichId that = (DangKyLichId) o;
        return this.maLlv.equals(that.maLlv) && this.maNv.equals(that.maNv);
    }

    @Override
    public int hashCode(){
        return this.maLlv.hashCode() + this.maNv.hashCode();
    }
}
