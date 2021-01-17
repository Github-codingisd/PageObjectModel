package com.nopcommerce.pages;

import com.nopcommerce.base.BasePage;
import com.nopcommerce.utils.Constants;
import com.nopcommerce.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage {

    private WebDriver driver;
    private ElementUtil elementUtil;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private By searchPageName = By.xpath("//div[@class='page-title']/h1");
    private By searchPageSearchField = By.id("q");
    private By advancedSearchCheckBox = By.id("adv");
    private By categoryDropDownList = By.id("cid");
    private By autoSearchCheckBox = By.id("isc");
    private By manufacturerDropDownList = By.id("mid");
    private By searchInProductCheckBox = By.id("sid");
    private By categoriesList = By.xpath("//div[@class='side-2']/div[1]/div[2]/descendant::a");
    private By manufacturersList = By.xpath("//div[@class='side-2']/div[2]/div[2]/descendant::a");

    public String getSearchPageName() {
        return elementUtil.doGetText(searchPageName);
    }

    public boolean verifyManufacturerDropDownList() {
        elementUtil.waitForElementsPresent(advancedSearchCheckBox,5);
        elementUtil.doClick(advancedSearchCheckBox);
        elementUtil.waitForElementsPresent(manufacturerDropDownList,5);
        return elementUtil.compareDropDownOptions(manufacturerDropDownList, Constants.MANUFACTURER_DROPDOWN);
    }
    public List<String> getManufactureListItems() {
        List<String> manufactureList=new ArrayList<String>();
        List<WebElement> manufactureListElements=elementUtil.getElements(manufacturersList);
        for(WebElement e:manufactureListElements) {
            manufactureList.add(e.getText());
        }
        return manufactureList;
    }



}
