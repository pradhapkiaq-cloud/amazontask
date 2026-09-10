package pages;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class Comparison extends PriceValidation {

	WebDriver driver;
	public Comparison(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//button[@class='XFwMiH'])[1]")
	public WebElement SearchBtn;
	
	@FindBy (xpath="(//a[contains(text(),'Flipkart SmartBuy')])[1]")
	public WebElement Mouse;
	
	@FindBy (xpath = "(//div[@class='RGLWAk'])[1]")
	public WebElement Mouse2;
	
	@FindBy(xpath = "//span[@role='button']")
	public WebElement closebtn;
	
	//@FindBy(xpath = "//h1[contains(text(),'Flipkart SmartBuy TC-M500 Ergon')]")
	//public WebElement Mouse1name;
	
	@FindBy(xpath = "//h1[@class='v1zwn21n v1zwn27 _1psv1zeb9 _1psv1ze0']")
	            //  "//h1[@class='v1zwn21n v1zwn27 _1psv1zeb9 _1psv1ze0']"
	public WebElement Mouse2name;
	
	@FindBy(xpath = "(//div[.='₹498'])[1]")
	public WebElement mouse2price;
	
	@FindBy (xpath="(//div[.='₹338'])[1]")
	public WebElement mouseprice1;
}
