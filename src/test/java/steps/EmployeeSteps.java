package steps;

import com.aventstack.extentreports.GherkinKeyword;
import com.ea.framework.base.CurrentPageContext;
import com.ea.framework.base.DriverContext;
import com.ea.framework.utilities.ExtentReport;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.*;
import model.EmployeeModel;
import pages.CreateEmployeePage;
import pages.EmployeeListPage;
import pages.HomePage;

import java.util.List;
import java.util.Map;

/**
 * Created by Karthik-pc on 02/10/2020.
 */
public class EmployeeSteps  {

    @DataTableType
    public EmployeeModel convertEmployeeModel(Map<String, String> entry) {
        return EmployeeModel.createEmployeeModel(entry);
    }

    @And("^I click employeeList link$")
    public void iClickEmployeeListLink() throws Throwable {
        CurrentPageContext.setCurrentPage(CurrentPageContext.getCurrentPage().As(HomePage.class).ClickEmployeeList());
        DriverContext.WaitForPageToLoad();
        ExtentReport.getScenario().createNode(new GherkinKeyword("And"), "I click employeeList link");

    }


    @Then("^I click createnew button$")
    public void iClickCreatenewButton() throws Throwable {
        CurrentPageContext.setCurrentPage(CurrentPageContext.getCurrentPage().As(EmployeeListPage.class).ClickCreateNew());
        DriverContext.WaitForPageToLoad();
        ExtentReport.getScenario().createNode(new GherkinKeyword("Then"), "I click createnew button");

    }

    @And("^I enter following details$")
    public void iEnterFollowingDetails(List<EmployeeModel> table) throws Throwable {
        CurrentPageContext.getCurrentPage().As(CreateEmployeePage.class).CreateEmployee(table.stream().findFirst().get());
        ExtentReport.getScenario().createNode(new GherkinKeyword("And"), "I enter following details");
    }

    @And("^I click create button$")
    public void iClickCreateButton() throws Throwable {
        CurrentPageContext.getCurrentPage().As(CreateEmployeePage.class).ClickCreateButton();
        ExtentReport.getScenario().createNode(new GherkinKeyword("And"), "I click create button");

    }

}
