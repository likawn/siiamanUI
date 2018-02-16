package Tests;

import PageObject.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static TemporaryDataProvider.TemporaryDataProvider.expectedRestaurantsHeader;
import static TemporaryDataProvider.TemporaryDataProvider.registerPageHeader;
import static Tools.AlphabeticalStringListComparator.compareTwoStringLists;
import static com.codeborne.selenide.Selenide.close;
import static org.testng.AssertJUnit.assertEquals;

public class LoginTest  extends SetUp {

    private HomePage homePage;
    private MainPage mainPage;


    @BeforeClass
    private void setUp() {
        homePage = openHomePage();
    }

    @Test
    private void shouldLogInto(){
        mainPage = homePage.logInto();
        assertEquals(mainPage.getRestaurantHeader(), expectedRestaurantsHeader);

    }

    @AfterClass
    private void tearDown(){
        close();
    }
}

