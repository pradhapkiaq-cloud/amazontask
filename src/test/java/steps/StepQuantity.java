package steps;

import java.awt.AWTException;

import base.BaseClass;
import io.cucumber.java.en.Given;
import pages.Quantitypage;

public class StepQuantity extends BaseClass{
	
	Quantitypage quan=new Quantitypage(driver);

	@Given("User Search the product")
	public void userSearchTheProduct() throws AWTException {
	    keys(quan.Searchbox, "Mivi Fort H350 Soundbar, 350 Watts, 5.1 Channel, Multi-...");
	    enter();
	   // explicitWaitClickable(quan.speaker).click();
	    click(quan.speaker);
	   // System.out.println(gettext(quan.speaker));
	}
	
	@Given("User get the product name and price")
	public void usergettheproductnameandprice() {
		System.out.println(gettext(quan.speaker));
		System.out.println(gettext(quan.spekerprice).replace("₹", "").replace(",", "").trim());
		//click(quan.AddCart1);
		
	    
	}
	@Given("user add the product into cart and click the cart button")
	public void useraddtheproductintocartandclickthecartbutton() {
	   
		impWait(20);
		windows(2);
		quan = new Quantitypage(driver);
		explicitWaitClickable(quan.AddCart1);
		click(quan.AddCart1);
		click(quan.cartbutton);
	}
	
	@Given("User clicks the quantity button and increase the quantity")
	public void userClicksTheQuantityButtonAndIncreaseTheQuantity() {
		click(quan.quantitybtn);
	    //selectByIndex(quan.quantitybtn, 2);
		click(quan.ddvalue);
		assertion(quan.qty2, "Qty: 2");
		
	}
}
