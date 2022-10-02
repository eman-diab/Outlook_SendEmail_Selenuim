package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import Helper.screenshot;
import java.io.IOException;
import InputData.propertiesReader;
import org.testng.ITestResult;


public class baseTest {
    public static WebDriver driver ;

    String path= "/src/test/java/InputData/config.properties";
    String Browser = propertiesReader.read(path,"Browser");
    String URL = propertiesReader.read(path,"google.home.url");

    @BeforeSuite
	public void OpenDriver() throws IOException {

        switch (Browser) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "resources/chromedriver 15");
                driver = new ChromeDriver();
                break;

            case "FireFox":
                System.setProperty("webdriver.gecko.driver", "resource/geckodriver");
                driver = new ChromeDriver();
                break;


            case "Edge":
                System.setProperty("webdriver.edge.driver", "resources/msedgedriver");
                driver = new ChromeDriver();
                break;
        }

        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void CloseDriver()
    {
        driver.quit();
    }
    
    
    @AfterMethod
	public void screenshotOnFailure(ITestResult result) 
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Screenshot....");
			screenshot.captureScreenshot(driver, result.getName());
		}
	}
}
