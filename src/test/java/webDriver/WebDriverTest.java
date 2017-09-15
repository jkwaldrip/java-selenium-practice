package webDriver;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.Test;

public class WebDriverTest {

	@Test
	public void test() {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Kittens");
		searchBox.submit();
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver d) {
			return d.getTitle().toLowerCase().startsWith("kittens");
			}
		});
		
		String pageTitle = driver.getTitle();
		
		driver.quit();
		
		assertEquals("Kittens - Google Search", pageTitle);
	}

}
