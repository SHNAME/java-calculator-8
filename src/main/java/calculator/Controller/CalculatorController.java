package calculator.Controller;

import calculator.Constant.MessageConstants;
import calculator.View.OutputView;

public class CalculatorController {
    private OutputView outputView = new OutputView();

    public CalculatorController() {
        outputView.printMessage(MessageConstants.CALCULATOR_START_MESSAGE);
    }

}
