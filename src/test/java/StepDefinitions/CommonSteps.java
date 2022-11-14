package StepDefinitions;

import POM.AddCustomerPage;
import POM.SearchCustomerPage;
import POM.loginPage;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.apache.log4j.Logger;

import java.util.Properties;

public class CommonSteps {
    public WebDriver driver;
    public loginPage lp;
    public AddCustomerPage pgaddCustomer;
    public SearchCustomerPage pgSearchCustomer;
    public static Logger logger;
    public Properties configProp;


    //generating random string for unique emails IDs
    public static String randomstring(){
        String generatedString1= RandomStringUtils.randomAlphabetic(5);
        return (generatedString1);
    }
}
