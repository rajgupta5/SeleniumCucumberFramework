package com.ea.test.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberTagStatement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Karthik-pc on 12/7/2016.
 */


@CucumberOptions(features = {"src/test/com/ea/test/features/"}, glue = {"com/ea/test/steps"}, format = {"pretty"})
public class TestRunner {


    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }


    @Test(dataProvider = "features")
    public void runTests(CucumberFeatureWrapper cucumberFeatureWrapper) {

        List<CucumberTagStatement> elements = cucumberFeatureWrapper.getCucumberFeature().getFeatureElements();

        for (Iterator<CucumberTagStatement> element = elements.iterator(); element.hasNext(); ) {
            //ToDo: Bring the scenario name from Excel sheet using the out-of-box library we have in utilities package
            //Pass the hardcoded scenario name

            CucumberTagStatement scenarioName = element.next();
            if (!scenarioName.getVisualName().equals("Scenario: Create Employee with all details")) {
                element.remove();
            }
        }

        testNGCucumberRunner.runCucumber(cucumberFeatureWrapper.getCucumberFeature());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        testNGCucumberRunner.finish();
    }


}
