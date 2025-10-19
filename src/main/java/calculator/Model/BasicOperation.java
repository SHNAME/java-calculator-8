package calculator.Model;

import java.util.ArrayList;
import java.util.List;
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

    @Override
    public void extractNumber(String inputNumber) {
        if (inputNumber.isBlank()) {
            setExtractionNumbers(List.of(0));
            return;
        }
        String delimiter = Pattern.quote(",") + "|" + Pattern.quote(":");
        String[] tokens = inputNumber.split(delimiter);
        setExtractionNumbers(parseToNumberList(tokens));
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

    private List<Integer> parseToNumberList(String[] tokens) {
        List<Integer> extractionNumber = new ArrayList<>();

        for (String token : tokens) {
            String trimmed = token.trim();

            if (trimmed.isBlank()) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다. 구분자 사이에 숫자가 없습니다.");
            }

            try {
                extractionNumber.add(Integer.parseInt(trimmed));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자 형식이 잘못되었습니다: " + token);
            }
        }

        return extractionNumber;
    }


}
