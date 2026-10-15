package steps;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import base.BaseClass;
import io.cucumber.java.en.When;
import pages.CartPage;

public class CartStep extends BaseClass{
	
	String FirstProductPrice;
	String SecondProductPrice;
	String output;
	int expected=2;
	int result;

	CartPage cart=new CartPage(driver);
	
	@When("user search the first {string}")
	public void userSearchTheFirst(String Product) throws AWTException {
	   keys(cart.Searchbox, Product);
	   enter();
	}
	
	@When("user clicks the first product and add to cart")
	public void userClicksTheFirstProductAndAddToCart() throws AWTException {
		String parentwindow=driver.getWindowHandle();
		click(cart.Product1);
		impWait(20);
		windows(2);
		cart=new CartPage(driver);
		impWait(20);
		 explicitWaitClickable(cart.CartButton);
		 click(cart.CartButton);
		 impWait(20);
		switchParentWindow(parentwindow);	 
	    back();
	    
	}
	@When("user searches the second Product")
	public void userSearchesTheSecondProduct() throws AWTException, InterruptedException {
		cart=new CartPage(driver);
		explicitWaitClickable(cart.Searchbox);
	   click(cart.Searchbox);
		keys(cart.Searchbox, "Solara Insulated Stainless Steel Water Bottle 1000 ml |...");
		enter();
		Thread.sleep(3000);
	   
	}
	@When("user clicks the second product and add to cart")
	public void userClicksTheSecondProductAndAddToCart() {
		
		explicitWaitClickable(cart.Product2);
		click(cart.Product2);
		//Set<String> windows=driver.getWindowHandles();
		//List<String> child=new ArrayList<>(windows);
		//driver.switchTo().window(child.get(2));
		windows(3);
		cart=new CartPage(driver);
		explicitWaitClickable(cart.CartButton);
		click(cart.CartButton);
		String window=driver.getWindowHandle();
		switchParentWindow(window);
		back();
		
	}
	@When("user clicks the cart button and get the product details")
	public void userClicksTheCartButtonAndGetTheProductDetails() {
		
		explicitWaitClickable(cart.Cartbtn);
		click(cart.Cartbtn);
		
		System.out.println(gettext(cart.ProductName1));
	    System.out.println(gettext(cart.ProductName2));
	    
	    FirstProductPrice=gettext(cart.ProductPrice1).replace("₹", "").replace(",", "").trim();
	    System.out.println(FirstProductPrice);
		SecondProductPrice=gettext(cart.ProductPrice2).replace("₹", "").trim();
		System.out.println(SecondProductPrice);
		output=gettext(cart.CartTotal);
		result=Integer.parseInt(output);
		
		if(result == expected) {
			System.out.println("pass");
			
		}else {
			System.out.println("fail");
		}
		
		
	}

}
