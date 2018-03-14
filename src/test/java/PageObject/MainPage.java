package PageObject;

import com.codeborne.selenide.Condition.*;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.CollectionCondition;

import java.util.ArrayList;
import java.util.Arrays;

import static TemporaryDataProvider.TemporaryDataProvider.baseUrl;
import static TemporaryDataProvider.TemporaryDataProvider.expectedUrlFromMenuBar;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.present;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.codeborne.selenide.WebDriverRunner.webdriverContainer;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;




public class MainPage {


    private SelenideElement menuBar = $x( "//*[@id='mainMenu']");
    private SelenideElement mainPageFirstHeader = $x("//*[@class='ui one column stackable center aligned page grid']/div[1]");
    private SelenideElement mainPageSecondHeader= $x( "//*[@class='ui one column stackable center aligned page grid']/div[3]");
    private SelenideElement inviteToApp = $x( "//*[@class='item right']");
    private SelenideElement userSettings = $x( "//*[@class=' item right']");
    private ElementsCollection menuBarElements = $$("a[class=' item']");
    private SelenideElement restaurantButton= $x( "//*[@id='restaurants']");
    private SelenideElement siiamanButton = $x( "//*[@id='index']");
    private SelenideElement logoutButton = $x( "//*[@value='Wyloguj']") ;

    /**
     * Gets URL value to check during test if user navigates after log in to proper site
     *@return url as string
     */

    public String getMainPageURL () {
        url();
        return url();
    }

    /**
     * Checks if menu bar is visible and has proper number of elements
     *@return MainPage
     */

    public void shouldBeVisible(){
        menuBar.shouldBe(visible);
    }

   public void shouldHaveSizeCheck() {
       menuBarElements.shouldHaveSize(5);
       System.out.println(menuBarElements);
   }

    /**
     * checks if menu elements are clickable and navigates to proper sites.
     */

   public void areMenuBarElementsClickable() {
      for(int i=0; i <menuBarElements.size(); i++){
          elementToBeClickable(menuBarElements.get(i));
      }
    }

    public void AmIinProperPlace(){
        String whereAmI=url();
        if (whereAmI != baseUrl)
            siiamanButton.click();
    }

    /**
     * Checks if pages change by clicking on Menu Bar elements.
     */

    public void checkIfPagesChangesByClickingOnMenuBarElements(){
       for(int i=0; i < menuBarElements.size(); i++){

           menuBarElements.get(i).click();
           assertEquals(url(), baseUrl + expectedUrlFromMenuBar.get(i));
           siiamanButton.click();
       }

   }
    //before fixing
    //
    // public void checkIfPagesChangesByClickingOnMenuBarElements(){
    //for(int i=0; i < menuBarElements.size(); i++){
    //assertEquals(url(), baseUrl + expectedUrlFromMenuBar.get(i));
    //menuBarElements.get(i).click();
    //}
    //}

    /**
     * Takes headers' texts to check during test if they are proper. After recent application changes, I have to change a little logic of the solution.
     * @return headers as strings
     */

    public String getMainPageFirstHeader(){
        return mainPageFirstHeader.getText();
    }
    public String getMainPageSecondHeader(){
        return mainPageSecondHeader.getText();
    }

    /**
     * Navigates user to restaurant page. It's temporary solution - after resolving problem with displaying proper website after login - i'll try to use menuBarElements List rather than button
     *@return restaurants page
     */

    public Restaurants goToRestaurantsPage(){
        restaurantButton.click();
        return new Restaurants();
    }

    }


