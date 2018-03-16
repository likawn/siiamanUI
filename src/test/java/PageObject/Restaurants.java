package PageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.lang.String;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;
import static org.testng.Assert.assertEquals;

public class Restaurants {

    private SelenideElement numOfRestaurants = $x( "//*[@class = 'value shadow']");
    private ElementsCollection restaurantsList = $$x("//*[@class ='ui divided items']/div");
    private SelenideElement popularityFilter = $x( "//*[@class='grouped fields']//div[2]//label");
    private SelenideElement filterButton = $x( "//*[@class='ui fluid button']");
    private ElementsCollection numOfOrdersFullInfo = $$x("//*[@id='divAddRestaurantViewLine']/div/div/div[2]/div/table/tbody/tr[2]/td[2]/span");


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

    /**
     * That method should take values from website, sort them to create expected result, and after that click sorting button on website and compare lists. But it doesn't work, probably because replaceAll method is ignored.
     */
   public void checkIfSorted(){

         List <String> numOfOrdersFullInfoList = numOfOrdersFullInfo.texts();

        for (int i=0; i<numOfOrdersFullInfo.size(); i++)
            numOfOrdersFullInfoList.get(i).replaceAll("Ilość złożonych zamówień:", "");

       List <Double> numOfOrdersExpected = new ArrayList<>();

        for (int i=0; i<numOfOrdersFullInfo.size(); i++)
            numOfOrdersExpected.add(Double.valueOf(numOfOrdersFullInfoList.get(i)));

        numOfOrdersExpected.sort(Comparator.reverseOrder());


        popularityFilter.click();
        filterButton.click();

        List<String> numOfOrdersOrdered = numOfOrdersFullInfo.texts();


       for (int i=0; i<numOfOrdersFullInfo.size(); i++)
           numOfOrdersOrdered.get(i).replaceAll("Ilość złożonych zamówień:", "");

       List <Double> numOfOrdersOrderedInt = new ArrayList<>();

       for (int i=0; i<numOfOrdersFullInfo.size(); i++)
           numOfOrdersOrderedInt.add(Double.valueOf(numOfOrdersOrdered.get(i)));

       assertEquals(numOfOrdersExpected, numOfOrdersOrderedInt );



    }



}
