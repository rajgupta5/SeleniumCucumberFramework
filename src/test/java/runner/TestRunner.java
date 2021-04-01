package runner;


import com.ea.framework.utilities.ExtentReport;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Karthik-pc on 02/10/2020.
 */
@CucumberOptions(features = {"src/test/java/features/"}, glue = {"steps"})
public class TestRunner {


    private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }


    @Test(dataProvider = "features")
    public void EmployeeTest(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) throws ClassNotFoundException {
        ExtentReport.startFeature(featureWrapper.toString());
        testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[] features(ITestContext context) {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        testNGCucumberRunner.finish();
    }


}
