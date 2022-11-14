package POM;

import Utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchCustomerPage {
    public WebDriver ldriver;

    WaitHelper waithelper;

    public SearchCustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(ldriver, this);
        waithelper = new WaitHelper(ldriver);
    }

    @FindBy(how = How.ID, using = "SearchEmail")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(how = How.ID, using = "SearchFirstName")
    @CacheLookup
    WebElement txtFirstName;

    @FindBy(how = How.ID, using = "SearchLastName")
    @CacheLookup
    WebElement txtFLastName;

    @FindBy(how = How.ID, using = "SearchMonthOfBirth")
    @CacheLookup
    WebElement drpMonthOfBirth;

    @FindBy(how = How.ID, using = "SearchDayOfBirth")
    @CacheLookup
    WebElement drpDayOfBirth;

    @FindBy(how = How.ID, using = "search-customers")
    @CacheLookup
    WebElement btnSearch;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']")
    @CacheLookup
    WebElement table;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
    List<WebElement> tableColumns;

    public void setEmail(String email) {
        waithelper.waitForElement(txtEmail, 10);
        txtEmail.clear();
        txtEmail.sendKeys(email);
    }

    public void setFirstName(String firstName) {
        waithelper.waitForElement(txtEmail, 10);
        txtFirstName.clear();
        txtFirstName.sendKeys(firstName);
    }

    public void clickSearch() {
        waithelper.waitForElement(btnSearch, 10);
        btnSearch.click();
    }

    public int getNoOfRows() {
        return tableRows.size();
    }

    public int getNoOfColumns() {
        return tableColumns.size();
    }

    public boolean searchCustomerByEmail(String email) {
        boolean flag = false;
        for (int i = 1; i <= getNoOfRows(); i++) {
            String emailID = table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println(emailID);
            if (emailID.equals(email)) {
                flag = true;
            }

        }
        return flag;
    }
}


