package steps;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.PriceValidation;

public class StepDefinition extends BaseClass{
	PriceValidation ref=new PriceValidation(driver);
	
	String homeprice;
	String cartprice;
	
	@Given("User launch the Application")
	
	public void userLaunchTheApplication() {
		driver.get("https://www.flipkart.com");
		impWait(20);
		click(ref.getCloseButton());
		click(ref.Searchbox);
		
	}
	
	@When("user clicks and search the Product")
	public void userClicksAndSearchTheProduct() throws AWTException {
	keys(ref.Searchbox,"samsung s25");
	enter();
	
	   
	}
	@When("user select the product")
	public void userSelectTheProduct() {
		//explicitWaitClickable(ref.Samsung);
		//impWait(20);
		click(ref.Samsung);
		gettext(ref.HomePrice);
		homeprice=gettext(ref.HomePrice).replace("₹", "").replace(",", "").trim();
		System.out.println("home page price = " + homeprice);
	    
	}
	@When("user add the product to addtocart")
	public void userAddTheProductToAddtocart() {
		impWait(20);
		windows(2);
		explicitWaitClickable(ref.AddCart).click();
		//click(ref.AddCart);
		
	}
	@When("User clicks the cart button")
	public void userClicksTheCartButton() {
	    safeclick(ref.CartBtn);
	    gettext(ref.CartPrice);
	    cartprice=gettext(ref.CartPrice).replace("₹", "").replace(",", "").trim();
		System.out.println("cart page price = " + cartprice);
	}
	
	@When("user checks the home page price and cart page price both are same or not")
	public void userchecksthehomepagepriceandcartpagepricebotharesameornot() {
		
		if(homeprice.equals(cartprice)) {
			System.out.println("both price are same");
		}
		else {
			System.out.println("both price are different");
		}
	   
	}




}
