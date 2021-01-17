package com.nopcommerce.tests;

import com.nopcommerce.base.BaseTest;
import com.nopcommerce.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {
    @BeforeClass
    public void loginPageSetup() {
        loginPage = homePage.goToLoginPage();
    }
    @Test(priority = 1)
    public void verifyLoginPageNameTest() throws InterruptedException {
        Thread.sleep(2000);
        String pageName= loginPage.getLoginPageName();
        System.out.println(pageName);
        Assert.assertEquals(pageName, Constants.LOGIN_PAGE_NAME,"Page name does not match.");
    }
    @Test(priority = 2)
    public void verifyLoginBtnStatusTest() {
        Assert.assertTrue(loginPage.verifyLoginBtn(),"Login button is not available.");
    }
    @Test(priority = 3)
    public void verifyRegisterBtnStatusTest() {
        Assert.assertTrue(loginPage.verifyRegisterBtn(),"Register button is not available.");
    }
    @Test(priority = 4)
    public void validateUserLoginTest() {
        loginPage.doLogin(prop.getProperty("id"),prop.getProperty("pass"));
        Assert.assertTrue(homePage.verifyMyAccountLink(),"Login failed, Logout link can't be verified.");
    }
    @Test(priority = 5)
    public void logoutTest() {
        homePage.doLogout();
        Assert.assertTrue(homePage.verifyLoginLink(),"Log out failed, login link can't be verified.");
    }






}
