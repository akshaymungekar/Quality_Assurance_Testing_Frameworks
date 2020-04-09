package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

import java.util.Properties;

public class BaseClass {

    public static WebDriver driver;
    public static LoginPage lp;
    public static AddcustomerPage addCust;
    public static SearchCustomerPage searchCust;
    public static Logger logger;
    public static Properties configProp;

    public static WebDriverWait wait;
    public static WebElement element;


    public String randomestring() {
        String generatedstring = RandomStringUtils.randomAlphabetic(8);
        return (generatedstring);
    }

    public static String randomeNum() {
        String generatedString2 = RandomStringUtils.randomNumeric(4);
        return (generatedString2);
    }
}
