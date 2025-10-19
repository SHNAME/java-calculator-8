package calculator.Model;

import java.util.regex.Pattern;

public class BasicOperation extends Operation {
    private static final String BASIC_PATTERN = "^[0-9]+([,:][0-9]+)*$";

    @Override
    public void validString(String inputNumber) {
        if (inputNumber.isBlank()) {
            return;
        }
        validateNegativeNumber(inputNumber);
        validLastCharacter(inputNumber);
        validFormat(inputNumber);
    }

    private void validateNegativeNumber(String inputNumber) {
        if (inputNumber.contains("-")) {
            throw new IllegalArgumentException("음수는 허용되지 않습니다.");
        }
    }

    private void validLastCharacter(String inputNumber) {
        if (!Character.isDigit(inputNumber.charAt(inputNumber.length() - 1))) {
            throw new IllegalArgumentException("입력은 숫자로 끝나야합니다.");
        }
    }

    private void validFormat(String inputNumber) {
        if (!Pattern.matches(BASIC_PATTERN, inputNumber)) {
            throw new IllegalArgumentException("기본 형식에 맞지 않습니다.");
        }
    }


}
