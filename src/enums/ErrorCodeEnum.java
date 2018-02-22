package enums;

public enum ErrorCodeEnum {
    id("Incomplete data"),
    ic("Incorrect credentials"),
    ce("Could not connect");

    private final String value;

    ErrorCodeEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static ErrorCodeEnum getValue(String value) {
        for(ErrorCodeEnum e: ErrorCodeEnum.values()) {
            if(e.value.equals(value)) {
                return e;
            }
        }
        return null;// not found
    }
}
