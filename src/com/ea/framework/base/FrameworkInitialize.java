package com.ea.framework.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Karthik-PC on 11/23/2016.
 */
public class FrameworkInitialize extends Base {


    public static void InitializeBrowser(BrowserType browserType)
    {

        WebDriver driver = null;
        switch (browserType)
        {
            case Chrome:
            {
                driver = new ChromeDriver();
                break;
            }
            case Firefox:
            {
                //Open the browser
                System.setProperty("webdriver.gecko.driver", "e:\\libs\\geckodriver.exe");
                driver= new FirefoxDriver();
                break;
            }
            case IE:
            {
                break;
            }
        }


        //Set the Driver
        DriverContext.setDriver(driver);
        //Browser
        DriverContext.Browser = new Browser(driver);

    }


}
