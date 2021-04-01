package steps;

import com.aventstack.extentreports.GherkinKeyword;
import com.ea.framework.base.Base;

import com.ea.framework.base.CurrentPageContext;
import com.ea.framework.utilities.ExtentReport;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.HomePage;
import pages.LoginPage;

/**
 * Created by Karthik-pc on 02/10/2020.
 */
public class LoginSteps extends Base {

    @And("^I ensure application opened$")
    public void iEnsureApplicationOpened() throws ClassNotFoundException {
        CurrentPageContext.setCurrentPage(GetInstance(HomePage.class));
        Assert.assertTrue("The login page is not loaded", CurrentPageContext.getCurrentPage().As(HomePage.class).IsLogin());

        ExtentReport.getScenario().createNode(new GherkinKeyword("And"), "I ensure application opened");
    }


    @Then("^I click login link$")
    public void iClickLoginLink() throws ClassNotFoundException {
        //Navigation to Login Page
        CurrentPageContext.setCurrentPage(CurrentPageContext.getCurrentPage().As(HomePage.class).ClickLogin());
        ExtentReport.getScenario().createNode(new GherkinKeyword("Then"), "I click login link");
    }

    @When("^I enter UserName and Password$")
    public void iEnterUserNameAndPassword(DataTable data) throws ClassNotFoundException {
        var table = data.asList();
        CurrentPageContext.getCurrentPage().As(LoginPage.class).Login(table.get(2), table.get(3));
        ExtentReport.getScenario().createNode(new GherkinKeyword("When"), "I enter UserName and Passwor");
    }

    @Then("^I click login button$")
    public void iClickLoginButton() throws InterruptedException, ClassNotFoundException {
        //Home Page
        CurrentPageContext.setCurrentPage(CurrentPageContext.getCurrentPage().As(LoginPage.class).ClickLogin());
        ExtentReport.getScenario().createNode(new GherkinKeyword("Then"), "I click login button");
    }

    @Then("^I should see the username with hello$")
    public void iShouldSeeTheUsernameWithHello() throws Throwable {
        Assert.assertEquals("The user is not admin", "Hello admin!", CurrentPageContext.getCurrentPage().As(HomePage.class).GetLoggedInUser());
        ExtentReport.getScenario().createNode(new GherkinKeyword("Then"), "I should see the username with hello");
    }


}
