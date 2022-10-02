package Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendEmailPage {
	
	private WebDriver driver;
	    
	    private By newMessageBtn = By.cssSelector("span[id='id__9']");
        private By to = By.cssSelector("div>div[aria-label='To']");
        private By emaillist = By.id("sug-footer2");
        private By subjectInput = By.cssSelector("input[placeholder='Add a subject']");
	    private By attachBtn = By.cssSelector("button[name='Attach']");
	    private By attachFromComputertBtn = By.cssSelector("button[name='Browse this computer']");
	    private By sendBtn = By.cssSelector("button[name='Send']");
        private By emailbody = By.cssSelector("div[aria-label='Message body, press Alt+F10 to exit']");

	    
	    
	    public SendEmailPage (WebDriver driver) {
	        this.driver = driver;
	    }

	    public void SendEmail(String sendTo, String mailSubject, String filePath) throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(newMessageBtn));

	        driver.findElement(newMessageBtn).click();
	        
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(to));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(subjectInput));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(emailbody));

	        
	        driver.findElement(to).sendKeys(sendTo);
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(emaillist));

	        driver.findElement(emaillist).click();
	        driver.findElement(subjectInput).sendKeys(mailSubject);
	        driver.findElement(emailbody).sendKeys("test");

	        wait.until(ExpectedConditions.visibilityOfElementLocated(attachBtn));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(sendBtn));
	        

	        driver.findElement(attachBtn).click();

	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(attachFromComputertBtn));

	        driver.findElement(attachFromComputertBtn).sendKeys(filePath); 
	         
	        driver.findElement(sendBtn).click();
	        

	    }


}
