package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/reports/cuucmberTests.json", "html:target/reports/"},
        features = {"src/test/resources/features"},
        glue = {"steps"},
        tags = {"@regressao"}
)
public class RunCucumber extends RunBase {

    WebDriverWait wait;

    @Before
    public void setUp() {
        wait = new WebDriverWait(getDriver(), 10);
    }

    @AfterClass
    public static void tearDown() {
        if(getDriver() != null)
        getDriver().quit();
    }
}