package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private WebDriver driver;
    private ElementUtil elementUtil;
    // 1. capture elements on the page
    // Object repository
    private By logo = By.xpath("//img[@alt='nopCommerce demo store']");
    private By registerLink = By.linkText("Register");
    private By loginLink = By.linkText("Log in");
    private By wishlistLink = By.linkText("Wishlist");
    private By myAccountLink =By.linkText("My account");
   // private By logoutLink=By.linkText("Log out");
    private By logoutLink=By.xpath("//div[@class='header-links']/ul/li/a[text()='Log out']");
    private By searchField=By.name("q");
    private By searchBtn=By.xpath("//input[@value='Search']");

    // 2. Constructor
    public HomePage(WebDriver driver) {
        this.driver=driver;
        elementUtil=new ElementUtil(driver);
    }

    // 3. actions we can perform on the elements
    // return the elements, and test/assertion it in test class
    public String getPageTitle() {
        return driver.getTitle();
    }
    public boolean verifyLogo() {
       // return driver.findElement(logo).isDisplayed();
        return elementUtil.doIsDisplayed(logo);
    }
    public boolean verifyRegisterLink() {
        //return driver.findElement(registerLink).isDisplayed();
        return elementUtil.doIsDisplayed(registerLink);

    }
    public boolean verifyLoginLink() {
        //return driver.findElement(loginLink).isDisplayed();
        return elementUtil.doIsDisplayed(loginLink);
    }
    public boolean verifyWishlistLink() {
        //return driver.findElement(wishlistLink).isDisplayed();
        return elementUtil.doIsDisplayed(wishlistLink);
    }
    public boolean verifyMyAccountLink() {
        //return driver.findElement(myAccountLink).isDisplayed();
        return elementUtil.doIsDisplayed(myAccountLink);
    }
    public boolean verifyLogoutLink() {
        return elementUtil.doIsDisplayed(logoutLink);
    }
     public void doLogout() {
        //driver.findElement(logoutLink).click();
        elementUtil.doClick(logoutLink);
    }

    public RegisterPage goToRegisterPage() {
       // driver.findElement(registerLink).click();
        elementUtil.doClick(registerLink);
        return new RegisterPage(driver);
    }
    public LoginPage goToLoginPage() {
        //driver.findElement(loginLink).click();
        elementUtil.doClick(loginLink);
        return new LoginPage(driver);
    }

    public SearchPage doSearch(String keyword) {
        elementUtil.doSendKeys(searchField,keyword);
        elementUtil.doClick(searchBtn);
        return new SearchPage(driver);
    }


}
