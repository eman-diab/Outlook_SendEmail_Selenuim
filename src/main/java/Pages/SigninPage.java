package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SigninPage {
	
	private WebDriver driver;
	   
	private By emailInput = By.id("i0116");
    private By nextBtn = By.id("idSIButton9");
    private By passwordInput = By.id("i0118");
    private By displayName = By.id("displayName");
	


	    public SigninPage (WebDriver driver) {
	        this.driver = driver;
	    }

	    public SendEmailPage SignIn(String email, String password) throws InterruptedException {
	        WebDriverWait wait = new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(nextBtn));

	        driver.findElement(emailInput).sendKeys(email);
	        driver.findElement(nextBtn).click();
			
	        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));

	        driver.findElement(passwordInput).sendKeys(password);
	        driver.findElement(nextBtn).click();

	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(displayName));
	        
	        driver.findElement(nextBtn).click();


	        return new SendEmailPage(driver);
	    }


	 


}
