package mx.tec.lab;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TestSwingApplicationTests {
	
	TestSwingApplication application = new TestSwingApplication();
	
	@Test
    void givenTwoIntegers_WhenSum_ThenCorrectResult() {
        // Given 5 and 7
        application.numberOneTextField.setText("5");
        application.numberTwoTextField.setText("7");
        String expectedResult = "12";

        // When operation is sum
        application.operationButton.doClick();

        // Then result is 12
        String actualResult = application.resultTextField.getText();
        assertEquals(expectedResult, actualResult);
    }

	@Test
    void givenTwoUnvalid_WhenSum_ThenValuesClear() {
        // Given an invalid input
        application.numberOneTextField.setText("fd");
        application.numberTwoTextField.setText("f");
        String expectedResult = "";

        // When the sum operation is performed
        application.operationButton.doClick();

        // Then the invalid input is cleared and no result is provided
        String actualResult = application.resultTextField.getText();;
        String positionOne = application.numberOneTextField.getText();
        String positionTwo = application.numberTwoTextField.getText();
        assertEquals(expectedResult, actualResult);
        assertEquals(positionOne, actualResult);
        assertEquals(positionTwo, actualResult);
    }

}
