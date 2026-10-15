package base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

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
	
	public static void safeclick(WebElement element) {
		int attempt=0;
		while(attempt<3) {
		try {
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(element)).click();
		break;
		}
		catch (StaleElementReferenceException e) {
			// TODO: handle exception
			attempt++;
			System.out.println("Retrying click due to exption  "+attempt);
		}
		}
	}
	
	public static WebElement explicitWaitClickable(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(element));
    }
	
	 public static WebElement WaitVisible(WebElement element) {
	        return new WebDriverWait(driver, Duration.ofSeconds(10))
	       .until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)));
	    }
	 
	 public static WebElement explicitWaitVisible(By locator) {
	        return new WebDriverWait(driver, Duration.ofSeconds(10))
	       .until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(locator)));
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
	 public static void esc() throws AWTException {
		  Robot r=new Robot();
		  r.keyPress(KeyEvent.VK_ESCAPE);
		  r.keyRelease(KeyEvent.VK_ESCAPE);
	  }
	 //SendKeys
	 public static void keys(WebElement element,String text) {
		 element.sendKeys(text);
		 
	 }
	 //window handles
	 
	 public static Set<String> Window() {
		 return driver.getWindowHandles();	 
		 
	 }
public static void switchParentWindow(String parentwindow ) {
	driver.switchTo().window(parentwindow);
	
	
}
    public static void windows(int windownumber) {
    	new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.numberOfWindowsToBe(windownumber));
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
    public static void switchtochildwindow(int windows) {
    	new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.numberOfWindowsToBe(windows));
    	String parentwindow=driver.getWindowHandle();
    	Set<String> handles=driver.getWindowHandles();
    	
    	for (String window : handles) {
    		if(!window.equals(parentwindow))
			
		{
   
    	driver.switchTo().window(window);
    	break;
		}
    	}
	}
    
    public static void newTab() {
    	driver.switchTo().newWindow(WindowType.TAB);
    }
    
    public static void back() {
    	driver.navigate().back();
    }
    //gettext
  public static String gettext(WebElement locator) {
	 return locator.getText();
  }
  //Clear
  
  public static void clear(WebElement element) {
	  element.clear();
  }
  //JavaScript
 public static void scrollintoView(WebElement element) {
	 ((JavascriptExecutor) driver)
     .executeScript("arguments[0].scrollIntoView(true);", element);
 }
 
 public static void jsClick(WebElement element) {
	 ((JavascriptExecutor) driver)
     .executeScript("arguments[0].scrollIntoView(true);", element);
	 ((JavascriptExecutor) driver)
     .executeScript("arguments[0].click;", element);
 }
  //Collections
 
 public static List<String>
     productname=new ArrayList<>();
 
 public static List<Double>
    productprice=new ArrayList<>();
 
 public static List<Integer>
 productprices=new ArrayList<>();
 
 
 //dropdown
 
 public static void selectByIndex(WebElement element, int index) {
     new Select(element).selectByIndex(index);
 }

 public static void selectByValue(WebElement element, String value) {
     new Select(element).selectByValue(value);
 }

 public static void selectByVisibleText(WebElement element, String text) {
     new Select(element).selectByVisibleText(text);
 }
 public static void assertion(WebElement element,String expected) {
	 Assert.assertEquals(element.getText(), expected);
 }
}


