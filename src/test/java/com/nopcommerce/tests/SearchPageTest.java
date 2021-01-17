package com.nopcommerce.tests;

import com.nopcommerce.base.BaseTest;
import com.nopcommerce.utils.Constants;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchPageTest extends BaseTest {
    @BeforeClass
    public void searchPageSetup() {
        searchPage = homePage.doSearch(prop.getProperty("searchItem"));
    }

    @Test(priority = 1)
    public void verifySearchPageNameTest() {
        Assert.assertEquals(searchPage.getSearchPageName(), Constants.SEARCH_PAGE_NAME);
    }
    @Test(priority = 2)
    public void verifyManufacturerDropDownListTest() {
        Assert.assertTrue(searchPage.verifyManufacturerDropDownList());
    }
    @Test(priority = 3)
    public void verifyManufacturersListTest() {
        Assert.assertEquals(searchPage.getManufactureListItems(),Constants.getManufacturersSectionList());
    }
}
