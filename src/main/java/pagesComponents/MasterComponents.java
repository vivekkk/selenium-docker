package pagesComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class MasterComponents {


    public WebDriverWait wait;

     MasterComponents(WebDriver driver)
    {
if(driver==null)
{
 System.out.println("driver is null");
}
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }



    abstract   boolean isDisplayed();
}
