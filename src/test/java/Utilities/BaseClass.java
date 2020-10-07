package Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.PageRepository.HomePage;
import com.PageRepository.Login;

public class BaseClass {
	public Properties Prop;
	public Login loginpage;
	public HomePage homepage;
	public WebDriverWait wait;
	public static WebDriver driver;
	public JavascriptExecutor jse;
	
	public BaseClass() {
		try {
			
			File src = new File(".//Configuration//config.property");
			FileInputStream FIS = new FileInputStream(src);
			Prop = new Properties();
			Prop.load(FIS);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public String getProperty(String Propertyname) {
		return Prop.getProperty(Propertyname);
	}
	
	public void init() {
		 loginpage = PageFactory.initElements(driver, Login.class);
		 homepage = PageFactory.initElements(driver, HomePage.class);
		  wait=new WebDriverWait(driver, 60);
		  jse = (JavascriptExecutor)driver;
	}
	
	
	
}
