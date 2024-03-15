package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CoursesPage extends BasePage {

	public CoursesPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//span[contains(text(),'Beginner')]")
	WebElement level;
	
	@FindBy(xpath="//*[@data-testid='search-filter-group-Language']//span[contains(text(),'Show more')]")
	WebElement showmore;
	
	@FindBy(xpath="//*[@data-testid='active-filter-items']/following-sibling::ul/li[1]")
	WebElement firstCourse;
	
	@FindBy(xpath="//*[@data-testid='active-filter-items']/following-sibling::ul/li[2]")
	WebElement secondCourse;
	
	@FindBy(xpath="//div[@data-e2e='NumberOfResultsSection']/span")
	WebElement result;
	
	By allLanguages=By.xpath("//div[starts-with(@id, 'checkbox-group')]/div");
	By allLevels=By.xpath("//*[@data-testid='search-filter-group-Level']//div[@class='cds-checkboxAndRadio-labelText']");
	
	@FindBy(xpath = "//div[starts-with(@id, 'checkbox-group')]//input")
	WebElement language;
	
	@FindBy(xpath="//div[starts-with(@class,'css-1hllf5q')]/button[1]")
	WebElement applyBtn;
	
	@FindBy(xpath="//div[@class='css-jyd7rb']//span[contains(text(),'Close')]")
	WebElement closeBtn;
	
	@FindBy(xpath="//div[@data-testid='search-filter-group-Level']//input")
	WebElement chkBox;
		
	@FindBy(xpath="//div[@data-testid='active-filter-items']/button[1]")
	WebElement filter;
	
	@FindBy(xpath="(//div[@class='cds-CommonCard-clickArea']//a)[1]")
	WebElement anycourse;
	
	@FindBy(xpath = "(//div[@class='cds-CommonCard-clickArea'])[1]")
	WebElement divscroll;
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	public void selectLevel() {
		level.click();
		
	}
	public void selectLanguage() {
		showmore.click();
		wait.until(ExpectedConditions.elementToBeClickable(language));
		language.click();
		applyBtn.click();
	}
	
	public void selectCourse(){
		scroll(firstCourse);
		hover(firstCourse);
		firstCourse.click();
		scroll(secondCourse);
		hover(secondCourse);
		secondCourse.click();
	}
	
	
	public List<String> getAllLanguage() {
		showmore.click();
		List<WebElement>languages=driver.findElements(allLanguages);
		List<String>arr=new ArrayList<>();
		for(WebElement ele:languages)
		{
			arr.add(ele.getText());
		}
		
		closeBtn.click();
		return arr;
	}
	
	public List<String>getAllLevels(){
		List<WebElement>levels=driver.findElements(allLevels);
		List<String>arr=new ArrayList<>();
		for(WebElement ele:levels)
		{
			arr.add(ele.getText());
		}
		return arr;
		
	}
	
	public boolean clickShowMore() {
		showmore.click();
		closeBtn.click();
		return showmore.isSelected();
	}
	
	public boolean checkChkBox() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
			
		return chkBox.isSelected();
	}
	
	public boolean checkResults() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-e2e='NumberOfResultsSection']/span")));
		String s=result.getText();
		return s.contains("No results");
		
	}
	
	public String checkLanguageFilter() {
		return filter.getText();
		
	}
	public String checkLevelFilter() {
		return filter.getText();
		
	}
	
	public void closePopup() {
		closeBtn.click();
	}
	public void clickCourse() {
		wait.until(ExpectedConditions.visibilityOf(anycourse));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		scroll(divscroll);
		System.out.println(anycourse.isDisplayed());
		anycourse.click();
	}
	
	
}
