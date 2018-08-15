package ApplicationDataTest;

import org.junit.runner.RunWith;

/*import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)


@CucumberOptions( features = "src/test/resources/features" ,
glue = "ApplicationDataTest",
tags = {},
		
plugin = {"pretty:reports/cucumber-pretty-report/cucumber-pretty.txt",
"html:reports/cucumber-html-report",
 "json:reports/cucumber-usage-report/cucumber-usage.json",
 "junit:report/cucumber-junit-report/cucumber.xml"
}
		)
public class RunnerTest {
		
}*/

import org.junit.runner.RunWith;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;

@RunWith(ExtendedCucumber.class)
@ExtendedCucumberOptions(jsonReport = "target/cucumber.json",
        retryCount = 3,
        detailedReport = true,
        detailedAggregatedReport = true,
        overviewReport = false,
        toPDF = false,
        outputFolder = "target")
@CucumberOptions(plugin = { "html:target/cucumber-html-report",
        "json:target/cucumber.json", "pretty:target/cucumber-pretty.txt",
        "usage:target/cucumber-usage.json",
        "junit:target/cucumber-results.xml"
        },
        features = { "src/test/resources/features" },
        glue = { "ApplicationDataTest" },
        tags = {})
public class RunnerTest {
}



