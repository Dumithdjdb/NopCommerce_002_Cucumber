package POM;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

    public WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver){
     ldriver=rdriver;
        PageFactory.initElements(ldriver,this);
    }
    By lnkCustomer_Menu=By.xpath("//a[@href='#']//i[@class='nav-icon far fa-user']");
    By linkCutomer_Menu_item=By.xpath("//a[@href='/Admin/Customer/List']");

    By linkAddNewCustomer=By.xpath("//a[@class='btn btn-primary']");

    By txtEmail=By.xpath("//input[@id='Email']");
    By txtPassword=By.xpath("//input[@id='Password']");
    By txtFN=By.xpath("//input[@id='FirstName']");
    By txtLN=By.xpath("//input[@id='LastName']");
    By rdoGenderMale=By.xpath("//input[@id='Gender_Male']");
    By rdoGenderFeMale=By.xpath("//input[@id='Gender_Female']");
    By txtDOB=By.xpath("//input[@id='DateOfBirth']");
    By txtCompany=By.xpath("//input[@id='Company']");
    By chkTaxExempt=By.xpath("//input[@id='IsTaxExempt']");

    By txtNewsLetter =By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']//ul[@id='SelectedNewsletterSubscriptionStoreIds_taglist']");
    By listitemNewsLetterYourStore=By.xpath("//option[@value='1'][contains(text(),'Your store name')]");
    By listitemNewsLetterTestStore=By.xpath("//option[@value='2'][contains(text(),'Test store 2')]");

    By txtCustomerRole=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']//ul[@id='SelectedCustomerRoleIds_taglist']");
    By listitemAdmin=By.xpath("//select[@id='SelectedCustomerRoleIds']//option[@value='1'][contains(text(),'Administrators')]");
    By listitemFormModerators=By.xpath("//select[@id='SelectedCustomerRoleIds']//option[@value='2'][contains(text(),'Forum Moderators')]");
    By listitemGuests=By.xpath("//select[@id='SelectedCustomerRoleIds']//option[@value='4'][contains(text(),'Guests')]");

    By checkActive=By.xpath("//input[@id='Active']");

    By btnSave=By.xpath("//button[@name='save']");

    //Action Methods

    public String getPageTitle(){
        return ldriver.getTitle();
    }

    public void clickOnCustomerMenu(){
        ldriver.findElement(lnkCustomer_Menu).click();
    }

    public void clickOnCustomerMenuItem(){
        ldriver.findElement(linkCutomer_Menu_item).click();
    }

    public void clickAddNewCustomer(){
        ldriver.findElement(linkAddNewCustomer).click();
    }

    public void setEmail(String email){
        ldriver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword (String password){
        ldriver.findElement(txtPassword).sendKeys(password);
    }

    public void setFirstName(String firstName){
        ldriver.findElement(txtFN).sendKeys(firstName);
    }
    public void setLastName(String lastName){
        ldriver.findElement(txtLN).sendKeys(lastName);
    }

    public void setGender(String gender){

        WebElement selectedGender;
        if (gender.equals("Male")) {
            selectedGender = ldriver.findElement(rdoGenderMale);
            selectedGender.click();

        }
        else if (gender.equals("Female")){
                selectedGender = ldriver.findElement(rdoGenderFeMale);
                selectedGender.click();
            }

        }



    public void setDOB(String dob){
        ldriver.findElement(txtDOB).sendKeys(dob);
    }

    public void setCompanyName(String compname){
        ldriver.findElement(txtCompany).sendKeys(compname);
    }

    public void setTaxExempt(){
        ldriver.findElement(chkTaxExempt).click();
    }

    public void setTxtNewsLetter(String newsletter){
        ldriver.findElement(txtNewsLetter).click();
         if (newsletter.equals("Your Store Name")){
            ldriver.findElement(listitemNewsLetterYourStore).click();
        }
         else if (newsletter.equals("Test store 2")){
             ldriver.findElement(listitemNewsLetterTestStore).click();
         }
    }

    public void setCustomerRole(String role){
        ldriver.findElement(txtCustomerRole).click();
        WebElement listitem;
        if (role.equals("Administrators")){
            listitem=ldriver.findElement(listitemAdmin);
            listitem.click();
        }
        else if(role.equals("Forum Moderators")){
            listitem=ldriver.findElement(listitemFormModerators);
            listitem.click();
        }
        else if(role.equals("Guests")){
            listitem=ldriver.findElement(listitemGuests);
            listitem.click();
        }

    }
    public void setActive() {
            ldriver.findElement(checkActive).click();
    }

    public void clickSave(){
            ldriver.findElement(btnSave).click();
    }
}
