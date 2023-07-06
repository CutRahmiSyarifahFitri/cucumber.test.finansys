package PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import StepMethod.Driver;
//import static StepMethod.Driver.wait;

import java.time.Duration;

public class LandingPO extends Driver{
	
	 public LandingPO (){
	       PageFactory.initElements(driver, this);
	   }

	   
	   @FindBy (id = "kt_login_signin_submit")
	   public WebElement loginBtn;
	   
	   @FindBy (name="email")
	   public WebElement UsernameField;
	   
	   @FindBy (id="password")
	   public WebElement PassField;
	   
	  // @FindBy (className = "topbar-item")
	  // public WebElement myProfileBtn;
	   
	   public void enterEmail(String Username) {
		   UsernameField.sendKeys(Username);
	   }	   
	   public void enterPassword(String password) {
		   PassField.sendKeys(password);
	   }
private Duration timeoutInSeconds;
private String url = "https://demo.finansysapps.id/authentication/login";

		public void openAppUrl() {
			driver.get(url);
			driver.manage().window().maximize();
		}

		public void clickLoginBtn(){

		WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		
		 wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		
		
		
}
/*	  public void openMyProfile(){
		 WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
		 wait.until(ExpectedConditions.visibilityOf(myProfileBtn)).click();
		}
		*/


}