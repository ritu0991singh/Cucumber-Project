package Utilities;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;



public class Utility extends BaseClass {
	public static String parentWindowHandle;
	
	public int generateRamdomNumber() {
		Random randomGenerator = new Random();  
		int randomInt = randomGenerator.nextInt(100);
		return randomInt;
	}
	
	public void selectdropdownValueText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void selectdropdownByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	public void switchToFrame(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToChildWindow() {
	 parentWindowHandle = driver.getWindowHandle();
	Set<String> windows = driver.getWindowHandles();
	for (String window: windows) {
		if(!window.equalsIgnoreCase(parentWindowHandle)) {
			driver.switchTo().window(window);
		}
	}
	}
	
	public void switchToParentWindow() {
		driver.switchTo().window(parentWindowHandle);
		
	}

}
