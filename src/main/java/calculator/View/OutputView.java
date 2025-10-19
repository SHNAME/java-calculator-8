package calculator.View;

import calculator.Constant.MessageConstants;

public class OutputView {

    public void printMessage(MessageConstants message) {
        System.out.println(message.getMessage());
    }

    public void printSumResult(MessageConstants message, int sum) {
        System.out.println(message.getMessage() + sum);
    }
}
