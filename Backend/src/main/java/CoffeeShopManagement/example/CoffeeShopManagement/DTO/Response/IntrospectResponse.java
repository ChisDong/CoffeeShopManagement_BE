package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response;
//response trả về token còn hiệu lực hay không
public class IntrospectResponse {
    Boolean valid;

    public Boolean isValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }
}
