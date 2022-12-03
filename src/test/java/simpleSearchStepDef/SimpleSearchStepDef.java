package simpleSearchStepDef;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimpleSearchStepDef {
	
	WebDriver driver = null;
	String title = null;

	@Given("browser is open")
	public void browser_is_open() throws InterruptedException {
	   System.out.println("Open the chrome browser");
	   
	   System.setProperty("webdriver.chrome.driver", "/Users/kavibharathimunusamy/eclipse-workspace/TestingEasyFundraising/src/main/resources/drivers/chromedriver");
	   
	   driver = new ChromeDriver();
	   driver.manage().window().maximize();
	   TimeUnit.SECONDS.sleep(10);
	   
	   driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	   driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	    
	}
	
	@And("user opened the website {string}")
	public void user_opened_the_website(String url) {
		driver.navigate().to (url);
	}
	
	@And("user Go to the link {string} on the top of the page")
	public void user_go_to_the_link_on_the_top_of_the_page(String causeLink) {
		driver.findElement(By.linkText(causeLink)).click();
	}
	
	@When("User Enter {string} in the Search field")
	public void user_enter_in_the_search_field(String searchString) {
		driver.findElement(By.id("sagc-hero-search-input")).sendKeys(searchString);
	}
	
	@And("User select the {int}rd cause from the suggestion list")
	public void user_select_the_third_cause_from_the_suggestion_list(int selectCauseSuggestionNumber) {
		driver.findElement(By.xpath("//*[@id=\"sagc-hero-search-input-auto-suggest\"]/li["+selectCauseSuggestionNumber+"]/button[1]")).click();
	
	}
	
	@And("click Search Cause")
	public void click_search_cause() {
		driver.findElement(By.id("sagc-hero-search-submit")).click();
	}
	

	@Then("Confirm with a message that the selected third Cause exists in the Search results")
	public void confirm_with_a_message_that_the_selected_third_cause_exists_in_the_search_results() {
		
		title = driver.findElement(By.xpath("//*[@data-testid=\"title\"]")).getText();
		if (title == null) {
			System.err.println("Not able to find any cause");
		} else {
			System.out.println("Found the cause in the search: " + title);
		}
	    
	}
}



