package CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response;
public class AuthenticationResponse {
    private boolean authenticated;
    private String token; // trả về response cho người dùng

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
