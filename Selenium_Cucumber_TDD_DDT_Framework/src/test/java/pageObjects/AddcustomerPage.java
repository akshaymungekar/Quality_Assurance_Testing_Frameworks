package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;

public class AddcustomerPage {

    public WebDriver ldriver;

    public AddcustomerPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    By lnkCustomers_menu = By.xpath("//body[@class='skin-blue sidebar-mini']/div[@class='wrapper']/div[@class='main-sidebar']/div[@class='sidebar']/ul[@class='sidebar-menu tree']/li[4]/a[1]");
    By lnkCustomers_menuitem = By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/span[1]");

    By btnAddnew = By.xpath("/html[1]/body[1]/div[3]/div[3]/div[1]/form[1]/div[1]/div[1]/a[1]");

    By txtEmail = By.xpath("//input[@id='Email']");
    By txtPassword = By.xpath("//input[@id='Password']");

    By txtcustomerRoles = By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

    By lstitemAdministrators = By.xpath("//span[contains(text(),'Administrators')]");
    By lstitemRegistered = By.xpath("//li[@class='k-button']//span[contains(text(),'Registered')]");
    By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
    By lstitemVendors = By.xpath("//li[@class='k-button']//span[contains(text(),'Vendors')]");

    By drpmgrOfVendor = By.xpath("//select[@id='VendorId']");
    By rdMaleGender = By.id("Gender_Male");
    By rdFemaleGender = By.id("Gender_Female");

    By txtFirstName = By.xpath("//input[@id='FirstName']");
    By txtLastName = By.xpath("//input[@id='LastName']");

    By txtDob = By.xpath("//input[@id='DateOfBirth']");

    By txtCompanyName = By.xpath("//input[@id='Company']");

    By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");

    By btnSave = By.xpath("//button[@name='save']");

    //Actions Methods

    public String getPageTitle()
    {
        return ldriver.getTitle();
    }

    public void clickOnCustomersMenu() {
        ldriver.findElement(lnkCustomers_menu).click();
    }

    public void clickOnCustomersMenuItem() {
        ldriver.findElement(lnkCustomers_menuitem).click();
    }

    public void clickOnAddnew() {
        ldriver.findElement(btnAddnew).click();
    }

    public void setEmail(String email) {
        ldriver.findElement(txtEmail).sendKeys(email);
    }

    public void setPassword(String password) {
        ldriver.findElement(txtPassword).sendKeys(password);
    }

    public void setCustomerRoles(String role) throws InterruptedException {
        if (role.equals("Guests")) {
            ldriver.findElement(By.xpath("//span[@class='k-icon k-delete']")).click();
        }

        ldriver.findElement(txtcustomerRoles).click();

        WebElement listitem;

        Thread.sleep(4000);

        if (role.equals("Administrators")) {
            listitem = ldriver.findElement(lstitemAdministrators);
        } else if (role.equals("Guests")) {
            listitem = ldriver.findElement(lstitemGuests);
        } else if (role.equals("Registered")) {
            listitem = ldriver.findElement(lstitemRegistered);
        } else if (role.equals("Vendors")) {
            listitem = ldriver.findElement(lstitemVendors);
        } else {
            listitem = ldriver.findElement(lstitemGuests);
        }
        listitem.click();
        Thread.sleep(3000);
    }


    //JavascriptExecutor js = (JavascriptExecutor) ldriver;
    //js.executeScript("arguments[0].click();",listitem);

    public void setManagerOfVendor(String value) {
        Select drp = new Select(ldriver.findElement(drpmgrOfVendor));
        drp.selectByVisibleText(value);
    }

    public void setGender(String gender) {
        if (gender.equals("Male")) {
            ldriver.findElement(rdMaleGender).click();
        } else if (gender.equals("Female")) {
            ldriver.findElement(rdFemaleGender).click();
        } else {
            ldriver.findElement(rdMaleGender).click(); //Default
        }
    }

    public void setFirstName(String fname) {
        ldriver.findElement(txtFirstName).sendKeys(fname);
    }

    public void setLastName(String lname) {
        ldriver.findElement(txtLastName).sendKeys(lname);
    }

    public void setDob(String dob) {
        ldriver.findElement(txtDob).sendKeys(dob);
    }

    public void setCompanyName(String comname) {
        ldriver.findElement(txtCompanyName).sendKeys(comname);
    }

    public void setAdminContent(String content) {
        ldriver.findElement(txtAdminContent).sendKeys(content);
    }

    public void clickOnSave() {
        ldriver.findElement(btnSave).click();
    }
}



