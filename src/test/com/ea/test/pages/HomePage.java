package com.ea.test.pages;

import com.ea.framework.base.BasePage;
import com.ea.framework.controls.elements.HyperLink;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by kkr on 11/26/2016.
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
        lnkEmployeeList.click();
        return GetInstance(EmployeeListPage.class);
    }
}
