package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {

        super(driver);
    }

    @FindBy(xpath = "//div[@id='cbx-combo-1031-trigger-picker']")
    WebElement clickDropdown;

    @FindBy(xpath = "//ul[@id='cbx-combo-1031-picker-listEl']//div")
    List<WebElement> distance;

    @FindBy(xpath = "//input[@id='cbx-suggest-1022-inputEl']")
    List<WebElement> venueSearchBox1; // Search Box on SearchPageResults, I unable to validate venueName in this searchbox (Hold)

    @FindBy(xpath = "//input[@id='cbx-suggest-1022-inputEl']")
    WebElement venueSearchBox2; // Search Box on SearchPageResults, I unable to validate venueName in this searchbox (Hold)

    @FindBy(xpath = "//div[@class='x-grid-item-container']") //table xpath
    WebElement table;// To get the venue data from Webtable

    @FindBy(xpath = "//img[@class='jn-w-20 cbx-action']")// it shows & get 1 of 1 venue list
    WebElement clickVenueLogo;

    @FindBy(xpath = "//div[@id='tbtext-1064']")// Displaying text message in "1 of 1 venue" from search list
    WebElement venueCounts;


    @FindBy(xpath = "//input[@id='cbx-combo-1024-inputEl']")
    WebElement placeActivityDropdown; //Place Activity Dropdown, Now not used this webelement maybe later we can use

    /* Unable to validate this method so I put on comment block & do it later(Unable to fix method)
     This method will validate the venue name in SearchPage from searchBox compared to list of matched venue found in SearchPage...

        public boolean isVenuesExist(){
            boolean flag = false;

            for (WebElement venue : venueSearchBox1) {
                String venueName = "venueName";
                if (venue.getAttribute("placeholder").equals(venueName)) {
                    //System.out.println(venue);
                    flag = true;
                    break;
                }
            }
            return flag;

        }
    */
    public void DistanceDropDown() {

        clickDropdown.click();
        String dd_value = "No Limits";

        for (WebElement webElement : distance) {
            //System.out.println(webElement.getText()); // if use this line code print all the dropdown values in cosole output
            if (webElement.getText().contains(dd_value)) {
                webElement.click();

            }

        }

    }
    public void isDisplayingOneofOneResult() {
        boolean displayed = venueCounts.isDisplayed();
        System.out.println("Displayed 1 of 1 venue status: " + displayed);


    }

    public VenueDetailPage isVenueDisplayed() {

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        //int size = rows.size(); // if use this line code get the row count & store the size variable
        //System.out.println("Venue Count " +size); // To print the venue count list in search page result
        boolean venueStatus = table.isDisplayed();
        System.out.println("Venue visible status in search page: " + venueStatus);

        String text = table.getText();
        System.out.println(text);

        clickVenueLogo.click();
        return new VenueDetailPage();


    }



}
