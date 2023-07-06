package PageFactory;

import StepMethod.Driver;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v114.page.model.NavigatedWithinDocument;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePO extends Driver {
private Duration timeoutInSeconds;
   public ProfilePO (){
       PageFactory.initElements(driver, this);
   }

   @FindBy(partialLinkText = "My Profile")
   public WebElement ProfileBtn;

   @FindBy (partialLinkText = "Settings")
   public WebElement Setting;

   @FindBy (xpath=("//span[contains(.,'system')]"))
   public WebElement myProfile;

   /*@FindBy (xpath = "//*[@id=\"mainbar-full\"]/div[1]/div[1]/div/div/div[1]")
   public WebElement displayNameElement;
   */
   @FindBy (className ="ant-select-selection-item")
   public WebElement DateDisplayFormat; 
   
   @FindBy (className ="MM-DD-YYYY (US)")
   public WebElement WaktuYangDipilh; 
   

   public void openMyProfile(){
	   wait.until(ExpectedConditions.visibilityOf(myProfile)).click();
			}
   public void CekMyProfile(){
       wait.until(ExpectedConditions.visibilityOf(ProfileBtn)).click();
   }
   

   public void Setting(){
       wait.until(ExpectedConditions.visibilityOf(Setting)).click();
       
   }
   

   public void Date(){
       wait.until(ExpectedConditions.visibilityOf(DateDisplayFormat)).click();
       
   }
   
   public void PilihWaktu(){  
	   wait.until(ExpectedConditions.visibilityOf(WaktuYangDipilh)).click();

   
	       driver.quit();
	   }
  


 public void checkNameChangeSuccess(){  /*
      String actualDisplayName = wait.until(ExpectedConditions.visibilityOf(displayNameElement)).getText();
      String expectedDisplayName= "Funky Monkey";
       Assertions.assertEquals(expectedDisplayName, actualDisplayName);
       */
       driver.quit();
   }
}