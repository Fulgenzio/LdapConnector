package contracts.exceptions;

import enums.ErrorCodeEnum;

public class CredentialsException extends Exception{

    private String message;
    private String errorCode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String errorCode) {
        this.message = ErrorCodeEnum.getValue(errorCode).toString();

    }

    public CredentialsException(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
