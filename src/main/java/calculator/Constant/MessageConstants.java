package calculator.Constant;

public enum MessageConstants {
    CALCULATOR_START_MESSAGE("덧셈할 문자열을 입력해 주세요."),
    RESULT_RESPONSE_MESSAGE("결과 : ");

    private final String message;

    MessageConstants(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
