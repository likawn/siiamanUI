package Tests;

import PageObject.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.close;


public class RestaurantsPageTest extends SetUp{

    private HomePage homePage;
    private MainPage mainPage;
    private Restaurants restaurants;

    @BeforeClass
    private void setUp(){
        homePage = openHomePage();
        mainPage = homePage.logInto();
        restaurants = mainPage.goToRestaurantsPage();

    }

    @Test
    private void checkHowManyRestaurants(){
        restaurants.getNumOfRestaurants();


    }

    @AfterClass
    private void tearDown(){
        close();
    }
}
