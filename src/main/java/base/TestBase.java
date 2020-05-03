package base;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import utilclass.TestUtil;
import utilclass.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver edriver;
	public static WebEventListener eventlistener;
	
	public TestBase() {
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream("C:\\Users\\kaarthic\\eclipse-workspace\\LetsKodeit\\s"
					+ "rc\\main\\java\\configclass\\config.properties");
			prop.load(ip);			
		}	
		catch(FileNotFoundException e){
			e.printStackTrace();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
			
	
	
	}
	
	public static void initialisation() {
		
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Gayathri Selenium\\eclipse-workspace\\Chrome Driver 81\\chromedriver.exe");
			driver= new ChromeDriver();
			
		}
		
		edriver= new EventFiringWebDriver(driver);
		eventlistener= new WebEventListener();
		edriver.register(eventlistener);
		driver=edriver;
		
					
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Time ,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
			driver.get(prop.getProperty("url"));
		
		
	}
	



	
}