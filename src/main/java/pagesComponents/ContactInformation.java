package pagesComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;

public class ContactInformation  extends  MasterComponents{

    @FindBy(how = How.NAME, using ="firstName" )
    WebElement firstName;
    @FindBy(how = How.NAME, using ="lastName" )
    WebElement lastName;
    @FindBy(how = How.NAME, using ="phone" )
    WebElement phone;
    @FindBy(how = How.ID, using ="userName" )
    WebElement email;

    public  ContactInformation(WebDriver driver)
    {
        super(driver);
    }

    @Override
    boolean isDisplayed() {
       return this.wait.until((d) -> this.lastName.isDisplayed() );
    }

    public void enterContctInfo(HashMap<String,String> contact){
        this.firstName.sendKeys(contact.get("firstName"));
        this.lastName.sendKeys(contact.get("lastname"));
        this.phone.sendKeys(contact.get("phone"));
        this.email.sendKeys(contact.get("username"));
    }


}
