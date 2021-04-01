package com.ea.framework.base;

import com.ea.framework.config.Settings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Karthik-PC on 11/23/2016.
 */
public class FrameworkInitialize extends Base {


    public static void InitializeBrowser(BrowserType browserType) throws MalformedURLException {

        RemoteWebDriver driver = null;
        String runmode = Settings.RunMode;
        switch (browserType)
        {
            case Chrome:
            {
                if(runmode.equalsIgnoreCase("remote")) {
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName(org.openqa.selenium.remote.BrowserType.CHROME);
                    driver =new RemoteWebDriver(new URL(Settings.SeleniumGridHub), cap);
                }
                else {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                break;
            }
            case Firefox:
            {
                if(runmode.equalsIgnoreCase("remote")) {
                    DesiredCapabilities cap = new DesiredCapabilities();
                    cap.setBrowserName(org.openqa.selenium.remote.BrowserType.FIREFOX);
                    driver =new RemoteWebDriver(new URL(Settings.SeleniumGridHub), cap);
                }
                else {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                LocalDriverContext.setRemoteWebDriverThreadLocal(driver);
                break;
            }
            case IE:
            {
                break;
            }
        }

    }


}
