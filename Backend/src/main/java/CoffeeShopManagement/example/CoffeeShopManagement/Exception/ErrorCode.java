package CoffeeShopManagement.example.CoffeeShopManagement.Exception;

public enum ErrorCode{
    CALENDAR_NOT_EXISTED(1003, "User not existed");

    private String message;
    private int code;
    ErrorCode(int code, String message){
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
