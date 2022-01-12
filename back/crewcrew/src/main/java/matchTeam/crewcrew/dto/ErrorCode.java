package matchTeam.crewcrew.dto;

public enum ErrorCode {
    INVALID_INPUT_VALUE(400, "COMMON_001", " Invalid Input Value"),
    METHOD_NOT_ALLOWED(405, "COMMON_002", "Method not allowed"),
    HANDLE_ACCESS_DENIED(403, "COMMON_003", "Access is Denied"),
    INVALID_REQUEST_DATA(404,"INVALID_REQUEST","invalid Access"),
    TOKEN_NOT_FOUND(404,"TOKEN_NOT_FOUND","invalidToken"),

    // Standard
    ILLEGAL_STATE(400, "STANDARD_001", "illegal state"),
    ILLEGAL_ARGUMENT(400, "STANDARD_002", "illegal argument"),

    LOGIN_FAILED(600,"LOGIN_FAILED","cannot login to server"),
    // Exception
    EXCEPTION(500, "EXCEPTION", "exception"),

    EMAIL_ALREADY_EXIST(1001,"EMAIL_001","email alreadyExist");


    private int status;
    private final String code;
    private final String message;


    ErrorCode( int status,String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;

    }

    public int getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
