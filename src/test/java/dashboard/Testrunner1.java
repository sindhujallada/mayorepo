package dashboard;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features= {"C:\\eclipseworkspace\\health.org\\src\\test\\resources\\dash1"},
glue= {"dashboard"},monochrome=true,plugin= {"pretty","html:target/testresult.html","rerun:target/failedtests.txt"})
public class Testrunner1 extends AbstractTestNGCucumberTests {

}
