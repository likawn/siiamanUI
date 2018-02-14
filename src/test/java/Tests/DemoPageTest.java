package Tests;

import PageObject.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static TemporaryDataProvider.TemporaryDataProvider.homePageHeader;
import static TemporaryDataProvider.TemporaryDataProvider.registerPageHeader;
import static Tools.AlphabeticalStringListComparator.compareTwoStringLists;
import static com.codeborne.selenide.Selenide.close;
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
        close();
    }
}

