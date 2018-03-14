package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static TemporaryDataProvider.TemporaryDataProvider.login_correct;
import static TemporaryDataProvider.TemporaryDataProvider.password_correct;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    private SelenideElement loginButton = $x("//*[@id='login_button']");
    private SelenideElement logo = $("img[alt='SII']");
    private SelenideElement registerLink = $x("//a[contains (@href, 'register')]");
    private SelenideElement recoverLink = $x("//a[contains (@href, 'recover')]");
    private SelenideElement loginHeader = $("h2");
    private SelenideElement emailInput = $(By.id("emailInput"));
    private SelenideElement passwordInput = $(By.name("password"));




    /**
     * Checks if Logo Element, login button, recover link is displayed
     * @return true if displayed
     */

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public boolean isLoginButtonDisplayed(){
        return loginButton.isDisplayed();
    }

    public boolean isRecoverLinkDisplayed(){
        return recoverLink.isDisplayed();
    }

    /**
     * Takes login header to check during test if proper header is displayed
     * @return header as a string
     */

    public String getLoginHeader(){
        return loginHeader.getText();
    }

    /**
    * Navigates to register page
    * @return register page
    */

    public RegisterPage followRegisterLink() {
        registerLink.followLink();
        return new RegisterPage();
    }

    /**
     * Logs into application
     * @return Main Page
     */

    public MainPage logInto(){
        emailInput.setValue(login_correct);
        passwordInput.setValue(password_correct);
        loginButton.click();
        return new MainPage();
    }
        }

