package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import base.BaseClass;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		
		features={"features/cart.feature"},
		//dryRun =true,
		glue="steps",
		snippets=CucumberOptions.SnippetType.CAMELCASE,
		monochrome = true
	//plugin = {"pretty","html:reports/report.html","json:reports/result.json","junit:reports/result.xml"}
		
		
		)

public class TestRunner extends BaseClass{
	
	 @BeforeClass
	    
	    public static void Startup() {
	    	BrowserLaunch();
	       maximize();
	       
	    }
	 
	 @AfterClass
	 public static void after() {
		//quit();
	 }
	 

}
