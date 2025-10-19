package calculator.Controller;

import calculator.Constant.MessageConstants;
import calculator.Model.Operation;
import calculator.Util.OperationTypeChecker;
import calculator.View.InputView;
import calculator.View.OutputView;

public class CalculatorController {
    private OutputView outputView = new OutputView();
    private InputView inputView = new InputView();

    public CalculatorController() {
        outputView.printMessage(MessageConstants.CALCULATOR_START_MESSAGE);
    }

    public void operateCalculator() {
        String userInput = getUserInput();
        Operation operation = createOperation(userInput);
        int totalSum = calculate(operation, userInput);
        responseOutput(totalSum);
    }

    private String getUserInput() {
        return inputView.readInput().trim();
    }

    private Operation createOperation(String userInput) {
        return OperationTypeChecker.checkOperationType(userInput);
    }

    private int calculate(Operation operation, String userInput) {
        operation.validString(userInput);
        operation.extractNumber(userInput);
        return operation.getTotalSum();
    }

    private void responseOutput(int totalSum) {
        outputView.printSumResult(MessageConstants.RESULT_RESPONSE_MESSAGE, totalSum);
    }

}
