package steps;

import com.ea.framework.base.DriverContext;
import com.ea.framework.base.FrameworkInitialize;
import com.ea.framework.config.Settings;
import com.ea.framework.utilities.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


import java.io.IOException;

/**
 * Created by Karthik-pc on 12/4/2016.
 */
public class TestInitialize extends FrameworkInitialize {
    @Before
    public void Initialize(Scenario scenario) throws IOException {
        //Enter the scenario name
        ExtentReport.startScenario(scenario.getName());

        InitializeBrowser(Settings.BrowserType);
        Settings.Logs.Write("Browser Initialized");
        DriverContext.GoToUrl(Settings.AUT);
        Settings.Logs.Write("Navigated to URL " + Settings.AUT);

        try {
            ExcelUtil util = new ExcelUtil(Settings.ExcelSheetPath);
        } catch (Exception e) {
        }


    }

    @After
    public void TearDown(){
        DriverContext.QuitDriver();

    }
}
