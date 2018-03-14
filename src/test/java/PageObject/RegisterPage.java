package PageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class RegisterPage {

    private SelenideElement backToLoginButton = $x("//a[contains(@href, login)]");
    private SelenideElement registerButton = $x("//name = 'submit'");
    private SelenideElement registerHeader = $("h2");

    /**
     * Gets header to check during test if proper header is displayed
     * @return header as a string
     */

    public String getHeader() {
        return registerHeader.getText();
    }

    /**
     * Checks if login & register buttons are displayed
     * @return true if buttons are displayed
     */

    public boolean isBackToLoginButtonDisplayed(){
        return backToLoginButton.isDisplayed();
    }

    public boolean isRegisterButtonDisplayed(){
        return registerButton.isDisplayed();
    }

}
