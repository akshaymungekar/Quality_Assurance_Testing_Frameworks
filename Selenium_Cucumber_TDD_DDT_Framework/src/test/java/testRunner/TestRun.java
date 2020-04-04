package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"D://Education//IntelliJ_Projects//Cucumber_Project_2//Features//Login.feature", "D://Education//IntelliJ_Projects//Cucumber_Project_2//Features//Customers.feature"} ,
        glue = "stepDefinitions",
        dryRun = false,
        monochrome = true,
        plugin = {"pretty","html:test-output"},
        tags = {"@sanity, @regression"}
        )

public class TestRun {

}