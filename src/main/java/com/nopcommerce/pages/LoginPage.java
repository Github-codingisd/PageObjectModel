package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;

    private By loginPageName= By.xpath("//div[@class='page-title']/h1");
    private By emailField=By.id("Email");
    private By passwordField=By.id("Password");
    private By loginBtn=By.xpath("//input[@value='Log in']");
    private By registerBtn=By.xpath("//input[@value='Register']");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
        elementUtil=new ElementUtil(driver);
    }

    public String getLoginPageName() {
       // return driver.findElement(loginPageName).getText();
        return elementUtil.doGetText(loginPageName);
    }
    public boolean verifyLoginBtn() {
       // return driver.findElement(loginBtn).isDisplayed();
        return elementUtil.doIsDisplayed(loginBtn);
    }
    public boolean verifyRegisterBtn() {
       // return driver.findElement(registerBtn).isDisplayed();
        return elementUtil.doIsDisplayed(registerBtn);
    }
    public HomePage doLogin(String userName, String password) {
       // driver.findElement(emailField).sendKeys(userName);
        elementUtil.doSendKeys(emailField,userName);
       // driver.findElement(passwordField).sendKeys(password);
        elementUtil.doSendKeys(passwordField,password);
       // driver.findElement(loginBtn).click();
        elementUtil.doClick(loginBtn);
        return new HomePage(driver);
    }

}
