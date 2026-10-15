package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quantitypage extends PriceValidation{
	 
	public static WebDriver driver;
	public Quantitypage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//a[.='Mivi Fort H350 Soundbar, 350 Watts, 5.1 Channel, Multi-...']")
	public WebElement speaker;
	
	@FindBy (xpath = "(//div[.='₹6,999'])[1]")
	public WebElement spekerprice;
	
	@FindBy (xpath = "(//div[@class='css-g5y9jx'])[193]")
	public WebElement AddCart1;
	//(//div[contains(@class,'_1psv1zeb9')]/div[contains(@class,'css-g5y9jx')])[34]
	@FindBy(xpath = "//a[@class='SXucWY']")
	public WebElement cartbutton;
	
	@FindBy(xpath = "//div[@class='css-g5y9jx r-13awgt0 r-18u37iz r-15ysp7h r-1awozwy r-1777fci']")
	public WebElement quantitybtn;
	
	@FindBy (xpath="(//div[.='2 '])[3]")
	public WebElement ddvalue;
	
	@FindBy (xpath = "(//div[.='Qty: 2'])[4]")
	public WebElement qty2;

}
