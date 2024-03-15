package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//form[@class='search-form']//input")
	WebElement searchBox;
	
	@FindBy(xpath="//button[@class='nostyle search-button']/div")
	WebElement searchIcon;
	
	@FindBy(xpath="//span[contains(text(),'Individual')]")
	WebElement nav1;
	
	@FindBy(xpath="//a//span[contains(text(),'Businesses')]")
	WebElement nav2;
	
	@FindBy(xpath="//a//span[contains(text(),'Universities')]")
	WebElement nav3;
	
	@FindBy(linkText="Solutions")
	WebElement solutionLink;
	
	@FindBy(xpath="//a//p[contains(text(),'Coursera for Campus')]")
	WebElement forCampusLink;

	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	public void submitSearch(String s) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='search-form']//input")));
		searchBox.clear();
		searchBox.sendKeys(s);
	}
	
	public void clickSearchIcon() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='nostyle search-button']/div")));	
		searchIcon.click();
	}
	
	public void clickNav1() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		nav1.click();
	}
	public void clickNav2() {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
		nav2.click();	
	}
	
	public void clickNav3() {
		nav3.click();
	}
	public void clickSolutions() {
		
		Actions actions = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Solutions")));
		actions.moveToElement(solutionLink).click().perform();
	
	}

	public void clickForCampus() {

		forCampusLink.click();
	}

	public boolean searchBoxDisplay() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@class='search-form']//input")));
		return searchBox.isDisplayed();
	}
	
	public boolean pageLoaded() {
		return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
	}
	
	public boolean solutionDisplay() {
		return solutionLink.isDisplayed();
	}
	public boolean solutionClicked() {
		return solutionLink.isSelected();
	}
}
