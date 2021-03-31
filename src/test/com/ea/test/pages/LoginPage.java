package com.ea.test.pages;

import com.ea.framework.base.BasePage;
import com.ea.framework.controls.elements.Button;
import com.ea.framework.controls.elements.ButtonBase;
import com.ea.framework.controls.elements.TextBox;
import com.ea.framework.controls.elements.TextBoxBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Karthik-PC on 11/24/2016.
 */
public class LoginPage extends BasePage {

    @FindBy(how = How.NAME, using = "UserName")
    public TextBox txtUserName;

    @FindBy(how = How.NAME, using = "Password")
    public WebElement txtPassword;

    @FindBy(how = How.CSS, using = "[class*='btn-default']")
    public Button btnLogin;

    public void Login(String userName, String password) {
        txtUserName.EnterText(userName);
        txtPassword.sendKeys(password);
    }

    public HomePage ClickLogin() {
        btnLogin.PerformSubmit();
        return GetInstance(HomePage.class);
    }


}
