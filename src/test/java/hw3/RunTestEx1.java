package hw3;

//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.Cucumber;
//import org.junit.runner.RunWith;
import org.testng.annotations.Test;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
//@RunWith(Cucumber.class)
@Test
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-report.html"}, features = "src/test/resources/hw3/ex1.feature")
public class RunTestEx1 extends AbstractTestNGCucumberTests{

}
