package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegistrationConfirmation {

    @FindBy(how= How.PARTIAL_LINK_TEXT, using = "Flights")
    private WebElement flightsLink;
    protected  boolean isDisplayed()
    {
  return  flightsLink.isDisplayed();
    }

    public  RegistrationConfirmation(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    public FlightBooking clickFlightsLink( WebDriver driver)
    {
        if(isDisplayed())
        {
            flightsLink.click();
            return new FlightBooking(driver);
        }
        else return null;
    }
}
