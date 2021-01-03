package gridTest;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class MultipleBrowserInstances {
	
	@Parameters("Browser")
	@Test
	public void crmTest(String browser) throws MalformedURLException {
		DesiredCapabilities dc = null;
		
		System.out.println(browser);
		
		if(browser.equals("firefox")) {
			dc = DesiredCapabilities.firefox();
			dc.setBrowserName("firefox");
			dc.setPlatform(Platform.MAC);
			
		}else {
			dc = DesiredCapabilities.chrome();
			dc.setBrowserName("chrome");
			dc.setPlatform(Platform.MAC);	
		}
		String hubUrl = "http://192.168.1.254:4444/wd/hub";
		WebDriver driver = new RemoteWebDriver(new URL(hubUrl), dc);
		
		driver.get("https://classic.crmpro.com/index.html");
		
		System.out.println(driver.getTitle());
		
		driver.close();

	}

}
