package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver ldriver;

    public LoginPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "Email")
    @CacheLookup
    WebElement txtEmail;

    @FindBy(id = "Password")
    @CacheLookup
    WebElement txtPassword;

    @FindBy(xpath = "//input[@class='button-1 login-button']")
    @CacheLookup
    WebElement btnLogin;

    @FindBy(css = "body.skin-blue.sidebar-mini:nth-child(2) div.wrapper:nth-child(3) div.main-header div.navbar.navbar-static-top div.navbar-custom-menu ul.nav.navbar-nav li:nth-child(3) > a:nth-child(1)")
    @CacheLookup
    WebElement lnkLogout;

    public void setUserName(String email) {
        txtEmail.clear();
        txtEmail.sendKeys(email);

    }

    public void setPassword(String pwd) {
        txtPassword.clear();
        txtPassword.sendKeys(pwd);
    }

    public void clickLogin() {
        btnLogin.click();
    }

    public void clickLogout() {
        lnkLogout.click();
    }

}