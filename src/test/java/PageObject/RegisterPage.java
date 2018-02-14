package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.*;

public class RegisterPage {

    private SelenideElement backToLoginButton = $x("//a[contains(@href, login)]");
    private SelenideElement registerButton = $x("//name = 'submit'");
    private SelenideElement registerHeader = $("h2");

    public String getHeader() {
        return registerHeader.getText();
    }

    public boolean isBackToLoginButtonDisplayed(){
        return backToLoginButton.isDisplayed();
    }

    public boolean isRegisterButtonDisplayed(){
        return registerButton.isDisplayed();
    }


}
