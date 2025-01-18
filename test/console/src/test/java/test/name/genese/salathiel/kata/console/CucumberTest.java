package test.name.genese.salathiel.kata.console;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.core.options.Constants.*;
import static test.name.genese.salathiel.kata.console.CucumberTest.BASE_PACKAGE;

@Suite
@IncludeEngines("cucumber")
@SelectPackages(BASE_PACKAGE)
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = BASE_PACKAGE)
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME, value = "classpath:features")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports/cucumber.html, json:target/cucumber-reports/cucumber.json")
public class CucumberTest {
    static final String BASE_PACKAGE = "test.name.genese.salathiel.kata.console.steps";
}
