package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        mainSteps
                .login("maxigh@mail.sd","2222222");

    }

    @Test
    public void emptyLoginTest() {

        mainSteps
                .failedLogin("","2222222")
                .errorMessageShouldBe("Error: Could not find account. Forgot Password?");
    }

    @Test
    public void emptyPasswordTest() {
        mainSteps
                .failedLogin("maxigh@mail.sd","")
                .errorMessageShouldBe("Error: Could not find account. Forgot Password?");
    }
}
