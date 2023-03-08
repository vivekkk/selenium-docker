import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FlightBooking;
import pages.RegistrationConfirmation;
import pages.UserRegistrationPage;

import java.net.MalformedURLException;
import java.util.HashMap;

public class FlibhtBookingTest  extends  BaseTest {

    UserRegistrationPage userRegistrationPage;
    RegistrationConfirmation registrationConfirmation;
    FlightBooking flightBooking;


    @Test(dataProvider = "dp1")

    public void testUserRegistration(HashMap<String, HashMap<String, String>> hash) throws InterruptedException, MalformedURLException {

        userRegistrationPage = new UserRegistrationPage(driver);
        userRegistrationPage.getURL(driver);
        userRegistrationPage.enterUserRegistrationDetails(hash);
        registrationConfirmation =userRegistrationPage.submit(driver);
        flightBooking = registrationConfirmation.clickFlightsLink(driver);
        Thread.sleep(5000);
        flightBooking.clickContBtn();
        System.out.println();
     //   BaseTest.getSessionid(driver);
    }


    @DataProvider(name="dp1")
    public Object[][] userFlightData() {
        HashMap<String,String> userRegistrationHash= new HashMap<>();
        userRegistrationHash.put("firstName", "Vivek");
        userRegistrationHash.put("lastname", "kaushik");
        userRegistrationHash.put("phone", "9717986");
        userRegistrationHash.put("username", "vivek");
        HashMap<String,String> mailingInfo= new HashMap<>();
        mailingInfo.put("address", "C2-708, 7 Hills");
        mailingInfo.put("city", "Hyderabad");
        mailingInfo.put("postalCode", "500089");
        mailingInfo.put("state", "Telangana");
        mailingInfo.put("country", "INDIA");
        HashMap<String,String> userInfo= new HashMap<>();
        userInfo.put("email","vivekkaushik@gmail.com");
        userInfo.put("password","abc@786");
        userInfo.put("password","abc@786");
     HashMap<String,HashMap<String, String>> userRegist = new HashMap<>();
     userRegist.put("contactInfo",userRegistrationHash);
     userRegist.put("mailingInformation",mailingInfo);
        userRegist.put("enteruserInfo",userInfo);

        Object[][] obj=new Object[1][1];
        obj[0][0]=userRegist;
        return obj;
    }
}