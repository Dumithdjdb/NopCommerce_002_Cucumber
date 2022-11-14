package StepDefinitions;

import POM.SearchCustomerPage;
import POM.loginPage;
import POM.AddCustomerPage;
import com.fasterxml.jackson.databind.ser.std.ClassSerializer;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Steps extends CommonSteps {

    //Setting up the browser, initiate the logins in this method
    @Before //Cucumber Hook -Will only execute only 1 time
    public void setup() throws IOException {

        //Reading properties file
        configProp=new Properties();
        FileInputStream configPropFile=new FileInputStream("config.properties");
        configProp.load(configPropFile);

        //initiate the log4J
        logger= Logger.getLogger("nopCommnerce"); //Added Logger
        PropertyConfigurator.configure("log4j.properties");
        //initiate the browser

        String br=configProp.getProperty("browser");

        if (br.equals("chrome")){
            System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
            driver=new ChromeDriver();
        }
        else if (br.equals("edge")){
            System.setProperty("webdriver.edge.driver",configProp.getProperty("edgepath"));
            driver=new EdgeDriver();
        }
        logger.info("***Launching the Browser**");

        }

    @Given("User launches the chrome browser")
    public void user_launches_the_chrome_browser() {


        //Creating the objects from the POM classes to use
        lp=new loginPage(driver);
        pgaddCustomer= new AddCustomerPage(driver);
        pgSearchCustomer =new SearchCustomerPage(driver);

    }
    @When("User opens the URL {string}")
    public void user_opens_the_url(String url) {
        logger.info("***Launching the URL**");
        driver.get(url);
        driver.manage().window().maximize();

    }
    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String pwd) throws InterruptedException {
        logger.info("***Providing the user info given by the user**");
        lp.setUserName(email);
        lp.setPassword(pwd);
        Thread.sleep(1000);
    }
    @When("Clicks on Login")
    public void clicks_on_login() throws InterruptedException {
        logger.info("***Clicked the login button**");
        lp.clickLogin();
        Thread.sleep(3000);

    }
    @Then("page title should be {string}")
    public void page_title_should_be(String title) throws InterruptedException {
        if(driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again."))
        {
            driver.close();
            Assert.assertTrue(false);
            logger.info("***Login is unsuccessful**");
        } else{
            Assert.assertEquals(title,driver.getTitle());
            logger.info("***Login Successful**");
        }
        Thread.sleep(3000);
    }
    @When("User clicks the log out link")
    public void user_clicks_the_log_out_link() throws InterruptedException {
        lp.clicklogout();
        Thread.sleep(3000);
        logger.info("***Logout unsuccessful**");

    }
    @Then("Close the browser")
    public void close_browser() {
        driver.close();
    }

    //Customer Add Step Definitions

    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        Assert.assertEquals("Dashboard / nopCommerce administration",pgaddCustomer.getPageTitle());
    }
    @When("User clicks the CustomerMenu")
    public void user_clicks_the_customer_menu() throws InterruptedException {
        Thread.sleep(3000);
        pgaddCustomer.clickOnCustomerMenu();
    }
    @When("User clicks the CustomerMenuIcon")
    public void user_clicks_the_customer_menu_icon() throws InterruptedException {
        Thread.sleep(2000);
        pgaddCustomer.clickOnCustomerMenuItem();
    }
    @When("Click on Add New Button")
    public void click_on_add_new_button() throws InterruptedException {
        Thread.sleep(2000);
        logger.info("***Adding Customer**");
        pgaddCustomer.clickAddNewCustomer();

    }
    @Then("User can view Add New Customer page")
    public void user_can_view_add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration",pgaddCustomer.getPageTitle());
    }
    @When("User enters the customer info")
    public void user_enteres_the_customer_info() {
        logger.info("***Provding the details**");
        String email=randomstring()+"@gmail.com";
       pgaddCustomer.setEmail(email);
       pgaddCustomer.setPassword("test123");
       pgaddCustomer.setFirstName("ABC");
       pgaddCustomer.setLastName("DEF");
       pgaddCustomer.setDOB("11/11/2010");
       pgaddCustomer.setGender("Male");
       pgaddCustomer.setCompanyName("Cool");
       pgaddCustomer.setTaxExempt();
       //pgaddCustomer.setTxtNewsLetter("Your Store Name");
       //pgaddCustomer.setCustomerRole("Guest");
       pgaddCustomer.setActive();


    }
    @When("Click on Save button")
    public void click_on_save_button() throws InterruptedException {
        logger.info("***Saving the customer info**");
        pgaddCustomer.clickSave();
        Thread.sleep(3000);
    }
    @Then("User can view the Confirmation message {string}")
    public void user_can_view_the_confirmation_message(String msg) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText()
                .contains("The new customer has been added successfully."));

    }

    //Steps for Enter Search
    @When("Enter Customer Email")
    public void enter_customer_email() {
        pgSearchCustomer.setEmail("victoria_victoria@nopCommerce.com");

    }


    @When("Click on the Search button")
    public void click_on_the_search_button() throws InterruptedException {
        pgSearchCustomer.clickSearch();
        Thread.sleep(3000);
    }
    @Then("User should find the customer email on the table")
    public void user_should_find_the_customer_email_on_the_table() {
        boolean status=pgSearchCustomer.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
        Assert.assertEquals(true,status);
    }
}
