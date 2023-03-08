package pagesComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class FlightDetails extends MasterComponents{

    @FindBy(how = How.CSS ,using ="input[value='roundtrip']" )
    WebElement roundTrip;
    @FindBy(how = How.CSS, using ="input[value='oneway']" )
    WebElement oneWay;
    @FindBy(how = How.ID, using ="passCount" )
    WebElement passengerdd;

    @FindBy(how=How.NAME, using = "fromMonth")
    WebElement fromMonthdd;

    @FindBy(how=How.NAME, using = "fromDay")
    WebElement fromDaydd;

    @FindBy(how = How.NAME, using ="toPort" )
    WebElement arrivingIndd;

    @FindBy(how=How.NAME, using="toDay")
    WebElement toMonthdd;
    @FindBy(how=How.NAME, using="toMonth")
    WebElement toDaydd;
    @FindBy(how = How.NAME, using ="fromPort" )
    WebElement departingFromdd;




   public FlightDetails(WebDriver driver) {
        super(driver);
    }

    public  void enterflightDetails(HashMap<String, String> flightDetails)
    {
        this.roundTrip.click();
        getselectdd(this.passengerdd).selectByValue(flightDetails.get("passanger"));
        getselectdd(this.fromMonthdd).selectByValue(flightDetails.get("fromMonth"));
        getselectdd(this.fromDaydd).selectByValue(flightDetails.get("fromDay"));
        getselectdd(this.arrivingIndd).selectByValue(flightDetails.get("arrivingInn"));
        getselectdd(this.toMonthdd).selectByValue(flightDetails.get("toMonth"));
        getselectdd(this.toDaydd).selectByValue(flightDetails.get("toDay"));
        getselectdd(this.departingFromdd).selectByValue(flightDetails.get("departingFrom"));
    }

    private Select getselectdd(WebElement ele)
    {
        Select select=new Select(ele);
        return  select;

    }

    @Override
    boolean isDisplayed() {
        return false;
    }
}
