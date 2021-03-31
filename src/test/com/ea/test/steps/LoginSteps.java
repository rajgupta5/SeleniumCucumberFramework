package com.ea.test.steps;

import com.ea.framework.base.Base;
import com.ea.framework.utilities.ExcelUtil;
import com.ea.test.pages.HomePage;
import com.ea.test.pages.LoginPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;

/**
 * Created by Karthik-pc on 12/6/2016.
 */
public class LoginSteps extends Base {

    @And("^I ensure application opened$")
    public void iEnsureApplicationOpened() {
        CurrentPage = GetInstance(HomePage.class);
        Assert.assertTrue("The login page is not loaded", CurrentPage.As(HomePage.class).IsLogin());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Then("^I click login link$")
    public void iClickLoginLink() {
        //Navigation to Login Page
        CurrentPage = CurrentPage.As(HomePage.class).ClickLogin();
        try {
            Thread.sleep(3000);
        } catch (Exception e) {

        }
    }

    @When("^I enter UserName and Password$")
    public void iEnterUserNameAndPassword(DataTable data) {
        List<List<String>> table = data.raw();
        CurrentPage.As(LoginPage.class).Login(table.get(1).get(0).toString(), table.get(1).get(1).toString());
    }

    @Then("^I click login button$")
    public void iClickLoginButton() throws InterruptedException {
        //Home Page
        CurrentPage = CurrentPage.As(LoginPage.class).ClickLogin();
        Thread.sleep(3000);
    }

    @Then("^I should see the username with hello$")
    public void iShouldSeeTheUsernameWithHello() throws Throwable {
        Assert.assertEquals("The user is not admin", "Hello admin!", CurrentPage.As(HomePage.class).GetLoggedInUser());
    }


}
