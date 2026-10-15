package steps;

import java.awt.AWTException;

import base.BaseClass;
import io.cucumber.java.en.Then;
import pages.MouseComparisonPage;

public class MouseComparisonStep extends BaseClass{
	
	MouseComparisonPage mouse=new MouseComparisonPage(driver);
	
	String MouseName1;
	String MouseName2;
	String MouseName3;
	String MousePrice1;
	String MousePrice2;
	String MousePrice3;
	
	@Then("User search the first mouse and capture the details")
	public void userSearchTheFirstMouseAndCaptureTheDetails() throws AWTException {
		
		 keys(mouse.Searchbox, "Portronics Toad 33 Wireless Mouse with adjustable DPI, ...");
		  enter();
		  click(mouse.mouse1);
		  MouseName1=gettext(mouse.mouse1);
		  System.out.println(MouseName1);
		  MousePrice1=gettext(mouse.mouse1price).replace("₹", "").trim();
		  System.out.println(MousePrice1);
	   
	}
	@Then("User search the second mouse and capture the details")
	public void userSearchTheSecondMouseAndCaptureTheDetails() throws AWTException {
		
		impWait(10);
		newTab();
		driver.get("https://www.flipkart.com");
		click(mouse.closebtn);
		click(mouse.searchbox2);
		 keys(mouse.searchbox2, "Flipkart SmartBuy TC-M500 Ergonomic Optical Mouse");
		 click(mouse.searchbtn2);
		 click(mouse.mouse2);
		 MouseName2=gettext(mouse.mouse2);
		 System.out.println(MouseName2);
		 MousePrice2=gettext(mouse.mouse2price).replace("₹", "").trim();
		 System.out.println(MousePrice2);
	}
	@Then("User search the third mouse and capture the details")
	public void userSearchTheThirdMouseAndCaptureTheDetails() throws AWTException {
		
		impWait(10);
		newTab();
		driver.get("https://www.flipkart.com");
		//click(mouse.closebtn);
		impWait(10);
		click(mouse.searchbox3);
		 keys(mouse.searchbox3, "NURAT OPTICAL MOUSE Wired Ambidextrous Optical  Gaming ...");
		 click(mouse.searchbtn2);
		 click(mouse.mouse3);
		 MouseName3=gettext(mouse.mouse3);
		 System.out.println(MouseName3);
		 MousePrice3=gettext(mouse.mouse3price).replace("₹", "").trim();
		 System.out.println(MousePrice3);
	}
	@Then("User store stored the captured details in list")
	public void userStoreStoredTheCapturedDetailsInList() {
		BaseClass.productname.add(MouseName1);
	    BaseClass.productname.add(MouseName2);
	    BaseClass.productname.add(MouseName3);
	    BaseClass.productprices.add(Integer.parseInt(MousePrice1));
	    BaseClass.productprices.add(Integer.parseInt(MousePrice2));
	    BaseClass.productprices.add(Integer.parseInt(MousePrice3));
	    
	    
	}
	@Then("User compare the stored details has which one is high")
	public void userCompareTheStoredDetailsHasWhichOneIsHigh() {
		
		if(BaseClass.productprices.get(0)>
		BaseClass.productprices.get(1) 
		    &&
		 BaseClass.productprices.get(0)>
		BaseClass.productprices.get(2)) {
			System.out.println("first mouse price is high");
		}
		else if(BaseClass.productprices.get(1)>BaseClass.productprices.get(0)
				&&
				BaseClass.productprices.get(1)>BaseClass.productprices.get(2)) {
			System.out.println("second mouse price is high  ="+BaseClass.productprices.get(1));
		}
		else {
			System.out.println("third mouse price is high");
		}
			
	   
	}


}
