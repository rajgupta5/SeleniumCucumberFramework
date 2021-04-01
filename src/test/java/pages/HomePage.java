package pages;

import com.ea.framework.base.BasePage;
import com.ea.framework.base.DriverContext;
import com.ea.framework.controls.elements.HyperLink;
import static org.awaitility.Awaitility.*;
import static org.awaitility.Duration.*;
import static java.util.concurrent.TimeUnit.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

/**
 * Created by kkr on 11/26/2018.
 */
public class HomePage extends BasePage {

    @FindBy(how = How.LINK_TEXT, using = "Login")
    public HyperLink lnkLogin;

    @FindBy(how = How.LINK_TEXT, using = "Employee List")
    public HyperLink lnkEmployeeList;

    @FindBy(how = How.XPATH, using = "//a[@title='Manage']")
    public WebElement lnkUserName;

    public LoginPage ClickLogin() {
        lnkLogin.ClickLink();
        return GetInstance(LoginPage.class);
    }

    public boolean IsLogin() {
        return lnkLogin.isDisplayed();
    }

    public String GetLoggedInUser() {
        return lnkUserName.getText();
    }

    public EmployeeListPage ClickEmployeeList() {

        lnkEmployeeList.WaitForVisible().Click();
        return GetInstance(EmployeeListPage.class);
    }
}
