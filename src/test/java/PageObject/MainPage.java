package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    SelenideElement menuBar = $("//id='mainMenu'");
    SelenideElement restaurantHeader = $(By.id("restaurantHeader"));


    public MainPage shouldBeVisible() {
        menuBar.shouldBe(Condition.visible);
        return new MainPage();
    }

    public String getRestaurantHeader(){
        return restaurantHeader.getText();
    }


}
