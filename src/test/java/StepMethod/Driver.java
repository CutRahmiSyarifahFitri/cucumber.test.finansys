package StepMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Driver {

   public void createChromeDriver(){
       System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
   }
   public static WebDriver driver = new ChromeDriver();
   public static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
}