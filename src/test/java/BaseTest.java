import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.function.Function;

public class BaseTest {

    public  WebDriver driver;
    protected Function<String,ChromeOptions> chrome =(d)-> new ChromeOptions();
    protected Function<String, FirefoxOptions> firefox =(d)-> new FirefoxOptions();
    public MutableCapabilities returnBrowserOptions (String browserName)
    {
      if(browserName.equals("chrome"))
      {
          System.out.println("Initialized the chrome caps");
          return  chrome.apply("chrome");

      }else if(browserName.equals("firefox"))
      {
          System.out.println("Initialized the chrome caps");
          return  firefox.apply("firefox");
      }

        return null;
    }
    @BeforeTest
    //@Parameters({"keyword"})
    public void initiateWebdriver(ITestContext ctx) throws MalformedURLException {
        System.out.println("I am in Base class");
        String host = "localhost";
        MutableCapabilities dc;

        if(System.getProperty("BROWSER") != null &&
                System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = new FirefoxOptions();
        }else{
            dc = new ChromeOptions();
        }

        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://" + host + ":4444/wd/hub";
        dc.setCapability("name", testName);
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);

       /* DefaultDriverFactory defaultDriverFactory = new DefaultDriverFactory(Platform.WINDOWS);
        TemporaryFilesystem temporaryFilesystem = TemporaryFilesystem.getDefaultTmpFS();
        ChromeOptions chromeOptions = new ChromeOptions();
        Session session = DefaultSession.createSession(defaultDriverFactory, temporaryFilesystem, chromeOptions);
        WebDriver webDriver = session.getDriver();
        SessionId sessionId = session.getSessionId();*/

    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }


    public static SessionId getSessionid(WebDriver driver) {
        SessionId s= ((ChromeDriver)driver).getSessionId();
        return s;
    }
}
