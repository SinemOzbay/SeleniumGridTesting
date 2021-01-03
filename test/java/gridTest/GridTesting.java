package gridTest;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities; //selenium library, remote package
import org.openqa.selenium.remote.RemoteWebDriver;


public class GridTesting {

	public static void main(String[] args) throws MalformedURLException {
		//System.setProperty("webdriver.gecko.driver","//Users//sinem//Documents//Drivers//geckodriver.exe");

		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setBrowserName("chrome");
		dc.setPlatform(Platform.MAC);
		
//		FirefoxOptions fo = new FirefoxOptions();
//		fo.merge(dc);
		
		ChromeOptions co = new ChromeOptions();
		co.merge(dc);
		
		String hubUrl = "http://192.168.1.254:4444/wd/hub";
		
		WebDriver driver = new RemoteWebDriver(new URL(hubUrl),co);
		
		driver.get("https://www.google.com");
		System.out.println(driver.getTitle());
		
		driver.close();
		
	}

}
