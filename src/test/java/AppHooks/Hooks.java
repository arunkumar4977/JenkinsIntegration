package AppHooks;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

@Before
public void launch_browser(Scenario scenario) {
	Properties prop = new Properties();
	try {
		FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
		prop.load(fis);
	} catch (FileNotFoundException e) {
		// TODO  Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	String browser = prop.getProperty("browser");
	if(browser.equals("chrome")) {
		 WebDriver driver = null;
		   System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/linuxdriver/chromedriver");
		   
		   ChromeOptions cp = new ChromeOptions();
		   cp.addArguments("--remote-allow-origins=*");
		   cp.addArguments("--start-maximized");
		   
		   driver = new ChromeDriver(cp);
		   
		   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		   driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		   
		   driver.manage().window().maximize();
	}
}
	
}
