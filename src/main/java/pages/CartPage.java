package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends PriceValidation{
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "(//a[contains(text(),'boAt Ultima Vogue 2, Typ')])[1]")
    public WebElement Product1;
	
	@FindBy(xpath = "(//div[contains(normalize-space(),'Add to cart')])[38]")
	public WebElement CartButton;

	@FindBy(xpath = "//a[contains(normalize-space(),'Solara Insulated Stainless Steel Water Bottle 1000 ml |...')]")
	public WebElement Product2;
	
	@FindBy(xpath = "(//div[@class='css-g5y9jx'])[174]")
	public WebElement CartButton2;
	
	@FindBy(xpath = "//a[@class='SXucWY']")
	public WebElement Cartbtn;
	
	@FindBy(xpath = "//div[contains(text(),'boAt Ultima Vogue 2, Type-C , 1.96\"')]")
	public WebElement ProductName1;
	
	@FindBy(xpath = "//div[contains(text(),'₹2,799')]")
	public WebElement ProductPrice1;
	
	@FindBy(xpath = "//div[contains(text(),'Solara Insulated Stainless Steel Water Bottle 1000 ml ')]")
	public WebElement ProductName2;
	
	@FindBy(xpath = "(//div[@class='css-146c3p1 r-op4f77 r-1rsjblm r-9iso6'])[1]")
	public WebElement ProductPrice2;
	
	@FindBy(xpath = "//span[text()='2']")
	public WebElement CartTotal;
	
}
