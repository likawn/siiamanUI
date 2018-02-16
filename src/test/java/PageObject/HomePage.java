package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.Selenide.*;
import org.openqa.selenium.By;

import java.util.List;

import static TemporaryDataProvider.TemporaryDataProvider.login_correct;
import static TemporaryDataProvider.TemporaryDataProvider.password_correct;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.testng.AssertJUnit.assertEquals;

public class HomePage {

    private SelenideElement loginButton = $x("//*[@id='login_button']");
    private SelenideElement logo = $("img[alt='SII']");
    private SelenideElement registerLink = $x("//a[contains (@href, 'register')]");
    private SelenideElement recoverLink = $x("//a[contains (@href, 'recover')]");
    private SelenideElement loginHeader = $("h2");
    private SelenideElement emailInput = $(By.id("emailInput"));
    private SelenideElement passwordInput = $(By.name("password"));




    /**
     * Checks if Logo Element is displayed
     * @return true if displayed
     */
    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public String getLoginHeader(){
        return loginHeader.getText();
    }
    public boolean isLoginButtonDisplayed(){
        return loginButton.isDisplayed();
    }
    public boolean isRecoverLinkDisplayed(){
        return recoverLink.isDisplayed();
    }
    /*
    * Navigates to register page
    * */

    public RegisterPage followRegisterLink() {
        registerLink.followLink();
        return new RegisterPage();
    }

    public MainPage logInto(){
        emailInput.setValue(login_correct);
        passwordInput.setValue(password_correct);
        loginButton.click();
        sleep(20000);
        return new MainPage();
    }
        }

