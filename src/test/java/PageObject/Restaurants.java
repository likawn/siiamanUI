package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.Find;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.lang.Object;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;


public class Restaurants {

    private SelenideElement numOfRestaurants = $x( "//*[@class = 'value shadow']");
    private ElementsCollection restaurantsList = $$x("//*[@class ='ui divided items']/div");
    private SelenideElement popularityFilter = $x( "//*[@class='grouped fields']//div[2]//label");
    private SelenideElement filterButton = $x( "//*[@class='ui fluid button']");
    private ElementsCollection numOfOrdersInfo = $$x("//*[@class ='ui divided items']/div//*[@class='shopping basket  icon']");


    /**
     * checks if counter works correctly -
     * firstly gets text from counter and changes data type from string to integer,
     * finally checks if list of restaurants has size equal to value declared in the counter
     *
     * @return integer
     */

    public int getNumOfRestaurants() {
        int intNumOfDisplayedRestaurants = Integer.valueOf(numOfRestaurants.text());
        restaurantsList.shouldHaveSize(intNumOfDisplayedRestaurants);
        return intNumOfDisplayedRestaurants;
    }

   /* Not finished yet.

   public void checkifclickable(){

        ArrayList a = (ArrayList) numOfOrdersInfo.texts();

        for (int i=0; i<numOfOrdersInfo.size(); i++){
            a[i].remove(0, 25);

        }

        popularityFilter.click();
        filterButton.click();

    }
    */


}
