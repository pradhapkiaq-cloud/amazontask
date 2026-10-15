package steps;

import java.awt.AWTException;

import base.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RatingPage;

public class RatingStep extends BaseClass {
	
	
	
	RatingPage rating=new RatingPage(driver);
	
	String name;
	String ratings;
	double a=4.0;
	double value;

	
	@When("user search the smart watch")
	public void userSearchTheSmartWatch() throws AWTException {
	   keys(rating.Searchbox, "smart watch");
	   enter();
	}
	   @When("user cliks the watch")
	   public void userCliksTheWatch() {
	       
	      
	   click(rating.watch);
	   name=gettext(rating.watch);
	   
	   ratings=gettext(rating.watchrating);
	  
	  }
	   @When("user convert the ratings into numeric")
	   public void userconverttheratingsintonumeric() {
	       
	   value=Double.parseDouble(ratings);
	   }
	   
	   @Then("the watch rating above {double} print name and ratings")
	   public void thewatchratingaboveprintnameandratings(Double double1) {
	       
	       
	   if(value > a) {
		   
		   System.out.println(name);
		   System.out.println(ratings);
		   
	   }else {
		   System.out.println("failled");
	   }

	
}}
