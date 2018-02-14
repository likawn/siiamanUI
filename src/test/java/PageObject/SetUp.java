package PageObject;

import static TemporaryDataProvider.TemporaryDataProvider.expectedUrl;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by cm on 2017-12-11.
 */
public class SetUp {

    /**
     * Opens local project homepage
     * @return HomePage
     */
    public HomePage openHomePage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        System.setProperty("selenide.browser", "Chrome");
        baseUrl = "http://localhost:8080/siiamanTest/";
        open(baseUrl);
        assertEquals(url(), expectedUrl);
        return new HomePage();
    }
}
