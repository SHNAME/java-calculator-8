package calculator.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomOperation extends Operation {
    private static final String CUSTOM_PATTERN = "^//(.{1})\\\\n(.*)$";

    @Override
    public void validString(String inputNumber) {
        validFormat(inputNumber);
    }

    @Override
    public void extractNumber(String inputNumber) {
        Matcher matcher = Pattern.compile(CUSTOM_PATTERN, Pattern.DOTALL)
                .matcher(inputNumber);
        matcher.matches();
        String delimiter = Pattern.quote(matcher.group(1));
        String numbersPart = matcher.group(2);
        if (numbersPart.isBlank()) {
            setExtractionNumbers(List.of(0));
            return;
        }
        String[] tokens = numbersPart.split(delimiter);
        setExtractionNumbers(parseToNumberList(tokens));
    }

    private void validFormat(String inputNumber) {
        Matcher matcher = Pattern.compile(CUSTOM_PATTERN, Pattern.DOTALL).matcher(inputNumber);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("커스텀 구분자 형식에 맞지 않습니다.");
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
                throw new IllegalArgumentException("숫자 형식이 잘못되었습니다 :" + token);
            }
        }
        return extractionNumber;
    }
}
