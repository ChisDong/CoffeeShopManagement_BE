package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request;


public class AuthenticationRequest {
   private String maNv;
   private String matKhau;

    public String getMaNv() {
        return maNv;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMaNv(String maNv) {
        this.maNv = maNv;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
}
