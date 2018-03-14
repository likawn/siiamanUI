package Tests;

import PageObject.HomePage;
import PageObject.RegisterPage;
import PageObject.SetUp;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static TemporaryDataProvider.TemporaryDataProvider.registerPageHeader;
import static org.testng.AssertJUnit.assertEquals;

//
//Navigates from Home Page to Register Page and checks if proper header is displayed.
//
public class DemoPageTest extends SetUp {

    private HomePage homePage;
    private RegisterPage registerPage;


    @BeforeClass
    private void setUp() {
        homePage = openHomePage();
    }

    @Test
    private void shouldGotoRegisterPage() {
        registerPage = homePage.followRegisterLink();
        assertEquals(registerPage.getHeader(), registerPageHeader);
    }

    @AfterClass
    private void tearDown() {
//        close();
    }
}

