package CoffeeShopManagement.example.CoffeeShopManagement.Exception;

public class AppExceptionHandler extends RuntimeException{
    private ErrorCode errorCode;

    public AppExceptionHandler(ErrorCode errorCode){
        super(errorCode.toString());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

}
