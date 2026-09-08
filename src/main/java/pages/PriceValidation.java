package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class PriceValidation extends BaseClass{
	
	WebDriver driver;
	public   PriceValidation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//span[@role='button']")
	private WebElement CloseButton;
	
	@FindBy(xpath = "//input[@class='nw1UBF v1zwn26'][1]")
	public WebElement Searchbox;
	@FindBy(xpath = "//div[.='Samsung Galaxy S25 5G (Silver Shadow, 128 GB)']")
	public WebElement Samsung;
	
	@FindBy(xpath = "(//div[.='₹69,999'])[1]")
	public WebElement HomePrice;
	
	@FindBy(xpath = "(//div[@class='css-g5y9jx'])[248]")
	public WebElement AddCart;
	
	@FindBy(xpath = "//a[@class='SXucWY']")
	public WebElement CartBtn;
	
	@FindBy (xpath = "(//div[.='₹69,999 '])[1]")
	public WebElement CartPrice;
		
	
	public WebElement getCloseButton() {
		return CloseButton;
	}
	
	 public String getHomePrice() {
		 return gettext(HomePrice);
		 }
	 
	 public String getCartPrice() {
		 return gettext(CartPrice); 
		 }
	 
	
	

}
