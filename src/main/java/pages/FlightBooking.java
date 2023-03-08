package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pagesComponents.FlightDetails;
import pagesComponents.Prefrences;

import java.util.HashMap;

public class FlightBooking {

    private FlightDetails flightDetails;
    private Prefrences prefrences;

    @FindBy(how= How.NAME,using = "findFlights")
    WebElement contbtn;

   public FlightBooking (WebDriver driver)
   {
       PageFactory.initElements(driver, this);
       flightDetails=new FlightDetails(driver);
       prefrences=new Prefrences(driver);


   }

   public void clickContBtn() {
       if (contbtn.isDisplayed()) {
           contbtn.click();
       }
   }
   public void enterFlightBookingdetails(HashMap<String, String> flightBooking)
   {
    flightDetails.enterflightDetails(flightBooking);
    prefrences.enterPrefData();

   }


}
