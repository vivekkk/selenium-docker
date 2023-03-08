package pagesComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;

public class Prefrences {

    @FindBy(how = How.CSS, using="input[value='Coach']")
    WebElement serClassEco;


    @FindBy(how = How.CSS, using="input[value='Business']")
    WebElement serClassBuss;

    @FindBy(how = How.CSS, using="input[value='First']")
    WebElement serClassFirst;

    @FindBy(how = How.NAME, using="airline")
    WebElement airlinedd;


    public  Prefrences(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }
    public  boolean  isDisplayed()
    {
         return this.serClassBuss.isDisplayed();
    }

    public void enterPrefData()
    {
        serClassBuss.click();
        Select select=new Select(this.airlinedd);
        select.selectByVisibleText("Blue Skies Airlines");
    }

}
