package com.ea.framework.base;

import org.openqa.selenium.WebDriver;

/**
 * Created by Karthik-PC on 11/23/2016.
 */
public class DriverContext {

    public static WebDriver Driver;

    public static Browser Browser;


    public static void setDriver(WebDriver driver) {
        Driver = driver;
    }

    public static WebDriver getDriver() {
        return Driver;
    }

}
