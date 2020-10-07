package Utilities;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class BrowserSettings extends BaseClass {
	

	
	@Before
	public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", getProperty("chromeDriverPath"));
			
			//create chrome instance
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		//Check if parameter passed as 'Edge'
				else if(browser.equalsIgnoreCase("Edge")){
					//set path to Edge.exe
					System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
					//create Edge instance
					driver = new EdgeDriver();
				}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void teardown() throws InterruptedException {
		driver.close();
		Thread.sleep(3000);
	}

}
