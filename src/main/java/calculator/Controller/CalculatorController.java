package calculator.Controller;

import calculator.Constant.MessageConstants;
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
    }

    private String getUserInput() {
        return inputView.readInput().trim();
    }

}
