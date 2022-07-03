package enums;

public enum StatusCode {

    OK(200, "OK");
    private final int value;
    private final String description;
    StatusCode(int value, String description) {
        this.value = value;
        this.description = description;
    }


    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

}
