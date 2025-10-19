package calculator.Util;

import calculator.Model.BasicOperation;
import calculator.Model.CustomOperation;
import calculator.Model.Operation;

public final class OperationTypeChecker {

    public static Operation checkOperationType(String userInput) {
        if (userInput.isBlank()) {
            return new BasicOperation();
        }
        if (userInput.charAt(0) >= '0' && userInput.charAt(0) <= '9') {
            return new BasicOperation();
        }
        if (userInput.startsWith("//")) {
            return new CustomOperation();
        }
        throw new IllegalArgumentException("잘못된 문자열을 입력했습니다.");
    }

}
