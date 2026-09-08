package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	public static Actions actions;
	
	public static Actions act() {
		actions=new Actions(driver);
		return actions;
	}
	
	public static WebDriver BrowserLaunch() {
		driver=new ChromeDriver();
		
		return driver;
	}
	
	
	public static void maximize() {
		driver.manage().window().maximize();
		
	}
	public static void close() {
		driver.close();
	}
	public static void quit() {
		driver.quit();
	}
	
	
	//webdriver wait
	public static void impWait(int seconds) {
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
		
	}
	
	public static WebElement explicitWaitClickable(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
	 public static WebElement explicitWaitVisible(By locator) {
	        return new WebDriverWait(driver, Duration.ofSeconds(10))
	       .until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(locator)));
	    }
	 
	 //webdriverwait click
	 public static void click(WebElement element) {
		 
	        new WebDriverWait(driver, Duration.ofSeconds(15))
	        .until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(element))).click();
	    }
	 //KeyBoard
	 public static void enter() throws AWTException {
		 Robot r=new Robot();
		 r.keyPress(KeyEvent.VK_ENTER);
		 r.keyRelease(KeyEvent.VK_ENTER);
		 
	 }
	 //SendKeys
	 public static void keys(WebElement element,String text) {
		 element.sendKeys(text);
		 
	 }
	 //window handles
	 
	 public static Set<String> Window() {
		 return driver.getWindowHandles();	 
		 
	 }
public static void switchWindow(String windowID ) {
	driver.switchTo().window(windowID);
	
}
    public static void windows(int windownumber) {
    Set<String> parentWindow=driver.getWindowHandles();
    int count=1;
    for (String windows : parentWindow) {
	    if(count==windownumber) {
		driver.switchTo().window(windows);
		break;
	}
	count++;	
}
}
    //gettext
  public static String gettext(WebElement locator) {
	 return locator.getText();
  }
}
