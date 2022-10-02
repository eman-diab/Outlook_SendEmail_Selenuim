package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	private WebDriver driver;
	
	private By signinBtn = By.linkText("Sign in");
    public HomePage(WebDriver driver) {
       this.driver = driver;
    }

    
    public SigninPage OpenSignInForm () {
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(signinBtn));
        driver.findElement(signinBtn).click();
        

        return new SigninPage(driver);
    }
	
}

