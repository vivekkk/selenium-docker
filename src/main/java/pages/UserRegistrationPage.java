package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import pagesComponents.ContactInformation;
import pagesComponents.MailingInformation;
import pagesComponents.UserInformation;

import java.util.HashMap;

public class UserRegistrationPage {
    public ContactInformation contactInformation;
    public MailingInformation mailingInformation;
    public UserInformation userInformation;

    @FindBy(how= How.NAME, using="register")
    WebElement registerBtn;


    public UserRegistrationPage(WebDriver driver)
    {
        this.contactInformation=new ContactInformation(driver);
        this.mailingInformation=new MailingInformation(driver);
        this.userInformation=new UserInformation(driver);
        PageFactory.initElements(driver, this);
    }
    public void  getURL(WebDriver driver)
    {
    driver.get("https://vins-udemy.s3.amazonaws.com/docker/docker-book-flight.html");
    }
    public RegistrationConfirmation submit(WebDriver driver)
    {
        registerBtn.click();
        return new RegistrationConfirmation(driver);
    }
    public void enterUserRegistrationDetails(HashMap<String, HashMap<String,String>> registerMap)
    {
        contactInformation.enterContctInfo(registerMap.get("contactInfo"));
        mailingInformation.enterMailingInformation(registerMap.get("mailingInformation"));
        userInformation.enterUserInformation(registerMap.get("enteruserInfo"));


    }


}
