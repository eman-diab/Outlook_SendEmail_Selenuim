package OutlookTest;


import Base.baseTest;
import InputData.propertiesReader;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.SendEmailPage;
import Pages.SigninPage;

public class sendEmailTest extends baseTest {

	HomePage homeObject = new HomePage(driver);
    SigninPage  signinObject;
    SendEmailPage sendEmailObject;
    
    String path= "/src/test/java/InputData/signinInfo.properties";
	String email = propertiesReader.read(path,"email");
	String password = propertiesReader.read(path,"password");
	String sendTo = propertiesReader.read(path,"sendto");
	String mailSubject = propertiesReader.read(path,"mailSubject");
    String sheetpath ="/src/test/java/InputData/Data.xlsx";


    
    @Test(priority = 1)
    public void SendEmailwithAttach() throws InterruptedException {
 
    	    	
        homeObject = new HomePage(driver);
        signinObject= homeObject.OpenSignInForm();
        sendEmailObject = signinObject.SignIn(email, password);
        sendEmailObject.SendEmail(sendTo, mailSubject, sheetpath);
 

    }
    
}
