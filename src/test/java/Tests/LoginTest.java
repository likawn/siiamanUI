package Tests;

import PageObject.HomePage;
import PageObject.MainPage;
import PageObject.SetUp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static TemporaryDataProvider.TemporaryDataProvider.baseUrl;
import static TemporaryDataProvider.TemporaryDataProvider.expectedMainPageFirstHeader;
import static com.codeborne.selenide.Selenide.close;
import static org.testng.AssertJUnit.assertEquals;

public class LoginTest  extends SetUp {

    private HomePage homePage;
    private MainPage mainPage;



    @BeforeClass
    private void setUp() {
        homePage = openHomePage();
    }
//should check if user after login see the page which is viewable before log out.
    @Test
    private void shouldLogInto(){
        mainPage = homePage.logInto();
        mainPage.AmIinProperPlace();
        assertEquals(mainPage.getMainPageURL(), baseUrl);
        assertEquals(mainPage.getMainPageFirstHeader(), expectedMainPageFirstHeader);
        mainPage.areMenuBarElementsClickable();
        mainPage.checkIfPagesChangesByClickingOnMenuBarElements();





    }

    @AfterClass
    private void tearDown(){
        close();
    }
}

