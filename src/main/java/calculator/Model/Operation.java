package calculator.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Operation {
    private List<Integer> extractionNumbers;

    protected Operation() {
        extractionNumbers = new ArrayList<>();
    }

    public abstract void validString(String inputNumber);

    public abstract void extractNumber(String inputNumber);

    protected void setExtractionNumbers(List<Integer> extractionNumbers) {
        if (extractionNumbers != null) {
            this.extractionNumbers.addAll(extractionNumbers);
        }
    }

    public int getTotalSum() {
        int sum = 0;
        for (Integer num : extractionNumbers) {
            try {
                sum = Math.addExact(sum, num);
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException("합산 결과가 너무 큽니다.");
            }
        }
        return sum;
    }

}
