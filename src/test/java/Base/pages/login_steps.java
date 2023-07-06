package Base.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import PageFactory.LandingPO;
import PageFactory.ProfilePO;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class login_steps {

public WebDriver driver;
LandingPO landingPO;
ProfilePO profilePO;

@Given("browser open chrome browser")
public void browser_open_chrome_browser() {	
    landingPO = new LandingPO();
    landingPO.openAppUrl();
    Reporter.log("Applikasi tampil!");
    System.out.println("Finansys is launced");
    
}

@When("I type valid Username and password")
public void i_type_valid_username_and_password(DataTable dataTable) {
	List<String> LoginForm = dataTable.asList();

    String userName = LoginForm.get(0);

    String passWord = LoginForm.get(1);

    driver.findElement(By.name("email")).sendKeys(userName);

    driver.findElement(By.id("Password")).sendKeys(passWord);
     } 
      
    



@And("I click submit")
public void i_click_submit() {
	driver.findElement(By.id("kt_login_signin_submit")).click();
	System.out.println("Dapat!");
}

@Then("it direct to home page")
public void it_direct_to_home_page() throws InterruptedException {
	Thread.sleep(2000);
	driver.navigate().to("https://demo.finansysapps.id/tasks"); 
	System.out.println("Anda di halaman Home page");
	//
	driver.close();

}

@When("I type invalid username and password")
public void i_type_invalid_username_and_password(DataTable credentials) {
	List<List<String>> data = credentials.cells();
	driver.findElement(By.name("email")).sendKeys(data.get(0).get(0)); 
    driver.findElement(By.id("password")).sendKeys(data.get(0).get(1));
    System.out.println("Anda gagal di halaman Home page");
}
}
