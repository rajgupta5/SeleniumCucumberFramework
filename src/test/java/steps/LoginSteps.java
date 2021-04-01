package steps;

import com.aventstack.extentreports.GherkinKeyword;
import com.ea.framework.base.Base;
import com.ea.framework.base.CurrentPageContext;
import com.ea.framework.utilities.ExcelUtil;
import com.ea.framework.utilities.ExtentReport;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import org.junit.Assert;

import java.util.List;

/**
 * Created by Karthik-pc on 12/6/2016.
 */
public class LoginSteps extends Base {

    @And("^I ensure application opened$")
    public void iEnsureApplicationOpened() throws ClassNotFoundException {
        CurrentPage = GetInstance(LoginPage.class);
        Assert.assertTrue("The login page is not loaded", CurrentPage.As(LoginPage.class).IsLogin());
        ExtentReport.getScenario().createNode(new GherkinKeyword("And"), "I ensure application opened");
    }


    @Then("^I click welcome link$")
    public void iClickLoginLink() {
        CurrentPage = CurrentPage.As(HomePage.class).ClickWelcome();
    }

    @When("^I enter UserName and Password$")
    public void iEnterUserNameAndPassword(DataTable data) throws ClassNotFoundException {
        var table = data.asList();
        CurrentPageContext.getCurrentPage().As(LoginPage.class).Login(table.get(2), table.get(3));
        ExtentReport.getScenario().createNode(new GherkinKeyword("When"), "I enter UserName and Passwor");
    }

    @When("^I enter UserName and Password from Excel$")
    public void iEnterUserNameAndPassword() throws ClassNotFoundException {
        CurrentPage.As(LoginPage.class).Login(ExcelUtil.ReadCell("UserName",1), ExcelUtil.ReadCell("Password",1));
        ExtentReport.getScenario().createNode(new GherkinKeyword("When"), "I enter UserName and Passwor");
    }

    @Then("^I click login button$")
    public void iClickLoginButton() throws ClassNotFoundException {
        CurrentPage = CurrentPage.As(LoginPage.class).ClickLogin();
        ExtentReport.getScenario().createNode(new GherkinKeyword("Then"), "I click login link");
    }

    @Then("^I click logout button$")
    public void iClickLogoutButton() throws ClassNotFoundException {
        //Home Page
        CurrentPage = CurrentPage.As(HomePage.class).ClickLogout();
        ExtentReport.getScenario().createNode(new GherkinKeyword("Then"), "I click logout link");
    }

    @And("^I should see Login Page$")
    public void LoginPageIsLoaded() throws ClassNotFoundException {
        iEnsureApplicationOpened();
    }

//    @Then("^I should see the username with hello$")
//    public void iShouldSeeTheUsernameWithHello() throws Throwable {
//        Assert.assertEquals("The user is not admin", "Hello admin!", CurrentPage.As(HomePage.class).GetLoggedInUser());
//    }


}
