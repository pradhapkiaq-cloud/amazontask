package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RatingPage extends PriceValidation {
	
	WebDriver driver;
	public RatingPage(WebDriver driver) {
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "(//a[contains(text(),'Fire-Boltt Hurricane 2026 1.3\"')])[1]")
	public WebElement watch;
	
	@FindBy(xpath = "(//div[.=4.1])[1]")
	public WebElement watchrating;

}
