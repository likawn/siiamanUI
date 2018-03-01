package PageObject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static TemporaryDataProvider.TemporaryDataProvider.baseUrl;
import static TemporaryDataProvider.TemporaryDataProvider.expectedUrlFromMenuBar;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.testng.AssertJUnit.assertEquals;



public class MainPage {


    private SelenideElement menuBar = $("//id='mainMenu'");
    //private SelenideElement menuBar = (SelenideElement) By.id("mainMenu");
    private SelenideElement mainPageFirstHeader = $x("//*[@class='ui one column stackable center aligned page grid']/div[1]");
    private SelenideElement mainPageSecondHeader= $x( "//*[@class='ui one column stackable center aligned page grid']/div[3]");
    private SelenideElement inviteToApp = $x( "//*[@class='item right']");
    private SelenideElement userSettings = $x( "//*[@class=' item right']");
    private ElementsCollection menuBarElements = $$("a[class=' item']");
    private SelenideElement restaurantButton= $x( "//*[@id='restaurants']");

    /**
     * Gets URL value to check in test if user navigates after log in to proper site
     *
     */

    public String getMainPageURL () {
        return url();

    }

    /**
     * Checks if menu bar is visible and has proper number of elements
     *
     */
    public MainPage shouldBeVisible(){
        menuBar.shouldBe(Condition.visible);
        return new MainPage();
    }

   public MainPage shouldHaveSizeCheck() {
       menuBarElements.shouldHaveSize(5);
       return new MainPage();
   }

    /**
     * checks if menu elements are clickable and navigates to proper sites.
     */
   public void areMenuBarElementsClickable() {
      for(int i=0; i <menuBarElements.size(); i++){
          elementToBeClickable(menuBarElements.get(i));
      }
    }

    public void checkIfPagesChangesByClickingOnMenuBarElements(){
        for(int i=0; i < menuBarElements.size(); i++){
            menuBarElements.get(i).click();
            assertEquals(url(), baseUrl + expectedUrlFromMenuBar.get(i));
        }
    }

    /**
     * checks if headears are displayed
     * @return
     */
    public String getMainPageFirstHeader(){
        return mainPageFirstHeader.getText();
    }
    public String getMainPageSecondHeader(){
        return mainPageSecondHeader.getText();
    }

    /**
     * navigates user to restaurant page. It's temporary solution - after resolving problem with displaying proper website after login - i'll try to use menuBarElements List rather than button
     * @return
     */

    public Restaurants goToRestaurantsPage(){
        restaurantButton.click();
        return new Restaurants();
    }


    }


