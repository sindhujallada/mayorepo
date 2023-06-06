package dashboard;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Stepdef {
	
	public Shared sh;
	public Stepdef(Shared sh) {
		this.sh=sh;
	}
	@Given("open browser")
	public void browser() {
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		sh.driver=new ChromeDriver(co);
		sh.driver.manage().window().maximize();
		
	}
	@When("launch site {string}")
	public void site(String url) {
		sh.driver.get(url);
		
	}
	@Then("click symptom checker")
	public void symptomcheck() {
		sh.wait=new FluentWait<RemoteWebDriver>(sh.driver);
		sh.wait.withTimeout(Duration.ofSeconds(5));
		sh.wait.pollingEvery(Duration.ofSeconds(2));
		sh.wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Check your symptoms to find a possible cause."))).click();
		
	}
	@Then("select one symptom")
	public void selectsymptom() {
		sh.wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Abdominal pain in children"))).click();
	}
	@Then("select checkboxes")
	public void multiplecheckbox() {
		sh.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Crampy']/preceding-sibling::input"))).click();
		WebElement e=sh.driver.findElement(By.xpath("//label[text()='Drinking more water']/preceding-sibling::input"));
		//sh.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[text()='Drinking more water']/preceding-sibling::input"))).click();
		e.click();
		if(e.isSelected())
		{
		//Assert.assertTrue(true);
		System.out.println("checkbox selected");
		}
	}
	@Then("click findcause")
	public void findcause() {
		sh.wait.until(ExpectedConditions.elementToBeClickable(By.id("FindCause"))).click();
		
	}
	
}
