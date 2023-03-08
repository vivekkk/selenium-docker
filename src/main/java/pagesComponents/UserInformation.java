package pagesComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;

public class UserInformation extends MasterComponents{

    @FindBy(how = How.NAME, using ="email" )
    WebElement userName;

    @FindBy(how = How.NAME, using ="password" )
    WebElement password;
    @FindBy(how = How.NAME, using ="confirmPassword" )
    WebElement confirmPassword;

   public UserInformation(WebDriver driver) {
        super(driver);
    }

    @Override
    boolean isDisplayed() {
        return this.wait.until((d)->userName.isDisplayed());
    }

    public void enterUserInformation(HashMap<String, String> hash)
    {
      userName.sendKeys(hash.get("email"));
      password.sendKeys(hash.get("password"));
      confirmPassword.sendKeys(hash.get("password"));

    }
}
