package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseComparisonPage extends PriceValidation{
	
	WebDriver driver;
	
	public MouseComparisonPage(WebDriver driver) {
		
		super(driver);
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@role='button']")
	public WebElement closebtn;
	
	@FindBy(xpath = "//a[contains(text(),'Portronics Toad 33')]")
	public WebElement mouse1;
	
	@FindBy (xpath = "(//div[.='₹249'])[1]")
	public WebElement mouse1price;
	
	@FindBy(xpath = "(//input[@class='nw1UBF v1zwn26'])[1]")
	public WebElement searchbox2;
	
	@FindBy(xpath = "(//button[@class='XFwMiH'])[1]")
	public WebElement searchbtn2;
	
	@FindBy(xpath = "(//a[.='Flipkart SmartBuy TC-M500 Ergonomic Optical Mouse'])[1]")
	public WebElement mouse2;
	
	@FindBy(xpath = "(//div[.='₹326'])[1]")
	public WebElement mouse2price;
	
	@FindBy(xpath = "(//input[@name='q'])[1]")
	public WebElement searchbox3;
	
	@FindBy(xpath = "//a[.='NURAT OPTICAL MOUSE Wired Ambidextrous Optical  Gaming ...']")
	public WebElement mouse3;
	
	@FindBy(xpath = "(//div[.='₹189'])[1]")
	public WebElement mouse3price;
}
