package pagesComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class MailingInformation extends  MasterComponents{
    @FindBy(how = How.NAME, using ="address1" )
    WebElement address;

    @FindBy(how = How.NAME, using ="city" )
    WebElement city;

    @FindBy(how = How.NAME, using ="state" )
    WebElement state;
    @FindBy(how = How.NAME, using ="postalCode" )
    WebElement postalcode;

    @FindBy(how = How.NAME, using ="country" )
    WebElement countrydd;

   public MailingInformation(WebDriver driver) {
        super(driver);
    }

    @Override
    boolean isDisplayed() {
        return this.wait.until((d)->city.isDisplayed());
    }

    public  void enterMailingInformation(HashMap<String, String > mail)
    {
        this.address.sendKeys(mail.get("address"));
        this.city.sendKeys(mail.get("city"));
        this.postalcode.sendKeys(mail.get("postalCode"));
        this.state.sendKeys(mail.get("state"));
        Select select=new Select(countrydd);
        select.selectByVisibleText(mail.get("country"));

    }


}
