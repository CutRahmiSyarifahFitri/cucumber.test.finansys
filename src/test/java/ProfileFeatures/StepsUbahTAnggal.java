package ProfileFeatures;
import PageFactory.LandingPO;
import PageFactory.ProfilePO;
import StepMethod.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StepsUbahTAnggal {
	LandingPO landingPO;
	ProfilePO profilePO;
	
	@Given("I am on finansys website")
	public void i_am_on_finansys_website() {
	    landingPO = new LandingPO();
	    landingPO.openAppUrl();
	    
	}

	@And("I login using my {string} and {string}")
	public void i_login_using_my_and(String Username, String password) {
	       landingPO.UsernameField.sendKeys(Username);
	       landingPO.PassField.sendKeys(password);;
	       	    
	}

	@And("I click login button")
	public void i_click_login_button() {
		landingPO.loginBtn.click();

	}

	@And("I choose App Editor")
	public void i_choose_app_editor() {
		profilePO = new ProfilePO();
		profilePO.openMyProfile();
	}

	@Then("I click my display name to my profile")
	public void i_click_my_display_name_to() {
		profilePO.CekMyProfile();
	}

	@And("click Setting")
	public void click_setting() {
		profilePO.Setting();
	}

	@And("I change Display format")
	public void i_change_display_format() { 
		profilePO.Date();
		profilePO.PilihWaktu();
	}

	@And("I click ok")
	public void i_click_ok() {
		
	}


	@Then("Success edit format")
	public void success_edit_format() {

	}



}
