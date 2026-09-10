package steps;

import java.awt.AWTException;

import base.BaseClass;
import io.cucumber.java.en.When;
import pages.Comparison;

public class StepComparison extends BaseClass {
	
	Comparison comp=new Comparison(driver) ;
	
	String Mousename1;
	String Mousename2;
	String Mouse1price;
	String Mouse2price;
	
	@When("User search the first product")
	public void userSearchTheFirstProduct() throws AWTException {
	  keys(comp.Searchbox, "wireless mouse");
	  enter();
	  //scrollintoView(comp.Mouse);
	 // System.out.println(gettext(comp.Mouse));
	  click(comp.Mouse);
	  gettext(comp.Mouse);
		 Mousename1=gettext(comp.Mouse);
		 System.out.println(Mousename1);
		 WaitVisible(comp.mouseprice1);
		 gettext(comp.mouseprice1);
		 Mouse1price=gettext(comp.mouseprice1).replace("₹", "").trim();
		 System.out.println(Mouse1price);
	}
	@When("User search the second product in new tab")
	public void userSearchTheSecondProductInNewTab() throws AWTException {
		impWait(10);
		newTab();
		driver.get("https://www.flipkart.com");
		impWait(10);
		//windows(3);
		click(comp.closebtn);
		click(comp.Searchbox);
		keys(comp.Searchbox, "wireless mouse");
		click(comp.SearchBtn);
		click(comp.Mouse2);
		
	}
	@When("User capture the product details")
	public void userCaptureTheProductDetailsAndStoreTheDetails() {
		
		//totalwindows(4);
		windows(4);
		 WaitVisible(comp.Mouse2name);
		 gettext(comp.Mouse2name);
		 Mousename2=gettext(comp.Mouse2name);
		 System.out.println(Mousename2);
		 WaitVisible(comp.mouse2price);
		 gettext(comp.mouse2price);
		 Mouse2price=gettext(comp.mouse2price).replace("₹", "").trim();
		 System.out.println(Mouse2price);
		  
	}

	@When("user store the product details and validate")
	public void userStoreTheProductDetailsAndValidate() {
	    BaseClass.productname.add(Mousename1);
	    BaseClass.productname.add(Mousename2);
	    BaseClass.productprice.add(Double.parseDouble(Mouse1price));
	    BaseClass.productprice.add(Double.parseDouble(Mouse2price));
	    if(BaseClass.productprice.get(0)>
	    BaseClass.productprice.get(1)) {
	    System.out.println("first product price is high");
	    }else {
	    	System.out.println("Second product price is high");
	    }
	}


}
