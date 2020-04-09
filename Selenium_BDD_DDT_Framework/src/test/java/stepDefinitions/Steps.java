package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import io.cucumber.java.sl.In;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Steps extends BaseClass {

    @Before
    public void setup() throws IOException
    {
        //Reading properties
        configProp = new Properties();
        FileInputStream configPropFile = new FileInputStream("config.properties");
        configProp.load(configPropFile);

        String br=configProp.getProperty("browser");

        if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver",configProp.getProperty("firefoxpath"));
            driver = new FirefoxDriver();
        }

        else if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",configProp.getProperty("chromepath"));
            driver = new ChromeDriver();
        }

        else if (br.equals("ie")) {
            System.setProperty("webdriver.ie.driver",configProp.getProperty("iepath"));
            driver = new InternetExplorerDriver();
        }

        logger = Logger.getLogger("Cucumber_Project_2"); //Added logger
        PropertyConfigurator.configure("log4j.properties");

        System.setProperty("webdriver.chrome.driver", "D://Education//nopCommerceV001_Cucumber//Drivers//chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Given("User Launch Chrome Browser")
    public void user_Launch_Chrome_Browser() {
        logger.info("***************Launching browser****************");
        lp = new LoginPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_URL(String url) throws InterruptedException {
        logger.info("***************Opening URL****************");
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User enters Email as {string} and Password as {string}")
    public void user_enters_Email_as_and_Password_as(String email, String password) {
        //lp = new LoginPage(driver);
        logger.info("***************Providing login details****************");
        lp.setUserName(email);
        lp.setPassword(password);

    }

    @And("click on Login")
    public void click_on_Login() throws InterruptedException {
        logger.info("***************Started login****************");
        lp.clickLogin();
        Thread.sleep(3000);
    }

    @Then("Page Title after login should be {string}")
    public void page_Title_after_login_should_be(String title) {
        if (driver.getPageSource().contains("Login was unsuccessful.")) {
            driver.close();
            logger.info("***************Login failed****************");
            Assert.assertTrue(false);
        } else {
            logger.info("***************Login passed****************");
            Assert.assertEquals(title, driver.getTitle());
        }

    }

    @When("User click on Log out link")
    public void user_click_on_Log_out_link() throws InterruptedException {
        logger.info("***************Opening URL****************");
        lp.clickLogout();
        Thread.sleep(3000);
    }

    @Then("Page Title after logout should be {string}")
    public void page_Title_after_logout_should_be(String title) {
        if (driver.getPageSource().contains("Logout was unsuccessful.")) {
            logger.info("***************Verifying Logout****************");
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }

    }

    @And("close browser")
    public void close_browser() {
        logger.info("***************Closing browser****************");
        driver.quit();
    }

    //Customer feature step definitions........................................................

    @Then("User can view Dashboard")
    public void user_can_view_Dashboard() throws InterruptedException {
        addCust = new AddcustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
        Thread.sleep(3000);
    }

    @When("User click on customers Menu")
    public void user_click_on_customers_Menu() throws InterruptedException {
        addCust.clickOnCustomersMenu();
        Thread.sleep(3000);
    }

    @When("click on customers Menu Item")
    public void click_on_customers_Menu_Item() throws InterruptedException {
        addCust.clickOnCustomersMenuItem();
        Thread.sleep(3000);
    }

    @When("click on Add new button")
    public void click_on_Add_new_button() throws InterruptedException {
        addCust.clickOnAddnew();
        Thread.sleep(2000);
    }

    @Then("User can view Add new customer page")
    public void user_can_view_Add_new_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
    }

    @When("User enter customer info")
    public void user_enter_customer_info() throws InterruptedException {

        logger.info("***************Adding new customer****************");
        logger.info("***************Providing customer details****************");
        String email = randomestring() + "@gmail.com";
        addCust.setEmail(email);
        addCust.setPassword("test123");
        //Add customer role as guest
        Thread.sleep(2000);
        addCust.setCustomerRoles("Guests");
        Thread.sleep(3000);

        addCust.setManagerOfVendor("Vendor 2");
        addCust.setGender("Male");
        addCust.setFirstName("akshay");
        addCust.setLastName("mungekar");
        addCust.setDob("6/20/1995"); // Format : M/DD/YYYY
        addCust.setCompanyName("TciTech");
        addCust.setAdminContent("This is for testing this web app.....");

    }

    @When("click on Save button")
    public void click_on_Save_button() throws InterruptedException {

        logger.info("***************Saving customer data****************");
        addCust.clickOnSave();
        Thread.sleep(2000);
    }

    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
    }


    //Steps for searching a customer using email-id......................................................................
    @When("Enter customer EMail")
    public void enter_customer_EMail() {

        logger.info("***************Searching a customer by Email id****************");
        searchCust = new SearchCustomerPage(driver);
        searchCust.setEmail("victoria_victoria@nopCommerce.com");
    }

    @When("Click on search button")
    public void click_on_search_button() throws InterruptedException {
        searchCust.clickSearch();
        Thread.sleep(3000);
    }

    @Then("User should found Email in the Search table")
    public void user_should_found_Email_in_the_Search_table() {
        boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");

        Assert.assertEquals(true, status);
    }

    //Steps for searching a customer using first and last name......................................................................

    @And("Enter customer FirstName")
    public void enter_customer_FirstName() {

        logger.info("***************Searching a customer by Name****************");
        searchCust = new SearchCustomerPage(driver);
        searchCust.setFirstName("Victoria");
    }

    @And("Enter customer LastName")
    public void enter_customer_LastName() {
        searchCust.setLastName("Terces");
    }

    @And("User should found Name in the Search table")
    public void user_should_found_Name_in_the_Search_table() {
        boolean status = searchCust.searchustomerByName("Victoria Terces");
        Assert.assertEquals(true, status);
    }


}