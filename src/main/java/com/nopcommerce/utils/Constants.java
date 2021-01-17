package com.nopcommerce.utils;

import java.util.ArrayList;
import java.util.List;

public class Constants {
    public static final String PAGE_TITLE="nopCommerce demo store";
    public static final String LOGIN_PAGE_NAME="Welcome, Please Sign In!";
    public static final String REGISTER_PAGE_NAME="Register";
    public static final String SEARCH_PAGE_NAME="Search";
    public static final String USER_SHEET_NAME="userdata";
    public static final String[] MANUFACTURER_DROPDOWN={"All","Apple","HP","Nike"};
    public static List<String> getManufacturersSectionList() {
        List<String> list = new ArrayList<String>();
        list.add("Apple");
        list.add("HP");
        list.add("View all");
        return list;
    }
}
