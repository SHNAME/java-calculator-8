package calculator.Model;

import java.util.ArrayList;
import java.util.List;

public abstract class Operation {
    private List<Integer> extractionNumbers;

    protected Operation() {
        extractionNumbers = new ArrayList<>();
    }

    public abstract void validString(String inputNumber);
}
