package CoffeeShopManagement.example.CoffeeShopManagement.Exception;

public enum ErrorCode{
    CALENDAR_NOT_EXISTED(1003, "User not existed"),
    REGISTRATION_NOT_EXISTED(1003, "Registration not existed"),
    LIST_NOT_EXISTED(1003, "List not existed"),
    REGISTRATION_IS_FUll(1004, "Registration is full"),
    USER_NOT_EXISTED(1003, "User not existed" );
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
