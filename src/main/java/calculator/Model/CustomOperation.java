package calculator.Model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomOperation extends Operation {
    private static final String CUSTOM_PATTERN = "^//(.{1})\\\\n(.*)$";

    @Override
    public void validString(String inputNumber) {
        validFormat(inputNumber);
    }

    private void validFormat(String inputNumber) {
        Matcher matcher = Pattern.compile(CUSTOM_PATTERN, Pattern.DOTALL).matcher(inputNumber);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("커스텀 구분자 형식에 맞지 않습니다.");
        }
    }
}
